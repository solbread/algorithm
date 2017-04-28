## 556. Next Greater Element III

**Difficulty:** Medium

https://leetcode.com/problems/next-greater-element-iii/#/description

Given a positive 32-bit integer n, you need to find the smallest 32-bit integer which has exactly the same digits existing in the integer n and is greater in value than n. <br/>
If no such positive 32-bit integer exists, you need to return -1.

```
Input: 12
Output: 21

Input: 21
Output: -1
```

**Show tag:** \#string

----------------------------------------

**Solution** <br/>
처음으로 짠 코드는 예외처리가 많이 들어가서 복잡하다. 이를 계속 refactoring하여 보다 간결하게 바꿀 것이다. <br/>
우선 input의 숫자를 재배치하여 input 보다 큰 수중에 가장 작은 수를 구하는 아이디어는 다음과 같다 <br/>
첫번째, input보다는 크기 위해서는 앞자리 부터 순회하였을 때 처음으로 달라지는 수가 input보다는 커야한다. <br/>
이것의 의미는 1324라는 수가 있을 때 2314 혹은 1432 처럼 앞자리의 숫자부터 체크하였을 때 숫자가 달라지는 순간 그 숫자는 원래의 input보다는 커야한다. <br/>
예를 들면 2314에서 첫번째 자리수가 1<2, 1432에서 첫번째 자리수는 1=1 두번째자리수가 3<4 이므로 input보다 크지만, 1234는 첫번째 자리수는 1=1 두번째 자리수는 3>2로 input보다 작으며 이는 input보다 큰 수가 아니다. <br/>
두번째, input보다 큰 수 중에서 가장 작아야 하기때문에 최대한 앞의 자릿수는 그대로 냅두고 뒤의 자릿수의 수를 바꾸는 것이 유리하다.<br/>
즉 뒤에서부터 순회하여 input보다 커질 수 있는 경우가 나오면 해당 수가 input보다 큰 수 중에 가장 작은 수 이다. <br/>
위에서 언급한것에 의하여, input보다 커지는 경우는 뒤의 자릿수에서 앞의 자릿수로 순회할 때, 수의 크기가 감소하는 시점이 나온다면 그 자릿수의 뒤에는 해당 수보다 큰 수가 있다는 것이기 떄문에 그 큰 수로 세팅해주면 된다. <br/>
이 때 뒤에 있는 숫자들 중에서 해당 자릿수의 수보다는 크면서 가장 작은 수로 세팅해줘야 우리가 원하는 조건에 맞는 수를 얻을 수 있게 된다.<br/>
위의 idea를 기반으로 for문을 이용하여 주어진 숫자를 맨 뒷자리부터 순회하면서 number[i]<number[i+1]인 i를 찾는다. <br/>
이 때의 number[i]를 기준으로 number[0]~number[i-1]은 input과 똑같이 넣고 number[i]에는 number[i+1]~number[number.lenght-1]범위에서 number[i]보다 큰 수 중에 가장 작은 수를 뽑아서 넣어준다. <br/>
그리고 number[i]~number[number.length-1] 범위에서 방금전에 뽑아준 수를 제외하고 오름차순으로 sort한 후에 결과에 넣어주면 된다.

