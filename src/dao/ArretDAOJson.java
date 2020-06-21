package dao;

import java.util.LinkedList;
import reseau.*;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

public class ArretDAOJson extends DAOGenerique<Arret> {
	
private static ArretDAOJson instance = null;
	
	protected ArretDAOJson() {
		
	}
	
	public static synchronized ArretDAOJson getInstance() {
		if (instance == null) {
			instance = new ArretDAOJson();
		}
		return instance;
	}

	@Override
	public Arret delete(Arret obj) {
		// TODO Auto-generated method stub
		LinkedList<Arret> lesArrets = findAll();
		lesArrets.remove(obj);
		return null;
	}

	@Override
	public Arret create(Arret obj) {
		// TODO Auto-generated method stub
		LinkedList<Arret> lesArrets = findAll();
		lesArrets.add(obj);
		return obj;
	}

	@Override
	public Arret update(Arret obj) {
		// TODO Auto-generated method stub
		LinkedList<Arret> lesArrets = findAll();
		lesArrets.remove(obj.getID());
		lesArrets.add(obj);
		return null;
	}

	@Override
	public void saveAll(LinkedList<Arret> objs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Arret findByID(int id) {
		// TODO Auto-generated method stub
		LinkedList<Arret> lesArrets = findAll();
		
		for(Arret a : lesArrets) {
			if(a.getID() == id) {
				return a;
			}
		}
		return null;
	}
	
	@Override
	public LinkedList<Arret> findByName(String name) {
		// TODO Auto-generated method stub
		LinkedList<Arret> lesArrets = findAll();
		LinkedList<Arret> lesArretsCorrespondant = new LinkedList<Arret>();
		
		for (Arret a: lesArrets) {
			if (a.getNom() == name) {
				lesArretsCorrespondant.add(a);
			}
		}
		return lesArretsCorrespondant;
	}

	@Override
	public LinkedList<Arret> findAll() {
		// TODO Auto-generated method stub
		LinkedList<Arret> lesArrets = new LinkedList<Arret>();
		if (connectjson.getJson().compareTo("") != 0) {
			Type type = new TypeToken<LinkedList<Arret>>(){}.getType();
			lesArrets = connectjson.getGson().fromJson(connectjson.getJson(), type);
		}
		return lesArrets;
	}

	
}
