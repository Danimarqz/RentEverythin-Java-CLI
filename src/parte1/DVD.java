package parte1;

public class DVD extends Producto{
	int duracion;

	public DVD(String codigo, String titulo) throws Throwable {
		super(codigo, titulo);
		//Constructor por defecto
	}

	public DVD(String codigo, String titulo, boolean alquilado, int diasPrestamo) throws Throwable {
		super(codigo, titulo, alquilado, diasPrestamo);
		//Constructor por defecto
	}

	public DVD(String codigo, String titulo, boolean alquilado, int diasPrestamo, int duracion) throws Throwable {
		super(codigo, titulo, alquilado, diasPrestamo);
		this.duracion = duracion;
		//Constructor con  duracion
	}

	public DVD(String codigo, String titulo, int duracion) throws Throwable {
		super(codigo, titulo);
		this.duracion = duracion;
		//Constructor con duracion
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	@Override
	public String toString() {
		return "DVD [duracion=" + duracion +  super.toString();
	}

	@Override
	public String toStringFichero() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
