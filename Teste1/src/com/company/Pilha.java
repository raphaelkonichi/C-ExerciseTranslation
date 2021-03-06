package com.company;

public class Pilha {
    private int CAPACIDADE;
    private String[] dados;
    private int topo = -1;
    public Pilha() {
        CAPACIDADE = 10;
        dados = new String[CAPACIDADE];
    }
    public Pilha(int capacidade) {
        CAPACIDADE = capacidade;
        dados = new String[CAPACIDADE];
    }
    public int tamanho() {
        return topo + 1;
    }
    public boolean vazia() {
        return tamanho() == 0;
    }
    public void empilha(String p_valor) throws Exception {
        if (tamanho() != CAPACIDADE) {
            topo++;
            dados[topo] = p_valor;
        } else {
            throw new Exception("A pilha está cheia!!!");
        }
    }
    public void empilha(String p_valor, int posicao) throws Exception {
        if (tamanho() == CAPACIDADE)
            throw new Exception("A Pilha está cheia!!!\n");
        else if (posicao > tamanho())
            throw new Exception("Não é possível inserir nesta posição");
        else {
            topo++;
            for (int i = tamanho() - 1; i > posicao; i--) {
                dados[i] = dados[i - 1];
            }
            dados[posicao] = p_valor;
        }
    }
    public String desempilha() throws Exception {
        if (vazia()) {
            throw new Exception("A pilha está vazia!!!");
        } else {
            topo--;
            return dados[topo + 1];
        }
    }
    public String desempilha(int posicao) throws Exception {
        if (vazia()) {
            throw new Exception("A pilha está vazia!!!");
        } else if (posicao >= tamanho())
            throw new Exception("Posição inválida!!!");
        else {
            String aux = dados[posicao];
            for (int i = posicao; i < tamanho() - 1; i++)
                dados[i] = dados[i + 1];
            topo--;
            return aux;
        }
    }
    public String retornaTopo() throws Exception {
        if (vazia())
            throw new Exception("A pilha está vazia!!!");
        else
            return dados[topo];
    }
}
