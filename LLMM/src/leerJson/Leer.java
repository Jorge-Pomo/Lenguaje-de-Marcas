package leerJson;

import java.io.BufferedReader;
import java.io.FileReader;

import com.google.gson.Gson;

public class Leer {

	DescargarArchivo descarga = new DescargarArchivo();
	Gson gson = new Gson();
	
	fichero = descarga.getFichero();
	
	try {
		BufferedReader br = new BufferedReader(new FileReader("datos.json"));
		String linea;
		while((linea = br.readLine()) != null) {
			
		}
	}catch() {
		
	}
}

https://www.discoduroderoer.es/leer-y-escribir-json-en-java/