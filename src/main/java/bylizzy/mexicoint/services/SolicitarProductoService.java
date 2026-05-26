/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bylizzy.mexicoint.services;

import bylizzy.mexicoint.data.api.ClienteApi;
import bylizzy.mexicoint.models.Controlador;
import bylizzy.mexicoint.models.Documento;
import bylizzy.mexicoint.models.Documentos;

/**
 *
 * @author La rana
 */
public class SolicitarProductoService extends Controlador {

    private String idProducto;
    private String nombreProducto;
    private Documentos documentos;

    public SolicitarProductoService() {
        this.documentos = ClienteApi.verificarDocumentosNecesarioscrud();
    }
    
    public void solicitudCompletada(){
        ClienteApi.procesarSolicitudcrud(this.idProducto);
    }
    
    
    
    
    
    
    
    
    

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        System.out.println("solicitud: " + idProducto);
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        System.out.println("solicitud: " + nombreProducto);
        this.nombreProducto = nombreProducto;
    }

    public Documentos getDocumentos() {
        return documentos;
    }

    public void setDocumentos(Documentos documentos) {
        this.documentos = documentos;
    }

}
