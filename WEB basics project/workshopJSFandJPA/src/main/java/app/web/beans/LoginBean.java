package app.web.beans;

import app.domain.models.binding.UserLoginBindingModel;
import app.domain.models.service.UserServiceModel;
import app.services.base.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.modelmapper.ModelMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;

@Named
@RequestScoped
public class LoginBean extends RedirectBean {
    private UserLoginBindingModel userLoginBindingModel;
    private UserService userService;
    private ModelMapper modelMapper;

    public LoginBean() {}

    @Inject
    public LoginBean(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    private void init() {
        this.userLoginBindingModel = new UserLoginBindingModel();
    }

    public UserLoginBindingModel getUserLoginBindingModel() {
        return userLoginBindingModel;
    }

    public void setUserLoginBindingModel(UserLoginBindingModel userLoginBindingModel) {
        this.userLoginBindingModel = userLoginBindingModel;
    }

    public void login() {
        UserServiceModel user = this.userService.findUser(this.userLoginBindingModel.getUsername());

        if (user == null) {
            this.redirect("/login");
        } else {
            if (user.getPassword()
                    .equals(DigestUtils.sha256Hex(this.userLoginBindingModel.getPassword()))) {
                Map<String, Object> sessionMap =
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
                sessionMap.put("username", userLoginBindingModel.getUsername());
                this.redirect("/home");
            }
        }
    }
}
