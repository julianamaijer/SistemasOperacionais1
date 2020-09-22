package controller;

import java.util.concurrent.Semaphore;

public class Transacoes extends Thread {

    private int tipoTransacao;
    private int valor;
    private int codigoConta;
    private int saldo;
    public Semaphore semaforoSaque;
    public Semaphore semaforoDeposito;

    public Transacoes(int tipoTransacao, int valor, int codigoConta, Semaphore semaforoSaque, Semaphore semaforoDeposito, int saldo ){
        this.tipoTransacao = tipoTransacao;
        this.valor = valor;
        this.codigoConta = codigoConta;
        this.semaforoSaque = semaforoSaque;
        this.semaforoDeposito = semaforoDeposito;
        this.saldo = saldo;
    }

    @Override
    public void run() {
        if(tipoTransacao == 1){
            try {
                semaforoSaque.acquire();
                saque();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaforoSaque.release();
            }
        }else {
            if (tipoTransacao == 2){
                try {
                    semaforoDeposito.acquire();
                    deposito();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaforoDeposito.release();
                }
            }
        }
    }

    public void saque(){
        System.out.println("Início do saque na conta " + codigoConta);
        if(saldo < valor){
            System.out.println("Saldo insuficiente!");
        }else {
            saldo = saldo - valor;
            System.out.println("O valor de R$" + valor + " foi sacado com sucesso da conta " + codigoConta);
        }
        System.out.println("Fim do saque na conta " + codigoConta);
    }

    public void deposito(){
        System.out.println("Início do depósito na conta " + codigoConta);
        saldo = saldo + valor;
        System.out.println("O valor de R$" + valor + " foi depositado na conta " + codigoConta);
        System.out.println("Fim do depósito na conta " + codigoConta);
    }
}
