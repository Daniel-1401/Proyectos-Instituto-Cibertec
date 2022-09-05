package etiquetas;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import DAO.DAOFactory;
import beans.cpuDTO;
import netscape.javascript.JSException;

public class cboCPU_Tag extends TagSupport{
	public int doStartTag() throws JspException{
		JspWriter jsw = pageContext.getOut();
		try {
			DAOFactory fabrica = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
			ArrayList<cpuDTO> lista = fabrica.getCpuDAO().listarCPU();
			jsw.println("<option value='-1'>Seleccione</option>");
			for (cpuDTO cpu : lista) {
				jsw.println("<option value=" + cpu.getCodCPU() + ">" + cpu.getModelCPU() +"</option>");
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
