package py.com.ideasweb.perseo.transaccion.reports.dataSource;

import java.util.Collection;
import java.util.Iterator;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import py.com.ideasweb.perseo.transaccion.dtos.FacturaDetDTO;

public class JRDataSourceFactura implements JRDataSource {
    Iterator it = null;

    FacturaDetDTO facturadet_data;

    public JRDataSourceFactura(Collection c) {
        it = c.iterator();
    }

    public boolean next() throws JRException {
        boolean ret = false;
        ret = it.hasNext();
        if (ret) {
            facturadet_data = (FacturaDetDTO) it.next();
        }
        return ret;
    }

    public Object getFieldValue(JRField field) throws JRException {
        Object value = null;
        if ("sArticulo".equals(field.getName())) {
            value = facturadet_data.getConcepto();
        }
        if ("tasa".equals(field.getName())) {
            if (facturadet_data.getArticulo().getTipoImpuesto()
                    .getIdTipoImpuesto() > 0) {
                if (facturadet_data.getArticulo().getTipoImpuesto()
                        .getIdTipoImpuesto() == 10) {
                    value = "10%";
                } else if (facturadet_data.getArticulo().getTipoImpuesto()
                        .getIdTipoImpuesto() == 5) {
                    value = "5%";
                }
            } else {
                value = "Ex";
            }
        }
        if ("nCantidad".equals(field.getName())) {
            value = facturadet_data.getCantidad();
        }
        if ("nExentas".equals(field.getName())) {
            value = facturadet_data.getExenta();
        }
        if ("nGravada5".equals(field.getName())) {
            value = facturadet_data.getGrabada5().doubleValue()
                    + facturadet_data.getIva5().doubleValue();
        }
        if ("nGravada10".equals(field.getName())) {
            value = facturadet_data.getGrabada10().doubleValue()
                    + facturadet_data.getIva10().doubleValue();
        }
        if ("nPrecio".equals(field.getName())) {
            value = facturadet_data.getPrecioVenta();
        }
        if ("totallinea".equals(field.getName())) {
            value = facturadet_data.getGrabada10() + facturadet_data.getIva5()
                    + facturadet_data.getGrabada10()
                    + facturadet_data.getIva10() + facturadet_data.getExenta();
        }
        return value;
    }
}