package service;

import dao.ProdutoDAO;
import model.Produto;
import java.util.List;

public class ProdutoService {

    private ProdutoDAO dao = new ProdutoDAO();

    // 1️⃣ Cadastrar produto com validações
    public void cadastrarProduto(int id, String nome, int quantidade) {

        if (quantidade < 0) {
            System.out.println("Erro: quantidade não pode ser negativa.");
            return;
        }

        if (dao.buscarPorId(id) != null) {
            System.out.println("Erro: já existe produto com esse ID.");
            return;
        }

        Produto produto = new Produto(id, nome, quantidade);
        dao.adicionar(produto);

        System.out.println("Produto cadastrado com sucesso!");
    }

    // 2️⃣ Listar produtos
    public List<Produto> listarProdutos() {
        return dao.listar();
    }

    // 3️⃣ Entrada de estoque
    public void entradaEstoque(int id, int quantidade) {

        if (quantidade <= 0) {
            System.out.println("Erro: quantidade inválida.");
            return;
        }

        Produto produto = dao.buscarPorId(id);

        if (produto == null) {
            System.out.println("Produto não encontrado.");
            return;
        }

        produto.setQuantidade(produto.getQuantidade() + quantidade);
        System.out.println("Entrada realizada com sucesso!");
    }

    // 4️⃣ Saída de estoque
    public void saidaEstoque(int id, int quantidade) {

        if (quantidade <= 0) {
            System.out.println("Erro: quantidade inválida.");
            return;
        }

        Produto produto = dao.buscarPorId(id);

        if (produto == null) {
            System.out.println("Produto não encontrado.");
            return;
        }

        if (produto.getQuantidade() < quantidade) {
            System.out.println("Erro: estoque insuficiente.");
            return;
        }

        produto.setQuantidade(produto.getQuantidade() - quantidade);
        System.out.println("Saída realizada com sucesso!");
    }
}
