
package br.com.model.persistencia.dao;

import br.com.model.negocio.Compra;
import java.util.List;

/**
 *
 * @author mayara_freita
 */
public interface CompraDAO extends  DAO <Compra, Integer> {
    
    List<Compra> getByProduto (String produto);
    Compra getByProd (String produto); 
    
    
    
}
