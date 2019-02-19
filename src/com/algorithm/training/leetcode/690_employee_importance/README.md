## 690. Employee Importance

**Difficulty:** Easy

https://leetcode.com/problems/employee-importance/description/

You are given a data structure of employee information, which includes the employee's unique id, his importance value and his direct subordinates' id. <br/>

For example, employee 1 is the leader of employee 2, and employee 2 is the leader of employee 3. <br/>
They have importance value 15, 10 and 5, respectively. Then employee 1 has a data structure like [1, 15, [2]], and employee 2 has [2, 10, [3]], and employee 3 has [3, 5, []]. Note that although employee 3 is also a subordinate of employee 1, the relationship is not direct. <br/>

Now given the employee information of a company, and an employee id, you need to return the total importance value of this employee and all his subordinates. <br/>

**Note**
One employee has at most one direct leader and may have several subordinates.
The maximum number of employees won't exceed 2000.

**Show tag:** \#hash\_table \#depth\_first\_search \#breadth\_first\_search

```
Input: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
Output: 11
Explanation:
Employee 1 has importance value 5, and he has two direct subordinates: employee 2 and employee 3. They both have importance value 3. So the total importance value of employee 1 is 5 + 3 + 3 = 11.
```

---------------------------------------------------

**Solution** <br/>
시간복잡도 : O(n) 공간복잡도 : O(n) <br/>
map에다가 employee id를 key로 하여 정보를 저장해두고 <br/>
(처음에는 map의 value에 entry로 employee의 importance와 subordinates를 저장하는 방법으로 구현하였는데, 그냥 employee 객체를 넣는것으로 리펙토링) <br/>
찾고자 하는 id에서 출발하여 함수를 재귀호출 하며 dfs로 모든 부하직원들을 타고 내려가서 최종적인 importance를 구하였다.