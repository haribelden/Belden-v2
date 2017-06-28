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

<%@include file="../top.jsp" %>
 <%@include file= "../pane_pc.jsp" %>
       
<div style="height:450px;text-align:left;vertical-align: middle;font-size:18px;font-family: Arial;padding-left: 100px;">
    <style>
        input[value="Generate Code"] {
    background-color:#012169;
    border-radius: 4px;
    border:1;
    border-color: black;
    color: white;
    padding: 10px 20px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 15px;
    margin-top: 20px;
    
    
   
}
label{
    width: 200px;
    padding: 10px 20px;
    border: 1;
    border-radius: 4px;
    font-size: 20px;
    font-family:HelveticaNeueBold;
}


    select {
    width: 200px;
    padding: 10px 20px;
    border: 1;
    border-radius: 4px;
    background-color: #f1f1f1;
    font-family: Arial;
   
   
    
}
</style>

<div style="width: 20%; float:left; margin-left: 20px;text-align:left;">
    <br>
    <label for='Cable type'>Cable Type</label><br><br>
    <label for='Conductor'>Conductor</label><br><br>
    <label for='Insulation or Jacket'>Insulation /Jacket</label><br><br>
    <label for='Insulation Color'>Insulation Color</label><br><br>
    <label for='Shield'>Shield</label><br><br>
    <label for='Triads'>No of. Triads</label><br><br>
    <label for='Jacket Color'>Jacket Color</label><br><br>
</div>
<div style="width: 40%; float:left; margin-left: 20px;">
        <%
            Control_And_Instrumentation addr = new Control_And_Instrumentation();
     FileInputStream file = new FileInputStream(new File(addr.MT6or10));
                XSSFWorkbook workbook = new XSSFWorkbook(file);
                String a; double x;
        %>
              <form action='../CI_MT_6or10'>
                <%--FOR CABLETYPE--%>
                <br><select name='Cable type'>
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
               <br><select name='Conductor'>
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
               <br><select name='Insulation or Jacket'>
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
               <br><select name='Insulation Color'>
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
               <br><select name='Shield'>
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
               <br><select name='Triads'>
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
               <br><select name='Jacket Color'>
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
                    
                
                    <br><input type="submit" value="Generate Code">
                    </div>
                <div style="width: 30%; float:left; margin-left: 20px;text-align:right;color:red;">
                    
                </div> 
          <%@include file="../bottom.jsp" %>