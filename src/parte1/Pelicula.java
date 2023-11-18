package parte1;

public class Pelicula extends DVD {
	String director;
	String genero;

	public Pelicula(String codigo, String titulo, boolean alquilado, int diasPrestamo, int duracion) throws Throwable {
		super(codigo, titulo, alquilado, diasPrestamo, duracion);
		// Constructor por defecto
	}

	public Pelicula(String codigo, String titulo, boolean alquilado, int diasPrestamo) throws Throwable {
		super(codigo, titulo, alquilado, diasPrestamo);
		// Constructor por defecto
	}

	public Pelicula(String codigo, String titulo, int duracion) throws Throwable {
		super(codigo, titulo, duracion);
		// Constructor por defecto
	}

	public Pelicula(String codigo, String titulo) throws Throwable {
		super(codigo, titulo);
		// Constructor por defecto
	}

	public Pelicula(String codigo, String titulo, boolean alquilado, int diasPrestamo, int duracion, String director,
			String genero) throws Throwable {
		super(codigo, titulo, alquilado, diasPrestamo, duracion);
		this.director = director;
		this.genero = genero;
		// Constructor con parametros
	}

	public Pelicula(String codigo, String titulo, String director, String genero) throws Throwable {
		super(codigo, titulo);
		this.director = director;
		this.genero = genero;
		// Constructor con parametros
	}

	public Pelicula(String codigo, String titulo, int duracion, String director, String genero) throws Throwable {
		super(codigo, titulo, duracion);
		this.director = director;
		this.genero = genero;
		// Constructor con parametros
	}

	public Pelicula(String codigo, String titulo, boolean alquilado, int diasPrestamo, String director, String genero)
			throws Throwable {
		super(codigo, titulo, alquilado, diasPrestamo);
		this.director = director;
		this.genero = genero;
		// Constructor con parametros
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "Pelicula [director=" + director + ", genero=" + genero + super.toString();
	}

	public boolean alquilar() {
		if (getAlquilado() == true) {
			return false;
		} else {
			setAlquilado(true);
			setDiasPrestamo(3);
			return true;
		}
	}

	@Override
	public String toStringFichero() {
		// TODO Auto-generated method stub
		return getCodigo() + "," + getTitulo() + "," + getDuracion() + "," + getDirector() + "," + getGenero() + ","
				+ Integer.toString(getAlquilado() ? 1 : 0) + "," + getDiasPrestamo();
	}
}
