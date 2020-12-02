package br.com.caelum.apigateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class RestaunranteRestClientFallback implements RestauranteRestClient {

    @Override
    public Map<String, Object> porId(Long id) {
        log.info("chamando o fallback para o restaurante {}", id);
        Map<String, Object> resultado = new HashMap<>();
        resultado.put("id", id);
        return resultado;
    }
}
