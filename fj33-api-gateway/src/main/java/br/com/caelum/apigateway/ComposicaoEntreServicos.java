package br.com.caelum.apigateway;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class ComposicaoEntreServicos {

    private DistanciaRestClient distanciaRestClient;
    private RestauranteRestClient restaunranteRestClient;
    private MeterRegistry meterRegistry;
    private Counter restauranteCounter;

    public ComposicaoEntreServicos(DistanciaRestClient distanciaRestClient, RestauranteRestClient restaunranteRestClient, MeterRegistry meterRegistry) {
        this.distanciaRestClient = distanciaRestClient;
        this.restaunranteRestClient = restaunranteRestClient;
        this.meterRegistry = meterRegistry;
        inicializaContadores();
    }

    public Map<String, Object> porCepEIdComDistancia(@PathVariable("cep") String cep,
                                                     @PathVariable("restauranteId") Long restauranteId) {

        Map<String, Object> dadosRestaurante = restaunranteRestClient.porId(restauranteId);
        List<Map<String, Object>> dadosDistancia = distanciaRestClient.buscaRestaurantesPeloCep(cep);

        dadosDistancia.forEach(distancia -> {
            dadosRestaurante.putAll(distancia);
        });

        restauranteCounter.increment();
        return dadosRestaurante;
    }

    private void inicializaContadores() {
        restauranteCounter = Counter.builder("apigateway.restaurante.calls")    // 2 - create a counter using the fluent API
                .tag("type", "composition")
                .description("Numero de chamadas para composição de serviços")
                .register(meterRegistry);
    }
}
