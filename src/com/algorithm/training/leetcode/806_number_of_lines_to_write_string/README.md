## 806. Number of Lines To Write String

**Difficulty:** Easy

https://leetcode.com/problems/number-of-lines-to-write-string/description/

We are to write the letters of a given string S, from left to right into lines.  
Each line has maximum width 100 units, and if writing a letter would cause the width of the line to exceed 100 units, it is written on the next line.  
We are given an array widths, an array where widths[0] is the width of 'a', widths[1] is the width of 'b', ..., and widths[25] is the width of 'z'.  

Now answer two questions:  
how many lines have at least one character from S, and what is the width used by the last such line?  
Return your answer as an integer list of length 2.

```
Input: 
widths = [10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10]
S = "abcdefghijklmnopqrstuvwxyz"
Output: [3, 60]
Explanation: 
All letters have the same length of 10. To write all 26 letters,
we need two full lines and one line with 60 units.

Input: 
widths = [4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10]
S = "bbbcccdddaaa"
Output: [2, 4]
Explanation: 
All letters except 'a' have the same length of 10, and 
"bbbcccdddaa" will cover 9 * 10 + 2 * 4 = 98 units.
For the last 'a', it is written on the second line because
there is only 2 units left in the first line.
So the answer is 2 lines, plus 4 units in the second line.
```

**Show tag:** \#string

----------------------------------------

**Solution** <br/>
시간복잡도 : O(n) 공간복잡도 : O(1) (n : 문자열 S의 길이)  
매우 쉬운 간단한 문제인데, 문제이해를 잘못하여 한번 wrong answer 하였다  
문자열의 각 문자를 순회하며 해당 문자의 width를 확인한 후,  
해당 문자를 현재 line에 write 할 수 있다면 현재 line의 width를 늘리고,  
해당 문자를 현재 line에 write 할 수 없다면 현재 line 번호를 늘리고, 현재 line의 width를 현재 문자의 width로 설정해준다  

처음에는 문제를 정말 단순하게, 문자가 쪼개질 수 있는 것처럼 전체 문자의 길이의 합을 구한 후  
100으로 나눈 몫과 내머지를 출력하면 될 것이라고 잘못 생각했었다.   