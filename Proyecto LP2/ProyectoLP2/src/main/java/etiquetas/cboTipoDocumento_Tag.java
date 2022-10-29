package etiquetas;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import DAO.DAOFactory;
import beans.tipoDocumentoDTO;
import netscape.javascript.JSException;

public class cboTipoDocumento_Tag extends TagSupport{
	public int doStartTag() throws JspException{
		JspWriter jsw = pageContext.getOut();
		try {
			DAOFactory fabrica = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
			ArrayList<tipoDocumentoDTO> lista = fabrica.getTipoDocu().listarTipoDoc();
			jsw.println("<option value='-1'>Seleccione</option");
			for (tipoDocumentoDTO tdoc : lista) {
				jsw.println("option value=" + tdoc.getCodTipoDoc() + ">" + tdoc.getNomTipoDoc()+"</option>");
			}
		} catch (IOException e) {
			System.out.println("Error en el cboTipoDocumento:" + e.getMessage());
		}
		return SKIP_BODY;
	}
	public int doEndTag() throws JSException{
		return EVAL_PAGE;
	}
}