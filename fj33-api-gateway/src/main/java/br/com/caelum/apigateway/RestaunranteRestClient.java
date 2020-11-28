package br.com.caelum.apigateway;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@FeignClient("monolito")
public interface RestaunranteRestClient {

    @GetMapping("/restaurantes/{id}")
    Map<String, Object> porId(@PathVariable("id") Long id);
}
