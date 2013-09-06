
package br.com.persistencia;

import br.com.model.negocio.Compra;
import br.com.model.persistencia.dao.CompraDAO;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author mayara_freita
 */
public class CompraDAOImpl extends DAOImpl<Compra, Integer> implements CompraDAO {

    @Override
    public List<Compra> getByProduto(String produto) {
        return getEntityManager().createQuery("select c from Compra c where c.produto like"
                + " '%" + produto + "%'").getResultList();
    }

    @Override
    public Compra getByProd(String produto) {
        Query q = getEntityManager().createQuery("select c from Compra c where c.produto like '" + produto + "'", Compra.class);
        List<Compra> compras = q.getResultList();
        Compra cc = new Compra();
        for (Compra c : compras) {
            cc = c;
        }
        return cc;

    }
    }

    
   
    
   
    
    

