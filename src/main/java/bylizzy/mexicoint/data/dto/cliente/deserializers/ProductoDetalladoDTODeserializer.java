/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bylizzy.mexicoint.data.dto.cliente.deserializers;

import bylizzy.mexicoint.data.dto.cliente.ProductoDetalladoCreditoResponseDTO;
import bylizzy.mexicoint.data.dto.cliente.ProductoDetalladoDebitoResponseDTO;
import bylizzy.mexicoint.data.dto.cliente.ProductoDetalladoResponseDTO;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

/**
 *
 * @author La rana
 */
public class ProductoDetalladoDTODeserializer extends JsonDeserializer<ProductoDetalladoResponseDTO> {

    @Override
    public ProductoDetalladoResponseDTO deserialize(JsonParser p ,DeserializationContext ctxt) throws IOException {
        ObjectMapper mapper = (ObjectMapper)p.getCodec();

        JsonNode node = mapper.readTree(p);

        return deserializeNode(node ,mapper);

    }

    public ProductoDetalladoResponseDTO deserializeNode(JsonNode node ,ObjectMapper mapper) throws IOException {
        String tipo = node.get("producto").get("tipo").asText();

        switch (tipo) {
            case "Debito":
                return mapper.convertValue(node ,ProductoDetalladoDebitoResponseDTO.class);
            case "Credito":
                return mapper.convertValue(node ,ProductoDetalladoCreditoResponseDTO.class);
            default:
                break;

        }

        throw new RuntimeException("Tipo desconocido: " + tipo);
    }

}
