/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bylizzy.mexicoint.utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author La rana
 */
public class ValidacionesService {

    /*
     * TODAS LAS VALIDACIONES DEBEN REGRESAR UN MENSAJE DE ERROR DESCRIBIENDO POR QUE FALLLARON. ESTE DEBE SER String.
     */
    public record Validacion(boolean estado ,String mensaje) {

    }

    /*
     * CURP 
     * aceptar formato alfanumerico CONTR
     * no aceptar caracteres especiales CONTR
     * no aceptar espacios CONTR
     * tener longitud exacta de 18 caracteres FXML Y AQUI
     * no debe estar previamente registrada en el sistema AQUI - BACK
     */
    public Validacion curp(String curp) {
        //si todo sale bien se regresa un true
        if (curp.length() == 18) {
            return new Validacion(true ,"");
        }//
        else if (curp.length() != 18) {
            return new Validacion(false ,"CURP incompleta.");
        }

        return new Validacion(false ,"Error desconocido.");
    }

    public Validacion curpRegistrada(String curp) {
        //peticion con la api al back
        if (true) {
            return new Validacion(true ,"");
        }
        return new Validacion(false ,"Error desconocido.");
    }

    /*
     * ===== CONTRASEÑA =====
     * aceptar cualquier tipo de caracter String
     * tener minimo 8 caracteres AQUI
     * tener maximo 50 caracteres CONTR
     * tener al menos un caracter especial AQUI
     * tener minimo un caracter mayuscula AQUI
     */
    public Validacion contrasena(String contrasena) {
        if (contrasena.length() >= 8 && caracterMayus(contrasena) && caracterEspecial(contrasena)) {
            return new Validacion(true ,"");
        } else if (contrasena.length() < 8) {
            return new Validacion(false ,"Debe tener minimo 8 caracteres.");
        } else if (!caracterMayus(contrasena)) {
            return new Validacion(false ,"Debe tener al menos un caracter en mayuscula.");
        } else if (!caracterEspecial(contrasena)) {
            return new Validacion(false ,"Debe tener al menos un caracter especial.");
        }
        return new Validacion(false ,"Error desconocido.");
    }

    public Validacion contrasenaCorrecta(String contrasena ,String confirmar) {
        if (confirmar.equals(contrasena)) {
            return new Validacion(true ,"");
        } else if (!confirmar.equals(contrasena)) {
            return new Validacion(false ,"Las contraseñas no coinciden.");
        }
        return new Validacion(false ,"Error desconocido.");
    }

    /*
     * ===== CONFIRMAR CONTRASEÑA =====
     * debe ser identica a la contraseña
     */
    public Validacion confirmarContrasena(String contrasena ,String confirmar) {
        if (contrasena == confirmar) {
            return new Validacion(true ,"");
        } else {
            return new Validacion(false ,"Las contraseñas no coinciden.");
        }
    }

    /*
     * ===== NOMBRE(S) =====
     * solo caracteres alfabeticos CONTR
     * minimo 3 caracteres sin contar espacios AQUI
     * maximo 100 caracteres CONTR
     */
    public Validacion nombre(String nombre) {
        if (nombre.length() >= 3 && espacioAlInicio(nombre)) {
            return new Validacion(true ,"");
        } else if (nombre.length() < 3) {
            return new Validacion(false ,"Minimo nombres de 3 letras.");
        } else if (!espacioAlInicio(nombre)) {
            return new Validacion(false ,"No puedes usar espacio en las primeras 3 letras.");
        } else {
            return new Validacion(false ,"Error desconocido.");
        }
    }

    /*
     * ===== APELLIDO PATERNO =====
     * solo caracteres alfabeticos CONTR
     * minimo 3 caracteres sin contar espacios AQUI
     * maximo 55 caracteres CONTR
     */
    public Validacion apellido(String apellido) {
        if (apellido.length() >= 3 && espacioAlInicio(apellido)) {
            return new Validacion(true ,"");
        } else if (apellido.length() < 3) {
            return new Validacion(false ,"Minimo 3 letras");
        } else if (!espacioAlInicio(apellido)) {
            return new Validacion(false ,"No puedes usar espacio en las primeras 3 letras.");
        }
        return new Validacion(false ,"Error desconocido.");
    }

    /*
     * ===== FECHA DE NACIMIENTO =====
     * listar formatos validos CONTR
     * detectar si esta vacio AQUI
     * mayoria de edad AQUI
     */
    public Validacion fechaNacimiento(String fecha) {
        boolean vacio = fecha == null || fecha.trim().isEmpty();
        if (!vacio) {
            LocalDate hoy = LocalDate.now();
            LocalDate nacimiento = LocalDate.parse(fecha.trim() ,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            int edad = Period.between(nacimiento ,hoy).getYears();
            if (edad >= 18) {
                return new Validacion(true ,"");
            } else {
                return new Validacion(false ,"No se permiten menores de 18.");
            }
        } else {
            return new Validacion(false ,"Campo vacio.");
        }
    }

    /*
     * ===== CALLE =====
     * alfanumerico mexicano y .-# CONTR y AQUI
     * minimo 5 caracteres AQUI
     * maximo 75 caracteres FXML
     */
    public Validacion calle(String calle) {
        if (calle.length() >= 5) {
            return new Validacion(true ,"");
        } else if (calle.length() < 5) {
            return new Validacion(false ,"Minimo 5 letras.");
        }
        return new Validacion(false ,"Error desconocido.");
    }

    /*
     * ===== NUMERO EXTERIOR =====
     * solo numerico + letra opcional CONTR y AQUI
     * minimo 1 caracter AQUI
     * maximo 10 caracteres CONTR
     */
    public Validacion numeroExterior(String numero) {
        boolean vacio = numero == null || numero.trim().isEmpty();
        if (!vacio) {
            return new Validacion(true ,"");
        } else if (vacio) {
            return new Validacion(false ,"Campo vacio.");
        }

        return new Validacion(false ,"Error desconocido.");
    }

    /*
     * ===== NUMERO INTERIOR =====
     * opcional
     * solo numerico + letra opcional CONTR y AQUI
     * maximo 10 caracteres CONTR
     * si esta vacio no genera error * 
     */
    public Validacion numeroInterior(String numero) {
        boolean esnull = numero == null;
        if (!esnull) {
            return new Validacion(true ,"");
        }
        return new Validacion(false ,"Error desconocido.");
    }

    /*
     * ===== COLONIA / BARRIO =====
     * alfanumerico mexicano CONTR Y AQUI
     * minimo 3 caracteres AQUI
     * maximo 75 caracteres CONTR
     */
    public Validacion coloniaBarrio(String coloniaBarrio) {
        if (coloniaBarrio.length() >= 3) {
            return new Validacion(true ,"");
        } else if (coloniaBarrio.length() < 3) {
            return new Validacion(false ,"Minimo 3 letras.");
        }

        return new Validacion(false ,"Error desconocido.");
    }

    /*
     * ===== CODIGO POSTAL =====
     * solo numerico AQUI Y CONTR
     * longitud exacta de 5 caracteres AQUI 
     */
    public Validacion codigoPostal(String codigo) {
        if (codigo.length() == 5) {
            return new Validacion(true ,"");
        } else if (codigo.length() != 5) {
            return new Validacion(false ,"Codigo postal incompleto.");
        }

        return new Validacion(false ,"Error desconocido.");
    }

    /*
     * ===== CIUDAD / MUNICIPIO =====
     * solo letras espacios y acentos
     * minimo 3 caracteres
     * maximo 75 caracteres
     */
    public Validacion ciudadMunicipio(String ciudadMunicipio) {
        if (ciudadMunicipio.length() >= 3) {
            return new Validacion(true ,"");
        } else if (ciudadMunicipio.length() < 3) {
            return new Validacion(false ,"Minimo 3 letras.");
        }
        return new Validacion(false ,"Error desconocido.");
    }

    /*
     * ===== ESTADO =====
     * no debe ser la opcion por default
     */
    public Validacion estado(String estado) {
        if (!"Seleccionar estado".equals(estado)) {
            return new Validacion(true ,"");
        } else if ("Seleccionar estado".equals(estado)) {
            return new Validacion(false ,"Selecciona un estado.");

        }
        return new Validacion(false ,"Error desconocido.");
    }

    /*
     * ====== PAIS ======
     * no debe ser la opcion por default
     */
    public Validacion pais(String pais) {
        if (!"Seleccionar pais".equals(pais)) {
            return new Validacion(true ,"");
        } else if ("Seleccionar pais".equals(pais)) {
            return new Validacion(false ,"Selecciona un pais.");
        }
        return new Validacion(false ,"Error desconocido.");
    }

    /*
     * ===== CODIGO (RECUPERACION) =====
     * solo numerico
     * longitud exacta de 9 caracteres
     */
    public Validacion codigo(String codigo) {
        if(codigo.length()==9){
            return new Validacion(true, "");
        }
        else if(codigo.length()<=9){
            return new Validacion(false,"Codigo demaciado corto.");
        }
        return new Validacion(false,"Error desconocido.");
    }
    
    public Validacion codigoCorrecto(String codigo){
        return new Validacion(false,"Error desconocido");
    }

    /*
     * Regex
     */
    public boolean alfanumerico(String dato) {
        return dato.matches("[a-zA-Z0-9]*");
    }

    public boolean alfanumericoMexicano(String dato) {
        return dato.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]*");
    }

    public boolean espacioAlInicio(String dato) {
        return dato.matches("^\\S{3}.*");
    }

    public boolean regexNombre(String dato) {
        return dato.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]{0,100}");
    }

    public boolean regexApellido(String dato) {
        return dato.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]{0,55}");
    }

    public boolean regexCurp(String dato) {
        return dato.matches("[a-zA-Z0-9]{0,18}");
    }

    public boolean regexCalle(String dato) {
        return dato.matches("[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ .#/-]{0,75}");
    }

    public boolean regexNumeroExt(String dato) {
        return dato.matches("[0-9A-Za-z/-]{0,10}");
    }

    public boolean regexNumeroInt(String dato) {
        return dato.matches("[0-9A-Za-z/-]*");
    }

    public boolean regexColoniaBarrio(String dato) {
        return dato.matches("[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ ]{0,75}");
    }

    public boolean regexCodigoPostal(String dato) {
        return dato.matches("[\\d]{0,5}");
    }

    public boolean regexCiudadMunicipio(String dato) {
        return dato.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]{0,75}");
    }

    public boolean regexContrasena(String dato) {
        return dato.matches("^(?=.*[A-Z])(?=.*[\\W_]).[a-z0-9].{0,55}$");
    }

    public boolean caracterMayus(String dato) {
        return dato.matches(".*[A-Z].*");
    }

    public boolean caracterEspecial(String dato) {
        return dato.matches(".*[^a-zA-Z0-9\\s].*");
    }

    public boolean regexCodigo(String dato){
        return dato.matches("[0-9]{0,9}");
    }
}
