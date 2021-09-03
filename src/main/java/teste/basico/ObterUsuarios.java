package teste.basico;

import modelo.basico.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ObterUsuarios {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        //String jpql = "select u from Usuario u";
        //TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
        //query.setMaxResults(5);
        //List<Usuario> usuarios = query.getResultList();

        List<Usuario> usuarios = em
                .createQuery("select u from Usuario u")
                .setMaxResults(5)
                .getResultList();

        for (Usuario u: usuarios) {
            System.out.println("ID: "+ u.getId() + "; E-mail: " + u.getEmail());
        }

        em.close();
        emf.close();
    }
}
