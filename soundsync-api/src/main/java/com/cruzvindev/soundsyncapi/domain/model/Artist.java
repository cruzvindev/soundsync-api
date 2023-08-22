package com.cruzvindev.soundsyncapi.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Generated;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Artist {
    @EqualsAndHashCode.Include
    private Long id;

    private String name;

    private String country;

    private String biography;
    private List<Album> albuns = new ArrayList<>();

}
