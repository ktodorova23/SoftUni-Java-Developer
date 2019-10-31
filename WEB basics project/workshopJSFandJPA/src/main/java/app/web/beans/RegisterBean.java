package app.web.beans;

import app.domain.models.binding.UserRegistrationBindingModel;
import app.domain.models.service.UserServiceModel;
import app.services.base.UserService;
import org.modelmapper.ModelMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class RegisterBean extends RedirectBean {

    private UserRegistrationBindingModel userRegistrationBindingModel;
    private UserService userService;
    private ModelMapper modelMapper;

    public RegisterBean() {
    }

    @Inject
    public RegisterBean(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    private void init() {
        this.userRegistrationBindingModel = new UserRegistrationBindingModel();
    }

    public UserRegistrationBindingModel getUserRegistrationBindingModel() {
        return userRegistrationBindingModel;
    }

    public void setUserRegistrationBindingModel(UserRegistrationBindingModel userRegistrationBindingModel) {
        this.userRegistrationBindingModel = userRegistrationBindingModel;
    }

    public void register() {
        if (!this.userRegistrationBindingModel.getPassword().equals(this.userRegistrationBindingModel.getConfirmPassword())) {
            this.redirect("/register");
        }
        this.userService.register(this.modelMapper.map(this.userRegistrationBindingModel, UserServiceModel.class));
        this.redirect("/login");

    }
}
