package demo;

import entities.*;
import models.AlunoModel;
import models.CursoModel;

import java.util.Date;

public class GestaoCursosMain {

    public static void main(String[] args) {

        AlunoModel alunoModel = new AlunoModel();
        CursoModel cursoModel = new CursoModel();

        //instanciando os objetos referentes ao curso
        MaterialCurso matCurso = new MaterialCurso();
        matCurso.setUrl("teste123");

        Professor professor = new Professor();
        professor.setNomeCompleto("Jão");
        professor.setMatricula("12345");
        professor.setEmail("jao@email.com");

        Curso curso = new Curso();
        curso.setNome("cursoJava");
        curso.setProfessor(professor);
        curso.setSigla("J");
        curso.setMaterialCurso(matCurso);

        Aluno aluno = new Aluno();
        aluno.setEmail("email.com");
        Date data = new Date();
        data.setDate(20);
        data.setMonth(7);
        data.setYear(1990);
        aluno.setNascimento(data);
        aluno.setNomeCompleto("jao");
        aluno.setMatricula("123");

        Endereco endereco = new Endereco();
        endereco.setAluno(aluno);
        endereco.setBairro("qualquer");
        endereco.setCidade("cidade");
        endereco.setLogradouro("rua");
        endereco.setNumero("312");
        endereco.setCep(12312312);
        endereco.setEstado("ms");
        endereco.setEndereco(endereco.getBairro() + endereco.getCidade() + endereco.getEstado() + endereco.getLogradouro() + endereco.getNumero());

        Telefone telefone = new Telefone();
        telefone.setAluno(aluno);
        telefone.setDDD("67");
        telefone.setNumero("8888899999");

        cursoModel.create(curso);
        alunoModel.create(aluno);

/*        adicionarTabela(professor);
        adicionarTabela(matCurso);*/


    }

/*    public static void adicionarTabela(Object obj){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }*/
}
