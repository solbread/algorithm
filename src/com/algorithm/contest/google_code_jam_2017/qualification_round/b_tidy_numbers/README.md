## B. Tidy Numbers

Tatiana likes to keep things tidy. <br/>
Her toys are sorted from smallest to largest, her pencils are sorted from shortest to longest and her computers from oldest to newest. <br/>
One day, when practicing her counting skills, she noticed that some integers, when written in base 10 with no leading zeroes, have their digits sorted in non-decreasing order. <br/>
Some examples of this are 8, 123, 555, and 224488. <br/>
She decided to call these numbers tidy. <br/.
Numbers that do not have this property, like 20, 321, 495 and 999990, are not tidy.

She just finished counting all positive integers in ascending order from 1 to N. What was the last tidy number she counted?

**문제 한글 해석**
주어진 숫자보다 같거나 작은 tidy number중에 가장 큰 수를 찾는것이다. <br/>
tidy number는 주어진 숫자의 각 자릿수가 왼쪽자릿수보다 오른쪽자릿수의 숫자가 크거나 같은 숫자들이다.

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
~~**풀긴 풀었는데 더 refactoring 할 수 있었는데 성급하게 submit을 해버렸다...**~~ <br/>
시간복잡도 : 최악일때 O(n^2) <br/>
inputString을 맨 뒤의 인덱스부터 순회하면서 j-1와 j의 문자를 비교해서 j번째의 문자가 더 작으면 j-1번째의 문자를 -1하고 j번째의 문자는 '9'로 바꿔주었다. <br/>
그리고 가장 가까운 tidy 수를 구하는것이므로 j번째~length-1번째의 문자를 모두 '9'로 바꿔주었다.<br/>
그 후 앞에 있는 0을 제거하는 작업을 하고난 것이 tidy number 이다.

~~**refactoring(no commit)**~~ <br/>
~~시간복잡도 : O(n)~~ 최악일때 O(n^2) <br/>
~~위와 같은 풀이 방법에서는 inputstring을 맨 뒤의 인덱스부터 순회하는 의미가 없다~~ <br/>
~~그냥 맨 앞의 index부터 순회하면서 최초로 등장하는 j-1보다 작은 j번째 문자를 발견하여 j-1번째 문자는 -1을 하고 j번째 문자부터 input.length-1번째의 문자까지는 '9'로 바꿔주면 되는것이었다.~~ <br/>

위의 내용처럼 refactoring 하면 될 것이라고 생각했는데, 앞에서부터 순회해서 최초로 등장하는 j-1보다 작은 j문자를 발견하면 j번째 문자부터 input.length-1번쨰까지의 문자를 '9'로 바꿔주는 것은 맞으나, j-1번쨰 문자를 -1 해주면 j-1번째부터 앞단까지의 규칙이 깨질 수 있으므로 그것을 다시 또 체크 해 주어야 한다. <br/>
따라서 경우에 따라서 조금 더 빨라질 수는 있지만 최악의 경우 O(n^2)으로 크게 좋아지지 않을 것 같다.