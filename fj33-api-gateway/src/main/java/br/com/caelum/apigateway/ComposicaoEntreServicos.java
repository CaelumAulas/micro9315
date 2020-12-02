package br.com.caelum.apigateway;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@AllArgsConstructor
@Slf4j
public class ComposicaoEntreServicos {

    private DistanciaRestClient distanciaRestClient;
    private RestaunranteRestClient restaunranteRestClient;


    public Map<String, Object> porCepEIdComDistancia(@PathVariable("cep") String cep,
                                                     @PathVariable("restauranteId") Long restauranteId) {

        Map<String, Object> dadosRestaurante = restaunranteRestClient.porId(restauranteId);
        List<Map<String, Object>> dadosDistancia = distanciaRestClient.buscaRestaurantesPeloCep(cep);

        dadosDistancia.forEach(distancia -> {
            dadosRestaurante.putAll(distancia);
        });

        return dadosRestaurante;
    }
}
