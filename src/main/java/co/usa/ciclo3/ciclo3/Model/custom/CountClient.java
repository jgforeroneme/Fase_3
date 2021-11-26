/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.ciclo3.ciclo3.Model.custom;

import co.usa.ciclo3.ciclo3.Model.Client;

/**
 *
 * @author jgfor
 */
public class CountClient {
    
    private Client client;
    private Long total;
    
    public CountClient(Long total, Client client){        
        this.total = total;
        this.client = client;        
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
    
    
    
}
