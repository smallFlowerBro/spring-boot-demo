package com.wei.demo.office;

import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/*********************************
 *   @Author WEIYJ
 *   @Description //TODO
 *   @Data 2023/3/31 14:59
 *   海到尽头天作岸 山登绝顶我为峰
 ********************************/
public interface IExcelOption {

    List<Map<Integer, Object>> read(String fileName, Option option) throws Exception;

    List<Map<Integer, Object>> read(Workbook workbook, Option option);

    void write(String file,Map<Object,Object> data);
}
