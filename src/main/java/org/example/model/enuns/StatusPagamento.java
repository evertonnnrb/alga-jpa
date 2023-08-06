package org.example.model.enuns;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum StatusPagamento {
    PROCESSANDO(1, "Processando"),
    CANCELADO(2, "Cancelado"),
    RECEBIDO(3, "Recebido");

    private Integer cod;
    private String status;

    public static StatusPagamento getStatusPagamento(Integer cod) {
        if (cod == null) {
            return null;
        }
        for (StatusPagamento statusPagamento : StatusPagamento.values()) {
            if (statusPagamento.equals(cod)) {
                return statusPagamento;
            }
        }
        throw new IllegalArgumentException("Erro status pagamento");
    }
}
