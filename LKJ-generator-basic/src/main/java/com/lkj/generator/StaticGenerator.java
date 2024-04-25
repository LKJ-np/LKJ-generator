package com.lkj.generator;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IORuntimeException;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ArrayUtil;

import java.io.File;
import java.io.IOException;

/**
 * @Description:静态文件生成
 * @Author：LKJ
 * @Package：com.lkj.generator
 * @Project：LKJ-generator-basic
 * @name：StaticGenerator
 * @Date：2024/4/19 15:16
 * @Filename：StaticGenerator
 */
public class StaticGenerator {
    public static void main(String[] args) {
        //获取整个项目的根路径
        String paraentPath = System.getProperty("user.dir");
        System.out.println(paraentPath);
        //输入路径
        String inputPath = new File(paraentPath, "LKJ-generator-demo-projects/acm-template").getAbsolutePath();
        //输出路径
        String outputPath = paraentPath;
        //方法一：使用HuTool工具类
        copyFileByHutool(inputPath,outputPath);
        //方法二：使用递归遍历
        copyFileByRecur(inputPath,outputPath);
    }

    /**
     * 复制文件(使用HuTool工具类)
     * @param inputPath 输入路径
     * @param outputPath 输出路径
     */
    public static void copyFileByHutool(String inputPath,String outputPath){
        FileUtil.copy(inputPath,outputPath,false);
    }

    public static void copyFileByRecur(String inputPath,String outputPath){
        File inputFile = new File(inputPath);
        File outputFile = new File(outputPath);
        try {
            copyFileDigui(inputFile,outputFile);
        } catch (IOException e) {
            System.out.println("复制失败");
            throw new RuntimeException(e);
        }
    }

    /**
     * 递归实现拷贝文件
     * @param src 原文件
     * @param dest  目标文件
     */
    public static void copyFileDigui(File src,File dest) throws IOException {

        //检查原文件是否为空
        Assert.notNull(src,"Source File is Null !");
        //原文件是否存在
        if (false == src.exists()){
            throw new IORuntimeException("File not exist: " + src);
        }
        //原文件与目的文件是否相等
        if (FileUtil.equals(src,dest)){
            throw new IORuntimeException("Files '{}' and '{}' are equal", src, dest);
        }

        if (src.isDirectory()) {//复制目录
            System.out.println(src.getName());
            File destName = new File(dest, src.getName());
            if (!destName.exists()) {
                destName.mkdirs();
            }
            //获取目录下的所有文件和子目录
            File[] files = src.listFiles();
            //如果无子文件，直接结束
            if (ArrayUtil.isEmpty(files)) {
                return;
            }
            for (File file : files) {
                copyFileDigui(file, destName);
            }
        }else {
            FileUtil.copy(src,dest,false);
        }


    }
}
