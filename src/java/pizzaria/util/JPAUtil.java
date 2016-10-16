/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaria.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 1856831
 */
public class JPAUtil {
    
    public static EntityManagerFactory ConnectionFactory(){
        return Persistence.createEntityManagerFactory("pizzaria-jpa");
    } 
    
}
