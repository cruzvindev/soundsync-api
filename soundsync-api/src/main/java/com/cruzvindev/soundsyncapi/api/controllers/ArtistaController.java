package com.cruzvindev.soundsyncapi.api.controllers;

import com.cruzvindev.soundsyncapi.montadores.montador.ArtistaDtoMontador;
import com.cruzvindev.soundsyncapi.montadores.desmontador.ArtistaDtoDesmontador;
import com.cruzvindev.soundsyncapi.domain.service.ArtistaService;
import com.cruzvindev.soundsyncapi.domain.model.Artista;
import com.cruzvindev.soundsyncapi.domain.repository.ArtistaRepository;
import com.cruzvindev.soundsyncapi.dtos.inputs.ArtistaDtoInput;
import com.cruzvindev.soundsyncapi.dtos.outputs.ArtistaDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Artistas")
@RestController
@RequestMapping("/v1/artistas")
public class ArtistaController {

    @Autowired
    private ArtistaService artistaService;

    @Autowired
    private ArtistaRepository artistaRepository;

    @Autowired
    private ArtistaDtoMontador artistaAssembler;

    @Autowired
    private ArtistaDtoDesmontador artistaDisassembler;

    @Operation(summary = "Busca um artista por ID", responses = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400", description = "ID do artista inválido",
                    content = @Content(schema = @Schema(ref = "Problema"))),
            @ApiResponse(responseCode = "404", description = "Artista não encontrado",
                    content = @Content(schema = @Schema(ref = "Problema")))
    })
    @GetMapping("/{artistaId}")
    @ResponseStatus(HttpStatus.OK)
    public ArtistaDto buscar(@PathVariable Long artistaId)  {
        Artista artista = artistaService.buscarOuFalhar(artistaId);
        return artistaAssembler.paraModelo(artista);
    }

    @Operation(method = "Lista todos os artistas")
    @GetMapping("/listar")
    @ResponseStatus(HttpStatus.OK)
    public List<ArtistaDto> listar(){
        var artistas = artistaRepository.findAll();
        return artistaAssembler.paraColecaoModelo(artistas);
    }

    @Operation(summary = "Cadastra um artista", responses = {
            @ApiResponse(responseCode = "201", description = "Artista cadastrado"),
    })
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ArtistaDto cadastrar(@RequestBody @Valid ArtistaDtoInput artistaInput) throws Exception {
        var artista = artistaDisassembler.paraObjetoDominio(artistaInput);
        artista = artistaRepository.save(artista);
        return artistaAssembler.paraModelo(artista);
    }

    @Operation(summary = "Atualiza um artista por ID", responses = {
            @ApiResponse(responseCode = "200", description = "Artista atualizado"),
            @ApiResponse(responseCode = "404", description = "Artista não encontrado",
                    content = @Content(schema = @Schema(ref = "Problema"))),
    })
    @PutMapping("/{artistaId}")
    public ArtistaDto atualizar(@PathVariable Long artistaId, @Valid @RequestBody ArtistaDtoInput artistaInput) throws Exception {
        Artista artista = artistaService.buscarOuFalhar(artistaId);
        artistaDisassembler.copiaParaObjetoDominio(artistaInput, artista);
        artista = artistaService.salvar(artista);
        return artistaAssembler.paraModelo(artista);

    }

    @Operation(summary = "Deleta um artista por id")
    @DeleteMapping("/{artistaId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long artistaId){
        var artista = artistaService.buscarOuFalhar(artistaId);
        artistaService.excluir(artistaId);
    }

}
