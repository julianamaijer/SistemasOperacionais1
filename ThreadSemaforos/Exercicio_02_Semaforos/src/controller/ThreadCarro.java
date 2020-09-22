package controller;

//Fazer uma aplica��o que gerencie a figura abaixo:
//Para tal, usar uma vari�vel sentido,
//que ser� alterado pela Thread que
//controla cada carro com a
//movimenta��o do carro. Quando a
//Thread tiver a possibilidade de ser
//executada, ela deve imprimir em
//console o sentido que o carro est�
//passando. S� pode passar um carro
//por vez no cruzamento.

import java.util.concurrent.Semaphore;

public class ThreadCarro extends Thread{

    private int idCarro;
    private Semaphore semaforo;
    private String sentido;

    public ThreadCarro(int idCarro, Semaphore semaforo, String sentido){
        this.idCarro = idCarro;
        this.semaforo = semaforo;
        this.sentido = sentido;
    }

    @Override
    public void run() {
        carroAndando();
        try {
            semaforo.acquire();
            carroCruzando();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaforo.release();
            carroCruzou();
        }
    }

    private void carroAndando() {
        int distanciaTotal = (int)((Math.random()*1501) + 1000);
        int distanciaPercorrida = 0;
        int descolamento = 100;
        int tempo = 1000;
        while (distanciaPercorrida < distanciaTotal){
            distanciaPercorrida += descolamento;
            try {
                sleep(tempo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("#"+ idCarro + " no sentido " + sentido + " j� andou " + distanciaPercorrida + "m. ");
        }
        System.out.println("#"+idCarro+ " no sentido " + sentido + " chegou no cruzamento. ");
    }

    //sess�o cr�tica:
    private void carroCruzando() {
        System.out.println("#"+idCarro+ " no sentido " + sentido + " est� cruzando o cruzamento.");
        int tempo = (int)((Math.random() * 2001) + 1000);
        try {
            sleep(tempo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void carroCruzou() {
        System.out.println("#"+idCarro+ " no sentido " + sentido + " cruzou o cruzamento.");
    }

}
