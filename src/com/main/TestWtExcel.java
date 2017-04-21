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

	    * д��07excel

	    * @param filePath

	    */

	   public static void write2007Excel(String filePath,List<String> list) {

	 

	      try {

	         //����excel�ļ�����  

	         XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(filePath));

	          //����һ���ű�  

	         XSSFSheet sheet = wb.getSheetAt(0);

	     

	         //�����ж���

	         XSSFRow row = null;

	         //����������

	         XSSFCell cell = null;

	        

	         //ѭ����

	         for (int i = sheet.getFirstRowNum(); i <= sheet

	               .getPhysicalNumberOfRows(); i++) {

	            row = sheet.getRow(i);

	            if (row == null) {//�ж��Ƿ�Ϊ��

	               continue;

	            }

	            //ѭ����

	            for (int j=0; j<list.size(); j++) {

	               cell = row.createCell(j);//������Ԫ��

	               String m = list.get(j);

	               cell.setCellValue(m);//��ֵ

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

	    * ����03excel

	    * @param filePath

	    */

	   public static void write2003Excel(String filePath,List<String> list) {

	      try {

	         //����excel�ļ�����  

	         HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(filePath));

	          //����һ���ű�  

	         HSSFSheet sheet = wb.getSheetAt(1);

	     

	         //�����ж���

	         HSSFRow row = null;

	         //����������

	         HSSFCell cell = null;

	        

	         //ѭ����

	         for (int i = sheet.getFirstRowNum(); i <= sheet

	               .getPhysicalNumberOfRows(); i++) {

	            row = sheet.getRow(i);

	            if (row == null) {//�ж��Ƿ�Ϊ��

	               continue;

	            }

	            //ѭ����

	            for (int j=0; j<list.size(); j++) {

	               cell = row.createCell(j);//������Ԫ��

	               String m = list.get(j);

	               cell.setCellValue(m);//��ֵ

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

	    * �����ṩ��ȡexcel �ķ���

	    */

	   public static void writeExcel(File file,List<String> mList) throws IOException {

	      String fileName = file.getName();

	      String extension = fileName.lastIndexOf(".") == -1 ? "" : fileName

	            .substring(fileName.lastIndexOf(".") + 1);

	     

	      //�ж��ļ�����

	      if ("xls".equals(extension)) {

	         write2003Excel(file.getPath(),mList);

	      } else if ("xlsx".equals(extension)) {

	         write2007Excel(file.getPath(),mList);

	      } else {

	         throw new IOException("��֧�ֵ��ļ�����");

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
