package com.cruzvindev.soundsyncapi.domain.service;

import com.cruzvindev.soundsyncapi.domain.exception.NegocioException;
import com.cruzvindev.soundsyncapi.domain.model.Artista;
import com.cruzvindev.soundsyncapi.domain.repository.ArtistaRepository;
import com.cruzvindev.soundsyncapi.domain.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArtistaService {

    @Autowired
    private ArtistaRepository artistaRepository;

    @Transactional
    public Artista salvar(Artista artista)throws Exception{
        Artista artistaBusca = buscarOuFalhar(artista.getId());
        return artistaRepository.save(artistaBusca);
    }

    @Transactional
    public void excluir(Long artistaId){
        artistaRepository.deleteById(artistaId);
        artistaRepository.flush();
    }

    public Artista buscarOuFalhar(Long id){
       return artistaRepository.findById(id)
               .orElseThrow(()-> new NegocioException("Artista não encontrado"));
    }

}
