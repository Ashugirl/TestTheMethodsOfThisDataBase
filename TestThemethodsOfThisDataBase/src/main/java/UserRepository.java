import javax.persistence.EntityManager;

public class UserRepository {

    public void createOne(User user) {
        EntityManager em = EMFactory.getEMF().createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();

    }

    public User findOneById(String userName) {
        EntityManager em = EMFactory.getEMF().createEntityManager();
        return em.find(User.class, userName);
    }



}
