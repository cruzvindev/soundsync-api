package com.cruzvindev.soundsyncapi.unit_tests;

import com.cruzvindev.soundsyncapi.domain.model.Artista;
import com.cruzvindev.soundsyncapi.domain.service.ArtistaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CadastroArtistaTest {

    @Autowired
    private ArtistaService cadastroArtistaService;

    @Test
    public void testarCadastroArtistaComSucesso(){
        //cenário
        Artista artista = new Artista();
        artista.setNome("Wesley Safadão");
        artista.setBiografia("Cantor cearense");
        artista.setOrigem("Brazil");

        //ação
        artista = cadastroArtistaService.salvar(artista);

        //validação
        assertNotNull(artista);
        assertNotNull(artista.getId());
    }

    @Test
    public void deveFalharAoCadastrarArtistaSemNome() {
        Artista artista = new Artista();
        artista.setBiografia("Cantor cearense");
        artista.setOrigem("Brazil");

        assertThrows(DataIntegrityViolationException.class, () -> {
            cadastroArtistaService.salvar(artista);
        });
    }

    @Test
    public void deveFalharAoCadastrarArtistaSemBiografia() {
        Artista artista = new Artista();
        artista.setNome("Xand Avião");
        artista.setOrigem("Brazil");

        assertThrows(DataIntegrityViolationException.class, () -> {
            cadastroArtistaService.salvar(artista);
        });
    }

    @Test
    public void deveFalharAoCadastrarArtistaSemOrigem() {
        Artista artista = new Artista();
        artista.setBiografia("Cantor cearense");
        artista.setNome("Roberto Carlos");

        assertThrows(DataIntegrityViolationException.class, () -> {
            cadastroArtistaService.salvar(artista);
        });
    }

}

