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

public class ListarSegurosServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Pido la lista al servicio (que llama al DAO con el INNER JOIN)
        ServicioSeguros servicioSeguros = new ServicioSeguros();
        ArrayList<Seguro> listaSeguros = servicioSeguros.obtenerSeguros();

        // La guardo en el request para que el JSP la pueda leer
        request.setAttribute("listaSeguros", listaSeguros);

        // Mando el request al JSP
        RequestDispatcher rd = request.getRequestDispatcher("/ListarSeguros.jsp");
        rd.forward(request, response);
    }
}
