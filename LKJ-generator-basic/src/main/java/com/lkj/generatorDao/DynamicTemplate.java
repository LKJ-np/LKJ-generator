package com.lkj.generatorDao;
import lombok.Data;

/**
 * @Description: 动态模板参数
 * @Author：LKJ
 * @Package：com.lkj.generatorDao
 * @Project：LKJ-generator
 * @name：DynamicTemplate
 * @Date：2024/4/25 21:06
 * @Filename：DynamicTemplate
 */
@Data
public class DynamicTemplate {

    //作者名字
    private String author = "lkj";

    //是否循环
    private boolean loop ;

    //输出结果
    private String outputText ="输出结果";

}
