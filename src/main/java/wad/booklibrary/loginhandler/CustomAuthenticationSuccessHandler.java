package wad.booklibrary.loginhandler;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import wad.booklibrary.User;
import wad.booklibrary.service.UserService;

@Component
public class CustomAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler  {
    
    @Autowired
    private UserService userService;
            
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        String username = authentication.getName();
        User user = userService.findByUsername(username);
        HttpSession session = request.getSession();
        session.setAttribute("userId", user.getUserId());
        response.sendRedirect(request.getContextPath()+"/app/menu");
   }
}
