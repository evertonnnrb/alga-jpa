package org.example.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class EnderecoEntrega {

    private String cep;

    private String lagraddouro;

    private String numero;

    private String complemento;
}
