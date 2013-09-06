package br.com.controller;

import br.com.model.negocio.Cliente;
import br.com.model.persistencia.dao.ClienteDAO;
import br.com.persistencia.ClienteDAOImpl;
import java.util.List;

/**
 *
 * @author mayara_freita
 */
public class ClienteController {

    public boolean salvar(Cliente cliente) {
        ClienteDAO dao = new ClienteDAOImpl();
        return dao.save(cliente);

    }

    public boolean excluir(int id) {
        ClienteDAO dao = new ClienteDAOImpl();
        return dao.remove(Cliente.class, id);

    }

    public List<Cliente> listarCliente() {
        ClienteDAO dao = new ClienteDAOImpl();
        return dao.getAll(Cliente.class);
    }

    public Cliente listarClienteById(int id) {
        ClienteDAO dao = new ClienteDAOImpl();
        return dao.getById(Cliente.class, id);

    }
     public Cliente listarClienteByNome(String nome){
     ClienteDAO dao = new ClienteDAOImpl();
     return dao.getClienteByNome(Cliente.class, nome);
     }
     
     public List<Cliente> listarClienteNome (String nome){
         ClienteDAO dao = new ClienteDAOImpl();
         return dao.getByNome(nome);
     }
     
    
}
