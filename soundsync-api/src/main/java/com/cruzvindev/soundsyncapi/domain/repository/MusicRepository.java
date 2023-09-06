package com.cruzvindev.soundsyncapi.domain.repository;

import com.cruzvindev.soundsyncapi.domain.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicRepository extends JpaRepository<Music, Long> {
}
