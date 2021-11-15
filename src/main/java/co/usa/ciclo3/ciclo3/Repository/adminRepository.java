/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.ciclo3.ciclo3.Repository;

import co.usa.ciclo3.ciclo3.Model.Admin;
import co.usa.ciclo3.ciclo3.Repository.Crud.adminCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jgfor
 */
@Repository
public class adminRepository {
    
    @Autowired
    private adminCrudRepository adminCrudRepository;
    
    public List<Admin> getAll(){
        return (List<Admin>)adminCrudRepository.findAll();
    }
    
    public Optional<Admin>getAdmin(int id){
        return adminCrudRepository.findById(id);
    }
    
    public Admin save(Admin p){
        return adminCrudRepository.save(p);
    }
    
       public void delete(Admin c){
        adminCrudRepository.delete(c);
    }
    
       
}
    


