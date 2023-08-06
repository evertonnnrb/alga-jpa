package org.example.model.enuns;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Sexo {
    MASCULINO(0, "Masculino"),
    FEMININO(1, "Feminino");

    @Getter
    private Integer cod;

    @Getter
    private String tipoSexo;

    public static Sexo getSexoCliente(Integer cod) {
        if (cod == null) {
            return null;
        }
        for (Sexo sexo : Sexo.values()) {
            if (cod.equals(sexo.cod)) {
                return sexo;
            }
        }
        throw new IllegalArgumentException("Cod inválido");
    }
}
