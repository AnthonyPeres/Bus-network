package dao;

import java.util.LinkedList;

import dataSourceManagement.JsonManager;

public abstract class DAOGenerique<T> {

	public JsonManager connectjson = JsonManager.getInstance();
	
	public abstract T delete(T obj);
	public abstract T create(T obj);
	public abstract T update(T obj);
	
	public abstract void saveAll(LinkedList<T> objs);
	public abstract T findByID(int id);
	public abstract LinkedList<T> findByName(String name);
	public abstract LinkedList<T> findAll();
	
	
}
