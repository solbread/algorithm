## BRACKETS2

**Difficulty:** Easy

https://algospot.com/judge/problem/read/BRACKETS2

Best White is a mathematics graduate student at T1 University. Recently, he finished writing a paper and he decided to polish it. <br/>
As he started to read it from the beginning, he realized that some of the formulas have problems: some of the brackets are mismatched! <br/>
Since there are so many formulas in his paper, he decided to check their validity with a computer program. <br/>

The following kinds of brackets are included in Best White’s paper. <br/>

* Round brackets are opened by a ( and closed by a ).
* Curly brackets are opened by a { and closed by a }.
* Square brackets are opened by a [ and closed by a ].

A formula is said well-matched when the following conditions are met: <br/>
1. Every bracket has a corresponding pair. ( corresponds to ), [ corresponds to ], et cetera.
2. Every bracket pair is opened first, and closed later.
3. No two pairs "*cross*" each other. For example, [(]) is not well-matched.

Write a program to help Best White by checking if each of his formulas is well-matched. To make the problem easier, everything other than brackets are removed from the formulas. <br/>

입력 <br/>
The first line of the input will contain the number of test cases C (1≤C≤100). Each test is given in a single line as a character string. The strings will only include characters in "[](){}" (quotes for clarity). The length of the string will not exceed 10,000.

출력 <br/>
For each test case, print a single line "YES" when the formula is well-matched; print "NO" otherwise. (quotes for clarity)

```
Input:
3
()()
({[}])
({}[(){}])

Output: 
YES
NO
YES
```

**Note:**

**Show tag:** \#stack

------------------------------------

**Main** <br/>
시간복잡도 : O(n) 공간복잡도 : O(n) (n=문자열의 길이) <br/>
문자열의 문자를 하나씩 순회하면서 stack에 넣는다. <br/>
닫힌 문자가 나올 경우 스택의 제일 위에 있는 문자를 꺼내서 매칭이 되는지를 확인한다. <br/>

이 문제에서 주의할 점은 닫힌문자 혹은 열린문자로만 이뤄진 문자열이나 열린문자가 남는 문자열이 들어올 경우의 처리이다. <br/>
닫힌 문자만 들어올 경우에는 비어있는 stack에서 pop을 하지않도록 예외처리 해야 하며, <br/>
열린 문자만 들어오거나, 다 매칭을 하고도 열린문자가 남는 경우에는 매칭은 다 되었지만 stack에 문자가 남아있으므로 stack size를 보고 처리해줘야 한다.
 