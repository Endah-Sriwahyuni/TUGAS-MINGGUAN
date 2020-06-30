/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pertemuan6;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author WINDOWS 10
 */
public class ReadDocx {
    public static void main(String[] args) throws FileNotFoundException, IOException, ParserConfigurationException, SAXException {
        File filenya = new File("D:\\readdocx.docx");
        FileInputStream file = new FileInputStream(filenya.getPath());
        ZipInputStream docx = new ZipInputStream(file);
        ZipEntry zipE;
        ZipEntry ZipEntry;
        OutputStream out;
        String xml = "";
        while ((ZipEntry = docx.getNextEntry()) != null) {
            if (ZipEntry.toString().equals("word/document.xml")) {
                byte[] buffer = new byte[1024 * 4];
                long count = 0;
                int n = 0;
                long size = ZipEntry.getSize();
                out = System.out;
                while (-1 != (n = docx.read(buffer)) && count < size){
                xml += new String(buffer, 0, n);
                count += n;
                }
            }
        }
        InputStream is = new ByteArrayInputStream(xml.getBytes("UTF-8"));
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder parser = factory.newDocumentBuilder();
        
        Document dokumen = (Document) parser.parse(is);
        NodeList sections = dokumen.getElementsByTagName("w:t");
        String isidocx = "";
        for (int i = 0; i < sections.getLength();i++){
            isidocx += sections.item(i).getFirstChild().getNodeValue();
            
    }
        System.out.println(isidocx);
}
    
}
