package com.alejandro;

public class Estanco {
    private boolean fumando = false, ingredientePuesto = false;
    private int ingrediente;

    public synchronized void ponerIngredientes(int ingrediente) throws InterruptedException {
        while (fumando || ingredientePuesto) {
            wait();
        }
        this.ingrediente = ingrediente;
        ingredientePuesto = true;
        System.out.println("El estanquero no pone el ingrediente: " + ingrediente);
        notifyAll();
    }

    public synchronized void empezarFumar(int id) throws InterruptedException {
        while (fumando || !ingredientePuesto || ingrediente != id) {
            wait();
        }
        System.out.println("Fumador "+id+" empieza a fumar.");
        ingredientePuesto = false;
        fumando=true;
    }

    public synchronized void terminarFumar(int id) {
        fumando = false;
        System.out.println("Fumador "+id+" termina de fumar.");
        notifyAll();
    }

}
