package etiquetas;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import DAO.DAOFactory;
import beans.paisDTO;
import beans.sistemaOperativoDTO;
import netscape.javascript.JSException;

public class cboPais_Tag extends TagSupport{
	public int doStartTag() throws JspException{
		JspWriter jsw = pageContext.getOut();
		try {
			DAOFactory fabrica = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
			ArrayList<paisDTO> lista = fabrica.getpaisDAO().listarPais();
			jsw.println("<option value='-1'>Seleccione</option");
			for (paisDTO ps : lista) {
				jsw.println("option value=" + ps.getCodPais() + ">" + ps.getNomPais()+"</option>");
			}
		} catch (IOException e) {
			System.out.println("Error en el cboPais:" + e.getMessage());
		}
		return SKIP_BODY;
	}
	public int doEndTag() throws JSException{
		return EVAL_PAGE;
	}
}
