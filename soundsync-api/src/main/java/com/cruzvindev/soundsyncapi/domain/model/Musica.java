package com.cruzvindev.soundsyncapi.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;


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
