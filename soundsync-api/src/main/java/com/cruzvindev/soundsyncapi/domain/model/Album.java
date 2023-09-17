package com.cruzvindev.soundsyncapi.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Album {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;

    @Column(name = "ano_lancamento")
    private String anoLancamento;

    @ManyToOne
    @JoinColumn(name = "artista_id")
    private Artista artista;
    private String genero;
    @OneToMany
    private List<Musica> musicas = new ArrayList<>();

}
