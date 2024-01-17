package com.cruzvindev.soundsyncapi.unit_tests;

import com.cruzvindev.soundsyncapi.domain.model.Artista;
import com.cruzvindev.soundsyncapi.domain.repository.ArtistaRepository;
import com.cruzvindev.soundsyncapi.domain.service.ArtistaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ArtistaServiceTestes {

    @Mock
    private ArtistaRepository artistaRepository;

    @InjectMocks
    private ArtistaService artistaService;

    @Nested
    class BuscarUsuario {

        @Test
        @DisplayName("Deve buscar um usuário no banco de dados")
        public void  deve_buscar_usuario_no_banco(){
            long idArtista = 1L;

            // Suponha que você tenha uma instância de Artista que será retornada pelo repository
            Artista artistaMock = new Artista();
            artistaMock.setId(idArtista);
            artistaMock.setNome("Artista de Teste");


            // Configurando o comportamento esperado do repository quando findById for chamado
            when(artistaRepository.findById(idArtista)).thenReturn(Optional.of(artistaMock));

        }
    }


}
