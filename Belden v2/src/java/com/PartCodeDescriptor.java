/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import addresses.Descriptor;
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
import addresses.*;

/**
 *
 * @author belden
 */
public class PartCodeDescriptor extends HttpServlet {

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
            out.println("<title>Servlet PartCodeDescriptor</title>");            
            out.println("</head>");
            out.println("<body>");
            Descriptor addr = new Descriptor();
            String input = request.getParameter("name");
            char a1,a2;
            a1=input.charAt(0);
            a2=input.charAt(1);
            String a3=Character.toString(a1)+Character.toString(a2);
            out.println(a3);
     FileInputStream file = new FileInputStream(new File(addr.desc));
                XSSFWorkbook workbook = new XSSFWorkbook(file);
                String a; double x;
                XSSFSheet sheet = workbook.getSheetAt(0);
                Iterator<Row> rowIterator = sheet.iterator();
                Cell cell;
                Row row;
                String c11 = null;
                String page = null;
                while (rowIterator.hasNext()) 
                {
                    row = rowIterator.next();
                    Iterator<Cell> cellIterator = row.cellIterator(); 
                    cell = cellIterator.next();
                    c11=cell.getStringCellValue();
                    if(c11.equals(a3))
                    {
                        cell=cellIterator.next();
                        switch (cell.getCellType()) 
                    {
                        case Cell.CELL_TYPE_NUMERIC:
                            double m=cell.getNumericCellValue();
                        int o=(int)m;
                        c11= String.valueOf(o);
                            break;
                        case Cell.CELL_TYPE_STRING:
                            c11=cell.getStringCellValue();
                           break;
                   }
                        out.println(c11);
                       break;
                        
                    }
                }
                
                //FOR CONTROL AND INSTRUMENTATION EN 50288-7
                if(c11.equals("C.E.C"))
                {
                    Control_And_Instrumentation abhi = new Control_And_Instrumentation();
                    page=abhi.MC3or5;
                  //  out.println(page);
                }
                else if(c11.equals("C.E.P"))
                {
                    Control_And_Instrumentation abhi = new Control_And_Instrumentation();
                    page=abhi.MP3or5;
                }
                else if(c11.equals("C.E.T"))
                {
                    Control_And_Instrumentation abhi = new Control_And_Instrumentation();
                    page=abhi.MT3or5;
                }
                 //FOR CONTROL AND INSTRUMENTATION IEC 60502-1
                else if(c11.equals("C.I.C"))
                {
                    Control_And_Instrumentation abhi = new Control_And_Instrumentation();
                    page=abhi.MC6or10;
                }
                else if(c11.equals("C.I.P"))
                {
                    Control_And_Instrumentation abhi = new Control_And_Instrumentation();
                    page=abhi.MP6or10;
                }
                else if(c11.equals("C.I.T"))
                {
                    Control_And_Instrumentation abhi = new Control_And_Instrumentation();
                    page=abhi.MT6or10;
                }
                
                
                
                //FOR FIRE SURVIVAL
                //FOR CONTROL AND INSTRUMENTAION
                //FOR EN50288-7
                if(c11.equals("F.C.E.C"))
                {
                    Fire_Survival_Cables abhi = new Fire_Survival_Cables();
                    page=abhi.MC3or5;
                }
                else if(c11.equals("F.C.E.P"))
                {
                    Fire_Survival_Cables abhi = new Fire_Survival_Cables();
                    page=abhi.MP3or5;
                }
                else if(c11.equals("F.C.E.T"))
                {
                    Fire_Survival_Cables abhi = new Fire_Survival_Cables();
                    page=abhi.MT3or5;
                }
                
                //FOR IEC60502-1
                else if(c11.equals("F.C.I.C"))
                {
                    Fire_Survival_Cables abhi = new Fire_Survival_Cables();
                    page=abhi.MC6or10;
                }
                else if(c11.equals("F.C.I.P"))
                {
                    Fire_Survival_Cables abhi = new Fire_Survival_Cables();
                    page=abhi.MP6or10;
                }
                else if(c11.equals("F.C.I.T"))
                {
                    Fire_Survival_Cables abhi = new Fire_Survival_Cables();
                    page=abhi.MT6or10;
                }
                
                //FOR FIRE MARINE
                
                 else if(c11.equals("F.M.C"))
                {
                    Fire_Survival_Cables abhi = new Fire_Survival_Cables();
                    page=abhi.MarineMC;
                }
                else if(c11.equals("F.M.P"))
                {
                    Fire_Survival_Cables abhi = new Fire_Survival_Cables();
                    page=abhi.MarineMP;
                }
                else if(c11.equals("F.M.T"))
                {
                    Fire_Survival_Cables abhi = new Fire_Survival_Cables();
                    page=abhi.MarineMT;
                }
                
                //FOR EXCLUSIVE MARINE
                 else if(c11.equals("M.C"))
                {
                    Marine abhi = new Marine();
                    page=abhi.MC;
                }
                else if(c11.equals("M.P"))
                {
                     Marine abhi = new Marine();
                    page=abhi.MP;
                }
                else if(c11.equals("M.T"))
                {
                    Marine abhi = new Marine();
                    page=abhi.MT;
                }
                
                //FOR EXCLUSIVE UL RATED PLTC
                else if(c11.equals("P.P"))
                {
                    PLTC abhi = new PLTC();
                    page=abhi.MP;
                }
                else if(c11.equals("P.T"))
                {
                     PLTC abhi = new PLTC();
                    page=abhi.MT;
                }
                
                //out.println(page);
                String cabletype;
                String conductor;
                String insulationorjacket;
                String insulationcolor;
                String shield;
                String number;
                String jacketcolor;
                String c1,c2,c3,c4,c5,c6,c7;
                Cell temp,temp1;
                double m;int o;
            
            cabletype=Character.toString(input.charAt(0))+Character.toString(input.charAt(1));
            conductor=Character.toString(input.charAt(2))+Character.toString(input.charAt(3));
            insulationorjacket=Character.toString(input.charAt(4));
            insulationcolor=Character.toString(input.charAt(5));
            shield=Character.toString(input.charAt(6));
            number=Character.toString(input.charAt(7))+Character.toString(input.charAt(8));
            jacketcolor=Character.toString(input.charAt(9))+Character.toString(input.charAt(10))+Character.toString(input.charAt(11));
             
              file = new FileInputStream(new File(page));
               workbook = new XSSFWorkbook(file);
            //for Cable Type
                sheet = workbook.getSheetAt(0);
                 rowIterator = sheet.iterator();
                while (rowIterator.hasNext()) 
                {
                    row = rowIterator.next();
                    Iterator<Cell> cellIterator = row.cellIterator(); 
                    cell = cellIterator.next();
                    
                    temp = cellIterator.next();
                    c1=stringValue(temp);
                    
                    
                    if(c1.equals(cabletype))
                    {
                        
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
                        out.println(c1);
                        
                    }
                }
                //for Conductor and BARE
                sheet = workbook.getSheetAt(1);
                rowIterator = sheet.iterator();
                while (rowIterator.hasNext()) 
                {
                    row = rowIterator.next();
                    Iterator<Cell> cellIterator = row.cellIterator(); 
                    cell = cellIterator.next();
                    temp = cellIterator.next();
                    c2=stringValue(temp);
                    if(c2.equals(conductor))
                    {
                                                
                       switch (cell.getCellType()) 
                    {
                        case Cell.CELL_TYPE_NUMERIC:
                            m=cell.getNumericCellValue();
                        o=(int)m;
                        c2= String.valueOf(o)+" (Bare)";
                            break;
                        case Cell.CELL_TYPE_STRING:
                            c2=cell.getStringCellValue()+" (Bare)";
                           break;
                   }
                        out.println(c2);
                    }
                }
                if(!c11.startsWith("C.")){
                    
                
                //for Conductor and TINNED
                sheet = workbook.getSheetAt(1);
                rowIterator = sheet.iterator();
                while (rowIterator.hasNext()) 
                {
                    row = rowIterator.next();
                    Iterator<Cell> cellIterator = row.cellIterator(); 
                    cell = cellIterator.next();
                    temp = cellIterator.next();
                    temp = cellIterator.next();
                    c2=stringValue(temp);
                    if(c2.equals(conductor))
                    {
                        
                        
                       switch (cell.getCellType()) 
                    {
                        case Cell.CELL_TYPE_NUMERIC:
                            m=cell.getNumericCellValue();
                        o=(int)m;
                        c2= String.valueOf(o)+" (Tinned)";
                            break;
                        case Cell.CELL_TYPE_STRING:
                            c2=cell.getStringCellValue()+" (Tinned)";
                           break;
                   }
                        out.println(c2);
                    }
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
                    temp = cellIterator.next();
                    c3=stringValue(temp);
                    if(c3.equals(insulationorjacket))
                    {
                        
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
                        
                        out.println(c3);
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
                    temp = cellIterator.next();
                    c4=stringValue(temp);
                    if(c4.equals(insulationcolor))
                    {
                        
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
                        out.println(c4);
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
                    temp = cellIterator.next();
                    c5=stringValue(temp);
                    if(c5.equals(shield))
                    {
                        
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
                        out.println(c5);
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
                    temp = cellIterator.next();
                    c6=stringValue(temp);
                    if(c6.equals(number))
                    {
                        
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
                        out.println(c6);
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
                    temp = cellIterator.next();
                    c7=stringValue(temp);
                    if(c7.equals(jacketcolor))
                    {
                        
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
                        out.println(c7);
                    }
                }
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

    public String stringValue(Cell cell){
        double m;
        String s = null;
        int o;
        switch (cell.getCellType()) 
                    {
                        case Cell.CELL_TYPE_NUMERIC:
                            m=cell.getNumericCellValue();
                        o=(int)m;
                        s= String.valueOf(o);
                            break;
                        case Cell.CELL_TYPE_STRING:
                            s=cell.getStringCellValue();
                           break;
                   }
        if(s == null)
            s=" ";
                        return s;
    }
}
