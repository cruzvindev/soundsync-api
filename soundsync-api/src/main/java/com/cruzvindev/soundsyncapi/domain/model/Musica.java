package com.cruzvindev.soundsyncapi.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Musica {
    @EqualsAndHashCode.Include
    @Id
    private Long id;
    private String titulo;
    @Column(name = "duracao")
    private Integer duracaoEmSegundos;
    @ManyToOne
    private Album album;

}
