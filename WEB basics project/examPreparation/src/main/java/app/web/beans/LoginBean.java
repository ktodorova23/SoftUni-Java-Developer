package app.web.beans;

import app.domain.models.binding.LoginBindingModel;
import app.domain.models.service.UserServiceModel;
import app.services.base.UserService;

import javax.annotation.PostConstruct;
import javax.ejb.PostActivate;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;

@Named
@RequestScoped
public class LoginBean extends BaseBean {

    private LoginBindingModel model;

    private UserService userService;

    public LoginBean() {}

    @Inject
    public LoginBean(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    private void init() {
        this.model = new LoginBindingModel();
    }

    public void login() {
        UserServiceModel user = this.userService.getByUsernameAndPassword(this.model.getUsername(), this.model.getPassword());

        if (user == null) {
            this.redirect("/login");
        }

        Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
                .getExternalContext()
                .getSessionMap();

        sessionMap.put("userId", user.getId());
        sessionMap.put("username", user.getUsername());

        this.redirect("/home");
    }

    public LoginBindingModel getModel() {
        return model;
    }

    public void setModel(LoginBindingModel model) {
        this.model = model;
    }
}
