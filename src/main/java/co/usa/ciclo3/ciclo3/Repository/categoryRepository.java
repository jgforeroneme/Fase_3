/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.ciclo3.ciclo3.Repository;

import co.usa.ciclo3.ciclo3.Model.Category;
import co.usa.ciclo3.ciclo3.Repository.Crud.categoryCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jgfor
 */
@Repository
public class categoryRepository {
    
    @Autowired
    private categoryCrudRepository categoryCrudRepository;
    
    public List<Category> getAll(){
        return (List<Category>)categoryCrudRepository.findAll();
    }
    
    public Optional<Category>getCategory(int id){
        return categoryCrudRepository.findById(id);
    }
    
    public Category save(Category p){
        return categoryCrudRepository.save(p);
    }
    
   public void delete(Category c){
        categoryCrudRepository.delete(c);
    }
    
}
