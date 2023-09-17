package com.cruzvindev.soundsyncapi.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Artista {
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
