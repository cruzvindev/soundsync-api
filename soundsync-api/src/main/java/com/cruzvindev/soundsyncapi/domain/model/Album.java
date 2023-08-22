package com.cruzvindev.soundsyncapi.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Album {


    @EqualsAndHashCode.Include
    private Long id;

    private String title;

    private Artist artist;

    private String releaseYear;

    private List<Music> songs = new ArrayList<>();


}
