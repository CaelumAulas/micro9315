package br.com.caelum.apigateway;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
@AllArgsConstructor
public class RestaurantesComDistanciaController {

    private ComposicaoEntreServicos composicaoEntreServicos;


    @GetMapping("/restaurantes-com-distancia/{cep}/restaurante/{restauranteId}")
    public Map<String, Object> retornaRestaurantes(@PathVariable("cep") String cep,
                                                   @PathVariable("restauranteId") Long restauranteId) {
        return composicaoEntreServicos.porCepEIdComDistancia(cep, restauranteId);
    }

}
