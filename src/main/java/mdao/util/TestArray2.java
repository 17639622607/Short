package mdao.util;

import java.util.ArrayList;
import java.util.List;

public class TestArray2 {
    /*
     * List分割
     */
    public static List<List<String>> groupList(List<String> list,int toIndex) {
        List<List<String>> listGroup = new ArrayList<List<String>>();
        int listSize = list.size();
        //子集合的长度
        //toIndex = 4;
        for (int i = 0; i < list.size(); i += toIndex) {
            if (i + toIndex > listSize) {
                toIndex = listSize - i;
            }
            List<String> newList = list.subList(i, i + toIndex);
            listGroup.add(newList);
        }
        return listGroup;
    }





    public static void main(String[] args) {
        System.out.println(100%3==0?100/3:100/3+1);
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        List<List<String>> lists = groupList(list,4);
        System.out.println("list:" + list.toString());
        System.out.println(lists.get(0));
    }
}
