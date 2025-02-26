/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.aplicacion;

/**
 * Clase que representa un cliente en el sistema de gestión de un hotel.
 *Cada cliente tiene un código único, nombre, DNI y número de teléfono. 
 *
 * @author María de los Ángeles
 */
public class Cliente {
    private static int contadorClientes = 0; //Contador estático para generar código
    private int codigo;	//Código único del cliente
    private String nombre;	//Nombre del cliente
    private String dni;		// DNI del cliente
    private String telefono;	// Número de teléfono del cliente
   
 /**
  * Constructor de la clase Cliente
  * 
  * @param nombre Nombre del cliente
  * @param dni	DNI del cliente
  * @param telefono	número de teléfono del cliente
  * @throws Exception Si el DNI no es válido.
  */

    
    public Cliente(String nombre, String dni, String telefono) throws Exception {
        // Validación del DNI, si no es correcto no creará el objeto
        Utilidades.validarDNI(dni); 
        this.setNombre(nombre);
        this.setDni(dni);
        this.setTelefono(telefono);
        this.setCodigo(obtenerNumeroCliente());
    }
    /**
     * Obtiene el siguiente número de cliente incrermentado el contador.
     * 
     * @return El siguiente numero del cliente
     */

        private static int obtenerNumeroCliente() {
        setContadorClientes(getContadorClientes() + 1);
        return getContadorClientes();
    }
 
    /**
     * Muestra la información del cliente en formato de cadena
     * 
     * @return Una cadena con el código, nombre, DNI y teléfono del cliente. 
     */
    
    public String mostrarInformacion() {
        return "Código: " + getCodigo() + ", Nombre: " + getNombre() + ", DNI: " + getDni() + ", Teléfono: " + getTelefono();
    }

    // Métodos de getter y setter (no se documentan según la solicitud)
	private String getTelefono() {
		return telefono;
	}

	private void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	private String getDni() {
		return dni;
	}

	private void setDni(String dni) {
		this.dni = dni;
	}

	private String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private int getCodigo() {
		return codigo;
	}

	private void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	private static int getContadorClientes() {
		return contadorClientes;
	}

	private static void setContadorClientes(int contadorClientes) {
		Cliente.contadorClientes = contadorClientes;
	}
}
