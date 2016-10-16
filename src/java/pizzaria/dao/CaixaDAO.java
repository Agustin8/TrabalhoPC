/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaria.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import pizzaria.util.JPAUtil;
import pizzaria.model.Caixa;

/**
 *
 * @author Agustin
 */
public class CaixaDAO {
    
	private EntityManager entityManager
            = JPAUtil.ConnectionFactory().createEntityManager();
    
    public void adicionarCaixa(Caixa c) {
		try{
			entityManager.getTransaction().begin();
			entityManager.persist(c);
			entityManager.getTransaction().commit();
		} catch(Exception ex){
			entityManager.getTransaction().rollback();
		}
    }

        public Caixa selecionarCaixa(String l) {
        
        return entityManager.createQuery("select l from Caixa l where l.login = :login", Caixa.class)
                .setParameter("login", l)
                . getSingleResult();
        
    }


    public void AlterarCaixa(Caixa c) {
        
		try{
			entityManager.getTransaction().begin();
			entityManager.merge(c);
			entityManager.getTransaction().commit();
		} catch(Exception ex){
                    ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
    }

    public void removerCaixa(Caixa c) {
		try{
			entityManager.getTransaction().begin();
			Caixa aSerApagado = entityManager.find(Caixa.class,c.getLogin());
			entityManager.remove(aSerApagado);
			entityManager.getTransaction().commit();
		} catch(Exception ex){
			entityManager.getTransaction().rollback();
		}

    }
    
    public boolean verificarCaixa(String l) {
        int size = entityManager.createQuery("select l from Caixa l where l.login = :login", Caixa.class)
                .setParameter("login", l)
                .getResultList().size();
        return !(size>0);
        
    }
     public boolean validarCaixa(String login,String senha) {
        int size = entityManager.createQuery("select c from Caixa c where c.login = :login and c.senha = :senha", Caixa.class)
                .setParameter("login", login).setParameter("senha", senha).getResultList().size();
        return (size>0);
	
    }
     public void close() {
        if (entityManager.isOpen()) {
            entityManager.close();
        }
        if (JPAUtil.ConnectionFactory().isOpen()) {
            JPAUtil.ConnectionFactory().close();
        }
     }
}
