package etiquetas;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import DAO.DAOFactory;
import beans.sistemaOperativoDTO;
import netscape.javascript.JSException;

public class cboSistemaOperativo_Tag extends TagSupport{
	public int doStartTag() throws JspException{
		JspWriter jsw = pageContext.getOut();
		try {
			DAOFactory fabrica = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
			ArrayList<sistemaOperativoDTO> lista = fabrica.getSODAO().listarSO();
			jsw.println("<option value='-1'>Seleccione</option>");
			for (sistemaOperativoDTO so : lista) {
				jsw.println("<option value=" + so.getCodSO() + ">" + so.getNomSO()+"</option>");
			}
		} catch (IOException e) {
			System.out.println("Error en el cboSistemaOp:" + e.getMessage());
		}
		return SKIP_BODY;
	}
	public int doEndTag() throws JSException{
		return EVAL_PAGE;
	}
}
