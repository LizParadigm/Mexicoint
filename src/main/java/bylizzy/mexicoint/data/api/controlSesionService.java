package bylizzy.mexicoint.data.api;

public class controlSesionService {

    private static String toksen;
    private static String rol;

    public controlSesionService(String token ,String rol) {
        this.toksen = token;
        this.rol = rol;
    }

    public static String getToken() {
        return toksen;
    }

    public static String getRol() {
        return rol;
    }

    public void limpiar() {
        this.toksen = null;
        this.rol = null;
    }

}
