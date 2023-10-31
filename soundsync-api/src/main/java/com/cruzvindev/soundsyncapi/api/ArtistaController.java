package com.cruzvindev.soundsyncapi.api;

import com.cruzvindev.soundsyncapi.assemblers.assembler.ArtistaDTOAssembler;
import com.cruzvindev.soundsyncapi.assemblers.disassemblers.ArtistaDtoDisassembler;
import com.cruzvindev.soundsyncapi.domain.service.ArtistaService;
import com.cruzvindev.soundsyncapi.domain.model.Artista;
import com.cruzvindev.soundsyncapi.domain.repository.ArtistaRepository;
import com.cruzvindev.soundsyncapi.dtos.inputs.ArtistaDtoInput;
import com.cruzvindev.soundsyncapi.dtos.outputs.ArtistaDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artistas")
public class ArtistaController {

    @Autowired
    private ArtistaService artistaService;

    @Autowired
    private ArtistaRepository artistaRepository;

    @Autowired
    private ArtistaDTOAssembler artistaAssembler;

    @Autowired
    private ArtistaDtoDisassembler artistaDisassembler;

    @GetMapping("/{artistaId}")
    @ResponseStatus(HttpStatus.OK)
    public ArtistaDto buscar(@PathVariable Long artistaId)  {
        Artista artista = artistaService.buscarOuFalhar(artistaId);
        return artistaAssembler.paraModelo(artista);
    }

    @GetMapping("/listar")
    @ResponseStatus(HttpStatus.OK)
    public List<ArtistaDto> listar(){
        var artistas = artistaRepository.findAll();
        return artistaAssembler.paraColecaoModelo(artistas);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ArtistaDto cadastrar(@RequestBody @Valid ArtistaDtoInput artistaInput){
        var artista = artistaDisassembler.paraObjetoDominio(artistaInput);
        artista = artistaRepository.save(artista);
        return artistaAssembler.paraModelo(artista);
    }

    @PutMapping("/{artistaId}")
    public ArtistaDto atualizar(@PathVariable Long artistaId, @Valid @RequestBody ArtistaDtoInput artistaInput) throws Exception {
        Artista artista = artistaService.buscarOuFalhar(artistaId);
        artistaDisassembler.copiaParaObjetoDominio(artistaInput, artista);
        artista = artistaService.salvar(artista);
        return artistaAssembler.paraModelo(artista);

    }



    @DeleteMapping("/{artistaId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long artistaId){
        var artista = artistaService.buscarOuFalhar(artistaId);
        artistaService.excluir(artistaId);
    }

}
