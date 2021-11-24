/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.Model.Message;
import co.usa.ciclo3.ciclo3.Repository.messageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jgfor
 */
@Service
public class messageService {
    
    @Autowired
    private messageRepository messageRepository;
    
    public List<Message> getAll(){
        return messageRepository.getAll();
    }
    
    public Optional<Message> getMessage(int id){
        return messageRepository.getmessage(id);
    }
    
    public Message save(Message p){
        if(p.getIdMessage()==null){
            return messageRepository.save(p);
    }else{
            Optional<Message> paux=messageRepository.getmessage(p.getIdMessage());
            if(paux.isEmpty()){
                return messageRepository.save(p);
            }else{
                return p;
            }
        }
    }
    
    public Message update(Message message){
        if(message.getIdMessage()==null){
            Optional<Message>g= messageRepository.getmessage(message.getIdMessage());
                if(!g.isEmpty()){
                if(message.getIdMessage()!=null){
                    g.get().setIdMessage(message.getIdMessage());
                }
                if(message.getIdMessage()!=null){
                    g.get().setIdMessage(message.getIdMessage());
                }
                return messageRepository.save(g.get());
            }
        }
        return message;
    }
 
    public boolean deleteMessage(int id){
        Optional<Message> c=getMessage(id);
        if(!c.isEmpty()){
            messageRepository.delete(c.get());
            return true;
        }
        return false;
    }
}
