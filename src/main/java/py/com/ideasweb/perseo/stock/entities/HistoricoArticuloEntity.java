package py.com.ideasweb.perseo.stock.entities;

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

import py.com.ideasweb.perseo.common.entities.BaseEntity;
import py.com.ideasweb.perseo.comunes.entities.DepositoEntity;
import py.com.ideasweb.perseo.comunes.entities.EmpresaEntity;
import py.com.ideasweb.perseo.comunes.entities.SucursalEntity;
import py.com.ideasweb.perseo.transaccion.entities.TurnoEntity;

@Entity
@Table(name = "historico_articulo")
public class HistoricoArticuloEntity extends BaseEntity {

    @Id
    @GenericGenerator(name = "HistoricoArticuloSequenceGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM, value = "historico_articulo_id_historico_articulo_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM, value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM, value = "1") })
    @GeneratedValue(generator = "HistoricoArticuloSequenceGenerator")
    @Column(name = "id_historico_articulo")
    private Integer idHistoricoArticulo;

    @ManyToOne(targetEntity = TurnoEntity.class)
    @JoinColumn(name = "id_turno")
    private TurnoEntity turno;

    @ManyToOne(targetEntity = SucursalEntity.class)
    @JoinColumn(name = "id_sucursal")
    private SucursalEntity sucursal;

    @ManyToOne(targetEntity = ArticuloDepositoEntity.class)
    @JoinColumn(name = "id_articulo_deposito", nullable = false)
    private ArticuloDepositoEntity articuloDeposito;

    @ManyToOne(targetEntity = DepositoEntity.class)
    @JoinColumn(name = "id_deposito", nullable = false)
    private DepositoEntity deposito;

    @ManyToOne(targetEntity = EmpresaEntity.class)
    @JoinColumn(name = "id_empresa")
    private EmpresaEntity empresa;

    private Double anterior;

    private Double entrada;

    private Double venta;

    private Double actual;

    private Double precioCosto;

    private Double precioVenta;

}
