/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bylizzy.mexicoint.data.api;

import bylizzy.mexicoint.data.dto.IniciarSesionDTO;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author La rana
 */
public class AutentificacionApi {
    public IniciarSesionDTO validarCredenciales(String curp, String contrasena) {
        //esto lo saque de chatgpt asi que no son ni las direcciones ni nada seguro, aun no lo pruebo si funciona diego.
        try {
            URL url = new URL("https://api.tuservidor.com/login");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String jsonInput = String.format(
                "{\"email\":\"%s\",\"password\":\"%s\"}", curp, contrasena
            );

            try (OutputStream os = conn.getOutputStream()) {
                os.write(jsonInput.getBytes());
            }

            InputStream is = conn.getInputStream();
            String response = new String(is.readAllBytes());

            // Aquí parseas JSON → DTO (puedes usar Gson o Jackson)
            return parseResponse(response);

        } catch (Exception e) {
            throw new RuntimeException("Error en login API", e);
        }
    }

    private IniciarSesionDTO parseResponse(String json) {
        // Simulación (usa Gson en real)
        IniciarSesionDTO dto = new IniciarSesionDTO();
        dto.curp = "VEGA780615HDFLML08";
        dto.rol = "ADMIN";
        dto.token = "ejemplodetoken123bien123cabron321";
        return dto;
    }
}
