package entities;

import javax.persistence.*;

@Entity
@Table(name="telefone")
public class Telefone {

    @Id
    @GeneratedValue
    private Long id;
    private String DDD;
    private String numero;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "aluno_id", referencedColumnName = "id")
    private Aluno aluno;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDDD() {
        return DDD;
    }

    public void setDDD(String DDD) {
        this.DDD = DDD;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
}
