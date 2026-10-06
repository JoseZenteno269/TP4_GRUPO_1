package Servlet;

import java.io.IOException;

import Servicio.ServicioTipoSeguro;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TipoSeguroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ServicioTipoSeguro servicioTipoSeguro = new ServicioTipoSeguro();
		request.setAttribute("tipos", servicioTipoSeguro.obtenerTipoSeguros());

		RequestDispatcher rd = request.getRequestDispatcher("/AgregarSeguro.jsp");
		rd.forward(request, response);
	}
}