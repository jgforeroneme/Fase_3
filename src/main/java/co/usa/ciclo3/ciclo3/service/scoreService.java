/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.Model.Score;
import co.usa.ciclo3.ciclo3.Repository.scoreRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jgfor
 */
@Service
public class scoreService {
    
    @Autowired
    private scoreRepository scoreRepository;
    
    public List<Score> getAll(){
        return scoreRepository.getAll();
    }
    
    public Optional<Score> getScore(int id){
        return scoreRepository.getScore(id);
    }
    
    public Score save(Score p){
        if(p.getId()==null){
            return scoreRepository.save(p);
    }else{
            Optional<Score> paux=scoreRepository.getScore(p.getId());
            if(paux.isEmpty()){
                return scoreRepository.save(p);
            }else{
                return p;
            }
        }
    }
    
    public Score update(Score score){
        if(score.getId()==null){
            Optional<Score>g= scoreRepository.getScore(score.getId());
                if(!g.isEmpty()){
                if(score.getId()!=null){
                    g.get().setId(score.getId());
                }
                if(score.getId()!=null){
                    g.get().setId(score.getId());
                }
                return scoreRepository.save(g.get());
            }
        }
        return score;
    }
 
    public boolean deleteScore(int id){
        Optional<Score> c=getScore(id);
        if(!c.isEmpty()){
            scoreRepository.delete(c.get());
            return true;
        }
        return false;
    }
    

}