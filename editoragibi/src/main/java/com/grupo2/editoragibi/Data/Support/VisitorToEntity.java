package com.grupo2.editoragibi.Data.Support;

import com.grupo2.editoragibi.Data.Entity.DesenhistaEntity;
import com.grupo2.editoragibi.Data.Entity.EscritorEntity;
import com.grupo2.editoragibi.Data.Entity.HistoriaEntity;
import com.grupo2.editoragibi.Data.Entity.PersonagemEntity;
import com.grupo2.editoragibi.Service.Domain.Escritor;
import com.grupo2.editoragibi.Service.Domain.Historia;
import com.grupo2.editoragibi.Service.Domain.Personagem;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class VisitorToEntity {

    private ModelMapper modelMapper = new ModelMapper();

    public EscritorEntity escritorToEntity(Escritor escritor) {

        return modelMapper.map(escritor, EscritorEntity.class);
    }

    public HistoriaEntity historiaToEntity(Historia historia) {

        HistoriaEntity historiaEntity = modelMapper.map(historia, HistoriaEntity.class);

        historiaEntity.setArtefinalizador(modelMapper.map(historia.getArtefinalizador(), DesenhistaEntity.class));
        historiaEntity.setDesenhista(modelMapper.map(historia.getDesenhista(), DesenhistaEntity.class));
        historiaEntity.setEscritor(modelMapper.map(historia.getEscritor(), EscritorEntity.class));

        historiaEntity.setPersonagens(historia.getPersonagens().stream().map(personagem -> {
            return modelMapper.map(personagem, PersonagemEntity.class);
        }).collect(Collectors.toList()));

        return historiaEntity;
    }

    public PersonagemEntity personagemToEntity(Personagem personagem) {

        PersonagemEntity personagemEntity = modelMapper.map(personagem, PersonagemEntity.class);

        List<Escritor> escritores = personagem.getEscritores();

        List<EscritorEntity> escritoresEntity = escritores.stream().map(escritor -> {
            return modelMapper.map(escritor, EscritorEntity.class);
        }).collect(Collectors.toList());

        personagemEntity.setEscritores(escritoresEntity);

        return personagemEntity;
    }
}
