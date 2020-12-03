package br.com.caelum.eats.pagamento;


import lombok.AllArgsConstructor;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class NotificadorDePagamento {

    private RabbitPagamentoConfig.PagamentoSource pagamentoSource;

    void notificaPagamentoConfirmado(Pagamento pagamento) {
        PagamentoConfirmado pagamentoConfirmado = new PagamentoConfirmado(pagamento.getId(), pagamento.getPedidoId());
        pagamentoSource.pagamentosConfirmados().send(MessageBuilder.withPayload(pagamentoConfirmado).build());
    }


}
