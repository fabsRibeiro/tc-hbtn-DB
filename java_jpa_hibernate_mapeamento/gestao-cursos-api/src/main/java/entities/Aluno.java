package entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name="aluno")
public class Aluno {

    @Id
    @GeneratedValue
    private Long id;
    private String nomeCompleto;
    private String matricula;
    private Date nascimento;
    private String email;

    @OneToMany(mappedBy = "aluno")
    private List<Endereco> enderecos;

    @OneToMany(mappedBy = "aluno")
    private List<Telefone> telefones;

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

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
