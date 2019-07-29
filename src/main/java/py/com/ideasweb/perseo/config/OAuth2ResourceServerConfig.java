package py.com.ideasweb.perseo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

import py.com.ideasweb.perseo.common.constants.ProtectedModule;
import py.com.ideasweb.perseo.seguridad.constants.Role;

/**
 * Created by mcespedes
 */
@Configuration
@EnableResourceServer

public class OAuth2ResourceServerConfig
        extends ResourceServerConfigurerAdapter {

    private static final String RESOURCE_ID = "resources";

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests().antMatchers("/api/**")
                .hasRole(Role.ADMIN.getSecurityName())
                
                // Organizations related resources
                // .antMatchers(ProtectedModule.PACIENTE.getUrls()).hasAnyRole(ProtectedModule.ORGANIZATIONS.getWriteRoles())
                .antMatchers(ProtectedModule.ORGANIZATIONS.getUrls())
                .authenticated();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources)
            throws Exception {
        resources.resourceId(RESOURCE_ID);
    }

}