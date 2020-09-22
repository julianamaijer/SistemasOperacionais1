package controller;

import java.util.concurrent.Semaphore;

public class ThreadCarro extends Thread {

    private int idCarro;
    private int idEquipe;
    private Semaphore semaforo;

    public ThreadCarro(int idCarro, int idEquipe, Semaphore semaforo){
        this.idCarro = idCarro;
        this.idEquipe = idEquipe;
        this.semaforo = semaforo;
    }

    @Override
    public void run() {
        try {
            semaforo.acquire();
            carroCorrida();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            carroSaindo();
            semaforo.release();
        }
    }

    private int carroCorrida(){
        System.out.println("O carro " + idCarro + " da equipe " + idEquipe + " entrou na pista.");
        int tempoMenor = 0;
        int quantidadeVoltas = 1;
        while (quantidadeVoltas <= 3){
            int tempoTotal = volta();
            if (quantidadeVoltas == 1){
                tempoMenor = tempoTotal;
            }else {
                if (tempoMenor > tempoTotal){
                    tempoMenor = tempoTotal;
                }
            }
            System.out.println("O carro " + idCarro + " da equipe " + idEquipe + " deu a " + quantidadeVoltas + "ª volta em " + tempoTotal + " segundos.");
            quantidadeVoltas += 1;
        }
        return tempoMenor;
    }

    private int volta(){
        int distaciaTotal = 1000;
        int distanciaPercorrida = 0;
        int deslocamento = (int)((Math.random()*11) + 50);
        int tempo = 1000;
        int tempoTotal = 0;
        while (distanciaPercorrida < distaciaTotal){
            distanciaPercorrida += deslocamento;
            try {
                sleep(tempo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //System.out.println("O carro " + idCarro + " da equipe " + idEquipe + " percorreu " + distanciaPercorrida + "m.");
            tempoTotal += tempo;
        }
        return tempoTotal;
    }

    private void carroSaindo() {
        System.out.println("O carro " + idCarro + " da equipe " + idEquipe + " saiu da pista.");
    }

}
