package entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="professor")
public class Professor {

    @Id
    @GeneratedValue
    private Long id;
    private String nomeCompleto;
    private String matricula;
    private String email;

    @OneToMany(mappedBy = "professor")
    private List<Curso> cursoList;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Curso> getCursoList() {
        return cursoList;
    }

    public void setCursoList(List<Curso> cursoList) {
        this.cursoList = cursoList;
    }
}
