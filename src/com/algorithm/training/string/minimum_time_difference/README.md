## 539. Minimum Time Difference

**Difficulty:** Medium

https://leetcode.com/problems/minimum-time-difference/#/description

Given a list of 24-hour clock time points in "Hour:Minutes" format, find the minimum minutes difference between any two time points in the list.

```
Input: ["23:59","00:00"]
Output: 1
```

**Note:** <br/>
The number of time points in the given list is at least 2 and won't exceed 20000. <br/>
The input time is legal and ranges from 00:00 to 23:59.

**show tag:** \#string

--------------------------------------------

**Solution**
Time complexity : O(NlogN) <br/>
Comparator를 만들어서 시간순서대로 정렬한 후 i번째 시간과 i+1번째의 시간의 차이가 가장 작은 경우를 리턴 (i가 리스트의 마지막원소일 경우 0번째와 비교)

**BestSolution**
Time complexity : O(N) <br/>
boolean형 24\*60크기의 배열을 선언 <br/>
원본리스트를 순회하며 각 시간이 몇분인지를 계산해서 배열의 인덱스의 값을 true로 변경 (만약 같은 시간이 2번 나온다면 바로 0을 리턴)
boolean형 체크배열을 순회하며 최소 차이를 계산 <br>

**공통** <br/>
02:00와 23:00이 있을 때 두 시간의 차이는 21시간, 3시간 이렇게 두개가 나올 수 있음 -> 최소 시간차이를 구하는 것이므로 큰시간에서 작은시간을 뺐을때 12시간(720분)이 넘어가면 24시간(1440분)에서 빼줘야 함
