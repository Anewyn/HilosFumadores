package com.alejandro;

public class Main {
    public static void main(String[] args) {
        Estanco estanco = new Estanco();
        Estanquero estanquero = new Estanquero(estanco);

        Fumador fumador1 = new Fumador(0, estanco);
        Fumador fumador2 = new Fumador(1, estanco);
        Fumador fumador3 = new Fumador(2, estanco);

        estanquero.start();
        fumador1.start();
        fumador2.start();
        fumador3.start();
    }
}
