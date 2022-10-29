package etiquetas;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import DAO.DAOFactory;
import beans.tipoDiscoDuroDTO;
import netscape.javascript.JSException;

public class cboTipoDiscoDuro_Tag extends TagSupport{
	public int doStartTag() throws JspException{
		JspWriter jsw = pageContext.getOut();
		try {
			DAOFactory fabrica = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
			ArrayList<tipoDiscoDuroDTO> lista = fabrica.getTipoDiscoDuroDAO().listartipoDD();
			jsw.println("<option value='-1'>Seleccione</option");
			for (tipoDiscoDuroDTO tdd : lista) {
				jsw.println("option value=" + tdd.getCodTipoDD() + ">" + tdd.getNomTipoDD()+"</option>");
			}
		} catch (IOException e) {
			System.out.println("Error en el cboTipoDD:" + e.getMessage());
		}
		return SKIP_BODY;
	}
	public int doEndTag() throws JSException{
		return EVAL_PAGE;
	}
}
