package app.services;

import app.domain.entities.Gender;
import app.domain.entities.User;
import app.domain.models.service.UserServiceModel;
import app.repositories.base.UserRepository;
import app.services.base.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Inject
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void register(UserServiceModel user) {
        User userEntity = this.modelMapper.map(user, User.class);
        userEntity.setPassword(DigestUtils.sha256Hex(user.getPassword()));
        userEntity.setGender(Gender.valueOf(user.getGender()));
        this.userRepository.save(userEntity);
    }

    @Override
    public void update(UserServiceModel user) {
        this.userRepository.update(this.modelMapper.map(user, User.class));
    }

    @Override
    public UserServiceModel getByUsernameAndPassword(String username, String password) {
        password = DigestUtils.sha256Hex(password);
        return this.modelMapper
                .map(this.userRepository.findByUsernameAndPassword(username, password), UserServiceModel.class);
    }

    @Override
    public UserServiceModel getByUsername(String username) {
        return this.modelMapper
                .map(this.userRepository.findByUsername(username), UserServiceModel.class);
    }

    @Override
    public UserServiceModel getById(String id) {
        return this.modelMapper
                .map(this.userRepository.findById(id), UserServiceModel.class);
    }

    @Override
    public List<UserServiceModel> getAll() {
        return this.userRepository.findAll()
                .stream()
                .map(u -> this.modelMapper.map(u, UserServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void unfriend(String id, String friendId) {
        User user = this.userRepository.findById(id);
        User friend = this.userRepository.findById(friendId);

        user.getFriends().remove(friend);
        friend.getFriends().remove(user);

        this.userRepository.update(user);
        this.userRepository.update(friend);
    }
}
