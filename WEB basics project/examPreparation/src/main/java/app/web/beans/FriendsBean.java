package app.web.beans;

import app.domain.models.service.UserServiceModel;
import app.domain.models.view.FriendViewModel;
import app.services.base.UserService;
import org.modelmapper.ModelMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Named
@RequestScoped
public class FriendsBean extends BaseBean {

    private List<FriendViewModel> friends;

    private UserService userService;
    private ModelMapper modelMapper;

    public FriendsBean() {
    }

    @Inject
    public FriendsBean(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    private void init() {
        String id = ((HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false))
                .getAttribute("userId").toString();

        this.setFriends(this.userService.getById(id).getFriends()
                .stream()
                .map(u -> this.modelMapper.map(u, FriendViewModel.class))
                .collect(Collectors.toList()));
    }

    public void unfriend(String friendId) {
        String id = ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false))
                .getAttribute("userId")
                .toString();

        this.userService.unfriend(id, friendId);

        UserServiceModel loggedinUser = this.userService.getById(id);
        UserServiceModel friend = this.userService.getById(friendId);

        loggedinUser.getFriends().remove(friend);
        friend.getFriends().remove(loggedinUser);

        this.userService.update(loggedinUser);
        this.userService.update(friend);

        this.redirect("/friends");
    }

    public List<FriendViewModel> getFriends() {
        return friends;
    }

    public void setFriends(List<FriendViewModel> friends) {
        this.friends = friends;
    }
}
