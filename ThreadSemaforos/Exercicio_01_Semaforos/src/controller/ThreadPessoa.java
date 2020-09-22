package controller;

//4 pessoas caminham, cada uma em um corredor diferente.
//Os 4 corredores terminam em uma única porta. Apenas 1 pessoa pode cruzar a
//porta, por vez. Considere que cada corredor tem 200m. e cada pessoa
//anda de 4 a 6 m/s. Cada pessoa leva de 1 a 2 segundos para abrir e
//cruzar a porta. Faça uma aplicação em java que simule essa situação.

import java.util.concurrent.Semaphore;

public class ThreadPessoa extends Thread{

  private int idPessoa;
  private static int posChegada;
  private static int posSaida;
  private Semaphore semaforo;

  public ThreadPessoa(int idPessoa, Semaphore semaforo){
      this.idPessoa = idPessoa;
      this.semaforo = semaforo;
  }

  @Override
  public void run() {
      pessoaAndando();
      try {
          semaforo.acquire();
          pessoaCruzandoPorta();
      } catch (InterruptedException e) {
          e.printStackTrace();
      }finally {
          semaforo.release();
          pessoaSaiu();
      }
  }

  private void pessoaAndando(){
      int distanciaTotal = 200;
      int distanciaPercorrida = 0;
      int descolamento = (int)((Math.random()*3) + 4);
      int tempo = 1000;
      while (distanciaPercorrida < distanciaTotal){
          distanciaPercorrida += descolamento;
          try {
              sleep(tempo);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
          System.out.println("Pessoa "+ idPessoa + " já andou " + distanciaPercorrida + "m. ");
      }
      posChegada++;
      System.out.println("Pessoa " + idPessoa + " foi o " + posChegada + "° a chegar. ");
  }

  private void pessoaCruzandoPorta(){
      System.out.println("Pessoa "+idPessoa+" está cruzando a porta");
      int tempo = (int)((Math.random() * 1001) + 1000);
      try {
          sleep(tempo);
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
  }

  private void pessoaSaiu(){
      posSaida++;
      System.out.println("Pessoa "+idPessoa+" foi o "+posSaida+"º a sair");
  }


}
