<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import= "java.io.File"%>
<%@ page import= "java.io.FileInputStream"%>
<%@ page import= "java.io.IOException"%>
<%@ page import= "java.io.PrintWriter"%>
<%@ page import= "java.util.Iterator"%>
<%@ page import= "javax.servlet.ServletException"%>
<%@ page import= "javax.servlet.http.HttpServlet"%>
<%@ page import= "javax.servlet.http.HttpServletRequest"%>
<%@ page import= "javax.servlet.http.HttpServletResponse"%>
<%@ page import= "org.apache.poi.ss.usermodel.Cell"%>
<%@ page import= "org.apache.poi.ss.usermodel.Row"%>
<%@ page import= "org.apache.poi.xssf.usermodel.XSSFSheet"%>
<%@ page import= "org.apache.poi.xssf.usermodel.XSSFWorkbook"%>
<%@page import="addresses.Control_And_Instrumentation" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Multi Triads 300 or 500V</title>
    </head>
    <body>
        <table style="border:1;width:100%;height:100%">
            <tr  style="background-color:#012169;height:20%">
                <td colspan="3">
 <img src="../Resources/Styling/belden.jpg" alt="Belden-Logo" style="height:80px;width=5px;float:right"/>				</td>
			</tr>
            <tr>
                 
                 <td style="width:60%;padding-left:100px;padding-bottom:150px;font-size:18px;text-align:left">
        <%
            Control_And_Instrumentation addr = new Control_And_Instrumentation();
     FileInputStream file = new FileInputStream(new File(addr.MT3or5));
                XSSFWorkbook workbook = new XSSFWorkbook(file);
                String a; double x;
        %>
              <form action='../CI_MT_3or5'>
                <%--FOR CABLETYPE--%>
               <br>Cable Type: <select name='Cable type'>
                <% XSSFSheet sheet = workbook.getSheetAt(0);
                Iterator<Row> rowIterator = sheet.iterator();
                while (rowIterator.hasNext()) 
                {
                    Row row = rowIterator.next();
                     Iterator<Cell> cellIterator = row.cellIterator(); 
                     Cell cell = cellIterator.next();
                     switch (cell.getCellType()) 
                    {
                        case Cell.CELL_TYPE_NUMERIC:
                           
                            x =cell.getNumericCellValue();
                        
                        a= String.valueOf(x);
                            break;
                        case Cell.CELL_TYPE_STRING:
                            a=cell.getStringCellValue();
                           break;
                           
                        default:
                               a=cell.getStringCellValue();  
                   }
                %>
                 <option name="<%=a%>"><% out.println(a); %></option>
                 <%}%>
                </select>
            
                <%--FOR CONDUCTOR--%>
               <br>Conductor: <select name='Conductor'>
                <% sheet = workbook.getSheetAt(1);
                rowIterator = sheet.iterator();
                while (rowIterator.hasNext()) 
                {
                    Row row = rowIterator.next();
                     Iterator<Cell> cellIterator = row.cellIterator(); 
                     Cell cell = cellIterator.next();
                     switch (cell.getCellType()) 
                    {
                        case Cell.CELL_TYPE_NUMERIC:
                           
                            x =cell.getNumericCellValue();
                        
                        a= String.valueOf(x);
                            break;
                        case Cell.CELL_TYPE_STRING:
                            a=cell.getStringCellValue();
                           break;
                           
                        default:
                               a=cell.getStringCellValue();  
                   }
                %>
                 <option name="<%=a%>"><% out.println(a); %></option>
                 <%}%>
                </select>
                
                 <%--FOR Insulation/Jacket--%>
               <br>Insulation/Jacket: <select name='Insulation or Jacket'>
                <% sheet = workbook.getSheetAt(2);
                rowIterator = sheet.iterator();
                while (rowIterator.hasNext()) 
                {
                    Row row = rowIterator.next();
                     Iterator<Cell> cellIterator = row.cellIterator(); 
                     Cell cell = cellIterator.next();
                     switch (cell.getCellType()) 
                    {
                        case Cell.CELL_TYPE_NUMERIC:
                           
                            x =cell.getNumericCellValue();
                        
                        a= String.valueOf(x);
                            break;
                        case Cell.CELL_TYPE_STRING:
                            a=cell.getStringCellValue();
                           break;
                           
                        default:
                               a=cell.getStringCellValue();  
                   }
                %>
                 <option name="<%=a%>"><% out.println(a); %></option>
                 <%}%>
                </select>
                
                 <%--FOR Insulation Color--%>
               <br>Insulation Color: <select name='Insulation Color'>
                <% sheet = workbook.getSheetAt(3);
                rowIterator = sheet.iterator();
                while (rowIterator.hasNext()) 
                {
                    Row row = rowIterator.next();
                     Iterator<Cell> cellIterator = row.cellIterator(); 
                     Cell cell = cellIterator.next();
                     switch (cell.getCellType()) 
                    {
                        case Cell.CELL_TYPE_NUMERIC:
                           
                            x =cell.getNumericCellValue();
                        
                        a= String.valueOf(x);
                            break;
                        case Cell.CELL_TYPE_STRING:
                            a=cell.getStringCellValue();
                           break;
                           
                        default:
                               a=cell.getStringCellValue();  
                   }
                %>
                 <option name="<%=a%>"><% out.println(a); %></option>
                 <%}%>
                </select>
                
                 <%--FOR Shield--%>
               <br>Shield: <select name='Shield'>
                <% sheet = workbook.getSheetAt(4);
                rowIterator = sheet.iterator();
                while (rowIterator.hasNext()) 
                {
                    Row row = rowIterator.next();
                     Iterator<Cell> cellIterator = row.cellIterator(); 
                     Cell cell = cellIterator.next();
                     switch (cell.getCellType()) 
                    {
                        case Cell.CELL_TYPE_NUMERIC:
                           
                            x =cell.getNumericCellValue();
                        
                        a= String.valueOf(x);
                            break;
                        case Cell.CELL_TYPE_STRING:
                            a=cell.getStringCellValue();
                           break;
                           
                        default:
                               a=cell.getStringCellValue();  
                   }
                %>
                 <option name="<%=a%>"><% out.println(a); %></option>
                 <%}%>
                </select>
                
                 <%--FOR No. Of Triads--%>
               <br>Number of Triads: <select name='Triads'>
                <% sheet = workbook.getSheetAt(5);
                rowIterator = sheet.iterator();
                while (rowIterator.hasNext()) 
                {
                    Row row = rowIterator.next();
                     Iterator<Cell> cellIterator = row.cellIterator(); 
                     Cell cell = cellIterator.next();
                     switch (cell.getCellType()) 
                    {
                        case Cell.CELL_TYPE_NUMERIC:
                           
                            x =cell.getNumericCellValue();
                        
                        a= String.valueOf(x);
                            break;
                        case Cell.CELL_TYPE_STRING:
                            a=cell.getStringCellValue();
                           break;
                           
                        default:
                               a=cell.getStringCellValue();  
                   }
                %>
                 <option name="<%=a%>"><% out.println(a); %></option>
                 <%}%>
                </select>
                
                 <%--FOR Jacket Color--%>
               <br>Jacket Color: <select name='Jacket Color'>
                <% sheet = workbook.getSheetAt(6);
                rowIterator = sheet.iterator();
                while (rowIterator.hasNext()) 
                {
                    Row row = rowIterator.next();
                     Iterator<Cell> cellIterator = row.cellIterator(); 
                     Cell cell = cellIterator.next();
                     switch (cell.getCellType()) 
                    {
                        case Cell.CELL_TYPE_NUMERIC:
                           
                            x =cell.getNumericCellValue();
                        
                        a= String.valueOf(x);
                            break;
                        case Cell.CELL_TYPE_STRING:
                            a=cell.getStringCellValue();
                           break;
                           
                        default:
                               a=cell.getStringCellValue();  
                   }
                %>
                 <option name="<%=a%>"><% out.println(a); %></option>
                 <%}%>
                </select>
                    
                
                    <br><input type="submit" value="Find Code">
        </form>
                </td>
                        
           </tr>
		   <tr  style="background-color:#012169;height:20%">
                <td colspan="3">
			</td>
			</tr>
		    </table>
    </body>
</html>
                
            
                        