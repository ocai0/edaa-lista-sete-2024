class Pilha {
    int[] pilha = new int[100];
    private int indiceTopo = -1;
    private int maior = Integer.MIN_VALUE;
    private int menor = Integer.MAX_VALUE;

    public void empilhar(int numero) {
        if (indiceTopo + 1 > pilha.length)
            return;
        this.pilha[++indiceTopo] = numero;
        if (numero > maior)
            maior = numero;
        else if (numero < menor)
            menor = numero;
    }

    public int desempilhar() {
        return this.pilha[this.indiceTopo--];
    }

    public int tamanho() {
        return indiceTopo + 1;
    }

    public int ultimoValor() {
        return indiceTopo == -1 ? null : this.pilha[indiceTopo];
    }

    public boolean possuiItens() {
        return this.indiceTopo != -1;
    }

    public int maiorItem() {
        return maior;
    }

    public int menorItem() {
        return menor;
    }

    public int mediaAritmetica() {
        int resultado = 0;
        for (int i : pilha)
            resultado += i;
        resultado /= this.tamanho();
        return resultado;
    }
}