package com.cruzvindev.soundsyncapi.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Musica {
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String titulo;
    @Column(name = "duracao")
    private Integer duracaoEmSegundos;
    @ManyToOne
    private Album album;

}
