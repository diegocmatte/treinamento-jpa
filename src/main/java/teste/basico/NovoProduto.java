package teste.basico;

import infra.DAO;
import modelo.basico.Produto;

public class NovoProduto {

    public static void main(String[] args) {

        DAO<Produto> produtoDAO = new DAO<>(Produto.class);

        Produto produto = new Produto("Monitor 23", 789.98);
        produtoDAO.incluirAtomico(produto).fechar();

        System.out.println("ID do produto: " + produto.getId());
    }
}
