## 553. Optimal Division

**Difficulty:** Medium

https://leetcode.com/problems/optimal-division/#/description

Given a list of positive integers, the adjacent integers will perform the float division. For example, [2,3,4] -> 2 / 3 / 4.

However, you can add any number of parenthesis at any position to change the priority of operations. <br/>
You should find out how to add parenthesis to get the maximum result, and return the corresponding expression in string format. Your expression should NOT contain redundant parenthesis.

**Note** <br/>
1. The length of the input array is [1, 10].
2. Elements in the given array will be in range [2, 1000].
3. There is only one optimal division for each test case.

**Show tag:** \#math \#string

```
Input: [1000,100,10,2]
Output: "1000/(100/10/2)"

Explanation:
1000/(100/10/2) = 1000/((100/10)/2) = 200
However, the bold parenthesis in "1000/((100/10)/2)" are redundant, 
since they don't influence the operation priority. So you should return "1000/(100/10/2)". 

Other cases:
1000/(100/10)/2 = 50
1000/(100/(10/2)) = 50
1000/100/10/2 = 0.5
1000/100/(10/2) = 2
```

-------------------------------------------

참고 링크 : https://leetcode.com/articles/optimal-division/ <br/>
(위 링크에 Brute Force, Using Memorization, Using some Math를 이용한 방법이 있다.) <br/>

**Best Solution : Using some Math** <br/>
괄호를 추가해서 a/b/c/..../y/z 를 최대화 하려면 분모를 최대한 작게 만들어야 한다. <br/>
a,b,c의 3개의 수가 있다고 할 때 가능한 경우의 수는 a/(b/c)와 (a/b)/c 이다. <br/>
a/(b/c) = (a\*c)/b -> a로 나눠주면 c/b <br/>
(a/b)/c = a/(b\*c) -> a로 나눠주면 1/(b\*c) <br/>
c가 1보다 크다면 무조건 c/b > 1/(b\*c)인데 문제에서 조건이 element는 양수이므로 c/b > 1/(b\*c)는 항상 성립한다. <br/>
위의 내용을 여러개의 수에 대해 적용하면 a/(b/c/ ... y/z)를 하는 것이 항상 최대값을 구하게 된다. (왜 이와와 같이 되는지 정확하게는 이해를 하지 못하였다.) <br/>
따라서 nums의 length가 1일때랑 2일때만 잘 예외처리를 해주고 string을 가공하여 a/(b/c ... y/z)의 형태로 만들어주면 된다.

