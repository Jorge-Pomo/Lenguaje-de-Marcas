package leerJson;

import org.json.JSONException;

public class principal {

	public static void main(String[] args) throws JSONException {
		DescargarArchivo descarga = new DescargarArchivo();
		Leer lerArch = new Leer();
		
		
		descarga.Descargar();
		lerArch.leerArrchivo();
		
		
		
	}

}
