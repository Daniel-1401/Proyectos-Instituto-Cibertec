package etiquetas;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import DAO.DAOFactory;
import beans.marcaDTO;
import netscape.javascript.JSException;

public class cboMarca_Tag extends TagSupport{
	public int doStartTag() throws JspException{
		JspWriter jsw = pageContext.getOut();
		try {
			DAOFactory fabrica = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
			ArrayList<marcaDTO> lista = fabrica.getMarcaDAO().listarMarca();
			jsw.println("<option value='-1'>Seleccione</option");
			for (marcaDTO marca : lista) {
				jsw.println("<option value=" + marca.getCodMarca() + ">" + marca.getNomMarca()+"</option>");
			}
		} catch (IOException e) {
			System.out.println("Error en el cboMarca:" + e.getMessage());
		}
		return SKIP_BODY;
	}
	public int doEndTag() throws JSException{
		return EVAL_PAGE;
	}
}
