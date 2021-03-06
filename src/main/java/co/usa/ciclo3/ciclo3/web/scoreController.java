/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.ciclo3.ciclo3.web;

import co.usa.ciclo3.ciclo3.Model.Message;
import co.usa.ciclo3.ciclo3.Model.Score;
import co.usa.ciclo3.ciclo3.service.scoreService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jgfor
 */

@RestController
@RequestMapping("/api/Score")
@CrossOrigin(origins ="*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class scoreController {
    
    @Autowired
    private scoreService scoreService;
    
    @GetMapping("/all")
    public List<Score> getScore(){
        return scoreService.getAll();
        
    }
    
    @GetMapping("/{id}")
    public Optional<Score> getScore(@PathVariable("id") int idScore){
        return scoreService.getScore(idScore);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Score save(@RequestBody Score q){
        return scoreService.save(q);
        
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Score update(@RequestBody Score score){
        return scoreService.update(score);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteScore(@PathVariable("id") int id){
        return scoreService.deleteScore(id);
    }
    
}


