package com.cruzvindev.soundsyncapi.api.controllers;

import com.cruzvindev.soundsyncapi.domain.exception.EntidadeEmUsoException;
import com.cruzvindev.soundsyncapi.domain.exception.NegocioException;
import com.cruzvindev.soundsyncapi.domain.model.Musica;
import com.cruzvindev.soundsyncapi.domain.repository.MusicaRepository;
import com.cruzvindev.soundsyncapi.domain.service.MusicaService;
import com.cruzvindev.soundsyncapi.dtos.inputs.MusicaDtoInput;
import com.cruzvindev.soundsyncapi.dtos.outputs.MusicaDto;
import com.cruzvindev.soundsyncapi.montadores.desmontador.MusicaDtoDesmontador;
import com.cruzvindev.soundsyncapi.montadores.montador.MusicaMontador;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
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
    public void salvar(@RequestBody @Valid MusicaDtoInput musicaInput){
        musicaService.salvar(musicaInput);
    }

    @PutMapping("/{id}")
    public MusicaDto atualizar(@PathVariable Long id, @RequestBody @Valid MusicaDtoInput musicaInput){
            var musicaBuscada = musicaService.buscarOuFalhar(id);
            musicaDesmontador.copiaParaObjetoDominio(musicaInput, musicaBuscada);

            var musicaSalva = musicaRepository.save(musicaBuscada);
            return musicaMontador.paraModelo(musicaSalva);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
            var musicaBuscada = musicaService.buscarOuFalhar(id);
            musicaRepository.delete(musicaBuscada);
    }
}
