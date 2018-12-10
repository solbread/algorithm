## Alchemical Reduction Puzzle2

https://adventofcode.com/2018/day/5

One of the unit types is causing problems; it's preventing the polymer from collapsing as much as it should.  
Your goal is to figure out which unit type is causing the most problems,  
remove all instances of it (regardless of polarity), fully react the remaining polymer, and measure its length.
What is the length of the shortest polymer you can produce by removing all units of exactly one type and fully reacting the result?

```
or example, again using the polymer dabAcCaCBAcCcaDA from above:

Removing all A/a units produces dbcCCBcCcD. Fully reacting this polymer produces dbCBcD, which has length 6.
Removing all B/b units produces daAcCaCAcCcaDA. Fully reacting this polymer produces daCAcaDA, which has length 8.
Removing all C/c units produces dabAaBAaDA. Fully reacting this polymer produces daDA, which has length 4.
Removing all D/d units produces abAcCaCBAcCcaA. Fully reacting this polymer produces abCBAc, which has length 6.
In this example, removing all C/c units was best, producing the answer 4.

```

---------------------------

**Solution**  
시간복잡도 : O(n) 공간복잡도 : O(n) (n=input 문자열 길이)   
정답 : 6948  
a부터 z까지 순회하며 문자열에서 특정 문자를 제거 한 것에 대해, 케이스가 다른 문자를 제거하는 작업을 한다.  
(케이스가 다른 문자를 제거하는 작업은 puzzle1과 동일하게 함)  
a부터 z까지 모두 작업을 하면서, 가장 짧은 결과가 되는 문자열의 길이를 찾는다.
stack에 최종적으로 남은 문자의 개수가 결과
