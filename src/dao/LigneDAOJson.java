package dao;

import java.lang.reflect.Type;
import java.util.LinkedList;

import com.google.gson.reflect.TypeToken;

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
		LinkedList<Ligne> lesLignes = findAll();
		lesLignes.remove(obj);
		return null;
	}

	@Override
	public Ligne create(Ligne obj) {
		// TODO Auto-generated method stub
		LinkedList<Ligne> lesLignes = findAll();
		lesLignes.add(obj);
		return obj;
	}

	@Override
	public Ligne update(Ligne obj) {
		// TODO Auto-generated method stub
		LinkedList<Ligne> lesLignes = findAll();
		lesLignes.remove(obj.getID());
		lesLignes.add(obj);
		return null;
	}

	@Override
	public void saveAll(LinkedList<Ligne> objs) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Ligne findByID(int id) {
		// TODO Auto-generated method stub
		LinkedList<Ligne> lesLignes = findAll();
		
		for(Ligne l : lesLignes) {
			if(l.getID() == id) {
				return l;
			}
		}
		return null;
	} 

	@Override
	public LinkedList<Ligne> findByName(String name) {
		// TODO Auto-generated method stub
		LinkedList<Ligne> lesLignes = findAll();
		LinkedList<Ligne> lesLignesCorrespondantes = new LinkedList<Ligne>();
		
		for (Ligne l: lesLignes) {
			if (l.getNom() == name) {
				lesLignesCorrespondantes.add(l);
			}
		}
		return lesLignesCorrespondantes;
	}

	@Override
	public LinkedList<Ligne> findAll() {
		// TODO Auto-generated method stub
		LinkedList<Ligne> lesLignes = new LinkedList<Ligne>();
		if (connectjson.getJson().compareTo("") != 0) {
			Type type = new TypeToken<LinkedList<Ligne>>(){}.getType();
			lesLignes = connectjson.getGson().fromJson(connectjson.getJson(), type);
		}
		return lesLignes;
	}

	
	
}
