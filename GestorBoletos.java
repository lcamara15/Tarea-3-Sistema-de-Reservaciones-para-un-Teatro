//Sistema de Reservaciones para un Teatro

import java.util.LinkedList;
import java.util.Queue;

//Representa una reserva con el nombre del cliente y el número de asiento
class Reserva {
    private String cliente;
    private int asiento;

    public Reserva(String cliente, int asiento) {
        this.cliente = cliente;
        this.asiento = asiento;
    }

    public String getCliente() { return cliente; }
    public int getAsiento() { return asiento; }

    @Override
    public String toString() {
        return "Reserva: " + cliente + " - Asiento " + asiento;
    }
}

//Administra las reservas de boletos utilizando una Cola
class AdministradorReservas {
    private Queue<Reserva> listaReservas;

    public AdministradorReservas() {
        listaReservas = new LinkedList<>();
    }

    //Registra una nueva reserva en orden de llegada
    public void agregarReserva(String cliente, int asiento) {
        listaReservas.add(new Reserva(cliente, asiento));
        System.out.println("Reserva registrada: " + cliente + " - Asiento " + asiento);
    }
    
    //Cancela la primera reserva en la cola
    public void cancelarPrimeraReserva() {
        if (!listaReservas.isEmpty()) {
            Reserva cancelada = listaReservas.poll();
            System.out.println("Reserva cancelada: " + cancelada);
            System.out.println();
        } else {
            System.out.println("No hay reservas para cancelar.");
        }
    }

    //Verifica si un asiento en particular está reservado o no
    public boolean verificarAsientoReservado(int asiento) {
        for (Reserva r : listaReservas) {
            if (r.getAsiento() == asiento) {
                return true;
            }
        }
        return false;
    }

    //Buscar una reserva por el nombre del cliente
    public void buscarReservaPorCliente(String cliente) {
        for (Reserva r : listaReservas) {
            if (r.getCliente().equalsIgnoreCase(cliente)) {
                System.out.println("El cliente " + cliente + " tiene la reserva en el asiento " + r.getAsiento());
                return;
            }
        }
        System.out.println("No se encontró ninguna reserva a nombre de " + cliente);
    }

    //Muestra la lista de reservas en orden de llegada
    public void mostrarReservas() {
        if (listaReservas.isEmpty()) {
            System.out.println("No hay reservas registradas.");
        } else {
            System.out.println("Lista de reservas:");
            for (Reserva r : listaReservas) {
                System.out.println(r);
            }
        }
    }
}

//Prueba todas las funcionalidades del administrador de reservas
public class GestorBoletos {
    public static void main(String[] args) {
        AdministradorReservas teatro = new AdministradorReservas();

        //Registrar reservas
        teatro.agregarReserva("Carmen Hernández", 8);
        teatro.agregarReserva("Julio López", 21);
        teatro.agregarReserva("Andrea Ramos", 2);

        System.out.println();

        //Mostrar reservas
        teatro.mostrarReservas();

        //Verificar si un asiento está reservado
        int asientoConsultado = 15;
        System.out.println("¿El asiento " + asientoConsultado + " está reservado? " + 
            (teatro.verificarAsientoReservado(asientoConsultado) ? "Sí, está ocupado." : "No, está libre."));
        
        System.out.println();

        //Buscar reserva por cliente
        teatro.buscarReservaPorCliente("Carmen Hernández");

        //Cancelar una reserva
        teatro.cancelarPrimeraReserva();
        teatro.mostrarReservas();
    }
}



