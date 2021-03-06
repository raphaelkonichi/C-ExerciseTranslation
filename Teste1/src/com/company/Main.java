package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(ir);

        int opcao = 0;
        String valor;
        Pilha minhaPilha;

        System.out.println("Deseja instanciar com uma capacidade específica ou a default (E/D)?");
        String resp = in.readLine().toUpperCase();

        if (resp == "E") {
            System.out.println("Digite a capacidade");
            opcao = Integer.parseInt(in.readLine());
            minhaPilha = new Pilha(opcao);

        } else {
            minhaPilha = new Pilha();
        }
        do {
            try {
                System.out.println("\n\n Escolha: 1-> empilha 2-> desempilha " +
                        " 3-> topo 4-> tamanho 6-> empilha na posição " +
                        " 7-> desempilhar de uma posição  9-> sair : ");
                opcao = Integer.parseInt(in.readLine());

                if (opcao == 1) {
                    System.out.println(">>Digite o valor que deseja empilhar: ");
                    valor = in.readLine();
                    minhaPilha.empilha(valor);

                } else if (opcao == 2) {
                    valor = minhaPilha.desempilha();
                    System.out.println(">>Desempilhado: " + valor + "\n\n");

                } else if (opcao == 3) {
                    valor = minhaPilha.retornaTopo();
                    System.out.println(">>Valor no topo: " + valor + "\n\n");

                } else if (opcao == 4) {
                    System.out.println(">>Tamanho da pilha: " + minhaPilha.tamanho() + "\n\n");

                } else if (opcao == 6) {
                    System.out.print(">>Digite o valor que deseja empilhar: ");
                    valor = in.readLine();
                    System.out.print(">>Digite a posição: ");
                    int posicao = Integer.parseInt(in.readLine());
                    minhaPilha.empilha(valor, posicao);

                } else if (opcao == 7) {
                    System.out.print(">>Digite a posição: ");
                    int posicao = Integer.parseInt(in.readLine());
                    valor = minhaPilha.desempilha(posicao);
                    System.out.println("Desempilhado: " + valor);

                }
            } catch (Exception erro) {
                System.out.println("ERRO: " + erro.getMessage());
            }
        } while (opcao != 9);
    }
}
