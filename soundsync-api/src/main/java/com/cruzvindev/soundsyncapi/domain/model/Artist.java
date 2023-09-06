package com.cruzvindev.soundsyncapi.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Generated;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Artist {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "artist_name")
    private String name;

    private String country;

    private String biography;

    @OneToMany(mappedBy = "artist")
    private List<Album> albums = new ArrayList<>();

}
