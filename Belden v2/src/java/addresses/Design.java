/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addresses;

/**
 *
 * @author belden
 */
public class Design {
    
    public String top(){
    return "<html>\n" +
"    <head>\n" +
"    \n" +
"        \n" +
"        <title>Belden.INC</title>\n" +
"    </head>\n" +
"    <body style=\"background-color:#ccccff;\">\n" +
"         <div style=\"height:80px;width:100%;background-color:#01277A;vertical-align: top;padding-top: 0px;clear: both;border-radius: 25px 25px 0px 0px;\">\n" +
"          <img src=\"C:\\Users\\belden\\Documents\\NetBeansProjects\\Belden v2\\Styling\\logo.jpg\" alt=\"Belden logo\" style=\" height:80px;width=5px;float:right;border-radius: 25px;\"/>\n" +
"            <h1 style=\"color: white; text-align: left; font-size: 30px;font-family: Arial; text-indent: 50px;padding-top: 20px;\">Resource Centre</h1> \n" +
"        </div>";
    }
    
    
    public String bottom(){
    return "</div>\n" +
"\n" +
"<div style=\"height:80px;background-color:#01277A;float:bottom;border-radius: 0px 0px 25px 25px;\">\n" +
"\n" +
"                    <a href=\"https://twitter.com/beldeninc\">\n" +
"                    <img src=\"C:\\Users\\belden\\Documents\\NetBeansProjects\\Belden v2\\Styling\\twitterlogo.png\" alt=\"\" style=\" height:35px;width=35px;float:right; margin-right: 30px;margin-top: 20px;\"/>\n" +
"                    </a>\n" +
"    <a href=\"http://beldenapac.com/about-belden/company/contact-us\" style=\"float:left; margin-left: 50%;margin-top: 30px;color:grey;\">Contact Us</a>\n" +
"    <a href=\"http://beldenapac.com/terms-conditions\" style=\"float:left; margin-left: 60%;margin-top: -18px;color:grey;\">Terms & Conditions</a>\n" +
"    \n" +
"				</td>\n" +
"			\n" +
"		   \n" +
"                 \n" +
"</div>\n" +
"\n" +
"            \n" +
"                \n" +
"    </body>\n" +
"</html>";
    }
    
    
    public String side(){
        return "\n" +
"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
"<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n" +
"<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n" +
"\n" +
"\n" +
"<div class=\"w3-sidebar w3-bar-block w3-light-grey w3-card-2\" style=\"width:15%; height:72%;border-radius:2;border:1;\">\n" +
"  <a href=\"/Belden_v2/home_page_dec.jsp\" class=\"w3-bar-item w3-button\">Home Menu </a>\n" +
"   \n" +
"  <div class=\"w3-dropdown-hover\">\n" +
"    <button class=\"w3-button\">Part Code Generator\n" +
"      <i class=\"fa fa-caret-down\"></i>\n" +
"    </button>\n" +
"    <div class=\"w3-dropdown-content w3-bar-block\">\n" +
"      <a href=\"#\" class=\"w3-bar-item w3-button\">C&I EN50288-7</a>\n" +
"      <a href=\"#\" class=\"w3-bar-item w3-button\">C&I IEC60502-1</a>\n" +
"      <a href=\"#\" class=\"w3-bar-item w3-button\">Fire Survival EN50288-7</a>\n" +
"      <a href=\"#\" class=\"w3-bar-item w3-button\">Fire Survival IEC60502-1</a>\n" +
"      <a href=\"#\" class=\"w3-bar-item w3-button\">Fire Survival Marine</a>\n" +
"      <a href=\"#\" class=\"w3-bar-item w3-button\">PLTC</a>\n" +
"      <a href=\"#\" class=\"w3-bar-item w3-button\">Marine</a>\n" +
"      \n" +
"    </div>\n" +
"  </div> \n" +
"  <a href=\"/Belden_v2/PartCodeDescriptor.jsp\" class=\"w3-bar-item w3-button\">Part Code Descriptor</a>\n" +
"  <a href=\"/Belden_v2/DataPool.jsp\" class=\"w3-bar-item w3-button\">Data Pool</a>\n" +
"  <a href=\"/Belden_v2/LogoutPage\" class=\"w3-bar-item w3-button\">Logout</a>\n" +
"</div>\n" +
"";
    }
            
}
