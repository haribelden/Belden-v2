<%
    String x="1";
    Cookie ck[]=request.getCookies();  
            for(int i=0;i<ck.length;i++){  
               if(ck[i].getName().equals("usertype"))
                   x=ck[i].getValue();  
                     }
            if(x.equals("0"))
            response.sendRedirect("/Belden_v2/view0.jsp");
            else
            response.sendRedirect("/Belden_v2/view1.jsp");
            %>
