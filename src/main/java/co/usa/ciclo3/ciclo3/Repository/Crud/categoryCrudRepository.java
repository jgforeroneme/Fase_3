/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.ciclo3.ciclo3.Repository.Crud;

/**
 *
 * @author jgfor
 */
import org.springframework.data.repository.CrudRepository;
import co.usa.ciclo3.ciclo3.Model.Category;

public interface categoryCrudRepository extends CrudRepository<Category, Integer> {
    
}
