## LUNCHBOX(Microwaving Lunch Boxes)

**Difficulty:** Easy

https://algospot.com/judge/problem/read/LUNCHBOX

After suffering from the deficit in summer camp, Ainu7 decided to supply lunch boxes instead of eating outside for Algospot.com winter camp. <br/>

He contacted the famous packed lunch company "Doosot" to prepare N lunch boxes for N participants. <br/>
Due to the massive amount of order, Doosot was not able to prepare the same menu. <br/>
Instead, they provided different N lunch boxes. <br/>
Ainu7 put all the lunch boxes to a refrigerator. <br/>

The lunch time has come, and suddenly Ainu7 noticed that there is only one microwave available. <br/>
As all lunch boxes are not the same, they need a different amount of time to microwave and eat. <br/>
Specifically, i-th lunch box needs Mi seconds to microwave and Ei seconds to eat.

Ainu7 needs to schedule microwave usage order to minimize lunch time. <br/>
Lunch time is defined as the duration from the beginning of microwaving of any lunch box to the end of eating for all participants. <br/>
Write a computer program that finds minimum lunch time to help Ainu7. <br/>
Note that substituting lunch while microwave is turned on is totally unnecessary, because the lunch will be cooled down. <br/>

입력 <br/>
The first line of the input contains one integer T, the number of test cases. <br/>
Each test case consists of three lines. The first line of each test case contains N(1≤N≤10000), the number of the participants. <br/>
N integers will follow on the second line. They represent M1, M2, ⋯, MN. <br/>
Similarly, N integers will follow on the third line, representing E1, E2, ⋯, EN. <br/>

출력 <br/>
For each test case, print the minimized lunch time in one line. It is guaranteed that the answer is always strictly less than 2^31.

```
Input:
2
3
2 2 2
2 2 2
3
1 2 3
1 2 1

Output: 
8
7
```

**Note:**

**Show tag:** \#greedy

------------------------------------

**Main** <br/>
시간복잡도 : O(nlogn) 공간복잡도 : O(n) <br/>
처음에는 데우는 시간과 먹는시간의 합이 긴 사람먼저 도시락을 데워야한다고 생각했는데, 데우는 시간은 관계없이 먹는시간이 긴 사람이 먼저 도시락을 데워야 한다. <br/>
왜냐하면 n번째로 도시락을 데우는 사람이 도시락을 다 먹게되는 시간은 1~n번째 사람들의 도시락 데우는 시간의 합 + n번째 사람이 먹는시간이므로 먹는시간이 긴 사람은 빨리 데워서 다른사람들이 데울동안 먹고있는 것이 좋다. (데우는 시간은 사람들간에 겹칠 수 없지만 먹는 시간은 겹칠 수 있기 때문에 빨리 먹기 시작하는 것이 좋다.) <br/>
따라서 도시락을 먹는 시간에 따라 정렬한 후 가장 먼저 도시락을 데워야하는 사람부터 처리해주면서 다 먹는데 걸리는 최소시간을 구하였다.