package teste.basico;

import modelo.basico.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RemoverUsuario {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        Usuario usuario = em.find(Usuario.class, 8L);

        if(usuario != null){
            em.getTransaction().begin();
            em.remove(usuario);
            em.getTransaction().commit();
        } else {
            System.out.println("Usuário não localizado");
        }

        em.close();
        emf.close();
    }
}
