package parte1;

public class DVDMusica extends DVD{
	String grupo;
	public DVDMusica(String codigo, String titulo, boolean alquilado, int diasPrestamo, int duracion) throws Throwable {
		super(codigo, titulo, alquilado, diasPrestamo, duracion);
		//Constructor por defecto
	}
	public DVDMusica(String codigo, String titulo, boolean alquilado, int diasPrestamo) throws Throwable {
		super(codigo, titulo, alquilado, diasPrestamo);
		//Constructor por defecto
	}
	public DVDMusica(String codigo, String titulo, int duracion) throws Throwable {
		super(codigo, titulo, duracion);
		//Constructor por defecto
	}
	public DVDMusica(String codigo, String titulo) throws Throwable {
		super(codigo, titulo);
		//Constructor por defecto
	}
	public DVDMusica(String codigo, String titulo, boolean alquilado, int diasPrestamo, int duracion, String grupo) throws Throwable {
		super(codigo, titulo, alquilado, diasPrestamo, duracion);
		this.grupo = grupo;
		//Constructor con parametros
	}
	public DVDMusica(String codigo, String titulo, boolean alquilado, int diasPrestamo, String grupo) throws Throwable {
		super(codigo, titulo, alquilado, diasPrestamo);
		this.grupo = grupo;
		//Constructor con parametros
	}
	public DVDMusica(String codigo, String titulo, int duracion, String grupo) throws Throwable {
		super(codigo, titulo, duracion);
		this.grupo = grupo;
		//Constructor con parametros
	}
	public DVDMusica(String codigo, String titulo, String grupo) throws Throwable {
		super(codigo, titulo);
		this.grupo = grupo;
		//Constructor con parametros
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	@Override
	public String toString() {
		return "DVDMusica [grupo=" + grupo + ", duracion=" + super.toString();
	}
	public boolean alquilar() {
		if (getAlquilado()==true) {
			return false;
		}else {
			setAlquilado(true);
			setDiasPrestamo(5);
			return true;
	}
	}
	@Override
	public String toStringFichero() {
		//Stringn para guardar en el fichero que guarde el codigo, titulo, duracion, grupo y si esta alquilado (1) o no (0)
		return getCodigo() + "," + getTitulo() + "," + getDuracion() +"," + getGrupo() + "," + Integer.toString(getAlquilado() ? 1 : 0) + "," + getDiasPrestamo();
	}
}
