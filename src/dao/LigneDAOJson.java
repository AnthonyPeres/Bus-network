package dao;

import java.util.LinkedList;

import reseau.*;

public class LigneDAOJson extends DAOGenerique<Ligne> {

	private static LigneDAOJson instance = null;
	
	protected LigneDAOJson() {
		
	}
	
	public static synchronized LigneDAOJson getInstance() {
		if (instance == null) {
			instance = new LigneDAOJson();
		}
		return instance;
	}

	@Override
	public Ligne delete(Ligne obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ligne create(Ligne obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ligne update(Ligne obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveAll(LinkedList<Ligne> objs) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Ligne findByID(int id) {
		// TODO Auto-generated method stub
		return null;
	} 

	@Override
	public LinkedList<Ligne> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedList<Ligne> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
