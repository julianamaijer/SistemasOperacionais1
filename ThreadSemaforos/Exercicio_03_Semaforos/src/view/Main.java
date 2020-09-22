package view;

//Você foi contratado para automatizar um treino de Fórmula 1.
// As regras estabelecidas pela direção da provas são simples:
//“No máximo 5 carros das 7 escuderias (14 carros no total) presentes podem entrar na
// pista simultaneamente, mas apenas um carro de cada equipe. O segundo carro deve
// ficar à espera, caso um companheiro de equipe já esteja na pista. Cada piloto
// deve dar 3 voltas na pista. O tempo de cada volta deverá ser exibido e a volta
// mais rápida de cada piloto deve ser armazenada para, ao final, exibir o grid de
// largada, ordenado do menor tempo para o maior.”

import controller.ThreadCarro;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        int permissoesPista = 5;
        Semaphore semaforo = new Semaphore(permissoesPista);

        for (int idCarro = 1; idCarro <= 2; idCarro++){
            for (int idEquipe = 1; idEquipe <= 7; idEquipe++){
                ThreadCarro tEquipe = new ThreadCarro(idCarro, idEquipe, semaforo);
                tEquipe.start();
            }
        }


    }
}
