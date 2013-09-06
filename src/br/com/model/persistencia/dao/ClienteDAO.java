
package br.com.model.persistencia.dao;

import br.com.model.negocio.Cliente;
import java.util.List;

/**
 *
 * @author mayara_freita
 */
public interface ClienteDAO extends DAO<Cliente, Integer>{
    
    List<Cliente> getByNome (String nome);
    Cliente getClienteByRgCpf(String rg, String cpf);
    Cliente getClienteByNome(Class<Cliente> aClass, String nome);
   
  
}
