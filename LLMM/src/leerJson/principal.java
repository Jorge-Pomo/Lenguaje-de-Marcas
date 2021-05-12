package leerJson;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class principal {

	public static void main(String[] args) {
		DescargarArchivo descarga = new DescargarArchivo();
		
		//Crea el directorio destino en caso de que no exista
		File dir = new File(descarga.getFolder());
		if (!dir.exists()) {
			  if (!dir.mkdir()) {
				  //No se puede crear el directorio dstino
			    return;
			  }
		}
		
		//Creamos el archivo destino, en caso de existir lo elimina
		File file = new File(descarga.getFolder() + descarga.getNombre());
		
		try {
			//Establece la conexion con la url
			URLConnection conn = new URL(descarga.getUrl()).openConnection();
			conn.connect();
			
			System.out.println("\nempezando descarga: \n");
			System.out.println(">> URL: " + descarga.getUrl());
			System.out.println(">> Nombre: " + descarga.getNombre());
			System.out.println(">> tamaño: " + conn.getContentLength() + " bytes");
		
			//Abrimos los STream
			InputStream in = conn.getInputStream();
			OutputStream out = new FileOutputStream(file);
			
			//Vamos leyendo del InputStream y vamos escribiendo en el OutputStream.
			//-1 == a que llego al final
			int b = 0;
			while (b != -1) {
			  b = in.read();
			  if (b != -1)
			    out.write(b);
			}
			
			//Cerramos los streams
			out.close();
			in.close();
			
			//Cerramos conexion
			System.exit (0);
			
			} catch (MalformedURLException e) {
			  System.out.println("la url: " + descarga.getUrl() + " no es valida!");
			} catch (IOException e) {
			  e.printStackTrace();
			}
		
	}

}
