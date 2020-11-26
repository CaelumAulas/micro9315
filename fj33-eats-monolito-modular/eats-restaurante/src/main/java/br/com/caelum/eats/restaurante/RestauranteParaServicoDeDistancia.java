package br.com.caelum.eats.restaurante;

import lombok.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class RestauranteParaServicoDeDistancia {

    private Long id;
    private String cep;
    private Long tipoDeCozinhaId;

    RestauranteParaServicoDeDistancia(Restaurante restaurante){
        this(restaurante.getId(), restaurante.getCep(), restaurante.getTipoDeCozinha().getId());
    }

}