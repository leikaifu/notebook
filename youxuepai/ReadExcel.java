package com.youxuepai;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ReadExcel {
//    public static void main(String[] args) {
//        ReadExcel obj = new ReadExcel();
//        // 此处为我创建Excel路径：E:/zhanhj/studysrc/jxl下
//        File file = new File("D:\\javaproject\\usre.xls");
//        int titlenumber=0;
//        List excelList = obj.readExcel(file,titlenumber);
//        System.out.println("list中的数据打印出来");
//        System.out.println(excelList);
//        System.out.println(excelList.size());
//        for (int m=0;m<excelList.size();m++){
//            Map value= (Map) excelList.get(m );
//            for(Object ob:value.keySet()){
//                System.out.println(value.get(ob));
//            }
//
//            System.out.println("--------------------------");
//        }


//    }

    /**
     *
     * @param file   文件对象
     * @param titleRowindex  标题是从第几行开始类型int
     * @return
     */
    // 去读Excel的方法readExcel，该方法的入口参数为一个File对象
    public List readExcel(File file,int titleRowindex) {
        try {
            // 创建输入流，读取Excel
            POIFSFileSystem is=new POIFSFileSystem(file.getAbsoluteFile());
            // jxl提供的Workbook类
            HSSFWorkbook wb=new HSSFWorkbook(is);
            // Excel的页签数量
            int sheet_size = wb.getNumberOfSheets();
            for (int index = 0; index < sheet_size; index++) {
                List<Map<String,Object>> outerList= new ArrayList<Map<String, Object>>();
                // 每个页签创建一个Sheet对象
                HSSFSheet sheet = wb.getSheetAt(index);
                // sheet.getRows()返回该页的总行数
                String[] titles = new String[0];
                HSSFRow titleRow=null;
                int lastCellNum = 0;
                //行数
                for (int i = titleRowindex; i < sheet.getLastRowNum(); i++) {
                    Map innermap=new LinkedHashMap();
                    if (i==titleRowindex){
                        titleRow=sheet.getRow(titleRowindex);
                        lastCellNum=titleRow.getLastCellNum();
                        titles=new String[lastCellNum];
                    }
                    Row dataRow = sheet.getRow(i + 1);
                    //列数
                    for (int j = 0; j < lastCellNum; j++) {
                        if (i==titleRowindex){
                            titles[j]=titleRow.getCell(j).getStringCellValue();
                        }
                        innermap.put(titles[j],dataRow.getCell(j));
                    }
                    outerList.add(innermap);
                }
                return outerList;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
