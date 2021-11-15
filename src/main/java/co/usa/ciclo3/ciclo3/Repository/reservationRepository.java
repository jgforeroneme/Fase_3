/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.ciclo3.ciclo3.Repository;

import co.usa.ciclo3.ciclo3.Model.Client;
import co.usa.ciclo3.ciclo3.Model.Reservation;
import co.usa.ciclo3.ciclo3.Model.custom.CountClient;
import co.usa.ciclo3.ciclo3.Repository.Crud.reservationCrudRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jgfor
 */
@Repository
public class reservationRepository {
    
    @Autowired
    private reservationCrudRepository reservationCrudRepository;
    
    public List<Reservation> getAll(){
        return (List<Reservation>)reservationCrudRepository.findAll();
    }
    
    public Optional<Reservation>getReservation(int id){
        return reservationCrudRepository.findById(id);
    }
    
    public Reservation save(Reservation p){
        return reservationCrudRepository.save(p);
    }
    
    public void delete(Reservation c){
        reservationCrudRepository.delete(c);
    }
    
    //arreglo
    public List<Reservation> getReservationsByStatus(String status){
        return reservationCrudRepository.findAllByStatus(status);
    }
    
    public List<Reservation> getReservationByPeriod(Date dateOne,Date dateTwo){
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(dateOne, dateTwo);
    }
    
    public List<CountClient> getTopClient(){
        List<CountClient> res=new ArrayList<>();
        List<Object[]> report=reservationCrudRepository.countTotalReservationByClient();
        for(int i=0;i<report.size();i++){
            Client cat=(Client) report.get(i)[0];
            Integer client=(Integer) report.get(i)[1];
            CountClient cc=new CountClient(client,cat);
            res.add(cc);
        }
        return res;
    }

}
    

