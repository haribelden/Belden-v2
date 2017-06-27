
import addresses.Saving;


import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author belden
 */
public class NewClass {
    public static void main(String ar[]) throws IOException{
        Saving saving = new Saving();
        String def = "HARI";
        String source = saving.top;
            String destination = saving.resource+def+".xlsx";
            File sourcefile = new File(source);
            File targetfile = new File(destination);
            FileUtils.copyFile(sourcefile, targetfile);
    }
}
