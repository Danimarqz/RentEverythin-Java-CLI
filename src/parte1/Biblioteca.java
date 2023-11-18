package parte1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
	static ArrayList<Producto> biblioteca = new ArrayList<Producto>(); // Creo un arraylist biblioteca que contenga
																		// todos los productos
	static String rutaUsuario = System.getProperty("user.dir"); // Guardo la ruta en la que esta ubicado el programa
	static String rutatxtLibro = rutaUsuario + "\\src\\datos\\Libros.txt"; // Guardo la ruta del txt de libros
	static String rutatxtDisco = rutaUsuario + "\\src\\datos\\Discos.txt"; // Guardo la ruta del txt de discos
	static String rutatxtPelicula = rutaUsuario + "\\src\\datos\\Peliculas.txt"; // Guardo la ruta del txt de peliculas

	public static void main(String[] args) throws Throwable {
		gestionArchivos(); // Leo los datos de los txt
		int opcion;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Seleccione una opcion:");
			System.out.println("1. Alquilar un libro");
			System.out.println("2. Alquilar una Pelicula");
			System.out.println("3. Alquilar un DVD de música");
			System.out.println("4. Devolver un producto");
			System.out.println("5. Ver todos los productos disponibles");
			System.out.println("6. Guardar informacion en ficheros");
			System.out.println("7. Salir");
			opcion = sc.nextInt();

			switch (opcion) {
			case 1: // alquilar libro
				System.out.println("Introduce el codigo del libro");
				String codigoLibro = sc.next();
				boolean errorCodigoL = false;
				for (Producto i : biblioteca) { // busco en el arraylist biblioteca si existe ese codigo y si es un
												// libro y llamo al metodo alquilar
					if (i.getCodigo().equals(codigoLibro) && i instanceof Libro) {
						i.alquilar();
						errorCodigoL = false;
						break;
					} else { // Si no existe el codigo o no es un libro envio el mensaje de que no existe
						errorCodigoL = true;
					}
				}
				if (errorCodigoL) {
					System.out.println("No existe ningún libro con ese codigo");
				}
				break;
			case 2: // alqilar pelicula
				System.out.println("Introduce el codigo de la pelicula");
				String codigoPelicula = sc.next();
				boolean errorCodigoP = false;
				for (Producto i : biblioteca) { // Busco el codigo de la pelicula y compruebo si es una pelicula
					if (i.getCodigo().equals(codigoPelicula) && i instanceof Pelicula) {
						i.alquilar(); // la alquilo
						errorCodigoP = false;
						break;
					} else {
						errorCodigoP = true;
					}
				}
				if (errorCodigoP) { // Si no existe o no es pelicula envio el mensaje
					System.out.println("No existe ninguna pelicula con ese codigo");
				}
				break;
			case 3: // alquilar dvd musica
				System.out.println("Introduce el codigo del DVD de música");
				String codigoD = sc.next();
				boolean errorCodigoD = false;
				for (Producto i : biblioteca) { // busco por codigo y compruebo si es dvdmusica
					if (i.getCodigo().equals(codigoD) && i instanceof DVDMusica) {
						i.alquilar(); // lo alquilo
						errorCodigoD = false;
						break;
					} else {
						errorCodigoD = true;
					}
				}
				if (errorCodigoD) {// Envio mensaje si no existe dvdmusica con ese codigo
					System.out.println("No existe ningún DVD de música con ese codigo");
				}
				break;
			case 4: // devolver un producto
				System.out.println("Introduce el codigo del producto");
				String codigoDevolucion = sc.next();
				boolean errorDevolucion = false;
				for (Producto i : biblioteca) { // Busco el codigo del producto
					if (i.getCodigo().equals(codigoDevolucion)) {
						i.devolver(); // Loe devuelvo
						errorDevolucion = false;
						break;
					} else {
						errorDevolucion = true;
					}
				}
				if (errorDevolucion) { // Envio el mensaje si el codigo es erroneo
					System.out.println("Error en el codigo");
				}
				break;
			case 5: // Muestro por consola los productos que no han sido alquilados
				for (Producto i : biblioteca) {
					if (i.getAlquilado() == false) {
						System.out.println(i.toString());
					}
				}
				break;
			case 6:
				guardarInformacion();
				System.out.println("Guardado");
				break;
			case 7:
				System.out.println("Gracias por usar nuestro servicio!");
				break;
			default:
				System.out.println("Opcion invalida. Por favor, seleccione una opcion valida.");
			}
		} while (opcion != 7);
		sc.close();

	}

	public static void gestionArchivos() throws Throwable {
		ArrayList<String> libro = new ArrayList<String>(); // Creo un arraylist de libros
		ArrayList<String> discos = new ArrayList<String>(); // de discos
		ArrayList<String> peliculas = new ArrayList<String>(); // de peliculas
		// Guardar la ruta de los txt

		try {// Volcar los datos del txt al arraylist libro
			FileReader frlibros = new FileReader(rutatxtLibro); // Leo el archivos libros.txt
			BufferedReader buffRLibro = new BufferedReader(frlibros); // Leo linea a linea
			String line;
			while ((line = buffRLibro.readLine()) != null) { // Añado cada linea al arraylist libro
				libro.add(line);
			}
			// Volcar los datos del arraylist libro a biblioteca
			for (String i : libro) {
				String[] atributos = i.split(",");// Separo los datos de cada lina del arraylist libro por coma y los
													// asocio a un atributo
				String codigo = atributos[0];
				String titulo = atributos[1];
				String autor = atributos[2];
				int paginas = Integer.parseInt(atributos[3]);
				boolean alquilado;
				if (atributos[4].equals("1")) { // paso 1 a true y 0 a false
					alquilado = true;
				} else {
					alquilado = false;
				}
				int dias = Integer.parseInt(atributos[5]);
				// Creo un nuevo libro con los atributos del txt y lo añado a la biblioteca
				Libro i1 = new Libro(codigo, titulo, alquilado, dias, autor, paginas);
				biblioteca.add(i1);
			}
			buffRLibro.close();
			System.out.println(biblioteca);
		} catch (FileNotFoundException e) { // Error archivo no encontrado
			System.out.println("No se pudo abrir el archivo '" + rutatxtLibro + "'");
		} catch (IOException e) { // Error permisos
			System.out.println("Error leyendo el archivo '" + rutatxtLibro + "'");
		}

		try {// Volcar los datos del txt de discos al arraylist discos
			FileReader frdiscos = new FileReader(rutatxtDisco); // Leo el archivos discos.txt
			BufferedReader buffRdisco = new BufferedReader(frdiscos); // Leo linea a linea
			String line;
			while ((line = buffRdisco.readLine()) != null) { // Guardo las lineas en el arraylist discos
				discos.add(line);
			}
			// Volcar los datos del arraylist discos a biblioteca
			for (String i : discos) {// Separo los datos del arraylist por coma y los asocio a atributos
				String[] atr = i.split(",");
				String codigo = atr[0];
				String titulo = atr[1];
				int duracion = Integer.parseInt(atr[2]);
				String grupo = atr[3];
				boolean alquilado;
				if (atr[4].equals("1")) {
					alquilado = true;
				} else {
					alquilado = false;
				}
				int dias = Integer.parseInt(atr[5]);
				DVDMusica d1 = new DVDMusica(codigo, titulo, alquilado, duracion, dias, grupo);
				biblioteca.add(d1);
			}
			buffRdisco.close();
		} catch (FileNotFoundException e) {// Error archivo no encontrado
			System.out.println("No se pudo abrir el archivo '" + rutatxtDisco + "'");
		} catch (IOException e) { // Error permisos
			System.out.println("Error leyendo el archivo '" + rutatxtDisco + "'");
		}
		try {// Volcar datos del txt peliculas al arraylist peliculas
			FileReader frpeliculas = new FileReader(rutatxtPelicula); // Leo peliculas.txt
			BufferedReader buffRPeli = new BufferedReader(frpeliculas); // Linea a linea
			String line;
			while ((line = buffRPeli.readLine()) != null) { // Guardo en arraylist peliculas
				peliculas.add(line);
			}
			// Volcar arraylist pelicula a biblioteca
			for (String i : peliculas) {// Separo los atributos
				String[] atr = i.split(",");
				String codigo = atr[0];
				String titulo = atr[1];
				int duracion = Integer.parseInt(atr[2]);
				String director = atr[3];
				String genero = atr[4];
				boolean alquilado;
				if (atr[5].equals("1")) {
					alquilado = true;
				} else {
					alquilado = false;
				}
				int dias = Integer.parseInt(atr[6]);
				Pelicula p1 = new Pelicula(codigo, titulo, alquilado, dias, duracion, director, genero);
				biblioteca.add(p1);
			}buffRPeli.close();
		} catch (FileNotFoundException e) {// Error archivo no encontrado
			System.out.println("No se pudo abrir el archivo '" + rutatxtPelicula + "'");
		} catch (IOException e) { // Error permisos
			System.out.println("Error leyendo el archivo '" + rutatxtPelicula + "'");
		}
	}

	public static void guardarInformacion() {

		try {// Codigo para guardar libros en fichero
			FileWriter fwLibros = new FileWriter(rutatxtLibro, false); // Hago que sobreescriba el fichero libros.txt
			FileWriter fwDisco = new FileWriter(rutatxtDisco, false); // Hago que sobreescriba el fichero libros.txt
			FileWriter fwPelicula = new FileWriter(rutatxtPelicula, false); // Hago que sobreescriba el fichero
																			// libros.txt
			BufferedWriter buffWLibros = new BufferedWriter(fwLibros);// Que escriba linea a linea
			BufferedWriter buffWPelicula = new BufferedWriter(fwPelicula);// Que escriba linea a linea
			BufferedWriter buffWDisco = new BufferedWriter(fwDisco);// Que escriba linea a linea
			// Hago un bucle para recorrer alquilable y escribir en el fichero
			for (interfazAlquilable i : biblioteca) {
				if (i != null) {
					if (i instanceof Libro) { // Solo quiero que escriba libros
						buffWLibros.write(((Producto) i).toStringFichero());// Llamo a tostringfichero de libro y lo
																			// escribo en el txt
						buffWLibros.newLine();// añado una nueva linea
					}
					if (i instanceof Pelicula) {
						buffWPelicula.write(((Producto) i).toStringFichero());// Llamo a tostringfichero de pelicula y
																				// lo escribo en el txt
						buffWPelicula.newLine();// añado una nueva linea
					}
					if (i instanceof DVDMusica) {
						buffWDisco.write(((Producto) i).toStringFichero());// Llamo a tostringfichero de dvdmusica y lo
																			// escribo en el txt
						buffWDisco.newLine();// añado una nueva linea
					}
				}
			}
			buffWLibros.close();
			buffWDisco.close();
			buffWPelicula.close();
		} catch (IOException e) {
			// Excepcion por falta de permisos
			e.printStackTrace();
		}
	}
}
