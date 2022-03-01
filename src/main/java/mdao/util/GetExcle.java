package mdao.util;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;

import java.util.ArrayList;
import java.util.List;

public class GetExcle {
    public static List<String> getExcle(String url) {
        ExcelReader reader = ExcelUtil.getReader(url);
        List<List<Object>> readAll = reader.read();
        List<String> lstMo = new ArrayList<>();
        for (List<Object> o : readAll
        ) {
            lstMo.add(o.get(0).toString());
        }
        return lstMo;
    }
    public static void main(String[] args) {
        List<String> list=getExcle("D:\\test.xlsx");
        for ( String s:list
             ) {
            System.out.println(s);
        }
    }
}
