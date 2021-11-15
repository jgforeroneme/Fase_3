/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.ciclo3.ciclo3.Repository;

import co.usa.ciclo3.ciclo3.Model.Message;
import co.usa.ciclo3.ciclo3.Repository.Crud.messageCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jgfor
 */
@Repository
public class messageRepository {
    
    @Autowired
    private messageCrudRepository messageCrudRepository;
    
    public List<Message> getAll(){
        return (List<Message>)messageCrudRepository.findAll();
    }
    
    public Optional<Message>getmessage(int id){
        return messageCrudRepository.findById(id);
    }
    
    public Message save(Message p){
        return messageCrudRepository.save(p);
    }
    
       public void delete(Message c){
        messageCrudRepository.delete(c);
    }
    
}
    

