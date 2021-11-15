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
    
    public Machine update(Machine machine){
        if(machine.getId()==null){
            Optional<Machine>g= machineRepository.getMachine(machine.getId());
                if(!g.isEmpty()){
                if(machine.getName()!=null){
                    g.get().setName(machine.getName());
                }
                if(machine.getName()!=null){
                    g.get().setName(machine.getName());
                }
                return machineRepository.save(g.get());
            }
        }
        return machine;
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
