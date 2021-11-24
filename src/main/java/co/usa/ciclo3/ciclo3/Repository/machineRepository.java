/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.ciclo3.ciclo3.Repository;

import co.usa.ciclo3.ciclo3.Model.Machine;
import co.usa.ciclo3.ciclo3.Repository.Crud.machineCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jgfor
 */
@Repository
public class machineRepository {
    
    @Autowired
    private machineCrudRepository machineCrudRepository;
    
    public List<Machine> getAll(){
        return (List<Machine>)machineCrudRepository.findAll();
    }
    
    public Optional<Machine>getMachine(int id){
        return machineCrudRepository.findById(id);
    }
    
    public Machine save(Machine c){
        return machineCrudRepository.save(c);
    }
    
       public void delete(Machine c){
        machineCrudRepository.delete(c);
    }
    
}