import addresses.Saving;
import java.io.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
  
public class DownloadFile extends HttpServlet {  
  
public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  Saving s = new Saving();
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  

String filename = Saving.filename+".xlsx";   
String filepath =  s.resource;
response.setContentType("APPLICATION/OCTET-STREAM");   
response.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\"");   
  
FileInputStream fileInputStream = new FileInputStream(filepath + filename);  
            
int i;   
while ((i=fileInputStream.read()) != -1) {  
out.write(i);   
}   
fileInputStream.close();   
out.close();   
}  
  
}  