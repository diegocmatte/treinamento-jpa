package teste.umparaum;

import infra.DAO;
import modelo.umparaum.Assento;
import modelo.umparaum.Cliente;

public class NovoClienteAssento1 {

    public static void main(String[] args) {

        Assento assento = new Assento("16A");
        Cliente cliente = new Cliente("Carlos", assento);

        DAO<Object> dao = new DAO<>();

        dao.abrirTransacao()
                .incluir(cliente)
                .incluir(assento)
                .fecharTransacao()
                .fecharConexao();
    }
}
