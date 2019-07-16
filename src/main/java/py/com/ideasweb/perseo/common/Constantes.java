package py.com.ideasweb.perseo.common;

public class Constantes {

    public static final String EMAIL_MF = "clubdeclientes@fundacionparaguaya.org.py";
    public static final String EMAIL_TI = "appfupa@fundacionparaguaya.org.py";
    public static final int BUTTONS_TO_SHOW = 5;
    public static final int INITIAL_PAGE = 0;
    public static final int INITIAL_PAGE_SIZE = 5;
    public static final int[] PAGE_SIZES = { 5, 10, 20 };
    
    public static final int TIMEPO_INTENTOS_PERMITIDOS = 20; //en minutos
    public static final int CANTIDAD_INTENTOS_PERMITIDOS = 10;
    public static final String EMAIL_ADMIN = "sistema@fundacionparaguaya.org.py";
    
    public static final Double PRECIO_VALE_NEGOCIOS = new Double(50000);

    /*public static final String getTemporalPass() {
        String password = "temporal";
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }*/

}
