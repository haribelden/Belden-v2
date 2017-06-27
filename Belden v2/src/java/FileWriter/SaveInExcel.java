/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileWriter;

import addresses.Saving;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author belden
 */
public class SaveInExcel extends HttpServlet {

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
            out.println("<title>Servlet SaveInExcel</title>");            
            out.println("</head>");
            out.println("<body>");
            String code,filename = null,description,selection;
           
             code=request.getParameter("partcode");
              description=request.getParameter("description");
              selection=request.getParameter("select");
              String category=request.getParameter("category"); //new
              String deviation=request.getParameter("deviation");//new
              Cookie ck[]=request.getCookies();  
            for(int i=0;i<ck.length;i++){  
               if(ck[i].getName().equals("File"))
                   filename=ck[i].getValue();  
                     }
              
              if(selection.equals("Save"))
              {
            
            PartCode pc = new PartCode();
             pc.updateToFile(filename, code, description,category,deviation);
             
             
             
           response.sendRedirect("PartCodeHome.jsp");
              }
             
              
              
              if(selection.equals("View"))
              {
                  PartCode pc = new PartCode();
                  pc.updateToFile(filename, code, description,category,deviation);
                  Saving saving =new Saving();
                  String filepath = saving.temp+filename+".xlsx";
                  FileInputStream file = new FileInputStream(new File(filepath));
                  XSSFWorkbook workbook = new XSSFWorkbook(file);
                 Cell cell;
                 Row row;
                 XSSFSheet sheet;
                 String c1,c2;
                  sheet = workbook.getSheetAt(0);
                Iterator<Row> rowIterator = sheet.iterator();
                out.println("<form action ='deleteSample'>");
                out.println("<table>");
                while (rowIterator.hasNext()) 
                {
                    row = rowIterator.next();
                    Iterator<Cell> cellIterator = row.cellIterator(); 
                    cell = cellIterator.next();
                    c1=cell.getStringCellValue();
                    cell=cellIterator.next();
                    c2=cell.getStringCellValue();
                    out.println("<tr>");
                    out.println("<td><input type='radio' name='set' value='"+c1+"'></td>");
                    out.println("<td>"+c2+"</td>");
                    out.println("</tr>");
                        
                    }
                out.println("<input type='hidden' name='filename' value='"+filename+"'>");
                out.println("<input type='submit' name ='sub' value='Delete'>");
                out.println("<input type='submit' name ='sub' value='Download Sheet'");
               out.println("</table>"); 
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
