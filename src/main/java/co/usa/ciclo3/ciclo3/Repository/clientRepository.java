/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.ciclo3.ciclo3.Repository;

import co.usa.ciclo3.ciclo3.Model.Client;
import co.usa.ciclo3.ciclo3.Repository.Crud.clientCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jgfor
 */
@Repository
public class clientRepository {
    
    @Autowired
    private clientCrudRepository clientCrudRepository;
    
    public List<Client> getAll(){
        return (List<Client>)clientCrudRepository.findAll();
    }
    
    public Optional<Client>getclient(int idCliente){
        return clientCrudRepository.findById(idCliente);
    }
    
    public Client save(Client p){
        return clientCrudRepository.save(p);
    }
    
       public void delete(Client c){
        clientCrudRepository.delete(c);
    }
    
}
    
