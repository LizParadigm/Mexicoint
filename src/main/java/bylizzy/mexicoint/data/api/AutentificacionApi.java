/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bylizzy.mexicoint.data.api;

import bylizzy.mexicoint.data.dto.autentificacion.CambiarContrasenaRequestDTO;
import bylizzy.mexicoint.data.dto.autentificacion.CambiarContrasenaResponseDTO;
import bylizzy.mexicoint.data.dto.autentificacion.ComprobarCodigoRequestDTO;
import bylizzy.mexicoint.data.dto.autentificacion.ComprobarCodigoResponseDTO;
import bylizzy.mexicoint.data.dto.autentificacion.ComprobarCurpRequestDTO;
import bylizzy.mexicoint.data.dto.autentificacion.ComprobarCurpResponseDTO;
import bylizzy.mexicoint.data.dto.autentificacion.CrearClienteRequestDTO;
import bylizzy.mexicoint.data.dto.autentificacion.CrearClienteResponseDTO;
import bylizzy.mexicoint.data.dto.autentificacion.SolicitarAccesoRequestDTO;
import bylizzy.mexicoint.data.dto.autentificacion.SolicitarAccesoResponseDTO;
import bylizzy.mexicoint.utils.RutasApiService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 *
 * @author La rana
 */
public class AutentificacionApi {

    RutasApiService rutApi = new RutasApiService();

    //COMUN
    public ComprobarCurpResponseDTO comprobarCurp(String curp) throws InterruptedException {
        try {
            ComprobarCurpRequestDTO requestDto = new ComprobarCurpRequestDTO(curp);

            ObjectMapper mapper = new ObjectMapper();

            String json = mapper.writeValueAsString(requestDto);

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(rutApi.getComprobarCurp()))
                    .header("Content-Type" ,"aplication/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();

            HttpResponse<String> response = client.send(request ,HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                //json a dto
                return mapper.readValue(response.body() ,ComprobarCurpResponseDTO.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // INICIAR SESION
    public SolicitarAccesoResponseDTO solicitarAcceso(String curp ,String contrasena) throws JsonProcessingException ,InterruptedException {
        try {
            //crear SolicitarAccesoRequestDTO
            SolicitarAccesoRequestDTO requestDTO = new SolicitarAccesoRequestDTO(curp ,contrasena);

            //realizar la llamada al api
            ObjectMapper mapper = new ObjectMapper();

            String json = mapper.writeValueAsString(requestDTO);

            //crear cliente
            HttpClient client = HttpClient.newHttpClient();

            //crear request http
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(rutApi.getSolicitarAcceso()))
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

    //REGISTRAR CLIENTE
    public CrearClienteResponseDTO crearCliente(String nombre ,String apellido_p ,String apellido_m ,String fecha_nacimiento ,String curp ,String calle ,String num_ext ,String num_int ,String colonia_barrio ,String codigo_postal ,String ciudad_municipio ,String estado ,String pais ,String contrasena) throws JsonProcessingException ,IOException ,InterruptedException {
        try {
            CrearClienteRequestDTO requestDTO = new CrearClienteRequestDTO(nombre ,apellido_p ,apellido_m ,fecha_nacimiento ,curp ,calle ,num_ext ,num_int ,colonia_barrio ,codigo_postal ,ciudad_municipio ,estado ,pais ,contrasena);

            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(requestDTO);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(rutApi.getSolicitarAcceso()))
                    .header("Content-Type" ,"application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();

            HttpResponse<String> response = client.send(request ,HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                //json a dto
                return mapper.readValue(response.body() ,CrearClienteResponseDTO.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //RECUPERAR CUENTA
    public ComprobarCodigoResponseDTO comprobarCodigo(String codigo) throws InterruptedException {
        try {
            ComprobarCodigoRequestDTO requestDTO = new ComprobarCodigoRequestDTO(codigo);

            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(requestDTO);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(rutApi.getComprobarCodigo()))
                    .header("Content-Type" ,"application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();

            HttpResponse<String> response = client.send(request ,HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                //json a dto
                return mapper.readValue(response.body() ,ComprobarCodigoResponseDTO.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public CambiarContrasenaResponseDTO cambiarContrasena(String curp ,String codigo ,String contrasena) throws InterruptedException {
        try {
            CambiarContrasenaRequestDTO requestDTO = new CambiarContrasenaRequestDTO(curp ,codigo ,contrasena);

            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(requestDTO);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(rutApi.getCambiarContrasena()))
                    .header("Content-Type" ,"application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();

            HttpResponse<String> response = client.send(request ,HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                //json a dto
                return mapper.readValue(response.body() ,CambiarContrasenaResponseDTO.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
