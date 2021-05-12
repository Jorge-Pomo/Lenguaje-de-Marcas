package leerJson;

import java.io.File;

public class DescargarArchivo {

	//Atributos
	private String url;
	private String nombre;
	private String fichero = "";

	//Ubicacion de la carpeta destino
	private String folder;
	
	//Constructores
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
	
	//Getters && Setters
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
	
	
}
