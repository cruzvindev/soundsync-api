package com.cruzvindev.soundsyncapi.domain.repository;

import com.cruzvindev.soundsyncapi.domain.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
}
