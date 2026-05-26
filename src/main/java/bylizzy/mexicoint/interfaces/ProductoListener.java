/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bylizzy.mexicoint.interfaces;

/**
 *
 * @author La rana
 */
public interface ProductoListener {
    void seleccionarProducto(
            String id,
            String nombre
    );
    
    void nuevoProductoPrincipal(
            int id
    );
    
    void cerrarMenuLateral();
}
