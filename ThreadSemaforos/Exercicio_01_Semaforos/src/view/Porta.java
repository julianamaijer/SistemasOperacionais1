package view;

import controller.ThreadPessoa;

import java.util.concurrent.Semaphore;

public class Porta {
    public static void main(String[] args) {

        int permissao = 1;
        Semaphore semaforo = new Semaphore(permissao);

        for ( int idPessoa = 0; idPessoa < 4; idPessoa++){
            Thread tPessoa = new ThreadPessoa(idPessoa, semaforo);
            tPessoa.start();
        }
    }

}
