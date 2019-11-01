package app.web.beans;

import app.domain.models.service.UserServiceModel;
import app.domain.models.view.HomeViewModel;
import app.services.base.UserService;
import org.modelmapper.ModelMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Named
@RequestScoped
public class HomeBean extends BaseBean {

    private List<HomeViewModel> models;

    private UserService userService;
    private ModelMapper mapper;

    public HomeBean() {}

    @Inject
    public HomeBean(UserService userService, ModelMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @PostConstruct
    private void init() {
        String loggedIn = ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false))
                .getAttribute("username")
                .toString();

        this.setModels(this.userService.getAll()
                        .stream()
                        .filter(u -> !u.getUsername().equals(loggedIn) &&
                                !u.getFriends().stream()
                                        .map(f -> f.getUsername())
                                        .collect(Collectors.toList())
                                        .contains(loggedIn))
                        .map(u -> this.mapper.map(u, HomeViewModel.class))
                        .collect(Collectors.toList()));
    }

    public void addFriend(String friendId) {
        String id = ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false))
                .getAttribute("userId")
                .toString();

        UserServiceModel loggedInUser = this.userService.getById(id);
        UserServiceModel friend = this.userService.getById(friendId);

        loggedInUser.getFriends().add(friend);
        friend.getFriends().add(loggedInUser);

        this.userService.update(loggedInUser);
        this.userService.update(friend);
    }

    public List<HomeViewModel> getModels() {
        return models;
    }

    public void setModels(List<HomeViewModel> models) {
        this.models = models;
    }
}
