package etiquetas;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import DAO.DAOFactory;
import beans.categoriaDTO;
import beans.ciudadDTO;
import netscape.javascript.JSException;

public class cboCiudad_Tag extends TagSupport{
	public int doStartTag() throws JSException{
		JspWriter jsw = pageContext.getOut();
		try {
			DAOFactory fabrica = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
			ArrayList<ciudadDTO> lista = fabrica.getCiudadDAO().listarCiudad();
			jsw.println("<option value='-1'>Seleccione</option>");
			for(ciudadDTO cd : lista) {
				jsw.println("<option value="+ cd.getCodCiudad() + ">" + cd.getNombreCiudad()+"</option>");
			}
		} catch (IOException e) {
			System.out.println("Error en el cboCiudad:" + e.getMessage());
		}
		return SKIP_BODY;
	}
	public int doEndTag() throws JSException{
		return EVAL_PAGE;
	}
}
