package com.main;
import java.io.File;

import java.io.FileInputStream;

import java.io.FileOutputStream;

import java.io.IOException;

import java.util.LinkedList;

import java.util.List;

 

import org.apache.poi.hssf.usermodel.HSSFCell;

import org.apache.poi.hssf.usermodel.HSSFRow;

import org.apache.poi.hssf.usermodel.HSSFSheet;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.xssf.usermodel.XSSFCell;

import org.apache.poi.xssf.usermodel.XSSFRow;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class TestWtExcel {
	 /**

	    * 写入07excel

	    * @param filePath

	    */

	   public static void write2007Excel(String filePath,List<String> list) {

	 

	      try {

	         //创建excel文件对象  

	         XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(filePath));

	          //创建一个张表  

	         XSSFSheet sheet = wb.getSheetAt(0);

	     

	         //创建行对象

	         XSSFRow row = null;

	         //创建表格对象

	         XSSFCell cell = null;

	        

	         //循环行

	         for (int i = sheet.getFirstRowNum(); i <= sheet

	               .getPhysicalNumberOfRows(); i++) {

	            row = sheet.getRow(i);

	            if (row == null) {//判断是否为空

	               continue;

	            }

	            //循环列

	            for (int j=0; j<list.size(); j++) {

	               cell = row.createCell(j);//创建单元格

	               String m = list.get(j);

	               cell.setCellValue(m);//赋值

	            }

	           

	         }

	         FileOutputStream out = new FileOutputStream(filePath);

	         wb.write(out);

	         out.close();

	      } catch (Exception e) {

	         e.printStackTrace();

	      }

	   }

	  

	   /**

	    * 寫入03excel

	    * @param filePath

	    */

	   public static void write2003Excel(String filePath,List<String> list) {

	      try {

	         //创建excel文件对象  

	         HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(filePath));

	          //创建一个张表  

	         HSSFSheet sheet = wb.getSheetAt(1);

	     

	         //创建行对象

	         HSSFRow row = null;

	         //创建表格对象

	         HSSFCell cell = null;

	        

	         //循环行

	         for (int i = sheet.getFirstRowNum(); i <= sheet

	               .getPhysicalNumberOfRows(); i++) {

	            row = sheet.getRow(i);

	            if (row == null) {//判断是否为空

	               continue;

	            }

	            //循环列

	            for (int j=0; j<list.size(); j++) {

	               cell = row.createCell(j);//创建单元格

	               String m = list.get(j);

	               cell.setCellValue(m);//赋值

	            }

	           

	         }

	         FileOutputStream out = new FileOutputStream(filePath);

	         wb.write(out);

	         out.close();

	      } catch (Exception e) {

	         e.printStackTrace();

	      }

	   }

	  

	 

	   /**

	    * 对外提供读取excel 的方法

	    */

	   public static void writeExcel(File file,List<String> mList) throws IOException {

	      String fileName = file.getName();

	      String extension = fileName.lastIndexOf(".") == -1 ? "" : fileName

	            .substring(fileName.lastIndexOf(".") + 1);

	     

	      //判断文件类型

	      if ("xls".equals(extension)) {

	         write2003Excel(file.getPath(),mList);

	      } else if ("xlsx".equals(extension)) {

	         write2007Excel(file.getPath(),mList);

	      } else {

	         throw new IOException("不支持的文件类型");

	      }

	   }
	   public static void main(String[] args) throws IOException{

		      List<String> mList = new LinkedList<String>();

		      mList.add("aa");

		      mList.add("bb");

		      mList.add("cc");

		      mList.add("dd");

		      mList.add("ee");

		      writeExcel(new File("F:/a.xls"),mList);

		   }
}
