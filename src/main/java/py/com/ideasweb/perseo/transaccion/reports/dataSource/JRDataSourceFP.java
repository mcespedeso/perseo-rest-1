package py.com.ideasweb.perseo.transaccion.reports.dataSource;

import java.util.Iterator;
import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import py.com.ideasweb.perseo.transaccion.dtos.FacturaFormaCobroDTO;


public class JRDataSourceFP implements JRDataSource {
		Iterator it;
		private FacturaFormaCobroDTO ffc;

		public JRDataSourceFP(List<FacturaFormaCobroDTO> list) {
			it = list.iterator();
		}

		public boolean next() throws JRException {
			boolean ret = false;
			ret = it.hasNext();
			if (ret) {
				ffc = (FacturaFormaCobroDTO) it.next();
				ret = true;
			}
			return ret;
		}

		public Object getFieldValue(JRField field) throws JRException {
			Object value = null;
			if ("importe".equals(field.getName())) {
				value = ffc.getImporte();
			}
			/*if ("formapago".equals(field.getName())) {
				value = ffc.getCajacuenta().getDescripcion();
			}
			if ("tipo".equals(field.getName())) {
				if (ffc.getCajacuenta().getTipo().equals("E")) {
					value = "EFECTIVO";
				}else if (ffc.getCajacuenta().getTipo().equals("T")) {
					value = "TARJETA";
				}
			}*/

			return value;
		}
	}