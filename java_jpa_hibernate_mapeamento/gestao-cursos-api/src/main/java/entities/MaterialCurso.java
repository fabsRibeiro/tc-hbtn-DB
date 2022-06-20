package entities;

import javax.persistence.*;

@Entity
@Table(name="materialcurso")
public class MaterialCurso {

    @Id
    @GeneratedValue
    private Long id;
    private String url;

    @OneToOne
    @JoinColumn(name = "curso_id", referencedColumnName = "id")
    private Curso curso;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
