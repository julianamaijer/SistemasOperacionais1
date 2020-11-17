package view;

import controller.ArquivosController;
import controller.IArquivosController;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        IArquivosController arquivosController = new ArquivosController();
        String arquivo = "texto.txt";
        int codigo = 123;
        try{
            arquivosController.verificaDirTemp();
            arquivosController.verificaRegistro(arquivo, codigo);
        }catch (IOException e){
            e.printStackTrace();
        }

    }

}
