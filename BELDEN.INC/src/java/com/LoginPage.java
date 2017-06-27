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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author axv01011
 */
public class LoginPage extends HttpServlet {

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
           out.println("<!DOCTYPE html>");
           out.println("<html>");
           out.println("<head>");
           out.println("<title>Servlet Login</title>");            
           out.println("</head>");
           out.println("<body>");
            Cookie ck1,ck2;
            
            int x=1,flag=0;
            String y,z,q;
            y=request.getParameter("uname");
            z=request.getParameter("pass");
            Configuration cfg = new Configuration();
            cfg.configure("hibernate.cfg.xml");
            
            SessionFactory sf = cfg.buildSessionFactory();
            Session s = sf.openSession();
            Users st=new Users();
         List<Users> list = new ArrayList<Users>();
          
           Query query = s.createQuery("FROM Users");
            list = query.list();
       
            ListIterator<Users> itr=list.listIterator();
               while(itr.hasNext())
                {
                    
                    st=(Users)itr.next();
                    
                if(st.getUname().equals(y))
                {
                   
                    if(st.getPass().equals(z))
                    {
                     
                        if(st.getUtype()==0)
                    {
                        out.println("You are admin / SE");
                        flag =1;
                        ck1=new Cookie("fname",st.getFname());
                        //ck1.setMaxAge(60 * 60 * 24); 
                        ck2=new Cookie("lname",st.getLname());
                       // ck2.setMaxAge(60 * 60 * 24);
                        response.addCookie(ck1);
                        response.addCookie(ck2);
                        response.sendRedirect("view1.html");
                    }
                    else 
                    {
                        out.println("you are not an admin/SE");
                        flag=1;
                        ck1=new Cookie("fname",st.getFname());
                       // ck1.setMaxAge(60 * 60 * 24); 
                        ck2=new Cookie("lname",st.getLname());
                       // ck2.setMaxAge(60 * 60 * 24);
                        response.addCookie(ck1);
                        response.addCookie(ck2);
                        response.sendRedirect("BasicDetails.html");
                    }
                    break;
                    }
                    
                }
               
                    
             
            }
                if(flag==0)
                {
                    out.print("Wrong id/pass");
                }
            
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
