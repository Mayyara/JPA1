
package br.com.persistencia;

import br.com.model.negocio.Cliente;
import br.com.model.persistencia.dao.ClienteDAO;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author mayara_freita
 */
public class ClienteDAOImpl extends DAOImpl<Cliente, Integer> implements ClienteDAO {

  
    public List<Cliente> getByNome(String nome) {
        return getEntityManager().createQuery("select c from Cliente c where c.nome like"
                + "'%" + nome + "%'").getResultList();
    }

  
    public Cliente getClienteByRgCpf(String rg, String cpf) {
       Query q = getEntityManager().createQuery("select c from Cliente c where c.rg"
                + " like '" + rg + "' and c.cpf like '" + cpf + "'", Cliente.class);
        List<Cliente> clientes = q.getResultList();
        Cliente c1 = new Cliente();
        for (Cliente c : clientes) {
            c1 = c;
        }
        return c1;
    }

  
   
    public Cliente getClienteByNome(Class<Cliente> Class, String nome) {
          Query q = getEntityManager().createQuery("select c from Cliente c where c.nome"
                + " like '"+ nome +"'", Cliente.class);
        List<Cliente> clientes = q.getResultList();
        Cliente c1 = new Cliente();
        for (Cliente c : clientes) {
            c1 = c;
        }
        return c1;
            
    }

    
   
        
        
       
    



   
    
    
    
}
