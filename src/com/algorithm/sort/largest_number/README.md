## 179. Largest Number

https://leetcode.com/problems/largest-number/#/description

Given a list of non negative integers, arrange them such that they form the largest number.

```
For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
```

**Note:** The result may be very large, so you need to return a string instead of an integer.

**Show tag:** \#sort

-----------------------------------------------

**Solution** <br/>
int형 배열을 string형 배열에 다시 넣은 다음에 largest number를 만들 수 있는 조건으로 정렬한 후 하나의 string에 넣은 다음에 ~~맨 앞에 있는 0을 제거해주는 작업을 하여~~ 반환한다. <br/>
정렬의 조건은 String o1, String o2가 있을 때 o1+o2랑 o2+o1을 비교해서 정렬하면 된다. <br/>
o1+o2가 o2+o1보다 클 경우 o1이 앞에와야 하는 것이며 그 반대의 경우 o2가 앞에와야 하는 것이다. <br/>
refactoring) <br/>
0을 제거해주는 작업이 필요없다. <br/>
그냥 정렬한 배열의 맨 앞 원소의 맨 앞 문자가 만약에 0이라면 0을 리턴해주면 된다. <br/>
왜냐하면 0이 배열의 맨 앞에 있다는 것은 0이 제일 큰 값이었다는 것인데, 0보다 작을수는 없으므로 그 배열에 0만 있다는 의미가 되므로 바로 0을 리턴하면 된다.