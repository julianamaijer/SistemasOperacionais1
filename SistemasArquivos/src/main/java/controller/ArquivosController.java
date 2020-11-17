package controller;

import java.io.File;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class ArquivosController implements IArquivosController {

    public ArquivosController(){super();}

    public void verificaDirTemp() throws IOException {
        String path = "C:\\TEMP";
        String name = "arquivo";
        File dir = new File(path);
        File arq = new File(path, name + ".csv");
        if (dir.exists() && dir.isDirectory()){
            boolean exist = false;
            if (arq.exists()){
                exist =  true;
            }

            String content = generateTxt();
            FileWriter fileWriter = new FileWriter(arq, exist);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.write(content);
            printWriter.flush(); // finalize the writing
            printWriter.close();
            fileWriter.close();
        }else {
            dir.mkdir();
            boolean exist = false;
            if(arq.exists()){
                exist = true;
            }

            String content = generateTxt();
            FileWriter fileWriter = new FileWriter(arq, exist);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.write(content);
            printWriter.flush(); // finalize the writing
            printWriter.close();
            fileWriter.close();
        }
    }

    private String generateTxt() {
        StringBuffer stringBuffer = new StringBuffer();
        String line = "Codigo \n Nome \n Email";
        stringBuffer.append(line);
        return stringBuffer.toString();
    }

    public boolean verificaRegistro(String arquivo, int codigo) throws IOException {
        String path = "C:\\TEMP";
        File arq = new File(path, arquivo);
        if (arq.exists() && arq.isFile()){
            FileInputStream flow = new FileInputStream(arq);
            InputStreamReader reader = new InputStreamReader(flow);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = bufferedReader.readLine();
            while (line != null){
                System.out.println(line);
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
            reader.close();
            flow.close();
        }else {
            throw new IOException("Arquivo Inválido!");
        }

        return false;
    }

    public void imprimeCadastro(String arquivo, int codigo) throws IOException {

    }

    public void insereCadastro(String arquivo, int codigo, String nome, String email) throws IOException {

    }

}
