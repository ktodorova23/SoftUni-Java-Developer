package app.web.beans;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.IOException;

@Named
@RequestScoped
public class RedirectBean {
    public void redirect(String url) {
        try {
            FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .redirect("/faces/views" + url + ".xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
