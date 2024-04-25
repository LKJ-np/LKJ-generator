import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @Description: FreeMaker学习测试 demo
 * @Author：LKJ
 * @Package：PACKAGE_NAME
 * @Project：LKJ-generator
 * @name：FreeMakerTest
 * @Date：2024/4/25 15:38
 * @Filename：FreeMakerTest
 */
public class FreeMakerTest {

    @Test
    public void FreeMakerTest() throws IOException, TemplateException {
        //创建出实例，并指定版本
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);

        //指定模板FTL文件地址
        configuration.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));

        //设置编码格式
        configuration.setDefaultEncoding("UTF-8");
        configuration.setNumberFormat("0.######");


        Template template = configuration.getTemplate("myweb.html.ftl");


        Map<String,Object> dataModel = new HashMap<>();
        dataModel.put("currentYear",2024);
        List<Map<String,Object>> menuItems = new ArrayList<>();
        Map<String,Object> menuItems1 = new HashMap<>();
        menuItems1.put("url","http....");
        menuItems1.put("lable","官网1");

        Map<String,Object> menuItems2 = new HashMap<>();
        menuItems2.put("url","https....");
        menuItems2.put("lable","官网2");


        menuItems.add(menuItems1);
        menuItems.add(menuItems2);

        dataModel.put("menuItems",menuItems);

        FileWriter out = new FileWriter("myweb.html");
        template.process(dataModel,out);

        out.close();
    }
}
