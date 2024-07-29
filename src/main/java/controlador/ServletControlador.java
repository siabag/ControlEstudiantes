package controlador;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import modelo.EstudianteDaoJDBC;
import modelo.Estudiante;
import javax.servlet.http.*;
import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;

@WebServlet(name = "ServletControlador", urlPatterns = "/ServletControlador")
public class ServletControlador extends HttpServlet {
    
    protected void editarEstudiante(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        int idEstudiante = Integer.parseInt(request.getParameter("idEstudiante"));
        Estudiante estudiante = new EstudianteDaoJDBC().buscar(new Estudiante(idEstudiante));
        request.setAttribute("estudiante", estudiante);
        String jspEditar = "/WEB-INF/vista/estudiante/editarEstudiante.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }
    
    protected void accionDefault(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Estudiante> estudiantes = new EstudianteDaoJDBC().listar();
        System.out.println("estudiantes = " + estudiantes);
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("estudiantes", estudiantes);
        sesion.setAttribute("totalEstudiantes", estudiantes.size());
        
        response.sendRedirect("estudiantes.jsp");
    }
    
    protected void modificarEstudiante(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idEstudiante = Integer.parseInt(request.getParameter("idEstudiante"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        double edad = 0;
        
        String edadString = request.getParameter("edad");
        if (edadString != null && !"".equals(edadString)) {
            edad = Double.parseDouble(edadString);
        }
        Estudiante estudiante = new Estudiante(idEstudiante, nombre, apellido, email, telefono, edad);
        int registrosModificados = new EstudianteDaoJDBC().actualizar(estudiante);
        this.accionDefault(request, response);
    }
    
    protected void eliminarEstudiante(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idEstudiante = Integer.parseInt(request.getParameter("idEstudiante"));
        Estudiante estudiante = new Estudiante(idEstudiante);
        int registrosModificados = new EstudianteDaoJDBC().eliminar(estudiante);
        this.accionDefault(request, response);
    }
    
    protected void insertarEstudiante(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        double edad = 0;
        
        String edadString = request.getParameter("edad");
        if (edadString != null && !"".equals(edadString)) {
            edad = Double.parseDouble(edadString);
        }
        Estudiante estudiante = new Estudiante(nombre, apellido, email, telefono, edad);
        int registrosModificados = new EstudianteDaoJDBC().insertar(estudiante);
        this.accionDefault(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.editarEstudiante(request, response);
                    break;
                case "eliminar":
                    this.eliminarEstudiante(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String accion = request.getParameter("accion");
        
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarEstudiante(request, response);
                    break;
                case "modificar":
                    this.modificarEstudiante(request, response);
                    break;
                case "eliminar":
                    this.eliminarEstudiante(request, response);
                    break;
                default:
                    this.eliminarEstudiante(request, response);
            }
        }
        else{
            this.eliminarEstudiante(request, response);
        }
    }
}
