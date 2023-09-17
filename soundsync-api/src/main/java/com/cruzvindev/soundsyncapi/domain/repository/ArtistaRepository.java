package com.cruzvindev.soundsyncapi.domain.repository;

import com.cruzvindev.soundsyncapi.domain.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {
}
