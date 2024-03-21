package com.cruzvindev.soundsyncapi.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Album {

    public Album(Long albumId){
        this.id = albumId;
    }
    public Album(String titulo, String anoLancamento, Artista artista, String genero){
        this.titulo = titulo;
        this.anoLancamento =  anoLancamento;
        this.artista = artista;
        this.genero = genero;
    }


    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(name = "ano_lancamento")
    private String anoLancamento;
    @ManyToOne
    @JoinColumn(name = "artista_id", nullable = false)
    private Artista artista;
    private String genero;
    @OneToMany
    private List<Musica> musicas = new ArrayList<>();

}
