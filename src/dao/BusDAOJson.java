package dao;

import java.lang.reflect.Type;
import java.util.LinkedList;

import com.google.gson.reflect.TypeToken;

import modele.Arret;
import modele.Bus;

public class BusDAOJson extends DAOGenerique<Bus> {

	private static BusDAOJson instance = null;
	
	protected BusDAOJson() {
		
	}
	
	public static synchronized BusDAOJson getInstance() {
		if (instance == null) {
			instance = new BusDAOJson();
		}
		return instance;
	}
	
	@Override
	public Bus delete(Bus obj) {
		// TODO Auto-generated method stub
		LinkedList<Bus> lesBus = findAll();
		lesBus.remove(obj);
		return null;
	}

	@Override
	public Bus create(Bus obj) {
		// TODO Auto-generated method stub
		LinkedList<Bus> lesBus = findAll();
		lesBus.add(obj);
		return obj;
	}

	@Override
	public Bus update(Bus obj) {
		// TODO Auto-generated method stub
		LinkedList<Bus> lesBus = findAll();
		lesBus.remove(obj.getNumero());
		lesBus.add(obj);
		return null;
	}

	@Override
	public void saveAll(LinkedList<Bus> objs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Bus findByID(int id) {
		// TODO Auto-generated method stub
		LinkedList<Bus> lesBus = findAll();
		
		for(Bus b : lesBus) {
			if(b.getNumero() == id) {
				return b;
			}
		}
		return null;
	}

	@Override
	public LinkedList<Bus> findByName(String name) {
		return null;
	}

	@Override
	public LinkedList<Bus> findAll() {
		// TODO Auto-generated method stub
		LinkedList<Bus> lesBus = new LinkedList<Bus>();
		if (connectjson.getJson().compareTo("") != 0) {
			Type type = new TypeToken<LinkedList<Bus>>(){}.getType();
			lesBus = connectjson.getGson().fromJson(connectjson.getJson(), type);
		}
		return lesBus;
	}


}
