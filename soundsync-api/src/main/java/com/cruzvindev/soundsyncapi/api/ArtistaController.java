package com.cruzvindev.soundsyncapi.api;

import com.cruzvindev.soundsyncapi.assemblers.assembler.ArtistaDTOAssembler;
import com.cruzvindev.soundsyncapi.domain.ArtistaService;
import com.cruzvindev.soundsyncapi.domain.model.Artista;
import com.cruzvindev.soundsyncapi.domain.repository.ArtistaRepository;
import com.cruzvindev.soundsyncapi.dtos.outputs.ArtistaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/artistas")
public class ArtistaController {

    @Autowired
    private ArtistaService artistaService;

    @Autowired
    private ArtistaRepository artistaRepository;

    @Autowired
    private ArtistaDTOAssembler artistaAssembler;

    @GetMapping("/{artistaId}")
    @ResponseStatus(HttpStatus.OK)
    public ArtistaDTO buscar(@PathVariable Long artistaId)  {
        Artista artista = artistaService.buscarOuFalhar(artistaId);
        return artistaAssembler.paraModelo(artista);
    }

}
