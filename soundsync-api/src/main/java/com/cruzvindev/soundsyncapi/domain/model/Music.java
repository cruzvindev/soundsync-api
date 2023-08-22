package com.cruzvindev.soundsyncapi.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Music {
    @EqualsAndHashCode.Include
    private Long id;
    private String title;
    private Album album;
    private int durationInSeconds;

}
