package view;

//Voc� foi contratado para automatizar um treino de F�rmula 1.
// As regras estabelecidas pela dire��o da provas s�o simples:
//�No m�ximo 5 carros das 7 escuderias (14 carros no total) presentes podem entrar na
// pista simultaneamente, mas apenas um carro de cada equipe. O segundo carro deve
// ficar � espera, caso um companheiro de equipe j� esteja na pista. Cada piloto
// deve dar 3 voltas na pista. O tempo de cada volta dever� ser exibido e a volta
// mais r�pida de cada piloto deve ser armazenada para, ao final, exibir o grid de
// largada, ordenado do menor tempo para o maior.�

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
