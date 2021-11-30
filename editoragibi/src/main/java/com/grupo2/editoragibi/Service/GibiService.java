package com.grupo2.editoragibi.Service;

import java.util.Optional;

import com.grupo2.editoragibi.Data.GibiRepository;
import com.grupo2.editoragibi.Service.Domain.Gibi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GibiService {
    
    @Autowired
    GibiRepository gibiRepository;

    public Gibi getGibiById(Integer id){
        
        Optional<Gibi> gibi = gibiRepository.getGibiById(id);

        if(!gibi.isPresent()){
            return null;
        }
        
        return gibi.get();
    }

    public Gibi addGibi(Gibi gibi){
        return gibiRepository.addGibi(gibi);
    }

    public boolean deleteGibi(Integer id){
        return gibiRepository.deleteGibi(id);

    }

    public Gibi updateGibi(Integer id, Gibi gibi){
        return gibiRepository.updateGibi(id, gibi);
    }
}
