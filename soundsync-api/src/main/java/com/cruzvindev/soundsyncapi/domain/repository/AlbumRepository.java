package com.cruzvindev.soundsyncapi.domain.repository;

import com.cruzvindev.soundsyncapi.domain.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
}
