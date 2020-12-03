package br.com.caelum.eats.pagamento;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PagamentoConfirmado {

    private Long pagamentoId;
    private Long pedidoId;

}
