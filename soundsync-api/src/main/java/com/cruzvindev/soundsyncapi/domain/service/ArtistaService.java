package com.cruzvindev.soundsyncapi.domain.service;

import com.cruzvindev.soundsyncapi.domain.exception.EntidadeEmUsoException;
import com.cruzvindev.soundsyncapi.domain.exception.EntidadeNaoEncontradaException;
import com.cruzvindev.soundsyncapi.domain.exception.NegocioException;
import com.cruzvindev.soundsyncapi.domain.model.Artista;
import com.cruzvindev.soundsyncapi.domain.repository.ArtistaRepository;
import com.cruzvindev.soundsyncapi.domain.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

@Service
public class ArtistaService {

    @Autowired
    private ArtistaRepository artistaRepository;

    @Transactional
    public Artista salvar(Artista artista){
        return artistaRepository.save(artista);
    }

    @Transactional
    public void excluir(Long artistaId) {
        try{
            artistaRepository.deleteById(artistaId);
            artistaRepository.flush();
        }
        catch(Exception ex){
            throw new EntidadeEmUsoException(String.format("O artista de id %d está em uso e" +
                    " não pode ser excluído", artistaId));
        }
    }

    public Artista buscarOuFalhar(Long id){
       return artistaRepository.findById(id)
               .orElseThrow(()-> new EntidadeNaoEncontradaException(String.format("O artista de id %d não foi encontrado", id)));
    }

}
