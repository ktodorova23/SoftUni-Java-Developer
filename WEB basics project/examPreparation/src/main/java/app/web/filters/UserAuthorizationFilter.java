package app.web.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter({"/views/home.jsf", "/views/profile.jsf", "/views/friends.jsf"})
public class UserAuthorizationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String id = request.getSession().getAttribute("userId").toString();

        if (id != null) {
            response.sendRedirect("/views/home.jsf");
            return;
        }

        filterChain.doFilter(request, response);
    }
}
