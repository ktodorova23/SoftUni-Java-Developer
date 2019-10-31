package app.web.beans;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@RequestScoped
public class LogoutBean extends RedirectBean {

    public void logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

        this.redirect("/index");
    }
}
