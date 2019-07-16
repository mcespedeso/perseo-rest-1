package py.com.ideasweb.perseo.common.constants;

import static py.com.ideasweb.perseo.common.constants.ProtectedResource.API_ROOT;

import py.com.ideasweb.perseo.seguridad.constants.Role;

/**
 * Created by mcespedes
 */
public enum ProtectedModule implements ProtectableModule {

    ORGANIZATIONS {
        private String[] urls = {
                API_ROOT + "/cliente-servicio",
                API_ROOT + "/cliente-servicio/**", API_ROOT + "/factura",
                API_ROOT + "/factura/**", API_ROOT + "/usuarios",
                API_ROOT + "/usuarios/**", API_ROOT + "/user-applications",
                API_ROOT + "/users-applications/**", API_ROOT + "/users",
                API_ROOT + "/user-roles", API_ROOT + "/user-roles/**",
                API_ROOT + "/families", API_ROOT + "/families/**",
                API_ROOT + "/cities", API_ROOT + "/cities/**",
                API_ROOT + "/countries", API_ROOT + "/countries/**",
                API_ROOT + "/parameters", API_ROOT + "/parameters/**",
                API_ROOT + "/people", API_ROOT + "/people/**", };

        private String[] readRoles = {
                Role.ROLE_ADMIN.getSecurityName(),
                Role.ROLE_USER.getSecurityName() };

        private String[] writeRoles = {
                Role.ROLE_ADMIN.getSecurityName(),
                Role.ROLE_USER.getSecurityName() };

        @Override
        public String[] getUrls() {
            return urls;
        }

        @Override
        public String[] getReadRoles() {
            return readRoles;
        }

        @Override
        public String[] getWriteRoles() {
            return writeRoles;
        }

    },
    ADMINISTRACION {
        private String[] urls = {
                API_ROOT + "/surveys", API_ROOT + "/surveys/**",
                API_ROOT + "/snapshots", API_ROOT + "/snapshots/**" };

        private String[] readRoles = {
                Role.ROLE_ADMIN.getSecurityName(),
                Role.ROLE_USER.getSecurityName() };

        private String[] writeRoles = {
                Role.ROLE_ADMIN.getSecurityName() };

        @Override
        public String[] getUrls() {
            return urls;
        }

        @Override
        public String[] getReadRoles() {
            return readRoles;
        }

        @Override
        public String[] getWriteRoles() {
            return writeRoles;
        }
    }

}
