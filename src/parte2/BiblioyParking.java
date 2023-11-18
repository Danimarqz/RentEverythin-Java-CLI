package parte2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import parte1.DVDMusica;
import parte1.Libro;
import parte1.Pelicula;
import parte1.Producto;

public class BiblioyParking {
	static ArrayList<Producto> biblioteca = new ArrayList<Producto>();
	static String rutaUsuario = System.getProperty("user.dir"); // Guardo la ruta en la que esta ubicado el programa
	static String rutatxtLibro = rutaUsuario + "\\src\\datos\\Libros.txt"; // Guardo la ruta del txt de libros
	static String rutatxtDisco = rutaUsuario + "\\src\\datos\\Discos.txt"; // Guardo la ruta del txt de discos
	static String rutatxtPelicula = rutaUsuario + "\\src\\datos\\Peliculas.txt"; // Guardo la ruta del txt de peliculas
	static String rutatxtVehiculo = rutaUsuario + "\\src\\datos\\Vehiculos.txt"; // ruta vehiculos
	static String rutatxtPlazas = rutaUsuario + "\\src\\datos\\Plazas.txt"; // ruta plazas

	public static void main(String[] args) throws Throwable {
		gestionArchivos();
		int opcion;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Seleccione una opcion:");
			System.out.println("1. Alquilar un libro");
			System.out.println("2. Alquilar una Pelicula");
			System.out.println("3. Alquilar un DVD de música");
			System.out.println("4. Devolver un producto");
			System.out.println("5. Ver todos los productos disponibles");
			System.out.println("6. Alquilar un Vehiculo");
			System.out.println("7. Devolver un vehiculo");
			System.out.println("8. Alquilar una plaza de aparcamiento");
			System.out.println("9. Guardar Informacion en Ficheros");
			System.out.println("10. Salir");
			opcion = sc.nextInt();
			switch (opcion) {
			case 1://Alquilar un libro
				System.out.println("Introduce el codigo del libro");
				String codigoLibro = sc.next();
				boolean errorCodigoL = false;
				for (Producto i : biblioteca) { // busco en el arraylist biblioteca si existe ese codigo y si
															// es un
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
			case 2://Alquilar una pelicula
				System.out.println("Introduce el codigo de la pelicula");
				String codigoPelicula = sc.next();
				boolean errorCodigoP = false;
				for (Producto i : biblioteca) { // Busco el codigo de la pelicula y compruebo si es una
															// pelicula
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
			case 3://Alquilar un DVD de música
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
			case 4://Devolver un producto
				System.out.println("Introduce el codigo o matricula del producto");
				String codigoDevolucion = sc.next();
				boolean errorDevolucion = false;
				for (Producto i : biblioteca) { // Busco el codigo del producto
					if (i.getCodigo().equals(codigoDevolucion)) {
						i.devolver(); // Los devuelvo
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
			case 5://Imprimir todos los productos
				for (Producto i : biblioteca) {
					if (i.getAlquilado() == false) {
						System.out.println(i.toString());
					}
				}
				break;
			case 6://Alquilar un vehiculo
				System.out.println("Introduce la matriculo del vehiculo");
				String matriculaV = sc.next();
				boolean errorMatriculaV = false;
				for (Producto i : biblioteca) {
					if (i.getCodigo().equals(matriculaV) && i instanceof Vehiculo) {
						i.alquilar();
						i.getAlquilado();
						i.toString();
						errorMatriculaV = false;
						break;
					} else {
						errorMatriculaV = true;
					}
				}
					if (errorMatriculaV) {
						System.out.println("Error en la matricula");
					
				}
				break;
			case 7://Devolver vehiculo
				System.out.println("Introduce la matricula del vehiculo");
				String codigoDevolucionV = sc.next();
				boolean errorDevolucionV = false;
				for (Producto i : biblioteca) { // Busco el codigo del producto
					if (i.getCodigo().equals(codigoDevolucionV)) {
						i.devolver(); // Loe devuelvo
						errorDevolucionV = false;
						break;
					} else {
						errorDevolucionV = true;
					}
				}
				if (errorDevolucionV) { // Envio el mensaje si el codigo es erroneo
					System.out.println("Error en la matricula");
				}
				break;

			case 8://Alquilar una plaza
				System.out.println("Introduce el codigo de la plaza");
				String codigoPlaza = sc.next();
				boolean errorPlaza = false;
				for (Producto i : biblioteca) {
					if (i.getCodigo().equals(codigoPlaza)) {
						i.alquilar();
						errorPlaza = false;
						break;
					} else {
						errorPlaza = true;
					}
					
					}if (errorPlaza) {
						System.out.println("Error el codigo");
				}
				break;
			case 9://Guardar los datos
				guardarInformacion();
				break;
			case 10://Salir
				System.out.println("Gracias por usar nuestro servicio!");
				break;
			default:
				System.out.println("Opcion invalida. Por favor, seleccione una opcion valida.");
			}
		} while (opcion != 10);
		sc.close();
	}

	public static void guardarInformacion() {

		try {// Codigo para guardar libros en fichero
			FileWriter fwLibros = new FileWriter(rutatxtLibro, false); // Hago que sobreescriba el fichero libros.txt
			FileWriter fwDisco = new FileWriter(rutatxtDisco, false); // Hago que sobreescriba el fichero libros.txt
			FileWriter fwPelicula = new FileWriter(rutatxtPelicula, false); // Hago que sobreescriba el fichero
																			// libros.txt
			FileWriter fwVehiculos = new FileWriter(rutatxtVehiculo, false);
			FileWriter fwPlazas = new FileWriter(rutatxtPlazas, false);
			BufferedWriter buffWLibros = new BufferedWriter(fwLibros);// Que escriba linea a linea
			BufferedWriter buffWPelicula = new BufferedWriter(fwPelicula);// Que escriba linea a linea
			BufferedWriter buffWDisco = new BufferedWriter(fwDisco);// Que escriba linea a linea
			BufferedWriter buffWVehiculo = new BufferedWriter(fwVehiculos);
			BufferedWriter buffWPlaza = new BufferedWriter(fwPlazas);
			// Hago un bucle para recorrer alquilable y escribir en el fichero
			for (Producto i : biblioteca) {
				if (i != null) {
					if (i instanceof Libro) { // Solo quiero que escriba libros
						buffWLibros.write(i.toStringFichero());// Llamo a tostringfichero de libro y lo
																			// escribo en el txt
						buffWLibros.newLine();// añado una nueva linea
					}
					if (i instanceof Pelicula) {
						buffWPelicula.write(i.toStringFichero());// Llamo a tostringfichero de pelicula y
																				// lo escribo en el txt
						buffWPelicula.newLine();// añado una nueva linea
					}
					if (i instanceof DVDMusica) {
						buffWDisco.write(i.toStringFichero());// Llamo a tostringfichero de dvdmusica y lo
																			// escribo en el txt
						buffWDisco.newLine();// añado una nueva linea
					}
					if (i instanceof Vehiculo) {
						buffWVehiculo.write(i.toStringFichero());
						buffWVehiculo.newLine();
					}
					if (i instanceof PlazaAparcamiento) {
						buffWPlaza.write(i.toStringFichero());
						buffWPlaza.newLine();
					}
				}
			}
			buffWLibros.close();
			buffWDisco.close();
			buffWPelicula.close();
			buffWPlaza.close();
			buffWVehiculo.close();
		} catch (IOException e) {
			// Excepcion por falta de permisos
			e.printStackTrace();
		}
	}

	public static void gestionArchivos() throws Throwable {
		ArrayList<String> libro = new ArrayList<String>(); // Creo un arraylist de libros
		ArrayList<String> discos = new ArrayList<String>(); // de discos
		ArrayList<String> peliculas = new ArrayList<String>(); // de peliculas
		ArrayList<String> vehiculos = new ArrayList<String>();
		ArrayList<String> plaza = new ArrayList<String>();
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
			}
			buffRPeli.close();
		} catch (FileNotFoundException e) {// Error archivo no encontrado
			System.out.println("No se pudo abrir el archivo '" + rutatxtPelicula + "'");
		} catch (IOException e) { // Error permisos
			System.out.println("Error leyendo el archivo '" + rutatxtPelicula + "'");
		}

		try {// Volcar datos del txt vehiculos al arraylist vehiculos
			FileReader frvehiculos = new FileReader(rutatxtVehiculo); // Leo peliculas.txt
			BufferedReader buffRVehi = new BufferedReader(frvehiculos); // Linea a linea
			String line;
			while ((line = buffRVehi.readLine()) != null) { // Guardo en arraylist peliculas
				vehiculos.add(line);
			}
			// Volcar arraylist vehiculos a biblioteca
			for (String i : vehiculos) {// Separo los atributos
				String[] atr = i.split(",");
				String matricula = atr[0];
				String marca = atr[1];
				LocalDate fechaDev = LocalDate.parse(atr[3]);
				LocalDate fechaPres = LocalDate.parse(atr[4]);
				boolean alquilado;
				if (atr[2].equals("1")) {
					alquilado = true;
				} else {
					alquilado = false;
				}
				Vehiculo v1 = new Vehiculo(matricula, marca, fechaDev, fechaPres, alquilado);
				biblioteca.add(v1);
			}
			buffRVehi.close();
		} catch (FileNotFoundException e) {// Error archivo no encontrado
			System.out.println("No se pudo abrir el archivo '" + rutatxtVehiculo + "'");
		} catch (IOException e) { // Error permisos
			System.out.println("Error leyendo el archivo '" + rutatxtVehiculo + "'");
		}
		try {// Volcar datos del txt plazas al arraylist plazas
			FileReader frplaza = new FileReader(rutatxtPlazas); // Leo plazas.txt
			BufferedReader buffRPlaza = new BufferedReader(frplaza); // Linea a linea
			String line;
			while ((line = buffRPlaza.readLine()) != null) { // Guardo en arraylist peliculas
				plaza.add(line);
			}
			// Volcar arraylist pelicula a biblioteca
			for (String i : plaza) {// Separo los atributos
				String[] atr = i.split(",");
				String codigo = atr[0];
				int numPlaza = Integer.parseInt(atr[1]);
				LocalTime devolucion = LocalTime.parse(atr[3]);
				LocalTime prestamo = LocalTime.parse(atr[4]);
				boolean alquilado;
				if (atr[2].equals("1")) {
					alquilado = true;
				} else {
					alquilado = false;
				}
				PlazaAparcamiento pl1 = new PlazaAparcamiento(codigo, alquilado, prestamo, devolucion, numPlaza);
				biblioteca.add(pl1);
			}
			buffRPlaza.close();
		} catch (FileNotFoundException e) {// Error archivo no encontrado
			System.out.println("No se pudo abrir el archivo '" + rutatxtPelicula + "'");
		} catch (IOException e) { // Error permisos
			System.out.println("Error leyendo el archivo '" + rutatxtPelicula + "'");
		}
	}
}
