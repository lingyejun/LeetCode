package com.lingyejun.leetcode;

import javafx.beans.binding.ObjectBinding;

import java.util.*;

public class RemoveListElement {

    /**
     * 通过简单的遍历方式，在遍历的过程中有可能会漏掉元素
     * 取第二个元素i=1时，满足条件被删掉，原有的数组的第三个元素，变成了新数组的第二个元素
     * i++后i=2,但i=2指向的是新数组中的第三个元素，那么原数组中的第三个元素就被漏掉了
     *
     * @param list
     * @param element
     * @return
     */
    public static List forRemove(List list, Object element) {
        for (int i = 0; i < list.size(); i++) {
            if (element.equals(list.get(i))) {
                list.remove(i);
            }
        }
        return list;
    }

    /**
     * 逆向循环，是正确的
     * 1--2--3--4
     * 逆向循环时，倒数第一个元素满足条件被删除时，i--后,原数组的倒数第二个变成了新数组的倒数第一个元素
     * i = size-2指向新数组的最后一个元素，没有漏掉。
     * 同理倒数第二个元素满足条件被删除时，i--后,原数组的倒数第三个变成了新数组的倒数第二个元素
     * i= size-3指向新数组的倒数第二个元素，也没有漏掉
     *
     * @param list
     * @param element
     * @return
     */
    public static List reverseorRemove(List list, Object element) {
        for (int i = list.size() - 1; i >= 0; i--) {
            if (element.equals(list.get(i))) {
                list.remove(i);
            }
        }
        return list;
    }

    /**
     * 使用增强for循环是，如果删除后继续向下循环则会报
     * java.util.ConcurrentModificationException
     *
     * @param list
     * @param element
     * @return
     */
    public static List forceForRemove(List list, Object element) {
        for (Object item : list) {
            if (item.equals(element)) {
                list.remove(item);
            }
        }
        return list;
    }

    /**
     * 删除元素后，立即跳出，则正常退出，但不能向后继续循环了
     *
     * @param list
     * @param element
     * @return
     */
    public static List forceForRemove1(List list, Object element) {
        for (Object item : list) {
            if (item.equals(element)) {
                // 删除后立马终端循环，会正常跳出，但代价是不能继续向后循环了
                list.remove(item);
                break;
            }
        }
        return list;
    }


    /**
     * 使用迭代器可，正确无误的删除
     *
     * @param list
     * @param element
     * @return
     */
    public static List iteratorRemove(List list, Object element) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object cur = iterator.next();
            if (cur.equals(element)) {
                // 注意！！！这里时Iterator.remove()!!!而不是list.remove()!!!
                iterator.remove();
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(4);
        List newList = reverseorRemove(list, 2);

        // 遍历list
        for (int i = 0; i < list.size(); i++) {
            Object object = list.get(i);
            // do something
        }
        // 遍历map
        Map<String, String> map = new HashMap<>();
        map.put("1", "first");
        map.put("2", "second");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            // do something
        }
    }
}