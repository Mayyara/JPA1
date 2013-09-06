package br.com.controller;

import br.com.model.negocio.Compra;
import br.com.model.persistencia.dao.CompraDAO;
import br.com.persistencia.CompraDAOImpl;
import java.util.List;

/**
 *
 * @author mayara_freita
 */
public class CompraController {

    public boolean salvar(Compra compra) {
        CompraDAO dao = new CompraDAOImpl();
        return dao.save(compra);

    }

    public boolean excluir(int id) {
        CompraDAO dao = new CompraDAOImpl();
        return dao.remove(Compra.class, id);

    }

    public List<Compra> listarCompra() {
        CompraDAO dao = new CompraDAOImpl();
        return dao.getAll(Compra.class);
    }

    public Compra listarCompraById(int id) {
        CompraDAO dao = new CompraDAOImpl();
        return dao.getById(Compra.class, id);

    }
     public List<Compra> listarCompraByProduto (String produto){
        CompraDAO dao = new CompraDAOImpl();
        return dao.getByProduto(produto);
    }
   
   public Compra listarCompraByProd (String produto){
        CompraDAO dao = new CompraDAOImpl();
        return dao.getByProd(produto);
    }
     
    
     
    
}
