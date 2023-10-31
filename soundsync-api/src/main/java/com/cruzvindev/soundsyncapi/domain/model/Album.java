package com.cruzvindev.soundsyncapi.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

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

    @Column(nullable = false)
    @NotBlank
    private String titulo;
    private String anoLancamento;
    @ManyToOne
    @JoinColumn(name = "artista_id", nullable = false)
    private Artista artista;
    private String genero;
    @OneToMany
    private List<Musica> musicas = new ArrayList<>();

}
