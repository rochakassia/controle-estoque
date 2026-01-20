package main;

import service.ProdutoService;
import model.Produto;

public class Main {

    public static void main(String[] args) {

        ProdutoService service = new ProdutoService();

        service.cadastrarProduto(1, "Caneta", 10);
        service.entradaEstoque(1, 5);
        service.saidaEstoque(1, 3);

        for (Produto p : service.listarProdutos()) {
            System.out.println(p.getNome() + " - " + p.getQuantidade());
        }
    }
}


