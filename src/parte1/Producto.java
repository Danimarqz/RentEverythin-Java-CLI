package parte1;

public abstract class Producto implements interfazAlquilable{
	protected String codigo;
	private String titulo;
	protected boolean alquilado;
	private int diasPrestamo;
	
	public Producto(String codigo, String titulo, boolean alquilado, int diasPrestamo) throws Exception {
		super();
		setCodigo(codigo);
		this.titulo = titulo;
		this.alquilado = alquilado;
		this.diasPrestamo = diasPrestamo;
	}
	public Producto (String codigo, String titulo) throws Exception {
		//Constructor que recibe codigo y titulo
		setCodigo(codigo);
		this.titulo = titulo;	
	}
	public Producto (String codigo, String titulo, boolean alquilado) throws Exception {
		//Constructor que recibe codigo y titulo
		setCodigo(codigo);
		this.titulo = titulo;
		this.alquilado = alquilado;
	}
	
	public String getCodigo() {
		
			return codigo;		
	}
	public void setCodigo(String codigo) throws Exception {
		if (codigo.matches("^[A-Z]{2}[0-9]{2}")){
			this.codigo = codigo;
		}else throw new Exception("Codigo erroneo"); //Suelta un error si el codigo es incorrecto
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public boolean getAlquilado() {
		return alquilado;
	}
	public void setAlquilado(boolean alquilado) {
		this.alquilado = alquilado;
	}
	public int getDiasPrestamo() {
		return diasPrestamo;
	}
	public void setDiasPrestamo(int diasPrestamo) {
		this.diasPrestamo = diasPrestamo;
	}
	@Override
	public String toString() {
		return " Producto [codigo=" + codigo + ", titulo=" + titulo + ", alquilado=" + alquilado + ", diasPrestamo="
				+ diasPrestamo + "]";
	}
	public boolean alquilar() {
		// TODO Auto-generated method stub
		return false;
	}
	public void devolver() {
		//Metodo devolver, actualiza alquilado a false y dias prestamo a 0
		setAlquilado(false);
		setDiasPrestamo(0);	
		System.out.println("Devolucion completada.");
	}
	public abstract String toStringFichero ();
	}

