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
import co.usa.ciclo3.ciclo3.Model.Reservation;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

public interface reservationCrudRepository extends CrudRepository<Reservation, Integer> {
    
    public List<Reservation>  findAllByStartDateAfterAndStartDateBefore(Date dateOne,Date dateTwo);
    
    public List<Reservation> findAllByStatus(String status);
    
    public List<Reservation> findAllByClient(String client);
    
    @Query("select c.client, COUNT(c.client) from Reservation AS c group by c.client order by COUNT(c.client) desc")
    public List<Object[]>countTotalReservationByClient();   
    
}
