package arquivoobjeto;

import java.io.*;
import java.util.Scanner;
public class EscreverObjeto {
    public static void main(String[] args) {
        File caminho = new File("C:\\Users\\Bruno\\Documents\\Prog2Aula23");

        if(caminho.exists()){
            System.out.println("A pasta existe: Sobrescrevendo arquivos");
        }else{
            caminho.mkdirs();
            System.out.println("Caminho criado");
        }
        File arquivo = new File(caminho,"pessoa.db");
        System.out.println(arquivo.getAbsolutePath());
        try{
            ObjectOutputStream arquivoObj = new ObjectOutputStream(new FileOutputStream(arquivo.getAbsolutePath()));

            Pessoa[] lista = new Pessoa[10];
            Scanner ler = new Scanner(System.in);
            String opc;
            int cont =0;
            do{
                System.out.println("Lendo informação da pessoa "+(cont+1));
                System.out.print("Qual o nome: ");
                String nome = ler.next();
                System.out.print("Qual o sobrenome: ");
                String sobrenomenome = ler.next();
                lista[cont]= new Pessoa();
                lista[cont].setNome(nome);
                lista[cont].setSobrenome(sobrenomenome);
                System.out.print("Tem mais pessoas(s - sim n - não): ");
                opc = ler.next().toLowerCase();
                while(!opc.equals("s") && !opc.equals("n")){
                    System.out.print("Tem mais pessoas(s - sim n - não): ");
                    opc = ler.next().toLowerCase();
                }
                cont++;
            }while(opc.equals("s"));

            arquivoObj.writeObject(lista);
            arquivoObj.close();

        }catch(IOException e){
            System.out.println("Erro ao criar ao criar o arquivo");
        }
    }
}