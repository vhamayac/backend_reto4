package com.usa.ciclo4.retociclo4.service;

import com.usa.ciclo4.retociclo4.model.Gadget;
import com.usa.ciclo4.retociclo4.repository.GadgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GadgetService {
    @Autowired
    private GadgetRepository gadgetRepository;

    public List<Gadget> getAll(){
        return gadgetRepository.getAll();
    }

    public Optional<Gadget> getGadget(int id){
        return gadgetRepository.getGadget(id);
    }

    public Gadget save(Gadget gadget){
        if(gadget.getId() == null) {
            return gadget;
        }else{
            return gadgetRepository.save(gadget);
        }
    }

    public Gadget update(Gadget gadget) {

        if (gadget.getId() != null) {
            Optional<Gadget> dbgadget = gadgetRepository.getGadget(gadget.getId());
            if (!dbgadget.isEmpty()) {
                /*if (gadget.getBrand() != null) {
                    dbgadget.get().setBrand(gadget.getBrand());
                }*/
                if (gadget.getCategory() != null) {
                    dbgadget.get().setCategory(gadget.getCategory());
                }
                if (gadget.getName() != null) {
                    dbgadget.get().setName(gadget.getName());
                }
                if (gadget.getDescription() != null) {
                    dbgadget.get().setDescription(gadget.getDescription());
                }
                if (gadget.getPrice() != 0.0) {
                    dbgadget.get().setPrice(gadget.getPrice());
                }
                if (gadget.getQuantity() != 0) {
                    dbgadget.get().setQuantity(gadget.getQuantity());
                }
                if (gadget.getPhotography() != null) {
                    dbgadget.get().setPhotography(gadget.getPhotography());
                }
                dbgadget.get().setAvailability(gadget.isAvailability());
                gadgetRepository.update(dbgadget.get());
                return dbgadget.get();
            } else {
                return gadget;
            }
        } else {
            return gadget;
        }
    }

    public boolean delete(int id){
        return getGadget(id).map(gadget -> {
            gadgetRepository.delete(gadget);
            return true;
        }).orElse(false);
    }
}
