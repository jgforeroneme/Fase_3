/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.Model.Client;
import co.usa.ciclo3.ciclo3.Repository.clientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jgfor
 */
@Service
public class clientService {
    
    @Autowired
    private clientRepository clientRepository;
    
    public List<Client> getAll(){
        return clientRepository.getAll();
    }
    
    public Optional<Client> getclient(int idCliente){
        return clientRepository.getclient(idCliente);
    }
    
    public Client save(Client p){
        if(p.getIdClient()==null){
            return clientRepository.save(p);
    }else{
            Optional<Client> paux=clientRepository.getclient(p.getIdClient());
            if(paux.isEmpty()){
                return clientRepository.save(p);
            }else{
                return p;
            }
        }
    }
    
    public Client update(Client client){
        if(client.getIdClient()==null){
            Optional<Client>g= clientRepository.getclient(client.getIdClient());
                if(!g.isEmpty()){
                if(client.getName()!=null){
                    g.get().setName(client.getName());
                }
                if(client.getName()!=null){
                    g.get().setName(client.getName());
                }
                return clientRepository.save(g.get());
            }
        }
        return client;
    }
 
    public boolean deleteClient(int idClient){
        Optional<Client> c=getclient(idClient);
        if(!c.isEmpty()){
            clientRepository.delete(c.get());
            return true;
        }
        return false;
    }
    
}
