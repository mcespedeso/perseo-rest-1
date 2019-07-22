package py.com.ideasweb.perseo.stock.reports.dataSources;

import java.util.Iterator;
import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import py.com.ideasweb.perseo.stock.dtos.ArticuloDepositoDTO;

public class JRDataListaArticulos implements JRDataSource {
    Iterator it = null;

    ArticuloDepositoDTO articulo;

    public JRDataListaArticulos(List<ArticuloDepositoDTO> c) {
        it = c.iterator();
    }

    public boolean next() throws JRException {
        boolean ret = false;
        ret = it.hasNext();
        if (ret) {
            articulo = (ArticuloDepositoDTO) it.next();
        }
        return ret;
    }

    public Object getFieldValue(JRField field) throws JRException {
        Object value = null;

        if ("idarticulo".equals(field.getName())) {
            value = articulo.getArticulo().getIdArticulo();
        }

        if ("descripcion".equals(field.getName())) {
            value = articulo.getArticulo().getDescripcion();
        }

        if ("codigobarra".equals(field.getName())) {
            value = articulo.getArticulo().getCodigoBarra();
        }

        if ("preciocosto".equals(field.getName())) {
            value = articulo.getPrecioCosto();
        }

        if ("precioventa".equals(field.getName())) {
            value = articulo.getPrecioVenta();
        }

        if ("disponible".equals(field.getName())) {
            value = articulo.getCantidad();
        }
        /*
         * if ("moneda".equals(field.getName())) { value =
         * articulo.getArticulo().getMoneda().getCodigo(); }
         * 
         * if ("familia".equals(field.getName())) { if
         * (articulo.getArticulo().getFamilia() != null) { value =
         * articulo.getArticulo().getFamilia().getDescripcion(); } } if
         * ("idfamilia".equals(field.getName())) { if
         * (articulo.getArticulo().getFamilia() != null) { value =
         * articulo.getArticulo().getFamilia().getIdfamilia(); } }
         */
        return value;
    }
}