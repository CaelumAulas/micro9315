package br.com.caelum.apigateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
class DistanciaRestClientFallback implements DistanciaRestClient {

    @Override
    public List<Map<String, Object>> buscaRestaurantesPeloCep(String cep) {
        log.info("realizando chamada de fallback para o cep {}", cep);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("cep", cep);

        return Arrays.asList(hashMap);
    }
}
