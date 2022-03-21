import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import dao.UserDao;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import pojo.Emp;
import pojo.User;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class test {

    static String PATH = "G:\\JavaSpace\\Java进阶\\easypoi\\";

    @Test
    public void test() throws IOException {
        List<User> list = new UserDao().getUserList();
        // 1.配置对象
        ExportParams params = new ExportParams("用户列表", "用户");
        // 2.创建工作簿
        Workbook workbook = ExcelExportUtil.exportExcel(params, User.class, list);
        // 3.导出工作簿
        FileOutputStream fos = new FileOutputStream(PATH + "a.xls");
        workbook.write(fos);
        fos.close();

        System.out.println("操作成功");
    }

    // 大数据量导出
    @Test
    public void bigDataExport() throws Exception {
        List<User> bigList = new UserDao().getBigList();
        List<User> list = new ArrayList<>();

        long star = System.currentTimeMillis();
        // 工作簿
        Workbook workbook = null;
        // 配置对象
        ExportParams params = new ExportParams("大数据测试", "测试");
        // 创建工作表
        for (int i = 0; i < bigList.size(); i++) {
            list.add(bigList.get(i));
            if(list.size() == 10000){
                workbook = ExcelExportUtil.exportBigExcel(params, User.class, list);
                list.clear();
            }
        }
        FileOutputStream fos = new FileOutputStream(PATH + "b.xlsx");
        workbook.write(fos);
        fos.close();

        long end = System.currentTimeMillis();

        System.out.println("操作成功");
        System.out.println(end - star);
    }

    @Test
    public void testImport() throws Exception {
        FileInputStream fis = new FileInputStream(PATH + "c.xls");

        ImportParams params = new ImportParams();
        params.setTitleRows(1);
        params.setHeadRows(1);

        List<Emp> list = ExcelImportUtil.importExcel(fis, Emp.class, params);

        for (Emp emp : list) {
            System.out.println(emp.toString());
        }

        fis.close();
        System.out.println("操作成功");
    }
}