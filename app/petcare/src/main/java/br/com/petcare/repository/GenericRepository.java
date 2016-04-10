package br.com.petcare.repository;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

public interface GenericRepository<T> {
	
	public void setEntityManager(EntityManager em);
	
	public void save(T entity);
	
	public void update(T entity);

	public void delete(T entity);

	public T find(Class<T> entityClass, Object id);

	public List<T> find(Class<T> entityClass);
	
	public List<T> find(String query, Map<String, Object> namedParams);
	
	public T findFirst(String query, Map<String, Object> namedParams);

}
