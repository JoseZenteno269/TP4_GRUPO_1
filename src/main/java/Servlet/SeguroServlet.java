package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import Entidades.Seguro;
import Servicio.ServicioSeguros;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SeguroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ServicioSeguros servicioSeguros = new ServicioSeguros();
		ArrayList<Seguro> listaSeguros = servicioSeguros.obtenerSeguros();

		request.setAttribute("listaSeguros", listaSeguros);

		RequestDispatcher rd = request.getRequestDispatcher("/ListarSeguros.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		try {
			
			if (request.getParameter("btnAceptar") == null) {
				throw new IllegalArgumentException("No se recibió la acción de agregar el seguro");
			}

			String descripcion = request.getParameter("txtDescripcion");
			
			if (descripcion == null || descripcion.trim().isEmpty() || descripcion.trim().length() > 200) {
				throw new IllegalArgumentException("La descripción del seguro no es válida");
			}

			int idTipo = Integer.parseInt(request.getParameter("ddlTipoSeguro"));
			
			double costoContratacion = Double.parseDouble(request.getParameter("txtCostoContratacion"));
			
			double costoMaximo = Double.parseDouble(request.getParameter("txtCostoMaximo"));
			
			if (idTipo <= 0 || !Double.isFinite(costoContratacion) || costoContratacion < 0 || !Double.isFinite(costoMaximo) || costoMaximo < 0) {
				throw new IllegalArgumentException("El tipo de seguro o los costos no son válidos");
			}

			ServicioSeguros servicioSeguros = new ServicioSeguros();
			if (servicioSeguros.agregarSeguros(descripcion.trim(), idTipo, costoContratacion, costoMaximo)) {
				response.sendRedirect(request.getContextPath() + "/AgregarSeguro.jsp?agregado=1");
				return;
			}
			
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
		catch (IllegalArgumentException e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}

		request.setAttribute("errorAgregarSeguro", Boolean.TRUE);
		RequestDispatcher rd = request.getRequestDispatcher("/AgregarSeguro.jsp");
		rd.forward(request, response);
	}
}