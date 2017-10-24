## Microwaving Lunch Boxes

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
