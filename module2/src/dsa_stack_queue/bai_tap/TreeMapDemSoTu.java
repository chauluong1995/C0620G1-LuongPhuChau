package dsa_stack_queue.bai_tap;

import java.util.TreeMap;

public class TreeMapDemSoTu {
    public static void main(String[] args) {
        String string = "Bài này không biết làm ! Bài này khó quá !";
        String[] arrays = string.split("\\s");
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        String temp;
        int count;
        for (String element : arrays) {
            temp = element.toUpperCase();
            if (treeMap.containsKey(temp)) {
                count = treeMap.get(temp);
                treeMap.put(temp, count + 1);
            } else treeMap.put(temp, 1);
        }
        System.out.println(treeMap);
    }
}
