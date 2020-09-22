package view;

//Um banco deve controlar Saques e Dep�sitos.
//O sistema pode permitir um Saque e um Dep�sito Simult�neos, mas nunca 2 Saques ou 2 Dep�sitos Simult�neos.
//Para calcular a transa��o (Saque ou Dep�sito), o m�todo deve receber o c�digo da conta, o saldo da conta e o valor a
// ser transacionado.
//Deve-se montar um sistema que deve considerar que 20 transa��es simult�neas ser�o enviadas ao sistema
// (aleatoriamente essas transa��es podem ser qualquer uma das op��es) e tratar todas as transa��es, de acordo com as regras acima.

import controller.Transacoes;

import java.util.concurrent.Semaphore;

public class Banco {
    public static void main(String[] args) {
         Semaphore semaforoSaque = new Semaphore(1);
         Semaphore semaforoDeposito = new Semaphore(1);

            for (int i = 0; i < 20; i++){
                int conta = (int)(Math.random()*10);
                int saldo = 3000;
                int valor = (int)((Math.random() * 501) + 2);
                int tipoTransacao = (int)((Math.random() * 2) + 1);

                Transacoes transacoes = new Transacoes(tipoTransacao, valor, conta, semaforoSaque, semaforoDeposito, saldo);
                transacoes.start();
            }
    }
}
