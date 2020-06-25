package dataSourceManagement;

import java.io.*;
import java.lang.reflect.Type;
import java.util.LinkedList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import modele.Ligne;

public class JsonManager {

	final Gson gson = new GsonBuilder().setPrettyPrinting().create();
	String json= "";
	String fichierJson="reseau.json";
	
	private static JsonManager instance=null;
	
	/* Constructeur */
	
	protected JsonManager() {
		remplissageVarJson();
	}
	
	public static synchronized JsonManager getInstance() {
		if (instance == null) {
			instance= new JsonManager();			
		}
		return instance;
	}
	
	
	// On recupere le contenu du fichier json pour le mettre dans la variable json
	public void remplissageVarJson() {
		try {
			InputStream ips=new FileInputStream(fichierJson); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null){
				json+=ligne;
			}
			br.close(); 
		}  
		catch (Exception e){
			System.out.println(e.toString());
		}
	}
	
	public String getJson() {
		return this.json;
	}
	
	public void setJson(String json) {
		this.json = json;
	}
	
	public Gson getGson() {
		return this.gson;
	}
}
