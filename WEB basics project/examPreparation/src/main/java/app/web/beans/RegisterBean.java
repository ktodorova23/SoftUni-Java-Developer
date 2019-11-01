package app.web.beans;

import app.domain.models.binding.RegisterBindingModel;
import app.domain.models.service.UserServiceModel;
import app.services.base.UserService;
import org.modelmapper.ModelMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.sql.Driver;
import java.util.Map;

@Named
@RequestScoped
public class RegisterBean extends BaseBean {

    private RegisterBindingModel model;

    private UserService userService;
    private ModelMapper modelMapper;

    public RegisterBean() {}

    @Inject
    public RegisterBean(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    private void init() {
        this.model = new RegisterBindingModel();
    }

    public void register() {
        this.userService
                .register(this.modelMapper.map(this.model, UserServiceModel.class));

        this.redirect("/login");
    }

    public RegisterBindingModel getModel() {
        return model;
    }

    public void setModel(RegisterBindingModel model) {
        this.model = model;
    }
}
