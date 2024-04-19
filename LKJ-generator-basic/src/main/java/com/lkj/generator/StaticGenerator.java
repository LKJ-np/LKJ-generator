package com.lkj.generator;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IORuntimeException;
import cn.hutool.core.lang.Assert;

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
        copyFileByHutool(inputPath,outputPath);
    }

    /**
     * 复制文件
     * @param inputPath 输入路径
     * @param outputPath 输出路径
     */
    public static void copyFileByHutool(String inputPath,String outputPath){
        FileUtil.copy(inputPath,outputPath,false);
    }
    //区分是文件还是目录
    //如果是目录，首先创建目标目录
    //获取目录下的所有文件和字目录
    //无子文件直接结束
    //有则递归拷贝下一层

    //如果是文件，直接复制到目标目录下


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

        if (src.isDirectory()){//复制目录
            System.out.println(src.getCanonicalPath());
            if (dest.exists() && false == dest.isDirectory()){
                //源为目录，目标为文件，抛出IO异常
                throw new IORuntimeException("Src is a directory but dest is a file!");
            }
            if (FileUtil.isSub(src,dest)){
                throw new IORuntimeException("Dest is a sub directory of src !");
            }
            //当拷贝来源是目录时是否只拷贝目录下的内容

        }else {

        }

    }
}
