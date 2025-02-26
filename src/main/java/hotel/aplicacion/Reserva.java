/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.aplicacion;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author María de los Ángeles
 */
public class Reserva {
    private static int contadorReservas = 0;
    private int codigoReserva;
    private Cliente cliente;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private TipoHabitacion tipoHabitacion;
    private boolean camaSupletoria;
    private double costeTotal;
    
    // Constantes fijas para el precio
    private static final double PRECIODOBLE = 50.0;
    private static final double PRECIOSUITE = 100.0;
    private static final double RECARGOCAMASUPLETORIA = 20.0;

       public Reserva(Cliente cliente, LocalDate fechaEntrada, LocalDate fechaSalida,
                   TipoHabitacion tipoHabitacion, boolean camaSupletoria) throws Exception {
        if (!fechaSalida.isAfter(fechaEntrada)) {
            throw new Exception("La fecha de salida debe ser posterior a la de entrada.");
        }
        this.codigoReserva = obtenerCodigoReserva();
        this.cliente = cliente;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.tipoHabitacion = tipoHabitacion;
        this.camaSupletoria = camaSupletoria;
        this.costeTotal = calcularCosteTotal();
    }

    
    private static int obtenerCodigoReserva() {
        contadorReservas++;
        return contadorReservas;
    }
/**
 * Calcula el coste total de la reserva en función de las fechas de entrada y salida, el tipo de habitación y si se requiere una cama supletoria.
 *
 * <p>El coste se calcula multiplicando el número de noches por el precio por noche, que varía según el tipo de habitación. Si se solicitan más de 7 noches, se aplica un descuento del 10% sobre el total. </p>
 * 
 * @return El coste total de la reserva en euros
 */
    
    public double calcularCosteTotal() {
        long noches = ChronoUnit.DAYS.between(fechaEntrada, fechaSalida);
        double precioNoche = (tipoHabitacion == TipoHabitacion.DOBLE) ? PRECIODOBLE : PRECIOSUITE;
        
        if (camaSupletoria) {
            precioNoche += RECARGOCAMASUPLETORIA;
        }
        double total = noches * precioNoche;
        if (noches > 7) {
            total *= 0.9; // Aplica un descuento del 10%
        }
        return total;
    }

    
    public String mostrarDetalles() {
        String detalles = "Código Reserva: " + codigoReserva + "\n" +
                          "Cliente: " + cliente.mostrarInformacion() + "\n" +
                          "Fecha de Entrada: " + fechaEntrada + "\n" +
                          "Fecha de Salida: " + fechaSalida + "\n" +
                          "Tipo de Habitación: " + tipoHabitacion + "\n" +
                          "Cama Supletoria: " + (camaSupletoria ? "Sí" : "No") + "\n" +
                          "Coste Total: " + costeTotal + "Euros";
        return detalles;
    }

    public int getCodigoReserva() {
        return codigoReserva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public boolean isCamaSupletoria() {
        return camaSupletoria;
    }

    public double getCosteTotal() {
        return costeTotal;
    }
    
    public void setFechaEntrada(LocalDate fechaEntrada) throws Exception {
        if (fechaSalida != null && !fechaSalida.isAfter(fechaEntrada)) {
            throw new Exception("La fecha de salida debe ser posterior a la de entrada.");
        }
        this.fechaEntrada = fechaEntrada;
        this.costeTotal = calcularCosteTotal();
    }

   
    public void setFechaSalida(LocalDate fechaSalida) throws Exception {
        if (fechaEntrada != null && !fechaSalida.isAfter(fechaEntrada)) {
            throw new Exception("La fecha de salida debe ser posterior a la de entrada.");
        }
        this.fechaSalida = fechaSalida;
        this.costeTotal = calcularCosteTotal();
    }
}