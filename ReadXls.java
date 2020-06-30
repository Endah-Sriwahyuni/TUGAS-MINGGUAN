/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pertemuan7;

import com.sun.rowset.internal.Row;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.scene.control.Cell;
import org.apache.poi.hssf.usermodel.HSSFCreationHelper;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.FormulaEvaluator;

/**
 *
 * @author WINDOWS 10
 */
public class ReadXls {
    public static void main(String[] args) throws IOException {
         readFromXls("D://readxls.xls");
    }

    public static void readFromXls(String urlexcel) throws FileNotFoundException, IOException {
        HSSFWorkbook myexcel = new HSSFWorkbook(new FileInputStream(urlexcel));
        HSSFSheet myexcelSheet = myexcel.getSheet("training");
        FormulaEvaluator formulaEv = myexcel.getCreationHelper().createFormulaEvaluator();

        for (org.apache.poi.ss.usermodel.Row row : myexcelSheet) { //FOR EACH, setiap sheet tampilkan row
            for (org.apache.poi.ss.usermodel.Cell cell : row) {     //setiap row tampilkan cell
                switch (formulaEv.evaluateInCell(cell).getCellType()) { //menampilkan sesuai cell type
                    case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC:
                        System.out.print(cell.getNumericCellValue() + "\t\t");
                        break;
                    case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING:
                        System.out.print(cell.getStringCellValue() + "\t\t");
                        break;
                }
            }
            System.out.println("");
            myexcel.close();
        }
    }
}
