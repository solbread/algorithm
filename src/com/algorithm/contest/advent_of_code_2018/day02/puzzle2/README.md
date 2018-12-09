## Inventory Management System Puzzle 2

https://adventofcode.com/2018/day/2

Confident that your list of box IDs is complete, you're ready to find the boxes full of prototype fabric.  
The boxes will have IDs which differ by exactly one character at the same position in both strings.

```
For example, given the following box IDs:

abcde
fghij
klmno
pqrst
fguij
axcye
wvxyz
The IDs abcde and axcye are close, but they differ by two characters (the second and fourth). 
However, the IDs fghij and fguij differ by exactly one character, the third (h and u). 
Those must be the correct boxes.

What letters are common between the two correct box IDs? 
(In the example above, this is found by removing the differing character from either ID, producing fgij.)

Your puzzle answer was hhvsdkatysmiqjxunezgwcdpr.
```

---------------------------

**Solution**  
시간복잡도 : O(n*n*m) 공간복잡도 : O(n) (n=주어진 배열의 개수, m=주어진 문자열의 길이)  
정답 : hhvsdkatysmiqjxunezgwcdpr  
우선 n개짜리 리스트에 모든 문자열을 담아놓고 시작한다.  
2개의 for문을 통해서 문자열의 모든 조합을 구하며, 각 문자열 쌍마다 문제의 조건을 충족하는지를 체크한다.  
따라서 모든 조합을 구하는데 n\*n의 반복을 수행하고,  
각 문자열 쌍마다 하나만 빼고 중복되는 문자열쌍인지를 체크하는데 m번의 반복문이 소요된다.  
위와 같은 이유로 시간복잡도가 O(n\*n\*m) 이다.  
각 문자열 쌍마다 하나만 빼고 중복되는 문자열쌍인지를 체크하는 방식은, 
문자열을 순회하며 다른 문자가 등장하는 횟수를 체크하여 2를 넘어가면 패스하고 딱 1이 되는 문자열쌍을 찾는다.  

