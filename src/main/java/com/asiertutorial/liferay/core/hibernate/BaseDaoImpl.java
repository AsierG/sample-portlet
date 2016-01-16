package com.asiertutorial.liferay.core.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public abstract class BaseDaoImpl<T> implements BaseDao<T> {

	@Autowired
	private SessionFactory sessionFactory;

	protected abstract Class<? extends T> getEntityClass();

	protected abstract Order getDefaultOrder();

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public T get(long id) {
		return (T) getSession().get(getEntityClass(), id);
	}

	public void delete(T object) {
		getSession().delete(object);
	}

	public T merge(T object) {
		getSession().merge(object);
		return object;
	}

	public T persist(T object) {
		getSession().persist(object);
		return object;
	}

	public T save(T object) {
		getSession().save(object);
		return object;
	}

	public T update(T object) {
		getSession().update(object);
		return object;
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return getSession().createQuery("from " + getEntityClass().getName())
				.list();
	}
}
