/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.Model.Machine;
import co.usa.ciclo3.ciclo3.Repository.machineRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jgfor
 */
@Service
public class machineService {
    
    @Autowired
    private machineRepository machineRepository;
    
    public List<Machine> getAll(){
        return machineRepository.getAll();
    }
    
    public Optional<Machine> getMachine(int id){
        return machineRepository.getMachine(id);
    }
    
    public Machine save(Machine p){
        if(p.getId()==null){
            return machineRepository.save(p);
    }else{
            Optional<Machine> paux=machineRepository.getMachine(p.getId());
            if(paux.isEmpty()){
                return machineRepository.save(p);
            }else{
                return p;
            }
        }
    }
    
    public Machine update(Machine c){
        if(c.getId()!=null){
            Optional<Machine>g=machineRepository.getMachine(c.getId());
            if(!g.isEmpty()){
                System.out.println("bla bla bla");
                if(c.getName()!=null){
                    g.get().setName(c.getName());
                }
                if(c.getDescription()!=null){
                    g.get().setDescription(c.getDescription());
                }
                if(c.getBrand()!=null){
                    g.get().setBrand(c.getBrand());
                }
                if(c.getYear()!=null){
                    g.get().setYear(c.getYear());
                }
                if(c.getCategory()!=null){
                    g.get().setCategory(c.getCategory());
                }
                machineRepository.save(g.get());
                return g.get();
            }
        }
        return c;

    }
 
    public boolean deleteMachine(int id){
        Optional<Machine> c=getMachine(id);
        if(!c.isEmpty()){
            machineRepository.delete(c.get());
            return true;
        }
        return false;
    }
    
}
