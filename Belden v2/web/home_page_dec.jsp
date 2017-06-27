<%
    String x="1";
    Cookie ck[]=request.getCookies();  
            for(int i=0;i<ck.length;i++){  
               if(ck[i].getName().equals("File"))
                   x=ck[i].getValue();  
                     }
            if(x.equals("0"))
            response.sendRedirect("view0.jsp");
            else
            response.sendRedirect("view1.jsp");
            %>
