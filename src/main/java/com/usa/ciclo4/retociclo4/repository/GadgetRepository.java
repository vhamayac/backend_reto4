package com.usa.ciclo4.retociclo4.repository;

import com.usa.ciclo4.retociclo4.model.Gadget;
import com.usa.ciclo4.retociclo4.repository.crudrepository.GadgetCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class GadgetRepository {
    @Autowired
    private GadgetCrudRepository gadgetCrudRepository;

    public List<Gadget> getAll(){
        return gadgetCrudRepository.findAll();
    }

    public Optional<Gadget> getGadget(int id){
        return gadgetCrudRepository.findById(id);
    }

    public Gadget save(Gadget gadget){
        return gadgetCrudRepository.save(gadget);
    }

    public void update(Gadget gadget){
        gadgetCrudRepository.save(gadget);
    }

    public void delete(Gadget gadget){
        gadgetCrudRepository.delete(gadget);
    }

}
