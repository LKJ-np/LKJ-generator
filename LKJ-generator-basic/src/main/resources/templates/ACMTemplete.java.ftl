package com.lkj.acm;
import java.util.*;

/**
 * ACM输入模板（多数之和）
 * @author:${author}
 */
public class MainTemplate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

<#if loop>
        while (scanner.hasNext()){
</#if>
            //输入n个数
            int n = scanner.nextInt();

            //将n个数放入数组中
            int[] arr =new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += arr[i];
            }
            System.out.println("${outputText}:" + sum);
<#if loop>
        }
</#if>
        scanner.close();
    }
}