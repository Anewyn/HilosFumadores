package com.alejandro;

import java.util.Random;

public class Estanquero extends Thread{
    private Random random = new Random();
    private Estanco estanco;

    public Estanquero(Estanco estanco){
        this.estanco = estanco;
    }

    @Override
    public void run(){
        while (true){
            int ingrediente = random.nextInt(3);
            try {
                Thread.sleep(random.nextInt(300));
                estanco.ponerIngredientes(ingrediente);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
