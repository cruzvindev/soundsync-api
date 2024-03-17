package com.cruzvindev.soundsyncapi.api.controllers;


import com.cruzvindev.soundsyncapi.domain.model.Album;
import com.cruzvindev.soundsyncapi.montadores.montador.AlbumDtoMontador;
import com.cruzvindev.soundsyncapi.montadores.desmontador.AlbumDtoDesmontador;
import com.cruzvindev.soundsyncapi.domain.repository.AlbumRepository;
import com.cruzvindev.soundsyncapi.domain.service.AlbumService;
import com.cruzvindev.soundsyncapi.dtos.inputs.AlbumDtoInput;
import com.cruzvindev.soundsyncapi.dtos.outputs.AlbumDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Albuns")
@RestController
@RequestMapping("/v1/album")
public class AlbumController {

    @Autowired
    private AlbumService albumService;
    @Autowired
    private AlbumDtoMontador albumAssembler;
    @Autowired
    private AlbumDtoDesmontador albumDisassembler;

    @Autowired
    private AlbumRepository albumRepository;

    @Operation(method = "Busca um album por id")
    @ApiResponses({
            @ApiResponse(responseCode = "400", description = "ID do album inválido", content =
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetail.class))),
            @ApiResponse(responseCode = "404", description = "Album não encontrado", content =
            @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetail.class)))
    })
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AlbumDto buscar(@PathVariable Long id){
        return albumAssembler.paraModelo(albumService.buscarOuFalhar(id));
    }

    @Operation(method = "Lista todos os albuns")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AlbumDto> listar(){
        return albumAssembler.paraColecaoModelo(albumRepository.findAll());
    }

    @Operation(method = "Cadastra um novo album")
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public AlbumDto cadastrar(@RequestBody @Valid AlbumDtoInput albumInput){
        var album = albumDisassembler.paraObjetoDominio(albumInput);
        return albumAssembler.paraModelo(albumService.salvar(album));
    }

    @Operation(method = "Deleta um album por id")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerAlbum(@PathVariable Long id){
        Album album = albumService.buscarOuFalhar(id);
        albumService.excluir(album);
    }
}
