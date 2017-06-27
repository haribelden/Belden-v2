
<style>
#mySidenav a {
    position: absolute;
    margin-top: 150px;
    left: -100px;
    transition: 0.3s;
    padding: 10px;
    width: 100px;
    text-decoration: none;
    font-size: 20px;
    color: white;
    border-radius: 0 5px 5px 0;
}

#mySidenav a:hover {
    left: 0;
}


#Home {
    top: 20px;
    background-color: #00ff00;
}

#PartCodeGenerator {
    top: 80px;
    background-color: #2196F3;
}

#PartCodeDescriptor {
    top: 140px;
    background-color: #f44336;
}

#UploadFiles {
    top: 200px;
    background-color: #555
}
#UserDetails {
    top: 260px;
    background-color: #4CAF50;
}

</style>


<div id="mySidenav" class="sidenav">
  <a href="home_page_dec.jsp" id="Home">Home Menu </a>
  <a href="BasicDetails.jsp" id="PartCodeGenerator">Part Code Generator</a>
  <a href="PartCodeDescriptor.jsp" id="PartCodeDescriptor">Part Code Descriptor</a>
 
</div>


     
