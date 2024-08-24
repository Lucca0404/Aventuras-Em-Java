public class Produto {
    
    private String nome;
    private float preco;

    Produto(String nome, float preco){
        this.nome = nome;
        this.preco = preco;
    }
    Produto(){

    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public float getPreco() {
        return preco;
    }
    public void setPreco(float preco) {
        this.preco = preco;
    }

}
