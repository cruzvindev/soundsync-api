package com.cruzvindev.soundsyncapi.api.controllers;


import com.cruzvindev.soundsyncapi.montadores.montador.AlbumDtoMontador;
import com.cruzvindev.soundsyncapi.montadores.desmontador.AlbumDtoDesmontador;
import com.cruzvindev.soundsyncapi.domain.repository.AlbumRepository;
import com.cruzvindev.soundsyncapi.domain.service.AlbumService;
import com.cruzvindev.soundsyncapi.dtos.inputs.AlbumDtoInput;
import com.cruzvindev.soundsyncapi.dtos.outputs.AlbumDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/album")
public class AlbumController {

    @Autowired
    private AlbumService albumService;
    @Autowired
    private AlbumDtoMontador albumAssembler;
    @Autowired
    private AlbumDtoDesmontador albumDisassembler;

    @Autowired
    private AlbumRepository albumRepository;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AlbumDto buscar(@PathVariable Long id){
        return albumAssembler.paraModelo(albumService.buscarOuFalhar(id));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AlbumDto> listar(){
        return albumAssembler.paraColecaoModelo(albumRepository.findAll());
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public AlbumDto cadastrar(@RequestBody @Valid AlbumDtoInput albumInput){
        var album = albumDisassembler.paraObjetoDominio(albumInput);
        return albumAssembler.paraModelo(albumService.salvar(album));
    }
}
