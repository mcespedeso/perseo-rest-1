package py.com.ideasweb.perseo.seguridad.constants;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Role {
    /**
     * Puede hacer de todo
     */
    ROLE_ADMIN,

    /**
     * Maneja servicios basicos para el usuario
     */
    ROLE_USER;

    private static final String SEPARATOR = "_";
    private static final String PREFIX = "ROLE";

    /**
     * Returns the name of this enum value without the {@link #PREFIX}. Spring
     * security works with role names without this prefix.
     *
     * @return
     */
    public String getSecurityName() {
        return Arrays.stream(this.name().split(SEPARATOR))
                .filter(part -> !part.equals(PREFIX))
                .collect(Collectors.joining(SEPARATOR));
    }
}