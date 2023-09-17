package com.cruzvindev.soundsyncapi.domain.repository;

import com.cruzvindev.soundsyncapi.domain.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicRepository extends JpaRepository<Musica, Long> {
}
