package com.softuni.demo.services;

import com.google.gson.Gson;
import com.softuni.demo.domain.dtos.*;
import com.softuni.demo.domain.entities.User;
import com.softuni.demo.repositories.UserRepository;
import com.softuni.demo.services.base.UserService;
import com.softuni.demo.utils.FileUtil;
import com.softuni.demo.utils.ValidatorUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final FileUtil fileUtil;
    private final ValidatorUtil validatorUtil;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(FileUtil fileUtil, ValidatorUtil validatorUtil, Gson gson, ModelMapper modelMapper, UserRepository userRepository) {
        this.fileUtil = fileUtil;
        this.validatorUtil = validatorUtil;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    @Override
    public void seedUsers(String path) throws IOException {
        String fileCOntent = this.fileUtil.fileContent(path);

        UserSeedDto[] userSeedDtos = this.gson.fromJson(fileCOntent, UserSeedDto[].class);

        for (UserSeedDto userSeedDto : userSeedDtos) {
            if (!this.validatorUtil.isValid(userSeedDto)) {
                this.validatorUtil.violations(userSeedDto).forEach(v -> System.out.println(v.getMessage()));

                continue;
            }

            User user = this.modelMapper.map(userSeedDto, User.class);
            this.userRepository.saveAndFlush(user);
        }
    }

    @Override
    public void seedWithFriends() {
        for (User user : this.userRepository.findAll()) {
            Set<User> randomFriends = this.getRandomFriends(user.getId());
            randomFriends.removeIf(u -> u.getId() == user.getId());
            user.setFriends(randomFriends);
        }
    }

    private Set<User> getRandomFriends(int userId) {
        Set<User> friends = new HashSet<>();

        Random random = new Random();

        int countFriends = random.nextInt((int) this.userRepository.count() - 1) + 1;
        for (int i = 0; i < countFriends; i++) {
            friends.add(this.getRandomFriend());
        }

        return friends;
    }

    private User getRandomFriend() {
        Random random = new Random();

        int id = random.nextInt((int) this.userRepository.count() - 1) + 1;

        return this.userRepository.findById(id).get();
    }

    /* Query 2 - Successfully Sold Products */
    @Override
    public Set<UserWithSoldProductsDto> getAllUsersWithSoldProductsWithBuyerName() {
        Set<User> allusers = this.userRepository.findBySoldProductsIsNotNullOrderByLastNameAscFirstNameAsc();

        Set<UserWithSoldProductsDto> filteredUsers = new LinkedHashSet<>();

        for (User user : allusers) {
            if (user.getSoldProducts().stream().anyMatch(p -> p.getBuyer() != null)) {
                UserWithSoldProductsDto userSellerDto = this.modelMapper.map(user, UserWithSoldProductsDto.class);
                List<ProductSoldWithBuyerNotNull> productWithBuyerDtos = user.getSoldProducts()
                        .stream()
                        .filter(p -> p.getBuyer() != null)
                        .map(p -> this.modelMapper.map(p, ProductSoldWithBuyerNotNull.class))
                        .collect(Collectors.toList());
                userSellerDto.setSoldProducts(productWithBuyerDtos);
                filteredUsers.add(userSellerDto);
            }
        }
        return filteredUsers;
    }

    /* Query 4 - Users and Products */
    @Override
    public UsersAndProductsDto usersAndProducts() {
        Set<User> allUsers = this.userRepository.findAllBySoldProductsNotNullOrderBySoldProductsDescLastNameAsc();

        Set<UserSimpleViewDto> userSimpleViewDtos = new LinkedHashSet<>();

        for (User user : allUsers) {
            UserSimpleViewDto mappedUser = this.modelMapper.map(user, UserSimpleViewDto.class);
            Set<ProductSimpleViewDto> mappedProducts = user.getSoldProducts().stream().map(p -> this.modelMapper.map(p, ProductSimpleViewDto.class))
                    .collect(Collectors.toSet());
            mappedUser.getSoldProducts().setCount(mappedProducts.size());
            mappedUser.getSoldProducts().setProducts(mappedProducts);
            userSimpleViewDtos.add(mappedUser);
        }

        UsersAndProductsDto usersAndProductsDto = new UsersAndProductsDto();
        usersAndProductsDto.setUsersCount(userSimpleViewDtos.size());
        usersAndProductsDto.setUsers(userSimpleViewDtos);

        return usersAndProductsDto;
    }
}
