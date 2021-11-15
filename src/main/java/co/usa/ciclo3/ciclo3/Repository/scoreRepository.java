/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.ciclo3.ciclo3.Repository;

import co.usa.ciclo3.ciclo3.Model.Score;
import co.usa.ciclo3.ciclo3.Repository.Crud.scoreCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jgfor
 */
@Repository
public class scoreRepository {
    
    @Autowired
    private scoreCrudRepository scoreCrudRepository;
    
    public List<Score> getAll(){
        return (List<Score>)scoreCrudRepository.findAll();
    }
    
    public Optional<Score>getScore(int id){
        return scoreCrudRepository.findById(id);
    }
    
    public Score save(Score p){
        return scoreCrudRepository.save(p);
    }  
    
    public void delete(Score c){
        scoreCrudRepository.delete(c);
    }
}
