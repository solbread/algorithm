## Cal Rage Sum of Matrix

**Difficulty:** None

알고리즘 문제해결 전략 600p 예제

주어진 2차원 배열 numbers의 왼쪽 상단이 (x1,y1)이고 오른쪽 하단이 (x2,y2)인 직사각형의 구간합을 구한다.

**Note:**

**Show tag:** \#partition\_#sum

----------------------------------------------

**Solution** <br/>
시간복잡도 : O(n^2) 공간복잡도 : O(n^2) <br/>
n*n크기의 각 index(i,j)가 왼쪽상단(0,0) 오른쪽하단(i,j)의 직사각형 구간의 부분합을 저장해두는 2차원 배열을 만들어 놓은 후. <br/>
왼쪽상단(x1,y1) 오른쪽하단(x2,y2)의 구간합을은 아래의 공식을 이용하여 O(1)만에 계산한다. <br/>
rangeSum(x1,y1,x2,y2) = partitionSum(x2,y2) - partitionSum(x2,y1-1) - partitionSum(x1-1,y2) + partitionSum(x1-1,y1-1) <br/>
이렇게 부분합을 이용하여 구간합을 구하는 것은 하나의 배열에 대해 여러번의 구간합 구해야 할 때 유용하게 활용될 수 있다. 
