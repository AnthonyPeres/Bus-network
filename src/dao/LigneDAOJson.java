package dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.LinkedList;

import com.google.gson.reflect.TypeToken;

import modele.Ligne;

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
		saveAll(lesLignes);
		return null;
	}

	@Override
	public Ligne create(Ligne obj) {
		// TODO Auto-generated method stub
		LinkedList<Ligne> lesLignes = findAll();
		lesLignes.add(obj);
		saveAll(lesLignes);
		return obj;
	}

	@Override
	public Ligne update(Ligne obj) {
		// TODO Auto-generated method stub
		LinkedList<Ligne> lesLignes = findAll();
		lesLignes.remove(obj.getID());
		lesLignes.add(obj);
		saveAll(lesLignes);
		return null;
	}

	@Override
	public void saveAll(LinkedList<Ligne> objs) {
		// TODO Auto-generated method stub
		connectjson.setJson(connectjson.getGson().toJson(objs));
		
		Writer writer = null;
		try {
			writer = new FileWriter("reseau.json");
			writer.write(connectjson.getJson());
		} catch(IOException e) {
			System.out.println("Impossible d'écrire dans le fichier json " + e);
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch(IOException e) {
					System.out.println("Erreur " + e);
				}
			}
		}
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
