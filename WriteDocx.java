/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pertemuan6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

/**
 *
 * @author WINDOWS 10
 */
public class WriteDocx {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String teks = "ENDAH SRIWAHYUNI";
        
        XWPFDocument dokumen = new XWPFDocument();
        
        String out = "D:\\writerdocx.docx";
        FileOutputStream outdocx = new FileOutputStream(new File(out));
        XWPFParagraph paragraf = dokumen.createParagraph();
        XWPFRun rundocx = paragraf.createRun();
        rundocx.setText(teks);
        
        dokumen.write(outdocx);
        outdocx.close();
        System.out.println("sukses");
        
    }
    
}
