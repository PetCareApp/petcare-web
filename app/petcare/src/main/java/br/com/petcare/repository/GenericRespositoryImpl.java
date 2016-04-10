package br.com.petcare.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

@Named
public class GenericRespositoryImpl<T> implements GenericRepository<T> {
	
	protected EntityManager em;
	
	@Override
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	@Override
	public void save(T entity) {
		this.em.persist(entity);
	}

	@Override
	public void update(T entity) {
		this.em.merge(entity);
	}

	@Override
	public void delete(T entity) {
		em.remove(em.merge(entity));
	}

	@Override
	@Transactional(readOnly = true)
	public T find(Class<T> entityClass, Object id) {
		T result = em.find(entityClass, id);
		return result;
	}

	@Override
	public List<T> find(Class<T> entityClass) {
		List<T> result = null;
		Query q = em.createQuery("select obj from " + entityClass.getSimpleName() + " obj");
		result = q.getResultList();
		return result;
	}

	@Override
	public List<T> find(String query, Map<String, Object> namedParams) {
		Query q = em.createQuery(query);
		setNamedParameters(q, namedParams);
		return q.getResultList();
		
	}

	@Override
	public T findFirst(String query, Map<String, Object> namedParams) {
		List<T> result = find(query, namedParams);
		return result == null || result.size() == 0 ? null : result.get(0);
	}
	
	private void setNamedParameters(Query q, Map<String, Object> namedParams) {
		if (namedParams != null) {
			Set<String> keys = namedParams.keySet();
			for (String key : keys) {
				q.setParameter(key, namedParams.get(key));
			}
		}
	}

}
