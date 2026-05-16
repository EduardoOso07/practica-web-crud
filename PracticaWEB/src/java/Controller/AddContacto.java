/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Contacto;
import Model.ContactoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author eduos
 */
@WebServlet("/AddContacto")
public class AddContacto extends HttpServlet {
    
    private ContactoDAO dao;
    
    @Override
    public void init() {
        dao = new ContactoDAO();
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        String accion = req.getParameter("accion");
        
        if ("guardar".equals(accion)) {
            String nom = req.getParameter("nom");
            String tel = req.getParameter("tel");
            String dir = req.getParameter("dir");
            String mail = req.getParameter("mail");
            
            Contacto c = new Contacto(nom, tel, dir, mail);
            if (dao.insertar(c)) {
                resp.sendRedirect("index.jsp?msg=guardado");
            } else {
                resp.sendRedirect("index.jsp?msg=error");
            }
        }
        else if ("actualizar".equals(accion)) {
            int id = Integer.parseInt(req.getParameter("id"));
            String nom = req.getParameter("nom");
            String tel = req.getParameter("tel");
            String dir = req.getParameter("dir");
            String mail = req.getParameter("mail");
            
            Contacto c = new Contacto(nom, tel, dir, mail);
            c.setId(id);
            if (dao.actualizar(c)) {
                resp.sendRedirect("index.jsp?msg=actualizado");
            } else {
                resp.sendRedirect("index.jsp?msg=error");
            }
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        String accion = req.getParameter("accion");
        
        if ("eliminar".equals(accion)) {
            int id = Integer.parseInt(req.getParameter("id"));
            dao.eliminar(id);
            resp.sendRedirect("index.jsp?msg=eliminado");
        }
        else if ("editar".equals(accion)) {
            int id = Integer.parseInt(req.getParameter("id"));
            Contacto c = dao.obtenerPorId(id);
            // Enviar datos como parámetros a editar.html
            resp.sendRedirect("editar.jsp?id=" + c.getId() + 
                             "&nom=" + java.net.URLEncoder.encode(c.getNom(), "UTF-8") +
                             "&tel=" + java.net.URLEncoder.encode(c.getTel() != null ? c.getTel() : "", "UTF-8") +
                             "&dir=" + java.net.URLEncoder.encode(c.getDir() != null ? c.getDir() : "", "UTF-8") +
                             "&mail=" + java.net.URLEncoder.encode(c.getMail(), "UTF-8"));
        }
        else {
            // Listar - enviar a JSP (o podemos hacer una página temporal)
            List<Contacto> contactos = dao.listar();
            req.setAttribute("contactos", contactos);
            req.getRequestDispatcher("listar.jsp").forward(req, resp);
        }
    }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /*protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {*/
            /* TODO output your page here. You may use following sample code. */
        /*    out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddController at " + request.getContextPath() + "</h1>");
            //DbConnection conn = new DbConnection();
            //conn.getConnection();
            Contacto c = new Contacto();
            out.println(request.getParameter("fname"));
            out.println(request.getParameter("lname"));
            out.println("</body>");
            out.println("</html>");
        }
    }*/

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /*@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
*/
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /*@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }*/

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    /*@Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
*/
}
