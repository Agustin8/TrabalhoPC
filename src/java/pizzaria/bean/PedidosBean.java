/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaria.bean;

import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import pizzaria.dao.PedidoDAO;
import pizzaria.model.Pedido;

/**
 *
 * @author Agustin
 */
@Named(value = "pedidosBean")
@Dependent
@ManagedBean
public class PedidosBean {
    private List<Pedido> pedido;
    private PedidoDAO pedidoDAO = new PedidoDAO();
    
    private String selecionarPedido(){
        pedidoDAO.listarPedido();
        return pedidoDAO.toString();
    }

    public PedidosBean() {
    }

    public List<Pedido> getPedido() {
        return pedido;
    }

    public void setPedido(List<Pedido> pedido) {
        this.pedido = pedido;
    }

    public PedidoDAO getPedidoDAO() {
        return pedidoDAO;
    }

    public void setPedidoDAO(PedidoDAO pedidoDAO) {
        this.pedidoDAO = pedidoDAO;
    }
    
    
    
}
