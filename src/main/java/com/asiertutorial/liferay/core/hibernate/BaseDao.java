package com.asiertutorial.liferay.core.hibernate;

import java.util.List;

import org.hibernate.Session;

public interface BaseDao<T> {

	Session getSession();

	T get(long id);

	void delete(T object);

	T merge(T object);

	T persist(T object);

	T save(T object);

	T update(T object);

	List<T> findAll();
}
