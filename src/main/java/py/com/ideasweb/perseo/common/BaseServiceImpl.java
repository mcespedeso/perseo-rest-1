package py.com.ideasweb.perseo.common;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

public class BaseServiceImpl {

    public static final String getTemporalPass() {
        String password = "temporal";
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }

    public String getHashPassword(String pass) {

        pass = BCrypt.hashpw(pass, BCrypt.gensalt(10));

        return pass;

    }

    public Boolean checkHashPassword(String pass, String pass2)
            throws Exception {
        BCryptPasswordEncoder cryp = new BCryptPasswordEncoder();

        if (cryp.matches(pass2, pass)) {
            return true;
        } else {
            return false;

        }
    }
    
    public String getUserPrincipal() {
        OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) SecurityContextHolder
                .getContext().getAuthentication();
        Authentication userAuthentication = oAuth2Authentication
                .getUserAuthentication();
        return userAuthentication.getName();
    }
    
  

}
