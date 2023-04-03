package com.wei.demo.office;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*********************************
 *   @Author WEIYJ
 *   @Description //TODO
 *   @Data 2023/3/31 15:03
 *   海到尽头天作岸 山登绝顶我为峰
 ********************************/
public class PoiExcel implements IExcelOption {


    @Override
    public List<Map<Integer, Object>> read(String fileName, Option option) throws Exception {
        Workbook workbook=null;
        List<Map<Integer, Object>> map;
        FileInputStream fi = new FileInputStream(fileName);

        if (fileName.indexOf(".xlsx")!=-1){
            workbook = new XSSFWorkbook(fi);
        }else if(fileName.indexOf(".xls")!=-1){
            workbook = new HSSFWorkbook(fi);
        }else{
            throw  new Exception("该文件格式暂不支持");
        }
        map = read(workbook,option);
        fi.close();
        return map;
    }

    @Override
    public List<Map<Integer, Object>> read(Workbook workbook, Option option) {
        List<Map<Integer, Object>> list = new ArrayList<>();
        int numberOfSheets = workbook.getNumberOfSheets();
        for (int i = 0; i <numberOfSheets ; i++) {
            Sheet sheet = workbook.getSheetAt(i);
            int lastRowNum = sheet.getLastRowNum();
            for (int j = option.getStart()-1; j <=lastRowNum ; j++) {
                HashMap<Integer, Object> row = new HashMap<>();
                Row row1 = sheet.getRow(j);
                short lastCellNum = row1.getLastCellNum();
                for (int k = 0; k <lastCellNum ; k++) {
                    row.put(k,row1.getCell(k));
                }
                list.add(row);
            }

        }
        return list;
    }

    @Override
    public void write(String file, Map<Object, Object> data) {

    }

    public static void main(String[] args) {
        Option option = new Option(1);
        option.add(1,Integer.class);
        String file ="C:\\Users\\weiyongjian\\Desktop\\work.xlsx";
        PoiExcel poiExcel = new PoiExcel();
        try {
            List<Map<Integer, Object>> read = poiExcel.read(file, option);
            System.out.println(read);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
