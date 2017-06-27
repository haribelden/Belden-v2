/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileWriter;

import addresses.Saving;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author belden
 */
public class deleteSample extends HttpServlet {

   public static String namefilename;
    
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
            out.println("<title>Servlet deleteSample</title>");            
            out.println("</head>");
            out.println("<body>");
            String sub = request.getParameter("sub");
            String pc = request.getParameter("set");
            String filename1=request.getParameter("filename");
            Saving saving =new Saving();
            String filepath = saving.temp+filename1+".xlsx";
            if(sub.equals("Delete")){
                  FileInputStream file = new FileInputStream(new File(filepath));
                  XSSFWorkbook workbook = new XSSFWorkbook(file);
                 Cell cell;
                 Row row;
                 
                 XSSFSheet sheet;
                 String c1,c2;
                  sheet = workbook.getSheetAt(0);
                Iterator<Row> rowIterator = sheet.iterator();
                while (rowIterator.hasNext()) 
                {
                    row = rowIterator.next();
                    Iterator<Cell> cellIterator = row.cellIterator(); 
                    cell = cellIterator.next();
                    c1=cell.getStringCellValue();
                    if(c1.equals(pc)){
                        sheet.removeRow(row);
                        break;
                    }
            }
             File outWB = new File(filepath);
                try (OutputStream out1 = new FileOutputStream(outWB)) {
                    workbook.write(out1);
                    out.flush();
                }  
                response.sendRedirect("viewer");
            }
            
            else if(sub.equals("Download Sheet"))
            {
                Date dt=new Date();
                SimpleDateFormat ft = new SimpleDateFormat ("dd.MM.yyyy");
                SimpleDateFormat ft1 = new SimpleDateFormat ("ddMMyyyy");
                String date= ft.format(dt);
                String date1=ft1.format(dt);
                String pcfile = null;
                String pcfile_name = null;
                //String finalfilepath = saving.resource+date+".xlsx";
                String name,fname = null,lname = null,f,l,t = null,customername = null,projectname = null;
                Cookie ck[]=request.getCookies(); 
                int flag=0; int times=0;
            for(int i=0;i<ck.length;i++){  
               if(ck[i].getName().equals("fname"))
                   fname=ck[i].getValue();
               if(ck[i].getName().equals("lname"))
                   lname=ck[i].getValue();
               if(ck[i].getName().equals("Customer"))
                   customername=ck[i].getValue();
               if(ck[i].getName().equals("Product"))
                   projectname=ck[i].getValue();
               if(ck[i].getName().equals("File"))
                   pcfile_name=ck[i].getValue();  
               if(ck[i].getName().equals("times"))
               {  flag=1;
               t = ck[i].getValue();
               times=Integer.parseInt(t);
               ck[i].setValue(String.valueOf(times+1));
               //ck[i].expires( Expiration.days( 1 ) );
               Calendar cd = Calendar.getInstance();
               long mil;
               mil = cd.getTimeInMillis();
               int seconds = (int)mil/1000;
               ck[i].setMaxAge(86400-seconds);
               response.addCookie(ck[i]);
               }
                     }
            if(flag==0){
                Cookie cook = new Cookie("times","1");
                Calendar cd = Calendar.getInstance();
               long mil;
               mil = cd.getTimeInMillis();
               int seconds = (int)mil/1000;
               cook.setMaxAge(86400-seconds);
               
                response.addCookie(cook);
                t="1";
            }
            
            name=fname+""+lname;
            f=String.valueOf(fname.charAt(0));
            l=String.valueOf(lname.charAt(0));
             String def = date1+"_"+f+l+"_"+t;
            pcfile = saving.temp+pcfile_name+".xlsx";
            
            //gettin from test file excel
             FileInputStream file1 = new FileInputStream(new File(pcfile));
                XSSFWorkbook workbook1 = new XSSFWorkbook(file1);
                XSSFSheet sheet1 = workbook1.getSheetAt(0);
                Iterator<Row> rowIterator1 = sheet1.iterator();
                String p,d,cat,dev;
                Row row1 = rowIterator1.next();
                Map<String, Object[]> data = new TreeMap<String, Object[]>();
                int i=0;
                while (rowIterator1.hasNext()) 
                {
                    row1 = rowIterator1.next();
                     Iterator<Cell> cellIterator = row1.cellIterator(); 
                     i++;
                     Cell cell1 = cellIterator.next();
                        cat=cell1.getStringCellValue();
                           cell1 = cellIterator.next();
                           p=cell1.getStringCellValue();
                           cell1 = cellIterator.next();
                           d=cell1.getStringCellValue();
                           cell1 = cellIterator.next();
                           dev=cell1.getStringCellValue();
                           data.put(String.valueOf(i),new Object[]{i,cat,p,d,dev});
                      
                   }
                        
            
            //Writing to excel
            String source = saving.top;
            String destination = saving.resource+def+".xlsx";
            File sourcefile = new File(source);
            File targetfile = new File(destination);
            FileUtils.copyFile(sourcefile, targetfile);
            
            FileInputStream file = new FileInputStream(new File(destination));
                  XSSFWorkbook workbook = new XSSFWorkbook(file);
                 Cell cell,c;
                 Row row,r;
                 
                 XSSFSheet sheet;
                 String c1,c2;
                  sheet = workbook.getSheetAt(0);
                Iterator<Row> rowIterator = sheet.iterator();
                
               //Customer Name
                  r = sheet.getRow(5); 
                   if (r == null) {
                      r = sheet.createRow(5);
                                  }
                        c = r.getCell(2); 
                       if (c == null) {
                      c = r.createCell(2, Cell.CELL_TYPE_STRING);
                           }
                     c.setCellValue(customername);
                     
                     //Project Name
                  r = sheet.getRow(6); 
                   if (r == null) {
                      r = sheet.createRow(6);
                                  }
                        c = r.getCell(2); 
                       if (c == null) {
                      c = r.createCell(2, Cell.CELL_TYPE_STRING);
                           }
                     c.setCellValue(projectname);
                     
                     
                     //Name
                  r = sheet.getRow(1); 
                   if (r == null) {
                      r = sheet.createRow(1);
                                  }
                        c = r.getCell(4); 
                       if (c == null) {
                      c = r.createCell(4, Cell.CELL_TYPE_STRING);
                           }
                     c.setCellValue(name);
                     
                     //Date
                  r = sheet.getRow(3); 
                   if (r == null) {
                      r = sheet.createRow(3);
                                  }
                        c = r.getCell(4); 
                       if (c == null) {
                      c = r.createCell(4, Cell.CELL_TYPE_STRING);
                           }
                     c.setCellValue(date);
                     
                     //DEF
                  r = sheet.getRow(2); 
                   if (r == null) {
                      r = sheet.createRow(2);
                                  }
                        c = r.getCell(4); 
                       if (c == null) {
                      c = r.createCell(4, Cell.CELL_TYPE_STRING);
                           }
                     c.setCellValue(def);
                     
                     
                     
                     Set<String> keyset = data.keySet();

    int rownum = 10;int rownumber=rownum;
    for (String key : keyset) 
    {
        //create a row of excelsheet
        rownumber = rownum++;
         row = sheet.createRow(rownumber);

        //get object array of prerticuler key
        Object[] objArr = data.get(key);

        int cellnum = 0;

        for (Object obj : objArr) 
        {
             cell = row.createCell(cellnum++);
            if (obj instanceof String) 
            {
                cell.setCellValue((String) obj);
            }
            else if (obj instanceof Integer) 
            {
                cell.setCellValue((Integer) obj);
            }
        }
    }
    rownumber = rownum++;
    row = sheet.createRow(rownumber);
    int cellnum = 4;
    cell = row.createCell(cellnum++);
     cell.setCellValue("Total");
    rownumber = rownum++;
    row = sheet.createRow(rownumber);
    cellnum = 0;
    cell = row.createCell(cellnum++);
     cell.setCellValue("For Belden internal use only.");
    
    //Deleting temp file
    File file123 = new File(pcfile);
      file123.delete();
       File f1=new File(destination);
        
                FileOutputStream out1 = new FileOutputStream(f1);
            workbook.write(out1);
            out1.close();
         
            
        Saving.filename =def;   
        
        
        //Deleting Cookies
        Cookie ck123[]=request.getCookies(); 
        
                
            for(int i123=0;i123<ck123.length;i123++){  
               if(ck[i123].getName().equals("fname"))
               { ck[i123].setMaxAge(0);
               response.addCookie(ck[i123]);}
               if(ck[i123].getName().equals("lname"))
                   { ck[i123].setMaxAge(0);
               response.addCookie(ck[i123]);}
               if(ck[i123].getName().equals("Customer"))
                    { ck[i123].setMaxAge(0);
               response.addCookie(ck[i123]);}
               if(ck[i123].getName().equals("Product"))
                    { ck[i123].setMaxAge(0);
               response.addCookie(ck[i123]);}
               if(ck[i123].getName().equals("File"))
                    { ck[i123].setMaxAge(0);
               response.addCookie(ck[i123]);} 
            }
            }
            out.println("</body>");
            out.println("</html>");
            response.sendRedirect("DownloadFile");
           
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
