package leerJson;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class DescargarArchivo {

	// Atributos
	private String url;
	private String nombre;
	private String fichero = "";

	// Ubicacion de la carpeta destino
	private String folder;

	// Constructores
	public DescargarArchivo() {
		url = "http://mapas.valencia.es/lanzadera/opendata/Tra-camaras/JSON?srsName=EPSG:4326";
		nombre = "camarasVlc.json";
		folder = "C:\\Users\\DAM\\Documents\\archivosLLMM\\";
	}

	public DescargarArchivo(String url, String nombre, String folder) {
		this.url = url;
		this.nombre = nombre;
		this.folder = folder;
	}

	// Getters && Setters
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFolder() {
		return folder;
	}

	public void setFolder(String folder) {
		this.folder = folder;
	}

	public String getFichero() {
		return fichero;
	}

	public void setFichero(String fichero) {
		this.fichero = fichero;
	}

	// Metodos
	public void Descargar() {
		// Crea el directorio destino en caso de que no exista
		File dir = new File(getFolder());
		if (!dir.exists()) {
			if (!dir.mkdir()) {
				// No se puede crear el directorio dstino
				return;
			}
		}

		// Creamos el archivo destino, en caso de existir lo elimina
		File file = new File(getFolder() + getNombre());

		try {
			// Establece la conexion con la url
			URLConnection conn = new URL(getUrl()).openConnection();
			conn.connect();

			System.out.println("\nempezando descarga: \n");
			System.out.println(">> URL: " + getUrl());
			System.out.println(">> Nombre: " + getNombre());
			System.out.println(">> tamaño: " + conn.getContentLength() + " bytes");

			// Abrimos los STream
			InputStream in = conn.getInputStream();
			OutputStream out = new FileOutputStream(file);

			// Vamos leyendo del InputStream y vamos escribiendo en el OutputStream.
			// -1 == a que llego al final
			int b = 0;
			while (b != -1) {
				b = in.read();
				if (b != -1)
					out.write(b);
			}

			// Cerramos los streams
			out.close();
			in.close();

			// Cerramos conexion
			

		} catch (MalformedURLException e) {
			System.out.println("la url: " + getUrl() + " no es valida!");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
