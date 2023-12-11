package com.cruzvindev.soundsyncapi.api.controllers;

import com.cruzvindev.soundsyncapi.domain.model.Musica;
import com.cruzvindev.soundsyncapi.domain.repository.MusicaRepository;
import com.cruzvindev.soundsyncapi.domain.service.MusicaService;
import com.cruzvindev.soundsyncapi.dtos.inputs.MusicaDtoInput;
import com.cruzvindev.soundsyncapi.dtos.outputs.MusicaDto;
import com.cruzvindev.soundsyncapi.montadores.desmontador.MusicaDtoDesmontador;
import com.cruzvindev.soundsyncapi.montadores.montador.MusicaMontador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/musica")
public class MusicaController {

    @Autowired
    private MusicaService musicaService;

    @Autowired
    private MusicaMontador musicaMontador;

    @Autowired
    private MusicaRepository musicaRepository;

    @Autowired
    private MusicaDtoDesmontador musicaDesmontador;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MusicaDto buscar(@PathVariable Long id){
        Musica musicaBuscada = musicaService.buscarOuFalhar(id);

        return musicaMontador.paraModelo(musicaBuscada);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MusicaDto> listar(){
        return musicaMontador.paraColecaoModelo(musicaRepository.findAll());
    }

    @PostMapping("/adicionar")
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody MusicaDtoInput musicaInput){
        musicaRepository.save(musicaDesmontador.paraObjetoDominio(musicaInput));
    }

    @PutMapping("/{id}")
    public MusicaDto atualizar(@RequestParam Long id, @RequestBody MusicaDtoInput musicaInput){
        var musicaBuscada = musicaService.buscarOuFalhar(id);
        musicaDesmontador.copiaParaObjetoDominio(musicaInput, musicaBuscada);

        return musicaMontador.paraModelo(musicaRepository.save(musicaBuscada));
    }
}
