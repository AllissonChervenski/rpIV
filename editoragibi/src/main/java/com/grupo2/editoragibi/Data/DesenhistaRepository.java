package com.grupo2.editoragibi.Data;

import com.grupo2.editoragibi.Data.Entity.DesenhistaEntity;
import com.grupo2.editoragibi.Service.Domain.Desenhista;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<Desenhista> getDesenhistas() {

        List<DesenhistaEntity> desenhistasEntity = desenhistaRepository.findAll();

        return desenhistasEntity.stream().map(desenhista -> {
            return modelMapper.map(desenhista, Desenhista.class);
        }).collect(Collectors.toList());
    }

    public Desenhista addDesenhista(Desenhista desenhista) {

        DesenhistaEntity desenhistaEntity = modelMapper.map(desenhista, DesenhistaEntity.class);

        DesenhistaEntity desenhistaToReturn = desenhistaRepository.save(desenhistaEntity);

        return modelMapper.map(desenhistaToReturn, Desenhista.class);
    }

<<<<<<< HEAD
<<<<<<< HEAD
    public void deleteDesenhista(Integer id) {
=======
    public boolean deleteDesenhista(Integer id) {
>>>>>>> b4a9255 (reorganização da api e conserto do crud desenhistas)
=======
    public void deleteDesenhista(Integer id) {
>>>>>>> f2e5813 (crud de escritor e personagem)

        desenhistaRepository.deleteById(id);
    }

    public Desenhista updateDesenhista(int id, Desenhista desenhista) {

        if (desenhistaRepository.findById(id).isEmpty())
            return null;

        desenhista.setId(id);

        DesenhistaEntity desenhistaEntity = modelMapper.map(desenhista, DesenhistaEntity.class);

        DesenhistaEntity desenhistaToReturn = desenhistaRepository.save(desenhistaEntity);

        return modelMapper.map(desenhistaToReturn, Desenhista.class);
    }
}
