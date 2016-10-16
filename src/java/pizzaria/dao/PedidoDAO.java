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
import pizzaria.model.Pedido;

/**
 *
 * @author Agustin
 */
public class PedidoDAO {
    
	private EntityManager entityManager
            = JPAUtil.ConnectionFactory().createEntityManager();
    
    public void adicionarPedido(Pedido p) {
		try{
			entityManager.getTransaction().begin();
			entityManager.persist(p);
			entityManager.getTransaction().commit();
		} catch(Exception ex){
                    ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
    }

    public Pedido selecionarPedido(int n) {
        return entityManager.createQuery("select n from Pedido n where numeroPedido = :numeroPedido", Pedido.class)
                .setParameter("numeroPedido", n)
                . getSingleResult();
        
    }

    public List<Pedido> listarPedido() {
        return entityManager.createQuery("select c from Pedido c ").getResultList();
        
    }

    public void AlterarPedido(Pedido p) {
        
		try{
			entityManager.getTransaction().begin();
			entityManager.merge(p);
			entityManager.getTransaction().commit();
		} catch(Exception ex){
			entityManager.getTransaction().rollback();
		}
    }

    public void removerPedido(Pedido p) {
		try{
			entityManager.getTransaction().begin();
			Pedido aSerApagado = entityManager.find(Pedido.class,p.getNumeroPedido());
			entityManager.remove(aSerApagado);
			entityManager.getTransaction().commit();
		} catch(Exception ex){
			entityManager.getTransaction().rollback();
		}

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
