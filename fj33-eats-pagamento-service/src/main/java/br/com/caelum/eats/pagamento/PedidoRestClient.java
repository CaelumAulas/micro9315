package br.com.caelum.eats.pagamento;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(value = "monolito")
public interface PedidoRestClient {

    @PutMapping("/pedidos/{pedidoId}/pago")
    void notificaPagamentoPedido(@PathVariable("pedidoId") Long pedidoId);


    @GetMapping("/pedidos/{pedidoId}")
    void buscaPedido(@PathVariable("pedidoId") Long pedidoId);

}