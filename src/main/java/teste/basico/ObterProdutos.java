package teste.basico;

import modelo.basico.Produto;
import infra.ProdutoDAO;

import java.util.List;

public class ObterProdutos {

    public static void main(String[] args) {

        ProdutoDAO produtoDAO = new ProdutoDAO();
        List<Produto> produtos = produtoDAO.obterTodos();

        for(Produto p: produtos){
            System.out.println("ID: " + p.getId() + "; Nome: " + p.getNome() + ";");
        }

        double precoTotal = produtos.stream()
                .map(produto -> produto.getPreco())
                .reduce(0.0, (t,p) -> t +p)
                .doubleValue();

        double precoTotalOtimizado = produtos.stream()
                .map(Produto::getPreco)
                .reduce(0.0, Double::sum);

        System.out.println("O valor total é: R$" + precoTotal);
        System.out.println("O valor total otimizado é: R$" + precoTotalOtimizado);

        produtoDAO.fecharConexao();

    }
}
