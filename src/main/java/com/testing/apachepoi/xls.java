package com.testing.apachepoi;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class xls {

    public static void main(String... args) {
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("fonts-example");


        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("XlSX");

        Font font = workbook.createFont();
        font.setTypeOffset(Font.SS_SUPER);

        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setFont(font);
        cell.setCellStyle(cellStyle);

        row = sheet.createRow(1);
        cell = row.createCell(0);
        cell.setCellValue("t1");
        row = sheet.createRow(2);
        cell = row.createCell(0);
        cell.setCellValue("t2");
        row = sheet.createRow(3);
        cell = row.createCell(0);
        cell.setCellValue("t4");
        row = sheet.createRow(4);
        cell = row.createCell(0);
        cell.setCellValue("t5");
        row = sheet.createRow(5);
        cell = row.createCell(0);
        cell.setCellValue("List");
        row = sheet.createRow(6);
        cell = row.createCell(0);
        cell.setCellValue("001");
        row = sheet.createRow(7);
        cell = row.createCell(0);
        cell.setCellValue("string1 t1");
        row = sheet.createRow(8);
        cell = row.createCell(0);
        cell.setCellValue("string1 t2");
        row = sheet.createRow(9);
        cell = row.createCell(0);
        cell.setCellValue("string1 t3");
        font = workbook.createFont();
        cell.setCellValue("002");
        row = sheet.createRow(10);
        cell = row.createCell(0);
        cell.setCellValue("string2 t1");
        row = sheet.createRow(11);
        cell = row.createCell(0);
        cell.setCellValue("string2 t2");
        row = sheet.createRow(12);
        cell = row.createCell(0);
        cell.setCellValue("string2 t3");
        font = workbook.createFont();
        font.setTypeOffset(Font.SS_SUB);

        cellStyle = workbook.createCellStyle();
        cellStyle.setFont(font);
        cell.setCellStyle(cellStyle);

        try (OutputStream fileOut = new FileOutputStream("createxlsx.xls")) {
            workbook.write(fileOut);
            workbook.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}