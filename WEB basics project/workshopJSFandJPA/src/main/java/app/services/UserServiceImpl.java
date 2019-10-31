package app.services;

import app.domain.entities.User;
import app.domain.models.service.UserServiceModel;
import app.repositories.base.UserRepository;
import app.services.base.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Inject
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void register(UserServiceModel userServiceModel) {
        this.userRepository.save(this.modelMapper.map(userServiceModel, User.class));
    }

    @Override
    public UserServiceModel findUser(String username) {
        return this.userRepository.findByUsername(username);
    }
}
