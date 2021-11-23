package com.grupo2.editoragibi.Data;

import com.grupo2.editoragibi.Data.Entity.DesenhistaEntity;
import com.grupo2.editoragibi.Service.Domain.Desenhista;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class DesenhistaRepository {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    IDesenhistaRepository desenhistaRepository;

    public Optional<Desenhista> getDesenhistaById(int id) {

        Optional<DesenhistaEntity> desenhistaEntity = desenhistaRepository.findById(id);

        if (!desenhistaEntity.isPresent())
            return Optional.empty();

        Desenhista desenhista = modelMapper.map(desenhistaEntity.get(), Desenhista.class);

        return Optional.of(desenhista);
    }

    public Desenhista addDesenhista(Desenhista desenhista) {

        DesenhistaEntity desenhistaEntity = modelMapper.map(desenhista, DesenhistaEntity.class);

        DesenhistaEntity desenhistaToReturn = desenhistaRepository.save(desenhistaEntity);

        return modelMapper.map(desenhistaToReturn, Desenhista.class);
    }

    public boolean deleteDesenhista(Integer id) {

        //DesenhistaEntity desenhistaEntity = modelMapper.map(id, DesenhistaEntity.class);

        desenhistaRepository.deleteById(id);

        return true;
    }
}
