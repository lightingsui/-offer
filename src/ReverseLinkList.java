import java.util.ArrayList;

/**
 * 从尾到头打印链表
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 *
 * @author ：LightingSui
 * @since ：2020/2/14 23:04
 */
public class ReverseLinkList {
    public static void main(String[] args) {
        int[] array = new int[]{67, 0, 24, 58};
        ListNode listNode = new ListNode(array[0]);
        ListNode param = listNode;

        for (int i = 1; i < array.length; i++) {
            ListNode temp = new ListNode(array[i]);
            listNode.next = temp;
            listNode = temp;
        }

        ArrayList<Integer> integers = printListFromTailToHead(param);

        integers.forEach(System.out::println);
    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode == null || listNode.next == null){
            return new ArrayList<>();
        }

        ArrayList<Integer> tempList = new ArrayList<>(16);
        ArrayList<Integer> result = new ArrayList<>(16);

        while (listNode != null) {
            tempList.add(listNode.val);
            listNode = listNode.next;
        }

        for (int i = tempList.size() - 1; i >= 0; i--) {
            result.add(tempList.get(i));
        }

        return result;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

