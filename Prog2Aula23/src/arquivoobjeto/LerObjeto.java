package arquivoobjeto;

import java.io.*;

public class LerObjeto {
    public static void main(String[] args) {
        File caminho = new File("C:\\Users\\Bruno\\Documents\\Prog2Aula23");
        File arquivo = new File(caminho,"pessoa.db");
        try{
            ObjectInputStream arquivoObj = new ObjectInputStream(new FileInputStream(arquivo.getAbsolutePath()));
            Pessoa[] lista = (Pessoa[]) arquivoObj.readObject();

            int cont =0;
            Pessoa p;
            do{
                p = lista[cont];
                if(p!=null){
                    cont++;
                }
            }while(p!=null);
            for(int i=0; i<cont;i++){
                System.out.println(lista[i]);
            }
            arquivoObj.close();
        }catch(IOException e){
            System.out.println("Erro ao ler o arquivo");
        }catch(ClassNotFoundException e){
            System.out.println("Classe não encontrada");
        }
    }
}