/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bylizzy.mexicoint.data.api;

import bylizzy.mexicoint.data.dto.cliente.MovimientosProductoResponseDTO;
import bylizzy.mexicoint.data.dto.cliente.MovimientosProductosResponseDTO;
import bylizzy.mexicoint.data.dto.cliente.MovimientosResponseDTO;
import bylizzy.mexicoint.data.dto.cliente.ProductoDTO;
import bylizzy.mexicoint.data.dto.cliente.SolicitarProductosObteniblesResponseDTO;
import bylizzy.mexicoint.data.dto.cliente.SolicitarProductosPoseidosRequestDTO;
import bylizzy.mexicoint.data.dto.cliente.SolicitarProductosPoseidosResponseDTO;
import bylizzy.mexicoint.models.Documento;
import bylizzy.mexicoint.models.Documentos;
import bylizzy.mexicoint.data.dto.cliente.ProductoDetalladoResponseDTO;
import bylizzy.mexicoint.models.Productos;
import bylizzy.mexicoint.data.dto.cliente.ProductosDetalladosResponseDTO;
import bylizzy.mexicoint.models.Movimientos;
import bylizzy.mexicoint.models.ProductosResp;
import bylizzy.mexicoint.models.ProductosSolicitables;
import bylizzy.mexicoint.utils.ControlSesion;
import bylizzy.mexicoint.utils.ControlVista;
import bylizzy.mexicoint.utils.RutasApiService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

/**
 *
 * @author La rana
 */
public class ClienteApi {

    RutasApiService rutApi = new RutasApiService();

    //MENUCLIENTE
    public SolicitarProductosPoseidosResponseDTO solicitarProducto() throws InterruptedException {
        try {
            ObjectMapper mapper = new ObjectMapper();

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(rutApi.getSolicitarProductosObtenidos()))
                    .header("Authorization" ,"Bearer " + ControlSesion.getUsuario().getToken())
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request ,HttpResponse.BodyHandlers.ofString());

            //respuestas:
            //bien
            if (response.statusCode() == 200) {
                //json a dto
                return mapper.readValue(response.body() ,SolicitarProductosPoseidosResponseDTO.class);
            }

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public SolicitarProductosObteniblesResponseDTO solicitarObtenerProducto() throws InterruptedException ,IOException {
        ObjectMapper mapper = new ObjectMapper();

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(rutApi.getSolicitarProductosObtenibles()))
                .header("Authorization" ,"Bearer " + ControlSesion.getUsuario().getToken())
                .GET()
                .build();

        HttpResponse<String> response = client.send(request ,HttpResponse.BodyHandlers.ofString());

        //respuestas:
        //bien
        if (response.statusCode() == 200) {
            //json a dto
            //SolicitarProductosObteniblesResponseDTO contenido = 
            return mapper.readValue(response.body() ,SolicitarProductosObteniblesResponseDTO.class);
            //List<ProductoDTO> debito = contenido.getProductos().getDebito();

            //List<ProductoDTO> credito = contenido.getProductos().getCredito();
        }
        return null;
    }

    //CLUD
    // ENCABEZADO
    //MENU CLIENTE
    public static Productos solicitarProductoscrud() {
        try {
            InputStream input = ClienteApi.class.getResourceAsStream(ControlVista.DATOS_PRODUCTOS_CLIENTE);
            ObjectMapper map = new ObjectMapper();
            return map.readValue(input ,Productos.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    //MENU CLIENTE

    public static ProductosSolicitables solicitarProductosSolicitablescrud() {
        try {
            InputStream input = ClienteApi.class.getResourceAsStream(ControlVista.DATOS_PRODUCTOS_SOLICITABLES_CLIENTE);
            ObjectMapper map = new ObjectMapper();
            ProductosResp respo = map.readValue(input ,ProductosResp.class);
            return respo.getProductos();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // PROCESO DE SOLICITARPRODUCTO
    public static Documentos verificarDocumentosNecesarioscrud() {
        try {
            InputStream input = ClienteApi.class.getResourceAsStream(ControlVista.DATOS_DOCUMENTOS_SOLICITADOS);
            ObjectMapper map = new ObjectMapper();
            Documentos docs = map.readValue(input ,Documentos.class);
            return docs;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //SOLICITAR PRODUCTO
    public static void procesarSolicitudcrud(String id) {
        System.out.println("ClienteApi: proceso solicitado" + id);
    }

    // HOME
    //CLIENTEPRODUCTO
    //consume el api para obtener la informacion general de un producto
    //para mostrarla al cliente en el home
    public ProductoDetalladoResponseDTO solicitarInfoProductocrud(int id) {
        //si id es 0 entonces se solicitara la tarjeta debito para mostrar como opcion default
        if (id == 0) {
            id = 1;
        }
        try {
            //creamos responseDTO vacio
            InputStream input = ClienteApi.class.getResourceAsStream(ControlVista.DATOS_PRODUCTOS_INFORMACION_CLIENTE);
            ObjectMapper map = new ObjectMapper();
            ProductosDetalladosResponseDTO response = map.readValue(input ,ProductosDetalladosResponseDTO.class);
            //lee el json fake api
            for (ProductoDetalladoResponseDTO p : response.getProductos()) {
                //selecciona el registro de id que se pide
                if (p.getId() == id) {
                    System.out.println("solicitarInfoProductoCrud. id: " + id + " producto por retornar: ");
                    System.out.println(map.writerWithDefaultPrettyPrinter().writeValueAsString(p));
                    //guarda en responseDTO
                    return p;
                }
            }
            //error
            return null;
            //si no hay nada en responseDTO
            //se retorna responseDTO con mensaje
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //solicita los ultimos 7 movimientos de un producto (basado en su id del producto 
    //y relacionado al cliente), ademas recibe un int filtro:
    // 0 = sin filtro
    // 1 = solo ingresos
    // 2 = solo gastos
    public List<Movimientos> solicitarMovimientosProducto(int id ,int filtro) {
        String json = null;
        switch (filtro) {
            case 0:
                json = ControlVista.DATOS_MOVIMIENTOS_TODOS_PRODUCTOS;
                break;
            case 1:
                json = ControlVista.DATOS_MOVIMIENTOS_INGRESOS_PRODUCTOS;
                break;
            case 2:
                json = ControlVista.DATOS_MOVIMIENTOS_GASTOS_PRODUCTOS;
                break;
            default:
                json = ControlVista.DATOS_MOVIMIENTOS_TODOS_PRODUCTOS;
                break;
        }

        try {
            //creamos responseDTO vacio
            InputStream input = ClienteApi.class.getResourceAsStream(json);

            ObjectMapper mapper = new ObjectMapper();
            MovimientosProductosResponseDTO response = mapper.readValue(input ,MovimientosProductosResponseDTO.class);

            //lee el json fake api
            for (MovimientosProductoResponseDTO p : response.getProductos()) {
                //selecciona el registro de id que se pide
                if (p.getId() == id) {
                    System.out.println("solicitarMovimientosProducto. id: " + id + " producto por retornar: ");
                    System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(p));
                    //guarda en responseDTO
                    return p.toModel().getMovimientos();
                }
            }
            //error
            return null;
            //si no hay nada en responseDTO
            //se retorna responseDTO con mensaje
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
