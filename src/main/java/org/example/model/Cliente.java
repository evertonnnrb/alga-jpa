package org.example.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.model.enuns.Sexo;

import javax.persistence.*;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String nome;
    private Sexo sexo;

}
