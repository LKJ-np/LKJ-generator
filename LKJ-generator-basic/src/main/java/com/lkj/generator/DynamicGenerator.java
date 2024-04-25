package com.lkj.generator;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IORuntimeException;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.db.DaoTemplate;
import com.lkj.generatorDao.DynamicTemplate;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;

/**
 * @Description:动态文件生成
 * @Author：LKJ
 * @Package：com.lkj.generator
 * @Project：LKJ-generator-basic
 * @name：StaticGenerator
 * @Date：2024/4/19 15:16
 * @Filename：StaticGenerator
 */
public class DynamicGenerator {
    public static void main(String[] args) throws TemplateException, IOException {
        String propertyPath = System.getProperty("user.dir");
        System.out.println(propertyPath);

        String inputPath = propertyPath + File.separator + "LKJ-generator-basic" + File.separator + "src/main/resources/templates/ACMTemplete.java.ftl";
        String outputPath = propertyPath + File.separator + "LKJ-generator-basic" + File.separator + "ACMTemplate.java";

        //创建数据模型
        DynamicTemplate dynamicdao = new DynamicTemplate();
        dynamicdao.setAuthor("lkj");
        dynamicdao.setLoop(true);
        dynamicdao.setOutputText("输出结果为");


        Dynamic(inputPath,outputPath,dynamicdao);
    }

    public static void Dynamic(String inputPath,String outputPath,Object model) throws IOException, TemplateException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_32);

        //指定模板的路径
        File Templatepath = new File(inputPath).getParentFile();
        System.out.println(Templatepath);
        cfg.setDirectoryForTemplateLoading(Templatepath);

        cfg.setDefaultEncoding("UTF-8");
        //创建模板对象,加载指定模板
        String templateName = new File(inputPath).getName();
        Template template = cfg.getTemplate(templateName);



        Writer out = new FileWriter(outputPath);
        template.process(model,out);
        out.close();
    }
}
