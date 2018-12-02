## Chronal Calibration Puzzle 2

You notice that the device repeats the same frequency change list over and over.  
To calibrate the device, you need to find the first frequency it reaches twice.


```
For example, using the same list of changes above, the device would loop as follows:

Current frequency  0, change of +1; resulting frequency  1.
Current frequency  1, change of -2; resulting frequency -1.
Current frequency -1, change of +3; resulting frequency  2.
Current frequency  2, change of +1; resulting frequency  3.
(At this point, the device continues from the start of the list.)
Current frequency  3, change of +1; resulting frequency  4.
Current frequency  4, change of -2; resulting frequency  2, which has already been seen.
In this example, the first frequency reached twice is 2. Note that your device might need to repeat its list of frequency changes many times before a duplicate frequency is found, and that duplicates might be found while in the middle of processing the list.

Here are other examples:

+1, -1 first reaches 0 twice.
+3, +3, +4, -2, -4 first reaches 10 twice.
-6, +3, +8, +5, -6 first reaches 5 twice.
+7, +7, -2, -7, -4 first reaches 14 twice.
What is the first frequency your device reaches twice?

Your puzzle answer was 219.
```

---------------------------

**Solution**  
시간복잡도 : O(n) 공간복잡도 : O(?)  
두 번 등장하는 주파수를 구하는 문제로, 두 번 등장하는 주파수를 찾을 때 까지 파일을 계속 읽는다.  
(파일을 쭉 읽어서 하나의 배열에 저장하는 방법도 상관없는데 그냥 파일을 계속 읽는것으로 하였다.)  
set에다가 주파수를 계속해서 누적하며 중복된 것을 발견하면 그것을 답으로 하였다.
궁금한점은 공간복잡도를 잘 모르겠다. O(n)일까? 어느순간 반복 되는 곳이 나오는 것일까?