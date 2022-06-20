package models;

import entities.Aluno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class AlunoModel {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
    EntityManager em = emf.createEntityManager();

    public void create(Aluno aluno) {

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.persist(aluno);
            em.getTransaction().commit();
            System.out.println("Aluno criado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao criar um aluno !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public Aluno findById(Long id) {
        return em.find(Aluno.class, id);
    }

    public List<Aluno> findAll() {
        return em.createQuery("FROM" + Aluno.class.getName()).getResultList();
    }

    public void update(Aluno aluno) {
        try{
            em.getTransaction().begin();
            em.merge(aluno);
            em.getTransaction().commit();
        } catch (Exception ex){
            ex.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void delete(Aluno aluno) {
        try {
            em.getTransaction().begin();
            aluno = em.find(Aluno.class, aluno.getId());
            em.remove(aluno);
            em.getTransaction().commit();
        } catch (Exception ex){
            ex.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
