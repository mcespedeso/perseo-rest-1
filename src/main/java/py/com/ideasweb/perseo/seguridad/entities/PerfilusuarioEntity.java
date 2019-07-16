package py.com.ideasweb.perseo.seguridad.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

@Entity
@Table(name = "perfilusuario", schema = "public")
public class PerfilusuarioEntity {

    @Id
    @GenericGenerator(name = "perfilUsuarioSequenceGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = SequenceStyleGenerator.SCHEMA, value = "public"),
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM, value = "perfilusuario_id_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM, value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM, value = "1") })
    @GeneratedValue(generator = "perfilUsuarioSequenceGenerator")
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_usuario")
    private Integer idUsuario;

    @ManyToOne(targetEntity = PerfilEntity.class)
    @JoinColumn(name = "id_perfil")
    private PerfilEntity perfil;

    public PerfilEntity getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilEntity perfil) {
        this.perfil = perfil;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Perfilusuario [idUsuario=" + idUsuario + ", perfil=" + perfil
                + "]";
    }

    
}
