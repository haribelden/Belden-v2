/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fire_Survival_Cables;

import FileWriter.PartCode;
import addresses.Fire_Survival_Cables;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author axv01011
 */
public class F_Marine_MC extends HttpServlet {

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
            out.println("<title>Servlet Marines Multi Cores</title>");            
            out.println("</head>");
            out.println("<body>");
            Fire_Survival_Cables addr = new Fire_Survival_Cables();
            try (  FileInputStream file = new FileInputStream(new File(addr.MarineMC))) {
                //Create Workbook instance holding reference to .xlsx file
                XSSFWorkbook workbook = new XSSFWorkbook(file);
                
                //Get first/desired sheet from the workbook
                XSSFSheet sheet;
                
                String s1,s2,s3,s4,s5,s6,s7;
                s1=request.getParameter("Cable type");
                s2=request.getParameter("Conductor");
                String s2c =request.getParameter("TypeOfCopper");
                s3=request.getParameter("Insulation or Jacket");
                s4=request.getParameter("Insulation Color");
                s5=request.getParameter("Shield");
                s6=request.getParameter("Cores");
                s7=request.getParameter("Jacket Color");
                String description= s6+","+s1+","+s2+","+s2c+","+s3+","+s4+","+s5+","+s7;
                int match=0;
                if(s2c.equals("Bare Copper"))
                    match=1;
                else
                    match=2;
                
                PartCode partcode=new PartCode();
  partcode.setDescription(description);
				Cell cell;
                Row row;
                String c1,c2,c3,c4,c5,c6,c7;
                int a=0;
                double m;
                int o;
                String n;
                
                //for Cable Type
                sheet = workbook.getSheetAt(0);
                Iterator<Row> rowIterator = sheet.iterator();
                while (rowIterator.hasNext()) 
                {
                    row = rowIterator.next();
                    Iterator<Cell> cellIterator = row.cellIterator(); 
                    cell = cellIterator.next();
                    c1=cell.getStringCellValue();
                    if(c1.equals(s1))
                    {
                        cell=cellIterator.next();
                        switch (cell.getCellType()) 
                    {
                        case Cell.CELL_TYPE_NUMERIC:
                            m=cell.getNumericCellValue();
                        o=(int)m;
                        c1= String.valueOf(o);
                            break;
                        case Cell.CELL_TYPE_STRING:
                            c1=cell.getStringCellValue();
                           break;
                   }
                        out.println(c1);partcode.setCabletype(c1);
                    }
                }
                
                //for Conductor
                sheet = workbook.getSheetAt(1);
                rowIterator = sheet.iterator();
                while (rowIterator.hasNext()) 
                {
                    row = rowIterator.next();
                    Iterator<Cell> cellIterator = row.cellIterator(); 
                    cell = cellIterator.next();
                    c2=cell.getStringCellValue();
                    if(c2.equals(s2))
                    {
                        if(match==1)
                        cell=cellIterator.next();
                        else if(match==2){
                            cell=cellIterator.next();
                          cell=cellIterator.next();
                        }
                       switch (cell.getCellType()) 
                    {
                        case Cell.CELL_TYPE_NUMERIC:
                            m=cell.getNumericCellValue();
                        o=(int)m;
                        c2= String.valueOf(o);
                            break;
                        case Cell.CELL_TYPE_STRING:
                            c2=cell.getStringCellValue();
                           break;
                   }
                        out.println(c2);partcode.setConductor(c2);
                    }
                }
              
                //for Insulation or Jacket
                sheet = workbook.getSheetAt(2);
                rowIterator = sheet.iterator();
                while (rowIterator.hasNext()) 
                {
                    row = rowIterator.next();
                    Iterator<Cell> cellIterator = row.cellIterator(); 
                    cell = cellIterator.next();
                    c3=cell.getStringCellValue();
                    if(c3.equals(s3))
                    {
                        cell=cellIterator.next();
                        switch (cell.getCellType()) 
                    {
                        case Cell.CELL_TYPE_NUMERIC:
                            m=cell.getNumericCellValue();
                        o=(int)m;
                        c3= String.valueOf(o);
                            break;
                        case Cell.CELL_TYPE_STRING:
                            c3=cell.getStringCellValue();
                           break;
                   }
                        
                        out.println(c3);partcode.setInsulation_or_jacket(c3);
                    }
                }

                //for Insulation Color
                sheet = workbook.getSheetAt(3);
                rowIterator = sheet.iterator();
                while (rowIterator.hasNext()) 
                {
                    row = rowIterator.next();
                    Iterator<Cell> cellIterator = row.cellIterator(); 
                    cell = cellIterator.next();
                    c4=cell.getStringCellValue();
                    if(c4.equals(s4))
                    {
                        cell=cellIterator.next();
                        switch (cell.getCellType()) 
                    {
                        case Cell.CELL_TYPE_NUMERIC:
                            m=cell.getNumericCellValue();
                        o=(int)m;
                        c4=String.valueOf(o);
                            break;
                        case Cell.CELL_TYPE_STRING:
                            c4=cell.getStringCellValue();
                           break;
                   }
                        out.println(c4);partcode.setInsulation_color(c4);
                    }
                }

                //for Shield
                sheet = workbook.getSheetAt(4);
                rowIterator = sheet.iterator();
                while (rowIterator.hasNext()) 
                {
                    row = rowIterator.next();
                    Iterator<Cell> cellIterator = row.cellIterator(); 
                    cell = cellIterator.next();
                    c5=cell.getStringCellValue();
                    if(c5.equals(s5))
                    {
                        cell=cellIterator.next();
                        switch (cell.getCellType()) 
                    {
                        case Cell.CELL_TYPE_NUMERIC:
                            m=cell.getNumericCellValue();
                        o=(int)m;
                        c5=String.valueOf(o);
                            break;
                        case Cell.CELL_TYPE_STRING:
                            c5=cell.getStringCellValue();
                           break;
                   }
                        out.println(c5);partcode.setShield(c5);
                    }
                }

                //for Cores
                sheet = workbook.getSheetAt(5);
               
                rowIterator = sheet.iterator();

                while (rowIterator.hasNext()) 
                {
                    row = rowIterator.next();
                    Iterator<Cell> cellIterator = row.cellIterator(); 
                    cell = cellIterator.next();
                    c6=cell.getStringCellValue();
                    
                    if(c6.equals(s6))
                    {
                        cell=cellIterator.next();
                        switch (cell.getCellType()) 
                    {
                        case Cell.CELL_TYPE_NUMERIC:
                            m=cell.getNumericCellValue();
                        o=(int)m;
                        c6= String.valueOf(o);
                            break;
                        case Cell.CELL_TYPE_STRING:
                            c6=cell.getStringCellValue();
                           break;
                   }
                        out.println(c6);partcode.setNumber_of_cpt(c6);
                    }
                }
                //for Jacket Color
                sheet = workbook.getSheetAt(6);
                rowIterator = sheet.iterator();
                while (rowIterator.hasNext()) 
                {
                    row = rowIterator.next();
                    Iterator<Cell> cellIterator = row.cellIterator(); 
                    cell = cellIterator.next();
                    c7=cell.getStringCellValue();
                    if(c7.equals(s7))
                    {
                        cell=cellIterator.next();
                        switch (cell.getCellType()) 
                    {
                        case Cell.CELL_TYPE_NUMERIC:
                            m=cell.getNumericCellValue();
                        o=(int)m;
                        c7= String.valueOf(o);
                            break;
                        case Cell.CELL_TYPE_STRING:
                            c7=cell.getStringCellValue();
                           break;
                   }
                        out.println(c7); partcode.setJacket_color(c7);
                    }
                }
                   out.println("<br>");
                out.println(description); 
				  String pc = partcode.getCompletePC();
               String description1=partcode.getDescription();
             
             
          
                out.println("<form action='SaveInExcel'>");
                out.println("<input type='hidden' value='"+pc+"' name='partcode'>");   
                out.println("<input type='hidden' value='"+description1+"' name='description'>");
                out.println("<input type='submit' name = 'select' value='Save'>");
				out.println("<input type='submit' name = 'select' value='View'>");
           
            
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
