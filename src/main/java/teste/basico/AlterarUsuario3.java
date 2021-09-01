package teste.basico;

import modelo.basico.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AlterarUsuario3 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Usuario usuario = em.find(Usuario.class, 6L);

        usuario.setNome("Diego");

        em.detach(usuario); // -> remover do estado gerenciado
        em.merge(usuario); // -> colocar em estado gerenciado

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
