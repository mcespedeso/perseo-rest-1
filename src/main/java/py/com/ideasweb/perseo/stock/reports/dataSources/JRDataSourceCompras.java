package py.com.ideasweb.perseo.stock.reports.dataSources;

import java.util.Iterator;
import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import py.com.ideasweb.perseo.transaccion.dtos.CompraCabDTO;

public class JRDataSourceCompras implements JRDataSource {
    Iterator it;
    private CompraCabDTO com;

    public JRDataSourceCompras(List<CompraCabDTO> list) {
        it = list.iterator();
    }

    public boolean next() throws JRException {
        boolean ret = false;
        ret = it.hasNext();
        if (ret) {
            com = (CompraCabDTO) it.next();
            ret = true;
        }
        return ret;
    }

    public Object getFieldValue(JRField field) throws JRException {
        Object value = null;
        if ("fecha".equals(field.getName())) {
            value = com.getFecha();
        }
        if ("comprobante".equals(field.getName())) {
            value = com.getComprobante();
        }
        if ("cliente".equals(field.getName())) {
            value = com.getProveedor().getDescripcion();
        }
        if ("importe".equals(field.getName())) {
            value = com.getImporte();
        }
        return value;
    }
}