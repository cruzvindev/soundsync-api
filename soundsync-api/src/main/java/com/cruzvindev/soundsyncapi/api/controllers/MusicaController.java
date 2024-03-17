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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Tag(name = "Músicas")
@RestController
@RequestMapping("/v1/musica")
public class MusicaController {

    @Autowired
    private MusicaService musicaService;

    @Autowired
    private MusicaMontador musicaMontador;

    @Autowired
    private MusicaRepository musicaRepository;

    @Autowired
    private MusicaDtoDesmontador musicaDesmontador;

    @Operation(summary = "Busca uma música por ID", responses = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400", description = "ID da música inválido",
                    content = @Content(schema = @Schema(ref = "Problema"))),
            @ApiResponse(responseCode = "404", description = "Música não encontrada",
                    content = @Content(schema = @Schema(ref = "Problema")))
    })
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MusicaDto buscar(@PathVariable Long id){
        Musica musicaBuscada = musicaService.buscarOuFalhar(id);

        return musicaMontador.paraModelo(musicaBuscada);
    }

    @Operation(method = "Lista todas as músicas")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MusicaDto> listar(){
        return musicaMontador.paraColecaoModelo(musicaRepository.findAll());
    }

    @Operation(summary = "Cadastra uma música", responses = {
            @ApiResponse(responseCode = "201", description = "Música cadastrada"),
    })
    @PostMapping("/adicionar")
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastar(@RequestBody @Valid MusicaDtoInput musicaInput){
        musicaService.salvar(musicaInput);
    }

    @Operation(summary = "Atualiza uma música por ID", responses = {
            @ApiResponse(responseCode = "200", description = "Música atualizada"),
            @ApiResponse(responseCode = "404", description = "Música não encontrada",
                    content = @Content(schema = @Schema(ref = "Problema"))),
    })
    @PutMapping("/{id}")
    public MusicaDto atualizar(@PathVariable Long id, @RequestBody @Valid MusicaDtoInput musicaInput){
            var musicaBuscada = musicaService.buscarOuFalhar(id);
            musicaDesmontador.copiaParaObjetoDominio(musicaInput, musicaBuscada);

            var musicaSalva = musicaRepository.save(musicaBuscada);
            return musicaMontador.paraModelo(musicaSalva);
    }

    @Operation(summary = "Deleta uma música por id")
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
            var musicaBuscada = musicaService.buscarOuFalhar(id);
            musicaRepository.delete(musicaBuscada);
    }
}
