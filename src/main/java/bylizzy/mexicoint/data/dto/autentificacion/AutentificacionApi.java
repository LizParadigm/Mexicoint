/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bylizzy.mexicoint.data.dto.autentificacion;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 *
 * @author La rana
 */
public class AutentificacionApi {

    //FACTORIZAR
    public SolicitarAccesoResponseDTO solicitarAcceso(String curp ,String contrasena) throws JsonProcessingException ,InterruptedException {
        try {
            //crear SolicitarAccesoRequestDTO
            SolicitarAccesoRequestDTO requestDTO = new SolicitarAccesoRequestDTO(curp,contrasena);

            //realizar la llamada al api
            ObjectMapper mapper = new ObjectMapper();

            String json = mapper.writeValueAsString(requestDTO);

            //crear cliente
            HttpClient client = HttpClient.newHttpClient();

            //crear request http
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8080/auth/login"))
                    .header("Content-Type" ,"application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();

            //enviar request
            HttpResponse<String> response = client.send(request ,HttpResponse.BodyHandlers.ofString());

            //respuestas:
            //bien
            if (response.statusCode() == 200) {
                //json a dto
                return mapper.readValue(response.body() ,SolicitarAccesoResponseDTO.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return null;

    }

    private SolicitarAccesoResponseDTO parseResponse(String json) {
        // Simulación (usa Gson en real)
        SolicitarAccesoResponseDTO dto = new SolicitarAccesoResponseDTO();
        dto.curp = "VEGA780615HDFLML08";
        dto.rol = "ADMIN";
        dto.token = "ejemplodetoken123bien123cabron321";
        return dto;
    }
}
