/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileWriter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import addresses.Saving;

/**
 *
 * @author belden
 */
public class PartCode {
    String cabletype;
    String conductor;
    String insulation_or_jacket;
    String insulation_color;
    String shield;
    String number_of_cpt;//Number of Cores, Pairs, or Triads
    String jacket_color;
    String description;
    String username;
    static int count=0;
      
public String Insert(){
    
    File f = null;
    Random r= new Random();
    String filepath = null;
    String filename=String.valueOf(r.nextInt(50));
     XSSFWorkbook workbook = new XSSFWorkbook();

     
    //Create a blank sheet
    XSSFSheet sheet = workbook.createSheet();

    //This data needs to be written (Object[])
    Map<String, Object[]> data = new TreeMap<String, Object[]>();
    data.put("1", new Object[]{"Category","PartCode", "Description", "Deviation"});
    //data.put("2", new Object[]{code, description});
    //i removed 1,

    //Iterate over data and write to sheet
    Set<String> keyset = data.keySet();

    int rownum = 0;
    for (String key : keyset) 
    {
        //create a row of excelsheet
        Row row = sheet.createRow(rownum++);

        //get object array of prerticuler key
        Object[] objArr = data.get(key);

        int cellnum = 0;

        for (Object obj : objArr) 
        {
            Cell cell = row.createCell(cellnum++);
            if (obj instanceof String) 
            {
                cell.setCellValue((String) obj);
            }
            else if (obj instanceof Integer) 
            {
                cell.setCellValue((Integer) obj);
            }
        }
    }
    try 
    {  filepath="C:\\Users\\belden\\Documents\\NetBeansProjects\\Belden v2\\Excel Sheets\\user\\"+filename+".xlsx";
        f=new File(filepath);
        try ( //Write the workbook in file system
                FileOutputStream out1 = new FileOutputStream(f)) {
            workbook.write(out1);
        }
        System.out.println("temp created");
        
        return filename;
    } 
    catch (IOException e)
    {
    }
    return filename;
}
	public void updateToFile(String filename,String code,String description,String category, String deviation) throws FileNotFoundException, IOException{
            Saving saving =new Saving();
            System.out.println(filename);
            String filepath = saving.temp+filename+".xlsx";
            FileInputStream file = new FileInputStream(new File(filepath));
     XSSFWorkbook workbook = new XSSFWorkbook(file);

    //Create a blank sheet
    XSSFSheet sheet = workbook.getSheetAt(0);

    //This data needs to be written (Object[])
    Map<String, Object[]> data = new TreeMap<String, Object[]>();
    
    data.put("1", new Object[]{category,code, description,deviation});
    //i removed 1,

    //Iterate over data and write to sheet
    Set<String> keyset = data.keySet();

    int rownum = sheet.getLastRowNum();
    rownum++;
    for (String key : keyset) 
    {
        //create a row of excelsheet
        Row row = sheet.createRow(rownum++);

        //get object array of prerticuler key
        Object[] objArr = data.get(key);

        int cellnum = 0;

        for (Object obj : objArr) 
        {
            Cell cell = row.createCell(cellnum++);
            if (obj instanceof String) 
            {
                cell.setCellValue((String) obj);
            }
            else if (obj instanceof Integer) 
            {
                cell.setCellValue((Integer) obj);
            }
        }
    }
    try 
    {  file.close();
 
            FileOutputStream outputStream = new FileOutputStream(filepath);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
        
    } 
    catch (Exception e)
    {
        e.printStackTrace();
    }
    }
 
        
	
    public String getCompletePC() throws IOException{
        String c= cabletype+conductor+insulation_or_jacket+insulation_color+shield+number_of_cpt+jacket_color;
        return c;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getCabletype() {
        return cabletype;
    }

    public void setCabletype(String cabletype) {
        this.cabletype = cabletype;
    }

    public String getConductor() {
        return conductor;
    }

    public void setConductor(String conductor) {
        this.conductor = conductor;
    }

    public String getInsulation_or_jacket() {
        return insulation_or_jacket;
    }

    public void setInsulation_or_jacket(String insulation_or_jacket) {
        this.insulation_or_jacket = insulation_or_jacket;
    }

    public String getInsulation_color() {
        return insulation_color;
    }

    public void setInsulation_color(String insulation_color) {
        this.insulation_color = insulation_color;
    }

    public String getShield() {
        return shield;
    }

    public void setShield(String shield) {
        this.shield = shield;
    }

    public String getNumber_of_cpt() {
        return number_of_cpt;
    }

    public void setNumber_of_cpt(String number_of_cpt) {
        this.number_of_cpt = number_of_cpt;
    }

    public String getJacket_color() {
        return jacket_color;
    }

    public void setJacket_color(String jacket_color) {
        this.jacket_color = jacket_color;
    }
    
    
}
