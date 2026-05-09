package bylizzy.mexicoint.data.api;

public class controlSesionService {

    private static String token;
    private static String rol;

    public controlSesionService(String token ,String rol) {
        this.token = token;
        this.rol = rol;
    }

    public static String getToken() {
        return token;
    }

    public static String getRol() {
        return rol;
    }

    public void limpiar() {
        this.token = null;
        this.rol = null;
    }

}
