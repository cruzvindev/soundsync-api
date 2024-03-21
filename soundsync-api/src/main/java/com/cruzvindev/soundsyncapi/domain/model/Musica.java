package com.cruzvindev.soundsyncapi.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Musica {

    public Musica(String titulo, Integer duracaoEmSegundos, Album album) {
        this.titulo = titulo;
        this.duracaoEmSegundos = duracaoEmSegundos;
        this.album = album;
    }

    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String titulo;

    @Column(name = "duracao")
    private Integer duracaoEmSegundos;

    @ManyToOne
    private Album album;

    public void setAlbum(Long albumId){
        this.album.setId(albumId);
    }
}
