using System.Text;

var s = new Solution();

// Example 1
// Input: list1 = [1,2,4], list2 = [1,3,4]
// Output: [1,1,2,3,4,4]
Console.WriteLine(s.MergeTwoLists(new ListNode([1,2,4]), new ListNode([1,3,4])));

Console.WriteLine(s.MergeTwoLists(null, new ListNode([0])));

// Definition for singly-linked list.
public class ListNode {
    public int val;
    public ListNode? next;
    public ListNode(int val=0, ListNode? next=null) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int[] arr)
    {
        val = arr[0];
        var curr = this;
        for (var i = 1; i < arr.Length; i++)
        {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }

    }

    public override string ToString()
    {
        return $"[{ToStringNoBracket()}]";
    }

    private string ToStringNoBracket()
    {
        return next != null ? $"{val},{next.ToStringNoBracket()}" : $"{val}";
    }
}

public class Solution {
    public ListNode MergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p = new ListNode(int.MinValue);
        ListNode head = p;
        ListNode? l = list1;
        ListNode? r = list2;
        while (l != null || r != null)
        {
            if (r == null || (l != null && l.val < r.val))
            {
                p.next = l;
                l = l!.next;
            }
            else
            {
                p.next = r;
                r = r.next;
            }
            p = p.next!;
        }

        return head.next!;
    }
}