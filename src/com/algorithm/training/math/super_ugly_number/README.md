## 313. Super Ugly Number

**Difficulty:** Medium

https://leetcode.com/problems/super-ugly-number/description/

Write a program to find the nth super ugly number. <br/>

Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k. <br/>
For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4. <br/>

**Note** <br/>
1. 1 is a super ugly number for any given primes.
2. The given numbers in primes are in ascending order.
3. 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
4. The nth super ugly number is guaranteed to fit in a 32-bit signed integer.

**Show tag:** \#math \#heap

**Related Problem:** \#math.ugly\_number \#math.uglry\_number2

```
Input: 12, [2,7,13,19]
Output: 32
```

-------------------------------------------

**Solution** <br/>
시간복잡도 : O(k \* logk \* n) 공간복잡도 : O(n+k) (n=구해야 하는 ugly number 개수 k=문제에서 주어진 소수의 개수) <br/>
heap에 소수와 index를 entity 형태로 저장하는데, 이를 이용해 만든 ugly number가 작은 순서대로 정렬하게 comparator를 재정의해둔다. <br/>
그리하여 n개의 ugly number를 구하기 위하여 n번 반복할 때 마다, heap에서 하나를 꺼내면 이 값이 n번째로 작은 ugly number이다. <br/>
그리고 나서 해당 ugly number와 같은 ugly number를 만드는 모든 소수들을 꺼내서 index를 +1해서 다시 넣어주면 된다.

이 solution으로 푸는 것 보다 ugly\_number2의 solution or solution2로 푸는 것이 더 빠르다. <br/>
(참고 : https://discuss.leetcode.com/topic/34841/java-three-methods-23ms-36-ms-58ms-with-heap-performance-explained) <br/>
위의 solution은 얼핏 보변 nlogk의 시간복잡도를 가지는 것 처럼 보인다. <br/>
ugly number2의 solution(or solution2)의 시간복잡도는 O(nk)인데 왜 O(nlogk)인 해당 solution보다 빠른가 하였는데, 댓글에 보니까 해당 solution이 O(nklogk)라는 글이 있었다. <br/>

```
I came up with the solution with a heap at first, but then I gave it up because I thought the time complexity was O(nklogk).
This is due to the inner loop at most pops out all the elements in the heap, which have a number of k.
So, the time complexity of the inner loop is: logk + log(k-1) + log(k-2) +...+log1=O(klogk).
As the inner loop runs n times, so the overall time complexity is O(nklogk).
Anyone could tell me where I am wrong?
```

(위의 내용은 해당 댓글이다.) <br/>
그러나 사실은 for루프 내부의 while문이 최악의 경우에 k번 반복될 수 있으며 k번 반복될 때 마다 logk의 정렬과정이 생기므로 최종 시간 복잡도는 n \* k \* logk가 되는 것이다. <br/>

내가 푼 solution은 entity를 사용하였지만 1차원 배열을 사용하여 소수의 값, index, ugly number값을 저장한다면 ugly nubmer를 중복해서 구하는 연산을 제거할 수 있을 것이다. (구현은 하지 않겠다.)