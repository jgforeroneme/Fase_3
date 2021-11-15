/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.Model.Admin;
import co.usa.ciclo3.ciclo3.Repository.adminRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jgfor
 */
@Service
public class adminService {
    
    @Autowired
    private adminRepository adminRepository;
    
    public List<Admin> getAll(){
        return adminRepository.getAll();
    }
    
    public Optional<Admin> getadmin(int idUser){
        return adminRepository.getAdmin(idUser);
    }
    
    public Admin save(Admin p){
        if(p.getIdUser()==null){
            return adminRepository.save(p);
    }else{
            Optional<Admin> paux=adminRepository.getAdmin(p.getIdUser());
            if(paux.isEmpty()){
                return adminRepository.save(p);
            }else{
                return p;
            }
        }
    }
    
    public Admin update(Admin admin){
        if(admin.getUser()==null){
            Optional<Admin>g= adminRepository.getAdmin(admin.getIdUser());
                if(!g.isEmpty()){
                if(admin.getName()!=null){
                    g.get().setName(admin.getName());
                }
                if(admin.getName()!=null){
                    g.get().setName(admin.getName());
                }
                return adminRepository.save(g.get());
            }
        }
        return admin;
    }
 
    public boolean deleteAdmin(int id){
        Optional<Admin> c=getadmin(id);
        if(!c.isEmpty()){
            adminRepository.delete(c.get());
            return true;
        }
        return false;
    }
    
    
}