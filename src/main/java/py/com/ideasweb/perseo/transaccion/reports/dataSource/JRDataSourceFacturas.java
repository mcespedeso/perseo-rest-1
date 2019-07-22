package py.com.ideasweb.perseo.transaccion.reports.dataSource;

import java.util.Iterator;
import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import py.com.ideasweb.perseo.transaccion.dtos.FacturaCabDTO;

public class JRDataSourceFacturas implements JRDataSource {
    Iterator it;
    private FacturaCabDTO facturacab;

    public JRDataSourceFacturas(List<FacturaCabDTO> list) {
        it = list.iterator();
    }

    public boolean next() throws JRException {
        boolean ret = false;
        ret = it.hasNext();
        if (ret) {
            facturacab = (FacturaCabDTO) it.next();
            ret = true;
        }
        return ret;
    }

    public Object getFieldValue(JRField field) throws JRException {
        Object value = null;
        if ("fecha".equals(field.getName())) {
            value = facturacab.getFecha();
        }
        if ("tipo".equals(field.getName())) {

            value = facturacab.getTipoFactura().getDescripcion();

        }
        if ("comprobante".equals(field.getName())) {
            value = facturacab.getEstablecimiento() + "-"
                    + facturacab.getPuntoExpedicion() + "-"
                    + facturacab.getNroFactura();
        }
        if ("cliente".equals(field.getName())) {
            value = facturacab.getCliente().getNrodoc() + " - "
                    + facturacab.getCliente().getNombreApellido();
        }
        if ("importe".equals(field.getName())) {
            value = facturacab.getImporte();
        }
        /*
         * if ("litros".equals(field.getName())) { value =
         * facturacab.getCantLitros(); }
         */

        return value;
    }
}