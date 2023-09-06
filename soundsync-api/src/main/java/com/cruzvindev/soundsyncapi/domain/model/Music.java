package com.cruzvindev.soundsyncapi.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Music {
    @EqualsAndHashCode.Include
    @Id
    private Long id;
    private String title;
    @Column(name = "duration")
    private Integer durationInSeconds;

    @ManyToOne
    private Album album;

}
