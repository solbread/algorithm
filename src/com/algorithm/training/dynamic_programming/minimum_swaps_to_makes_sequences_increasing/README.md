## 801. Minimum Swaps To Make Sequences Increasing

**Difficulty:** Medium

https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/description/

We have two integer sequences A and B of the same non-zero length.  

We are allowed to swap elements A[i] and B[i].  Note that both elements are in the same index position in their respective sequences.  

At the end of some number of swaps, A and B are both strictly increasing.  (A sequence is strictly increasing if and only if A[0] < A[1] < A[2] < ... < A[A.length - 1].)  

Given A and B, return the minimum number of swaps to make both sequences strictly increasing.  It is guaranteed that the given input always makes it possible.  

```
Example:
Input: A = [1,3,5,4], B = [1,2,3,7]
Output: 1
Explanation: 
Swap A[3] and B[3].  Then the sequences are:
A = [1, 3, 5, 7] and B = [1, 2, 3, 4]
which are both strictly increasing.
```

**Show tag:** \#dynamic\_programming

**Note:**  
* A, B are arrays with the same length, and that length will be in the range [1, 1000].
* A[i], B[i] are integer values in the range [0, 2000].

-------------------------------------

**Solution** <br/>
시간복잡도 : O(n) 공간복잡도 : O(n)  
처음에는 calMinSwap(int idx, int\[\] A, int\[\] B)라는 함수를 만들어서, A와 B배열의 idx이후의 요소에서 minSwap값을 구하는 방식으로 접근하였다.  
이렇게해도 답은 구해졌지만 TLE가 발생하여 어떻게하면 시간복잡도를 줄일 수 있을까? 라는 생각을 하다가 해당 메소드가 중복호출됨을 발견하였고, 중복호출을 줄이기 위해 메모리제이션을 해야겠다고 결정하였다.  
해당 메소드는 A랑 B라는 배열을 파라미터로 사용하고 있었지만, 사실 해당 메소드내부에서 사용하는 값은 A와 B배열 각각의 idx-1, idx번째의 값이기 때문에 배열전체를 받을 파라미터로 사용할 이유가 없다는 것을 알게되었다  
idx-1번째의 값은 swap이 되었는지 되지않았는지에 따라서 값이 달라지므로 배열 A와B를 파라미터에서 제거하고 0또는 1을 가지는 isSwapped라는 변수를 이용해서 idx-1번째 값이 swap되었는지 되지않았는지를 나타내도록 하였다.  
이렇게해서 2\*n 공간을 가지는 cache에 메모리제이션을 할 수 있게 되었고 해당 메소드 역시 2\*n번 호출하여 답을 구할 수 있게 되었다.