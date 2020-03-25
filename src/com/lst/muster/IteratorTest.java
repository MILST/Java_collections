package com.lst.muster;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


/*
 *
 *  15.集合元素的遍历操作，使用迭代器iterator 接口
 *
 *  1.内部的方法：hasNext()和 next() 推荐要一起用
 *    hasNext()：判断是否还有下一个元素
 *     next() ：1.指针下移 2.将下移以后集合位置上的元素返回
 *
 *   2.集合对象每次调用iterator()方法得到一个全新的迭代器对象
 *   默认游标都在集合都第一个元素之前
 *
 * 3.内部定义了remove(),可以在遍历都时候，删除集合中的元素。此方法不同于集合直接调用remove()
 * */
public class IteratorTest {

    @Test
    public void test1() {

        Collection coll = new ArrayList();

        coll.add(123);
        coll.add(456);
        coll.add(new String("lvst  "));
        coll.add(true);

        Iterator iterator = coll.iterator();
        //方式一：不推荐
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
        // 写超出数组的元素  报错java.util.NoSuchElementException
        //System.out.println(iterator.next());


        //方式二：开发中不推荐，一般都推荐next()和hasNext()一起用
//
//        for (int i= 0;i<coll.size();i++){
//            System.out.println(iterator.next());
//        }


        //方式三：推荐
        //hasNext()：判断是否还有下一个元素
        // next() ：1.指针下移 2.将下移以后集合位置上的元素返回
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


    }


    @Test
    public   void test2(){

        Collection coll =new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(false);
        coll.add(new String("lst"));


        //错误方式一：

//        Iterator iterator =coll.iterator();
//        while ((iterator.next())!=null){
//            System.out.println(iterator.next());
//        }

        //错误方式二：
       //集合对象每次调用iterator()方法得到一个全新的迭代器对象
        // *   默认游标都在集合都第一个元素之前
        while (coll.iterator().hasNext()){
            System.out.println(coll.iterator().next());
        }
    }

@Test
    public void  test3(){

        //如果还未调用next()或者在上一次调用next 方法之后已经调用了remove 方法，在调用remove都会报错java.lang.IllegalStateException
        Collection coll =new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(false);
        coll.add(new String("lst"));

       // 删除集合中的"lst"
        Iterator  iterator =coll.iterator();
          while (iterator.hasNext()){
              Object obj = iterator.next();
              //iterator.remove();java.lang.IllegalStateException
              if ("lst".equals(obj)){
                  iterator.remove();
                  //iterator.remove();java.lang.IllegalStateException
              }
          }
          //遍历集合
          //回归起点
          iterator =coll.iterator();
          while (iterator.hasNext()){
              System.out.println(iterator.next());
          }


    }
}
