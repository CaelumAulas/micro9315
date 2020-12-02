package br.com.caelum.apigateway;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

@FeignClient(name = "distancia",fallback = DistanciaRestClientFallback.class)
public interface DistanciaRestClient {

    @GetMapping("/restaurantes/mais-proximos/{cep}")
    List<Map<String, Object>> buscaRestaurantesPeloCep(@PathVariable("cep") String cep);

}