package parte2;

import java.time.LocalTime;

import parte1.Producto;

public class PlazaAparcamiento extends Producto {

	private String codigo;
	private int numeroPlaza;
	private LocalTime horaPrestamo;
	private LocalTime horaDevolucion;

	public PlazaAparcamiento(String codigo, boolean alquilado, LocalTime horaPrestamo, LocalTime horaDevolucion, int numeroPlaza) throws Exception {
		super(codigo, codigo, alquilado);
		this.codigo = codigo;
		this.horaPrestamo = horaPrestamo;
		this.horaDevolucion = horaDevolucion;
		this.numeroPlaza = numeroPlaza;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) throws Exception {
		if (codigo.matches("^[A-Z]{2}[0-9]{2}")) {
			this.codigo = codigo;
		} else
			throw new Exception("Codigo erroneo"); // Suelta un error si el codigo es incorrecto
	}

	public int getNumeroPlaza() {
		return numeroPlaza;
	}

	public void setNumeroPlaza(int numeroPlaza) {
		this.numeroPlaza = numeroPlaza;
	}

	public boolean getAlquilado() {
		return alquilado;
	}

	public void setAlquilado(boolean alquilado) {
		this.alquilado = alquilado;
	}

	public LocalTime getHoraPrestamo() {
		return horaPrestamo;
	}

	public void setHoraPrestamo(LocalTime horaPrestamo) {
		this.horaPrestamo = horaPrestamo;
	}

	public LocalTime getHoraDevolucion() {
		return horaDevolucion;
	}

	public void setHoraDevolucion(LocalTime horaDevolucion) {
		this.horaDevolucion = horaDevolucion;
	}

	@Override
	public boolean alquilar() {// Metodo alquilar, actualiza alquilar a true y hora alquiler a ahora.
		setAlquilado(true);
		setHoraPrestamo(LocalTime.now());//Solo actualizo la hora de prestamo para no perder los datos de la ultima devolucion
		System.out.println("Alquiler realizado.");
		return false;
	}

	@Override
	public String toString() {
		if (getAlquilado()){//Si la plaza esta alquilada no quiero que se muestre la hora de devolucion ya que es falsa
		return "PlazaAparcamiento [codigo=" + codigo + ", numeroPlaza=" + numeroPlaza + ", alquilado=" + alquilado
				+ ", horaPrestamo=" + horaPrestamo + "]";
		}else{//Si no esta alquilada, no quiero que se muestre la hora de prestamo
			return "PlazaAparcamiento [codigo=" + codigo + ", numeroPlaza=" + numeroPlaza + ", alquilado=" + alquilado
				+ ", horaDevolucion=" + horaDevolucion + "]";
		}
	}

	@Override
	public void devolver() {
		// Metodo devolver, actualiza alquilado a false y hora devolucion a ahora
		setAlquilado(false);
		setHoraDevolucion(LocalTime.now());//Solo actualizo la hora de la devolucion para poder saber la ultima hora a la que se presto
		System.out.println("Devolucion completada.");
	}

	public String toStringFichero() {
		return getCodigo() + "," + getNumeroPlaza() + "," + Integer.toString(getAlquilado() ? 1 : 0) + ","
				+ getHoraDevolucion() + "," + getHoraPrestamo();
	}
}
