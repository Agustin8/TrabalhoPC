/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaria.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Agustin
 */
@Entity
public class Pedido implements Serializable{
    @Id
    @GeneratedValue
    private int numeroPedido;
    
    private double valor;
    private String descricao;
    private boolean delivery;
    
    @ManyToOne
    @JoinColumn(name = "caixa_login")
    private Caixa caixa;

    public Pedido() {
    }

    public Pedido(double valor, String descricao, boolean delivery, Caixa caixa) {
        this.valor = valor;
        this.descricao = descricao;
        this.delivery = delivery;
        this.caixa = caixa;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

   

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getdescricao() {
        return descricao;
    }

    public void setdescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isDelivery() {
        return delivery;
    }

    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.numeroPedido;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pedido other = (Pedido) obj;
        if (this.numeroPedido != other.numeroPedido) {
            return false;
        }
        return true;
    }

   

    @Override
    public String toString() {
        return "Pedido: " + numeroPedido + ", valor: " + valor + ", descricao: " + descricao + ", delivery: " + delivery;
    }
    
    
    
}
