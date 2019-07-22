package py.com.ideasweb.perseo.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Service;

@Service
public class BaseServiceImpl {

    @Autowired
    DataSource dataSource;

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

    public Long getSecuenceFromName(String name) throws Exception {

        Connection conn = null;
        Long value = new Long(0);
        try {
            conn = dataSource.getConnection();

            String seq = " select nextval('" + name + "') as seq ";

            PreparedStatement ps = conn.prepareStatement(seq);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                value = rs.getLong("seq");
            }
            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;

    }

    public Long getLastSecuenceFromName(String name) throws Exception {
        Connection conn = null;
        Long value = new Long(0);
        try {
            conn = dataSource.getConnection();

            String seq = " select last_value as seq from " + name;

            PreparedStatement ps = conn.prepareStatement(seq);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                value = rs.getLong("seq");
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

}
