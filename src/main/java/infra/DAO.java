package infra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class DAO<E> {

    private static EntityManagerFactory emf;
    private EntityManager em;
    private Class<E> classe;

    static {
        try{
            emf = Persistence.createEntityManagerFactory("default");
        } catch (Exception e) {

        }
    }

    public DAO() {
        this(null);
    }

    public DAO(Class<E> classe) {
        em = emf.createEntityManager();
        this.classe = classe;
    }

    public DAO<E> abrirTransacao(){
        em.getTransaction().begin();
        return this;
    }

    public DAO<E> fecharTransacao(){
        em.getTransaction().commit();
        return this;
    }

    public DAO<E> incluir(E entidade){
        em.persist(entidade);
        return this;
    }

    public DAO<E> incluirAtomico(E entidade){
        return this.abrirTransacao().incluir(entidade).fecharTransacao();
    }

    public E obterPorID(Object id){
        return em.find(classe, id);
    }

    public List<E> obterTodos(){
        return this.obterTodos(10,0);
    }

    public List<E> obterTodos(int qtdRegistros, int deslocamento){
        if(classe == null){
            throw new UnsupportedOperationException("Operação não suportada. Classe nula.");
        }

        String jpql = "select e from " + classe.getName() + " e";
        TypedQuery<E> query = em.createQuery(jpql, classe);
        query.setMaxResults(qtdRegistros);
        query.setFirstResult(deslocamento);

        return query.getResultList();
    }

    public void fecharConexao(){
        em.close();
    }
}
