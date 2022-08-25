package etiquetas;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import DAO.DAOFactory;
import beans.categoriaDTO;
import netscape.javascript.JSException;

public class cboCategoria_Tag extends TagSupport{
	public int doStartTag() throws JSException{
		JspWriter jsw = pageContext.getOut();
		try {
			DAOFactory fabrica = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
			ArrayList<categoriaDTO> lista = fabrica.getCategoriaDAO().listarCate();
			jsw.println("<option value='-1'>Seleccione</option>");
			for (categoriaDTO cate : lista) {
				jsw.println("<option value="+ cate.getCodCategoria()+ ">" + cate.getNomCategoria() + "</option>");	
			}
		} catch (IOException e) {
			System.out.println("Error en el cboCategoriaTag:" + e.getMessage());
		}
		return SKIP_BODY;
	}
	public int doEndTag() throws JspException{
		return EVAL_PAGE;
	}
}
