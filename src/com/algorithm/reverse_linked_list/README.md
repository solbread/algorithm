## 206. Reverse Linked List

https://leetcode.com/problems/reverse-linked-list/#/description

Reverse a singly linked list.
```
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
```

**Show tag:** \#linked_list

-------------------------------------------------

**Solution : using recursively** <br/>
재귀함수를 이용해서 리스트노드의 맨 끝까지 들어간 후 result 리스트노드에 누적 <br/>

**Best Solution : using recursively** <br/>
head :  [3,2,1] -> [2,1] -> [1]   -> null <br/>
result : null   -> [3]   -> [2,3] -> [1,2,3] <br/>
head에서 앞에서부터 보면서 result의 앞에다가 붙여가면서 재귀를 호출 <br/>

**Best Solution2 : using iteratively** <br/>
Best Solution을 반복문으로 변경
