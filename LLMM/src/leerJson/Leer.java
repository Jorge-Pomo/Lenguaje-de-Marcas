package leerJson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

//https://www.discoduroderoer.es/leer-y-escribir-json-en-java/

public class Leer {
	DescargarArchivo descarga = new DescargarArchivo();
	Gson gson = new Gson();

	// Atributos
	private String fichero;

	// Constructor
	public Leer() {

	}

	// Getters && Setters
	public String getFichero() {
		return fichero;
	}

	public void setFichero(String fichero) {
		this.fichero = fichero;
	}

	// Metodos
	public void leerArrchivo() throws JSONException {
		fichero = "";

		try {
			BufferedReader br = new BufferedReader(new FileReader(descarga.getFolder() + descarga.getNombre()));
			String linea;
			while ((linea = br.readLine()) != null) {
				fichero += linea + "\n";
			}
		} catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}

		JSONObject json = new JSONObject(fichero);
//		String holder = json.getJSONArray("features").getJSONObject("properties").getString("angulo");
		
		JSONArray arr = json.getJSONArray("features");
		for (int i = 0; i < arr.length(); i++) {
			System.out.println("Descripció " + arr.getJSONObject(i).getJSONObject("properties").getString("descripcio"));
			System.out.println("Angul " + arr.getJSONObject(i).getJSONObject("properties").getString("angulo"));
			System.out.println("idcamara " + arr.getJSONObject(i).getJSONObject("properties").getString("idcamara"));
			System.out.println();
			
		}
		
	
	    
	    
	}

}
