package view;

import controller.ThreadCarro;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {

        int permissao = 1;
        String sentido;
        Semaphore semaforo = new Semaphore(permissao);

        for (int idCarro = 0; idCarro < 4; idCarro++){
            if (idCarro == 0 ){
                sentido = "Norte-Sul";
            }else{
                if (idCarro == 1){
                    sentido = "Sul-Norte";
                }else{
                    if (idCarro == 2){
                        sentido = "Leste-Oeste";
                    }else {
                        sentido = "Oeste-Leste";
                    }
                }
            }
            Thread tCarro = new ThreadCarro(idCarro, semaforo,sentido);
            tCarro.start();
        }


    }
}
