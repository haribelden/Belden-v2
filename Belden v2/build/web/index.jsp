<html>
    <head>
        <title>
            Belden-Login
        </title>
        
        
        
        
        <style>
            .box{
                width: 350px;
                padding: 45px;
                height: 40%;
                margin: 0 auto;
                background-color:#01277A;
                box-shadow: 10px 10px 5px #888888;
            }
            .labelss{
                float:left;
                margin-top: 35px;
                margin-left: 20px;
            }
            .details{
                text-align: center;
                font-family: sans-serif;
                float:right;
                margin-top: -90px;
                font-size: 15px;
            }
            
            .click{
               font-family: Tenor Sans; 
               margin-left: 80px;
               }
            
            
            .image{
                height:20%;
                width:100%;
                float:left;
                border-radius: 0px;
            }
            img{
               height:60px;
                width:170px;
                float:left;
                border-radius: 0px; 
                margin-top: -10px;
            }
            label{
                width: 200px;
                padding: 10px 20px;
                border: 1;
                border-radius: 4px;
                font-size: 20px;
                color:white;
                font-family:sans-serif;
                float:left;
            }
            
            input {
                width: 200px;
                padding: 10px 20px;
                border: 1;
                border-radius: 4px;
                background-color: #f1f1f1;
                font-family: sans-serif;
            }
            
        </style>
            
    </head>
    <body>

<div class='box'>
    <div class='image'>
          <img src="C:\Users\belden\Documents\NetBeansProjects\Belden v2\Styling\logo.jpg" alt="Belden logo"/>
    </div>
    <div class='labelss'>
        <label for="uname">Username</label>
        <br>
        <label for="pass">Password</label>
    </div>
    <div class='details'>
        <form action="LoginPage" method="post">
              <input type ="text" name="uname">
              <br><br>
              <input type="password" name="pass">
            
        
    </div>
    
    <div class='click'>
        <br><br><input type="Submit" value="Login">
            
        </form>
    </div>
</div>

    </body>
</html>






