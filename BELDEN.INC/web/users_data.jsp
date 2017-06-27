
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ListIterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="User_Bean.Users"%>
<%@page import="org.hibernate.Query"%>
<%@page import="org.hibernate.criterion.Projections"%>
<%@ page import="org.hibernate.Session;" %>
<%@ page import="org.hibernate.SessionFactory;" %>
<%@ page import="org.hibernate.cfg.Configuration;" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Belden-User Details</title>
    </head>
    <body>
        <table style="border:1;width:100%;height:100%">
            <tr  style="background-color:#012169;height:20%">
                <td colspan="3">
 <img src="../Resources/Styling/belden.jpg" alt="Belden-Logo" style="height:80px;width=5px;float:right"/>
                </td>
			</tr>
            <tr>
                 
                <td style="width:60%;text-align:center;font-size:18px">
                    <h1>User-Details</h1>
        <form action="RemoveUserPage">  
            <table cellpadding="5px" style="padding-left:370px">
                <tr>
                    <td><b>Button</b></td>
                    <td><b>S.No.</b> </td>
                    <td><b>First Name</b>  </td>
                    <td><b>Last Name </b></td>
                    <td><b>Username </b></td>
                    <td><b>Password </b></td>
                    <td><b>User Type </b></td>
                </tr>   
        <%  Configuration cfg = new Configuration();
            cfg.configure("hibernate.cfg.xml");
            SessionFactory sf = cfg.buildSessionFactory();
            Users st=new Users();
            Session s = sf.openSession();
            
         List<Users> list = new ArrayList<Users>();
            Query q = s.createQuery("FROM Users");
            list = q.list();
           ListIterator<Users> itr=list.listIterator();
            while(itr.hasNext())
                {
                    st=(Users)itr.next();
                  
            %>
            <tr>
                <td><input type="radio" name="set" value="<%=st.getSno()%>"></td>
                <td><%=st.getSno()%></td>
                <td><%=st.getFname()%></td>
                <td><%=st.getLname()%></td>
                <td><%=st.getUname()%></td>
                <td><%=st.getPass()%></td>
                <td><%=st.getUtype()%></td>
            </tr>
            <%}%>
    
            </table> 
            <br><input type="submit" name="selection" value="Delete">
            <input type="submit" name="selection" value="Modify">
            <input type="submit" name="selection" value="Add-User">
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
