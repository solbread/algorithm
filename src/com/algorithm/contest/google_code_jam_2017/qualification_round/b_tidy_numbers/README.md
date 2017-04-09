## B. Tidy Numbers

Tatiana likes to keep things tidy. <br/>
Her toys are sorted from smallest to largest, her pencils are sorted from shortest to longest and her computers from oldest to newest. <br/>
One day, when practicing her counting skills, she noticed that some integers, when written in base 10 with no leading zeroes, have their digits sorted in non-decreasing order. <br/>
Some examples of this are 8, 123, 555, and 224488. <br/>
She decided to call these numbers tidy. <br/.
Numbers that do not have this property, like 20, 321, 495 and 999990, are not tidy.

She just finished counting all positive integers in ascending order from 1 to N. What was the last tidy number she counted?

```
Input 
4
132
1000
7
111111111111111110
 	
Output 
Case #1: 129
Case #2: 999
Case #3: 7
Case #4: 99999999999999999
```

**Main** <br/>
**풀긴 풀었는데 더 refactoring 할 수 있었는데 성급하게 submit을 해버렸다...** <br/>
시간복잡도 : 최악일때 O(n^2) <br/>
inputString을 맨 뒤의 인덱스부터 순회하면서 j-1와 j의 문자를 비교해서 j번째의 문자가 더 작으면 j-1번째의 문자를 -1하고 j번째의 문자는 '9'로 바꿔주었다. <br/>
그리고 가장 가까운 tidy 수를 구하는것이므로 j번째~length-1번째의 문자를 모두 '9'로 바꿔주었다.<br/>
그 후 앞에 있는 0을 제거하는 작업을 하고난 것이 tidy number 이다.

**refactoring(no commit)** <br/>
시간복잡도 : O(n) <br/>
위와 같은 풀이 방법에서는 inputstring을 맨 뒤의 인덱스부터 순회하는 의미가 없다 <br/>
그냥 맨 앞의 index부터 순회하면서 최초로 등장하는 j-1보다 작은 j번째 문자를 발견하여 j-1번째 문자는 -1을 하고 j번째 문자부터 input.length-1번째의 문자까지는 '9'로 바꿔주면 되는것이었다. <br/>