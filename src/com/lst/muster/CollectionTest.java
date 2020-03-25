package com.lst.muster;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


public class CollectionTest {

    /*
     *  Collection 接口中声明的方法的测试
     *
     *   结论：向Collection  接口的实现类的对象中添加数据obj时，要求obj所在类要重写equals();
     *
     *
     *
     * */

    @Test
    public void test1() {

        Collection coll = new ArrayList();

        // 1. add(Object obj)：将元素e添加到集合coll中
        coll.add(123);//自动装箱
        coll.add("我上天了");
        coll.add(new Object());


        // 2. size()：获取添加的元素的个数
        System.out.println(coll.size());//3


        // 3. addAll(Collection coll):将coll1集合中的元素添加到当前集合中
        Collection coll1 = new ArrayList();
        coll1.add(456);//自动装箱
        coll1.add("守望先锋");
        coll1.add(new Object());
        coll.addAll(coll1);//

        System.out.println(coll.size());//6
        System.out.println(coll);//[123, 我上天了, java.lang.Object@7e0b37bc, 456, 守望先锋, java.lang.Object@3b95a09c]

        //4 .clear():清空集合元素
        coll.clear();
        System.out.println(coll);//输出[]没有元素

        //5 .isEmpty()：判断当前集合是否为空

        System.out.println(coll.isEmpty());


    }

    @Test
    public void test2() {

        //  6.contains(Object obj):判断当前集合中是否包含obj
        //我们在判断时会调用obj对象所在类的equals()
        Collection coll = new ArrayList();
        coll.add(123);//自动装箱
        coll.add("我上天了");
        coll.add(new Object());
        boolean contains = coll.contains("我上天了");
        System.out.println(contains);
        System.out.println("*******************");
        //7. containsAll(Collection coll1)：判断形参coll1中的所有元素是否都存在于集合中

        Collection coll1 = Arrays.asList(123, 456);
        System.out.println(coll1.containsAll(coll));

        System.out.println("*******************");
        //  8.remove(Object obj)：从当前集合中移除obj集合
        Collection coll4 = new ArrayList();
        coll4.add(123);//自动装箱
        coll4.add("我上天了");
        coll4.add(new Object());
        coll4.add(456);
        coll4.remove("我上天了");
        System.out.println(contains);
        System.out.println(coll4);// [123, java.lang.Object@6ae40994]


        //  9 .removeAll(Collection coll) :从当前集合中移除coll中 所有的元素
        Collection coll5 = Arrays.asList(123, 456);
        boolean rem = coll4.removeAll(coll5);//在coll4里删除coll5的数据
        System.out.println(rem);//删除成功，true，删除失败，或者找不到就false
        System.out.println(coll4);

    }


    @Test
    public void test3() {


        Collection coll = new ArrayList();

        coll.add(123);
        coll.add(456);
        coll.add(false);
        coll.add(new String("tom"));

        //  10. retainsAll(Collection coll) :获取当前集合和coll1集合的交集，并返回给当前集合
        //例如：集合 {1,2,3} 和 {2,3,4} 的交集为 {2,3}。即{1,2,3}∩{2,3,4}={2,3}
       /*
       Collection coll1 = Arrays.asList(123,456, 789,10,11,12);
        coll.retainAll(coll1);
        System.out.println(coll);

        */

        //  11 .equals(Object obj) ： 要想返回ture ，需要当前集合和形参集合的元素都相同，如果位置交换了，都是返回false的

        Collection coll2 = new ArrayList();
        coll2.add(123);
        coll2.add(456);
        coll2.add(false);
        coll2.add(new String("tom"));
        System.out.println(coll.equals(coll2));

    }

    @Test
    public void test4() {


        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(false);
        coll.add(new String("tom"));
        //12.hasCode():返回当前对象的哈希值
        System.out.println(coll.hashCode());//5179403


        //13.集合 - - - > 数组： toArray()
        Object[] arr = coll.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }


        //14.扩展：数组 - - - > 集合：调用Arrays类的静态方法alist()
        List<String> list = Arrays.asList(new String[]{"AA", "BB", "CC"});
        System.out.println(list);

        //这样的写法识别为一个元素：
        List arr1 = Arrays.asList(new int[]{123, 456});
        System.out.println(arr1);//[[I@7e0b37bc]
        //如果要非要输出{123,456}里面的集合，要这样写
        //方式一：
        List arr2 = Arrays.asList(123, 456);
        System.out.println(arr2);
        //方式二：如果写的包装类的对象，它就认为你这个识别的是两个元素
        List arr3 = Arrays.asList(new Integer[]{123, 456});
        System.out.println(arr3);


    }

}
