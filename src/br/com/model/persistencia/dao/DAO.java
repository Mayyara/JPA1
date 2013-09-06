

package br.com.model.persistencia.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author mayara_freita
 */
public interface DAO <T, I extends Serializable>  {
    
    public boolean save (T entity);
    
    public boolean remove (Class<T> classe, I pk);
    
    public T getById (Class<T> classe, I pk);
    
    public List<T> getAll (Class<T> classe);
    
    public EntityManager getEntityManager();
    
  
    
}
