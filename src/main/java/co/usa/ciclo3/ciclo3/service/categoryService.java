/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.Model.Category;
import co.usa.ciclo3.ciclo3.Repository.categoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jgfor
 */
@Service
public class categoryService {
    
    @Autowired
    private categoryRepository categoryRepository;
    
    public List<Category> getAll(){
        return categoryRepository.getAll();
    }
    
    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }
    
    public Category save(Category p){
        if(p.getId()==null){
            return categoryRepository.save(p);
    }else{
            Optional<Category> paux=categoryRepository.getCategory(p.getId());
            if(paux.isEmpty()){
                return categoryRepository.save(p);
            }else{
                return p;
            }
        }
    }
    
    public Category update(Category c){
        if(c.getId()!=null){
            Optional<Category>g=categoryRepository.getCategory(c.getId());
            if(!g.isEmpty()){
                if(c.getName()!=null){
                    g.get().setName(c.getName());
                }
                if(c.getDescription()!=null){
                    g.get().setDescription(c.getDescription());
                }
                if(c.getName()!=null){
                    g.get().setName(c.getName());
                }
                return categoryRepository.save(g.get());
            }
        }
        return c;

    }
 
    public boolean deleteCategory(int id){
        Optional<Category> c=getCategory(id);
        if(!c.isEmpty()){
            categoryRepository.delete(c.get());
            return true;
        }
        return false;
    }

}
