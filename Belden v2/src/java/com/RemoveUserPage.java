/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import User_Bean.Users;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author axv01011
 */
public class RemoveUserPage extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
             out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet remove_user</title>");            
            out.println("</head>");
            out.println("<body>");
            Configuration cfg = new Configuration();
            cfg.configure("hibernate.cfg.xml");
            SessionFactory sf = cfg.buildSessionFactory();
            Users st=new Users();
            Session s = sf.openSession();
            Transaction t=s.beginTransaction();
            Query q;
            String y=request.getParameter("selection");
            
             if(y.equals("Delete"))
             {
                 q = s.createQuery("delete Users where sno = :digit");
           int x=Integer.parseInt(request.getParameter("set"));      
            q.setParameter("digit",x);
            int result = q.executeUpdate();
        if(result>0)
            out.println("Entry Successfully Deleted");
        t.commit();
        response.sendRedirect("users_data.jsp");
        
             }
             else if(y.equals("Modify"))
             {
                q=s.createQuery("From Users where sno =:digit");
                 int x=Integer.parseInt(request.getParameter("set"));      
                 q.setParameter("digit",x);
                 List<Users> list = new ArrayList<Users>();
                  list = q.list();
                  ListIterator<Users> itr=list.listIterator();
                 st=(Users)itr.next();
                 
                out.println("<table style=\"border:1;width:100%;height:100%\">\n" +
"            <tr  style=\"background-color:#012169;height:20%\">\n" +
"                <td colspan=\"3\">\n" +
"				 <img src=\"../Resources/Styling/belden.jpg\" alt=\"Belden-Logo\" style=\"height:80px;width=5px;float:right\"/>\n" +
"				</td>\n" +
"			</tr>\n" +
"            <tr>\n" +
"                 \n" +
"                 <td style=\"width:60%;text-align:center;font-size:18px\">");
                
                 out.println("<form action='ModificationsPage'>");
                 out.println("<input type='hidden' name='sno' value='"+st.getSno()+"'>");
                 out.println("<input type='text' name='fname' value='"+st.getFname()+"'>");
                 out.println("<input type='text' name='lname' value='"+st.getLname()+"'>");
                 out.println("<input type='text' name='uname' value='"+st.getUname()+"'>");                 
                 out.println("<input type='text' name='pass' value='"+st.getPass()+"'>");
                 out.println("<input type='number' name='utype' value='"+st.getUtype()+"'>");
                 out.println("<input type='submit' value='Change Details'>");
                 out.println("</form>");
                 
                out.println("</td>\n" +
"           </tr>\n" +
"		   <tr  style=\"background-color:#012169;height:20%\">\n" +
"                <td colspan=\"3\">\n" +
"			</td>\n" +
"			</tr>\n" +
"		    </table>");
              }
             else if(y.equals("Add-User"))
             {
                 out.println("<table style=\"border:1;width:100%;height:100%\">\n" +
"            <tr  style=\"background-color:#012169;height:20%\">\n" +
"                <td colspan=\"3\">\n" +
"				<img src=\"C:\\Users\\axv01011\\Documents\\NetBeansProjects\\BELDEN.INC\\Resources\\Styling\\belden.jpg\" style=\"height:80px;width=5px;float:right\">\n" +
"				</td>\n" +
"			</tr>\n" +
"            <tr>\n" +
"                 \n" +
"                 <td style=\"width:60%;text-align:center;font-size:18px\">");
                 out.println("<form action='AddUserPage'>");
                 out.println("<input type='text' name='fname' value='First Name'>");
                 out.println("<input type='text' name='lname' value='Last Name'>");
                 out.println("<input type='text' name='uname' value='User Name'>");                 
                 out.println("<input type='text' name='pass' value='Password'>");
                 out.println("<input type='number' name='utype' value='User Type (0 or 1)'>");
                 out.println("<input type='submit' value='Add Details'>");
                 out.println("</form>");
                 
                 out.println("</td>\n" +
"           </tr>\n" +
"		   <tr  style=\"background-color:#012169;height:20%\">\n" +
"                <td colspan=\"3\">\n" +
"			</td>\n" +
"			</tr>\n" +
"		    </table>");
             }
             s.close();
             out.println("</body>");
                 out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
