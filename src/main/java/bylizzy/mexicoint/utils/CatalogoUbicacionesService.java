/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bylizzy.mexicoint.utils;

import bylizzy.mexicoint.models.Estado;
import bylizzy.mexicoint.models.Pais;
import java.util.List;

/**
 *
 * @author La rana
 */
public class CatalogoUbicacionesService {

    public static List<String> paises() {
        return List.of(
                "Seleccionar pais" ,
                "Mexico"
        );
    }

    public static Pais estados(String pais) {
        switch (pais) {
            case "Mexico":
                return new Pais(
                        "Mexico" ,List.of(
                                new Estado("AguasCalientes") ,
                                new Estado("Baja California") ,
                                new Estado("Baja California Sur") ,
                                new Estado("Campeche") ,
                                new Estado("Chiapas") ,
                                new Estado("Chihuahua") ,
                                new Estado("Ciudad de Mexico") ,
                                new Estado("Coahuila") ,
                                new Estado("Colima") ,
                                new Estado("Durango") ,
                                new Estado("Estado de Mexico") ,
                                new Estado("Guanajuato") ,
                                new Estado("Guerrero") ,
                                new Estado("Hidalgo") ,
                                new Estado("Jalisco") ,
                                new Estado("Michoacan") ,
                                new Estado("Morelos") ,
                                new Estado("Nayarit") ,
                                new Estado("Nuevo Leon") ,
                                new Estado("Oaxaca") ,
                                new Estado("Puebla") ,
                                new Estado("Queretaro") ,
                                new Estado("Quintana Roo") ,
                                new Estado("San Luis Potosi") ,
                                new Estado("Sinaloa") ,
                                new Estado("Sonora") ,
                                new Estado("Tabasco") ,
                                new Estado("Tamauliás") ,
                                new Estado("Tlaxcala") ,
                                new Estado("Veracruz") ,
                                new Estado("Yucatan") ,
                                new Estado("Zacatecas")
                        ));
            default:

                return null;
        }
    }
}
