package br.com.caelum.eats.pagamento;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.MessageChannel;

@EnableBinding(RabbitPagamentoConfig.PagamentoSource.class)
@Configuration
public class RabbitPagamentoConfig {

    static interface PagamentoSource {

        @Output
        MessageChannel pagamentosConfirmados();
    }
}
