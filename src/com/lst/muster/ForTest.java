package com.lst.muster;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/*
*   jdk 5.0 新增了foreach 循环 ，用于遍历集合、数组
*
* */
public class ForTest {

    @Test

    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(false);
        coll.add(new String("lst"));


        //for（集合元素都类型  局部变量： 集合对象）
        //内部仍然调用了迭代器
        for (Object obj : coll) {

            System.out.println(obj);
        }


    }

    @Test
    public void test2() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};

        for (int i : arr) {
            System.out.println(i);
        }

    }

//面试题：普通for赋值和增强for循环
    @Test
    public  void  test3(){

        String []arr =new String[]{"MM","MM","MM"};

        //方式一：普通for赋值  //输出是GG
//        for (int i =0;i<arr.length;i++){
//            arr[i]="GG";
//        }




        //方式二：增强for循环  //输出是MM，不变 相当于arr 赋值给s ，s重新赋值，修改s="gg"不会影响到原来的值
        for (String s:arr){
            s="GG";
        }


        //遍历
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);

        }

    }

}
