package parte2;

import java.time.LocalDate;

import parte1.Producto;

public class Vehiculo extends Producto {
	private String matricula;
	private String marca;
	private LocalDate fechaPrestamo;
	private LocalDate fechaDevolucion;

	public Vehiculo(String matricula, String marca, LocalDate fechaPrestamo, // He creado un constructor extra en
																				// producto para poder crear un vehícula
																				// ya que me estaba duplicando el
																				// boolean de alquilado
			LocalDate fechaDevolucion, boolean alquilado) throws Exception {
		super(matricula, marca, alquilado);
		setCodigo(matricula);
		this.marca = marca;
		this.fechaPrestamo = fechaPrestamo;
		this.fechaDevolucion = fechaDevolucion;
	}

	@Override
	public String toString() {
		if (getAlquilado()){//Si el vehículo está alquilado, no quiero que se muestre la fecha de devolución (ya que no es real)
			return "Vehiculo [matricula=" + matricula + ", marca=" + marca + ", alquilado=" + alquilado + ", fechaPrestamo="
				+ fechaPrestamo + "]";
	}else{//Si no está alquilado, no tiene fecha de prestamo, por tanto no quiero que se muestre
		return "Vehiculo [matricula=" + matricula + ", marca=" + marca + ", alquilado=" + alquilado + ", fechaDevolucion=" + fechaDevolucion + "]";
	}
	}

	public String getMatricula() {
		return matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public boolean getAlquilado() {
		return alquilado;
	}

	public void setAlquilado(Boolean alquilado) {
		this.alquilado = alquilado;
	}

	public LocalDate getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(LocalDate fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public LocalDate getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(LocalDate fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	@Override
	public boolean alquilar() {// Método alquilar, actualiza alquilado a true y fecha prestamo a hoy.
		if (getAlquilado())
		{
			System.out.println("Ya está alquilado");
			return false;
		} else {
			setAlquilado(true);
			setFechaPrestamo(LocalDate.now());
			System.out.println("Alquiler realizado");
			return true;
		}
	}

	@Override
	public void setCodigo(String matricula) throws Exception {
		if (matricula.matches("^[0-9]{4}[A-Z]{3}")) {
			this.matricula = matricula;
		} else
			throw new Exception("Código erróneo"); // Suelta un error si el código es incorrecto
	}

	@Override//Override de Producto ya que el constructor requiere un código, le doy la matricula
	public String getCodigo() {
		return getMatricula();
	}

	@Override
	public void devolver() {
		setAlquilado(false);
		setFechaDevolucion(LocalDate.now());
		System.out.println("Devolución realizada.");
	}

	public String toStringFichero() {
		return getMatricula() + "," + getMarca() + "," + Integer.toString(getAlquilado() ? 1 : 0) + ","
				+ getFechaDevolucion() + "," + getFechaPrestamo();
	}
}
