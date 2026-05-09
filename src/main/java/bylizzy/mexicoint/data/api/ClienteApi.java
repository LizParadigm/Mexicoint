/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bylizzy.mexicoint.data.api;

import bylizzy.mexicoint.models.Documento;
import bylizzy.mexicoint.models.Documentos;
import bylizzy.mexicoint.models.Productos;
import bylizzy.mexicoint.models.ProductosResp;
import bylizzy.mexicoint.models.ProductosSolicitables;
import bylizzy.mexicoint.utils.ControlVista;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author La rana
 */
public class ClienteApi {

    public static Productos solicitarProducto() {
        try {
            InputStream input = ClienteApi.class.getResourceAsStream(ControlVista.DATOS_PRODUCTOS_CLIENTE);
            ObjectMapper map = new ObjectMapper();
            return map.readValue(input ,Productos.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ProductosSolicitables solicitarProductosSolicitables() {
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

    public static Documentos verificarDocumentosNecesarios() {
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

    public static void obtenerProducto(String id) {
        System.out.println("ClienteApi: proceso solicitado" + id);
    }

}
