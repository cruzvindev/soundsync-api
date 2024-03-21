package com.cruzvindev.soundsyncapi.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Artista {

    public Artista(Long artistaId){
        this.id = artistaId;
    }
    public Artista(String nome, String origem, String biografia){
        this.nome = nome;
        this.origem = origem;
        this.biografia = biografia;
    }

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "artista_nome")
    private String nome;

    private String origem;

    private String biografia;

    @OneToMany(mappedBy = "artista")
    private List<Album> albums = new ArrayList<>();

}
