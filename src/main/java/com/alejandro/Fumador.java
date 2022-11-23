package com.alejandro;

import java.util.Random;

public class Fumador extends Thread{
    private int id;
    private Estanco estanco;
    private Random random = new Random();

    public Fumador(int id, Estanco estanco) {
        this.id = id;
        this.estanco = estanco;
    }

    @Override
    public void run() {
        while (true){
            try {
                estanco.empezarFumar(id);
                //fumador fuma
                Thread.sleep(random.nextInt(500));
                estanco.terminarFumar(id);
                //fumador termina de fumar
                Thread.sleep(random.nextInt(700));
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
