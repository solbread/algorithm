## Chronal Coordinates Puzzle1

https://adventofcode.com/2018/day/6

The device on your wrist beeps several times, and once again you feel like you're falling.

"Situation critical," the device announces.  
"Destination indeterminate. Chronal interference detected. Please specify new target coordinates."

The device then produces a list of coordinates (your puzzle input).  
Are they places it thinks are safe or dangerous?  
It recommends you check manual page 729.  
The Elves did not give you a manual.

If they're dangerous, maybe you can minimize the danger by finding the coordinate that gives the largest distance from the other points.

Using only the Manhattan distance,  
determine the area around each coordinate by counting the number of integer X,Y locations that are closest to that coordinate  
(and aren't tied in distance to any other coordinate).

Your goal is to find the size of the largest area that isn't infinite.

```
 For example, consider the following list of coordinates:

1, 1
1, 6
8, 3
3, 4
5, 5
8, 9
If we name these coordinates A through F, we can draw them on a grid, putting 0,0 at the top left:

..........
.A........
..........
........C.
...D......
.....E....
.B........
..........
..........
........F.
This view is partial - the actual grid extends infinitely in all directions. Using the Manhattan distance, each location's closest coordinate can be determined, shown here in lowercase:

aaaaa.cccc
aAaaa.cccc
aaaddecccc
aadddeccCc
..dDdeeccc
bb.deEeecc
bBb.eeee..
bbb.eeefff
bbb.eeffff
bbb.ffffFf
Locations shown as . are equally far from two or more coordinates, and so they don't count as being closest to any.

In this example, the areas of coordinates A, B, C, and F are infinite - while not shown here, 
their areas extend forever outside the visible grid. 
However, the areas of coordinates D and E are finite: D is closest to 9 locations, 
and E is closest to 17 (both including the coordinate's location itself). 
Therefore, in this example, the size of the largest area is 17.
```

---------------------------

**Solution**  
시간복잡도 : O(n\*i\*j) 공간복잡도 : O(i\*j) (n=문자 개수 i=grid행개수 j=grid열개수)   
정답 : 39398  
1. grid의 행 개수와 열 개수를 구한다.  
input을 순회하며 최대 행 번호와 최대 열 번호를 구한다. (시간복잡도 : O(n))
2. grid를 만든다.
3차원 배열을 만드는데 1에서 구한 최대 행번호와 열번호에 대한 grid에 2개의 공간을 추가로 더 할당해준다.
3. 전체 좌표를 순회하며 배열에 가장 짧은 거리정보를 넣는다.
\[i\]\[j\]\[0\]에는 (i, j) 좌표까지 가장 거리가 짧은 문자번호를 넣어놓고,
\[i\]\[j\]\[1]\에는 (i, j) 좌표까지 가장 짧은 거리를 저장한다.
4. 무한대로 가는 문자의 영역은 제외하고 가장 큰 영역을 찾는다.
무한대로 간다는 뜻은 가장자리에 들어있는 문자라는 의미이므로 가장자리에 있는 문자가 아닌 문자들 중에서 가장 큰 영역을 찾는다.
 
