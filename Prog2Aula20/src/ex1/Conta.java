package ex1;

import java.util.Random;

public class Conta {
    String titular;
    String identificador;
    String senha;
    float saldo;

    Conta(String titular, String senha, float deposito){
        this.titular = titular;
        this.senha = senha;
        saldo = deposito;
        geraIdentificador();
    }

    void geraIdentificador(){
        Random alea = new Random();
        String identificador="";
        for(int i=0; i<4; i++){
            identificador+=(char)alea.nextInt(65,90);
        }
        identificador+= alea.nextInt(1000,2000);
        this.identificador = identificador;

    }

}