package com.lst.muster;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/*
 *    区分list中remove(int  index)和remove(Object obj)
 *
 * */
public class ListExer {


    @Test
    public void testListRemove() {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);//
    }

    private static void updateList(List list) {
        //list.remove(2);//按索引来删除的，输出为【1，2】
        list.remove(new Integer(2));//按对象删除list.add(2);，输出为【1,3】
    }
}
