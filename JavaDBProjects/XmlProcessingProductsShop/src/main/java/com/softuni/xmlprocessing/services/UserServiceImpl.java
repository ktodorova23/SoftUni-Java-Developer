package com.softuni.xmlprocessing.services;

import com.softuni.xmlprocessing.domain.dtos.exportDtos.*;
import com.softuni.xmlprocessing.domain.dtos.importDtos.UserInputDto;
import com.softuni.xmlprocessing.domain.dtos.importDtos.UserInputRootDto;
import com.softuni.xmlprocessing.domain.entities.User;
import com.softuni.xmlprocessing.repositories.UserRepository;
import com.softuni.xmlprocessing.services.base.UserService;
import com.softuni.xmlprocessing.utils.XMLParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final static String USERS_XML_INPUT_FILE_PATH = "E:\\Java\\DB Projects\\JavaDB\\XmlProcessingProductsShop\\src\\main\\resources\\xml\\inputs\\users.xml";

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final XMLParser xmlParser;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, XMLParser xmlParser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public void seedUsers() throws JAXBException {
        UserInputRootDto userInputRootDto = this.xmlParser.parseXml(UserInputRootDto.class, USERS_XML_INPUT_FILE_PATH);

        for (UserInputDto user : userInputRootDto.getUsers()) {
            User entity = this.modelMapper.map(user, User.class);

            this.userRepository.saveAndFlush(entity);
        }
    }

    @Override
    public User getRandomBuyer() {
        Random random = new Random();

        int userId = random.nextInt((int) this.userRepository.count() - 1) + 1;

        if (userId % 3 == 0) {
            return null;
        }

        return this.userRepository.findById(userId).get();
    }

    @Override
    public User getRandomSeller() {
        Random random = new Random();

        int userId = random.nextInt((int) this.userRepository.count() - 1) + 1;

        return this.userRepository.findById(userId).get();
    }

    @Override
    public void seedFriends() {
        for (User user : this.userRepository.findAll()) {
            Set<User> friends = this.getRandomFriends();
            friends.removeIf(f -> f.getId() == user.getId());
            user.setFriends(friends);
        }
    }

    private Set<User> getRandomFriends() {
        Set<User> friends = new HashSet<>();

        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            int id = random.nextInt((int) this.userRepository.count()) + 1;
            friends.add(this.userRepository.findById(id).get());
        }
        return friends;
    }

    /* Query 2 - Successfully Sold Products */
    @Override
    public UserRootDto getAllUsersWithSoldProductsWithBuyerName() {
        Set<User> allUsers = this.userRepository.findBySoldProductsIsNotNullOrderByLastNameAscFirstNameAsc();

        List<UserDto> result = new ArrayList<>();

        for (User user : allUsers) {
            if (user.getSoldProducts().stream().anyMatch(p -> p.getBuyer() != null)) {
                List<ProductDto> soldProducts = user.getSoldProducts()
                        .stream()
                        .filter(p -> p.getBuyer() != null)
                        .map(p -> this.modelMapper.map(p, ProductDto.class))
                        .collect(Collectors.toList());

                UserDto dto = this.modelMapper.map(user, UserDto.class);
                dto.setSoldProducts(soldProducts);

                result.add(dto);
            }
        }

        UserRootDto userRootDto = new UserRootDto();
        userRootDto.setUsers(result);

        return userRootDto;
    }

    @Override
    public UsersAndProductsRootDto usersAndProducts() {

        Set<User> allUsers = this.userRepository.findAllBySoldProductsNotNullOrderBySoldProductsDescLastNameAsc();

        List<UserSimpleDto> allUserDtos = new ArrayList<>();

        for (User user : allUsers) {
            List<ProductSimpleDto> allProducts = user.getSoldProducts()
                    .stream()
                    .map(p -> this.modelMapper.map(p, ProductSimpleDto.class))
                    .collect(Collectors.toList());

            ProductSoldDto productSoldDto = new ProductSoldDto();
            productSoldDto.setProducts(allProducts);
            productSoldDto.setCountProducts(allProducts.size());

            UserSimpleDto dto = this.modelMapper.map(user, UserSimpleDto.class);
            dto.setSoldProducts(productSoldDto);

            allUserDtos.add(dto);
        }

        UsersAndProductsRootDto usersAndProductsRootDto = new UsersAndProductsRootDto();
        usersAndProductsRootDto.setUsers(allUserDtos);
        usersAndProductsRootDto.setCountUsers(allUserDtos.size());

        return usersAndProductsRootDto;
    }
}
