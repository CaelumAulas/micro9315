package br.com.caelum.eats;

import br.com.caelum.eats.administrativo.TipoDeCozinha;
import br.com.caelum.eats.restaurante.Restaurante;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.context.junit4.SpringRunner;
import br.com.caelum.eats.restaurante.DistanciaRestClient;
import org.springframework.web.client.RestTemplate;


@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureStubRunner(ids = "br.com.caelum:eats-distancia-service:+:stubs:9991", stubsMode = StubRunnerProperties.StubsMode.LOCAL)
public class TestDistanciaService {

    private DistanciaRestClient distanciaRestClient;

    @Before
    public void before() {
        RestTemplate restTemplate = new RestTemplate();
        distanciaRestClient = new DistanciaRestClient(restTemplate, "http://localhost:9992");
    }


    @Test
    public void deveAdiconarRestaurante() {
        TipoDeCozinha tipoDeCozinha = new TipoDeCozinha(1L, "Chinesa");

        Restaurante restaurante = new Restaurante();
        restaurante.setId(2L);
        restaurante.setCep("71500-000");
        restaurante.setTipoDeCozinha(tipoDeCozinha);

        distanciaRestClient.novoRestauranteAprovado(restaurante);

    }
}
