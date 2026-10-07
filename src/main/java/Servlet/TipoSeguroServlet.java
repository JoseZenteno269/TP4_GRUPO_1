package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import Entidades.TipoSeguros;
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
		ArrayList<TipoSeguros> tipoSeguros = servicioTipoSeguro.obtenerTipoSeguros();
		
		request.setAttribute("tipos", tipoSeguros);

		RequestDispatcher rd = request.getRequestDispatcher("/AgregarSeguro.jsp");
		rd.forward(request, response);
	}
}