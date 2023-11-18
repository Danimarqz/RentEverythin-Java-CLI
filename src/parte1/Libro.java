package parte1;

public class Libro extends Producto{
	String autor;
	int numPaginas;
	
	public Libro(String codigo, String titulo, boolean alquilado, int diasPrestamo) throws Throwable {
		super(codigo, titulo, alquilado, diasPrestamo);
		//Por defecto
	}

	public Libro(String codigo, String titulo) throws Throwable {
		super(codigo, titulo);
		//Por defecto
	}

	public Libro (String codigo, String titulo, boolean alquilado, int diasPrestamo, String autor, int numPaginas) throws Throwable {
		super(codigo, titulo, alquilado, diasPrestamo);
		this.autor = autor;
		this.numPaginas = numPaginas;
		//Constructor completo
	}
	
	public Libro(String codigo, String titulo, String autor, int numPaginas) throws Throwable {
		super(codigo, titulo);
		this.autor = autor;
		this.numPaginas = numPaginas;
		//Constructor completo
	}

	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getNumPaginas() {
		return numPaginas;
	}
	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}
	@Override
	public String toString() {
		return "Libro [autor=" + autor + ", numPaginas=" + numPaginas + super.toString();
	}
	public boolean alquilar() {
		if (getAlquilado()==true) {
			System.out.println("Ya esta alquilado");
			return false;
		}else {
			setAlquilado(true);
			setDiasPrestamo(10);
			System.out.println("Lo has alquilado durante 10 dias.");
			return true;
		}
	}
	@Override
	public String toStringFichero() {
		//Tostring para el fichero que guarda codigo, titulo, autor, paginas, y sie sta alquilado o no
		return getCodigo() + "," + getTitulo() + "," + getAutor() + "," + getNumPaginas() + "," + Integer.toString(getAlquilado() ? 1 : 0) + "," + getDiasPrestamo();
	}
}
