public class Carrinho {
    
    Produto[] produtos = new Produto[10];
    int quantidade_de_itens;

    Carrinho(){
        this.quantidade_de_itens = 0;
    }

    public int vazio(){
        if(this.quantidade_de_itens == 0){
            return 1;
        }
        return 0;
    }

    public int cheio(){
        if(this.quantidade_de_itens == 10){
            return 1;
        }
        return 0;
    }

    public int tamanho(){
        return this.quantidade_de_itens;
    }
    
    public int inserir(Produto p1){
        if(this.cheio() == 1){
            return 0;
        }
        this.produtos[this.quantidade_de_itens] = p1;
        this.quantidade_de_itens++;
        return 1;
    }

    public int remover(Produto p1){
        if(this.vazio() == 1){
            return 0;
        }
        int index = -1;
        for(int i = 0; i < this.tamanho(); i++){
            if(this.produtos[i] == p1){
                index = i;
            }
        }
        if(index == -1){
            return 0;
        }
        else{
            for(int i = index; i < this.tamanho()-1; i++){
                this.produtos[i] = this.produtos[i+1];
            }
            this.quantidade_de_itens--;
        }
        return 1;
    }

    public float preco(){
        if(this.vazio() == 1){
            return 0;
        }
        float precoTotal = 0;
        for(int i = 0; i < this.tamanho(); i++){
            precoTotal += this.produtos[i].getPreco();
        }
        return precoTotal;
    }

    public void ver(){
        if(this.vazio() == 1){
            System.out.println("Vazio");
        }
        for(int i = 0; i < this.tamanho(); i++){
            System.out.println( this.produtos[i].getNome());
        }
    }

    private int particiona(Produto[] produtos, int inicio, int fim, String chave){
        int esquerda = inicio, direita = fim;
        Produto pivo = produtos[inicio];
        Produto aux;
        while(esquerda < direita){
            if(chave == "Preco"){
                while(esquerda <= fim && produtos[esquerda].getPreco() <= pivo.getPreco()){
                    esquerda++;
                }
                while(direita >= 0 && produtos[direita].getPreco() > pivo.getPreco()){
                    direita--;
                }
            }
            else{
                while(esquerda <= fim && (produtos[esquerda].getNome()).compareTo(pivo.getNome()) <= 0){
                    esquerda++;
                }
                while(direita >= 0 && (produtos[direita].getNome()).compareTo(pivo.getNome()) > 0){
                    direita--;
                }
            }
            
            if(esquerda < direita){
                aux = produtos[esquerda];
                produtos[esquerda] = produtos[direita];
                produtos[direita] = aux; 
            }
        }
        produtos[inicio] = produtos[direita];
        produtos[direita] = pivo;
        return direita;
    }

    private void quicksort(Produto[] produtos, int inicio, int fim, String chave){
        int pivo = 0;
        if(inicio < fim){
            pivo = this.particiona(produtos,inicio,fim, chave);
            this.quicksort(produtos, inicio, pivo-1, chave);
            this.quicksort(produtos, pivo+1, fim, chave);
        }
    }

    public int ordenar(String chave){
        if(chave == null || chave == "Nome"){
            this.quicksort(this.produtos,0,this.tamanho()-1, "Nome");
            return 1;
        }
        else if(chave == "Preco"){
            this.quicksort(this.produtos,0,this.tamanho()-1, "Preco");
            return 1;
        }
        return 0;
    }
}
