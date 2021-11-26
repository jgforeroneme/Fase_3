/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.Model.Reservation;
import co.usa.ciclo3.ciclo3.Model.custom.CountClient;
import co.usa.ciclo3.ciclo3.Model.custom.StatustAmount;
import co.usa.ciclo3.ciclo3.Repository.reservationRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jgfor
 */
@Service
public class reservationService {
    
    @Autowired
    private reservationRepository reservationRepository;
    
    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }
    
    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }
    
    public Reservation save(Reservation p){
        if(p.getIdReservation()==null){
            return reservationRepository.save(p);
    }else{
            Optional<Reservation> paux=reservationRepository.getReservation(p.getIdReservation());
            if(paux.isEmpty()){
                return reservationRepository.save(p);
            }else{
                return p;
            }
        }
    }
    
    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()==null){
            Optional<Reservation>g= reservationRepository.getReservation(reservation.getIdReservation());
            if(!g.isEmpty()){
                if(reservation.getStartDate()!=null){
                    g.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    g.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    g.get().setStatus(reservation.getStatus());
                }
                reservationRepository.save(g.get());
                return reservationRepository.save(g.get());
            }
        }
        return reservation;
    }
 
    public boolean deleteReservation(int id){
        Optional<Reservation> c=getReservation(id);
        if(!c.isEmpty()){
            reservationRepository.delete(c.get());
            return true;
        }
        return false;
    }
    
     public List<CountClient> getTopClients(){
        return reservationRepository.getTopClient();
    }
    
    public StatustAmount getStatusReport(){
        List<Reservation> completed=reservationRepository.getReservationsByStatus("completed");
        List<Reservation> cancelled=reservationRepository.getReservationsByStatus("cancelled");

        StatustAmount descAmt=new StatustAmount(completed.size(),cancelled.size());
        return descAmt;
    }
    
    public List<Reservation> getReservationPeriod(String d1, String d2){

        // yyyy-MM-dd
        SimpleDateFormat parser=new SimpleDateFormat("yyyy-MM-dd");
        Date dateOne=new Date();
        Date dateTwo=new Date();
        try {
            dateOne=parser.parse(d1);
            dateTwo=parser.parse(d2);
        }catch (ParseException e) {
            e.printStackTrace();
        }
        if(dateOne.before(dateTwo)){
            return reservationRepository.getReservationByPeriod(dateOne, dateTwo);
        }else{
            return new ArrayList<>();
        }
    }
}

