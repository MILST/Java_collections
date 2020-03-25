package com.lst.muster;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/*
*
*    list 的常用方法:
void add(int index, Object ele):在index位置插入ele元素
*
boolean addAll(int index, Collection eles):从index位置开始将eles中
的所有元素添加进来
*
 Object get(int index):获取指定index位置的元素
*
int indexOf(Object obj):返回obj在集合中首次出现的位置
*
int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
*
Object remove(int index):移除指定index位置的元素，并返回此元素
*
Object set(int index, Object ele):设置指定index位置的元素为ele

* List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex
位置的子集合
*
*    常用方法总结：
*  增：add(Object obj)
   删：remove(int index) / remove(Object obj)
   改：set(int index, Object ele)
   查：get(int index)
   插：add(int index, Object ele)
   长度：size()
   遍历：① Iterator迭代器方式
     ② 增强for循环
     ③ 普通的循环
*
*
*
*
*
* */
public class ListTest {

    @Test
    public void test1() {


        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new String("lvst"));
        list.add(456);

        //void add(int index, Object ele):在index位置插入ele元素
        list.add(1, "BB");
        System.out.println(list);//[123, BB, 456, AA, lvst, 456]


        //boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进
        List list1 = Arrays.asList(1, 2, 3);
        list.addAll(list1);//6 +3
        System.out.println(list.size());
        System.out.println(list);//[123, BB, 456, AA, lvst, 456, 1, 2, 3]

        //Object get(int index):获取指定index位置的元素

        System.out.println(list.get(0));//第一个位置的元素是123

    }

    @Test
    public void test2() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new String("lvst"));
        list.add(456);
        //list.add(123);


        //int indexOf(Object obj):返回obj在集合中首次出现的位置,如果不存在，则返回-1；
        int index = list.indexOf(456);
        System.out.println(index);


        //int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置,如果元素只有一个，返回indexof和lastindexof参数都一样
        int lastindex = list.lastIndexOf("AA");
        System.out.println(lastindex);


        //Object remove(int index):移除指定index位置的元素，并返回此元素

        list.remove(0);
        System.out.println(list);


        //Object set(int index, Object ele):设置指定index位置的元素修改（替换）为ele

        list.set(2, "守望先锋");
        System.out.println(list);

        // List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的左开右闭 子集合

        List sublistTest = list.subList(1, 3);//1<=x<3
        System.out.println(sublistTest);
    }

    @Test
    public void test3() {
        //list遍历的三种方法

        ArrayList list = new ArrayList();

        list.add(123);
        list.add(456);
        list.add("AA");

        //方式一：Iterator 迭代器方式

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("————————————————————————————————————");
        //方式二：增强for循环

        for (Object obj : list) {
            System.out.println(obj);
        }

        System.out.println("————————————————————————————————————");
        //方式三：普通for循环

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }


    }
}
