package org.example.model.enuns;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum Status {
    AGUARDANDO (1,"Aguardando"),
    CANCELADO(2,"Cancelado"),
    PAGO(3,"Pago");

    private Integer cod;
    private String status;

    private static Status getStatusPeido(Integer cod){
        if (cod == null){
            return null;
        }
        for (Status S : Status.values()){
            if (S.cod.equals( S.values())){
                return S;
            }
        }
        throw new IllegalArgumentException("Not found");
    }

}
