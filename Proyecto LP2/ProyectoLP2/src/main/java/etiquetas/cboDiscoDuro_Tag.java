package etiquetas;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import DAO.DAOFactory;
import beans.DiscoDuroDTO;
import netscape.javascript.JSException;

public class cboDiscoDuro_Tag extends TagSupport {
		public int doStartTag() throws JSException{
			JspWriter jsw = pageContext.getOut();
			try {
				DAOFactory fabrica = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
				ArrayList<DiscoDuroDTO> lista = fabrica.getDiscoDuroDAO().listarDiscoDuro();
				jsw.println("<option value='-1'>Seleccione</option>");
				for(DiscoDuroDTO dd : lista) {
					jsw.println("<option value="+ dd.getCodMarca()+ ">" + dd.getCapacidad()+"</option>");
				}
			} catch (IOException e) {
				System.out.println("Erro en el cboDiscoDuro:" + e.getMessage());
			}
			return SKIP_BODY;
		}
		public int doEndTag() throws JspException{
			return EVAL_PAGE;
		}
}
