package etiquetas;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import DAO.DAOFactory;
import beans.gpuDTO;
import netscape.javascript.JSException;

public class cboGPU_Tag extends TagSupport{
	public int doStartTag() throws JspException{
		JspWriter jsw = pageContext.getOut();
		try {
			DAOFactory fabrica = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
			ArrayList<gpuDTO> lista = fabrica.getGPU().listarGPU();
			jsw.println("<option value='-1'>Seleccione</option>");
			for (gpuDTO gpu : lista) {
				jsw.println("<option value=" + gpu.getCodGPU() + ">" + gpu.getNomGPU()+"</option>");
			}
		} catch (IOException e) {
			System.out.println("Error en el cboGPU:" + e.getMessage());
		}
		return SKIP_BODY;
	}
	public int doEndTag() throws JSException{
		return EVAL_PAGE;
	}
}
