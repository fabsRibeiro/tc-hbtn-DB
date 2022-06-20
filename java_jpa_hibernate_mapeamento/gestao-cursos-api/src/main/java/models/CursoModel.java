package models;

import entities.Curso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CursoModel {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
    EntityManager em = emf.createEntityManager();
    public void create(Curso curso) {

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.persist(curso);
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

    public Curso findById(Long id) {
        return em.find(Curso.class, id);
    }

    public List<Curso> findAll() {
        return em.createQuery("FROM" + Curso.class.getName()).getResultList();
    }

    public void update(Curso curso) {
        try{
            em.getTransaction().begin();
            em.merge(curso);
            em.getTransaction().commit();
        } catch (Exception ex){
            ex.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void delete(Curso curso) {
        try {
            em.getTransaction().begin();
            curso = em.find(Curso.class, curso.getId());
            em.remove(curso);
            em.getTransaction().commit();
        } catch (Exception ex){
            ex.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
