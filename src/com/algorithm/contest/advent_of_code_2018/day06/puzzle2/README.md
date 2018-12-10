## Chronal Coordinates Puzzle2

https://adventofcode.com/2018/day/6

On the other hand, if the coordinates are safe,  
maybe the best you can do is try to find a region near as many coordinates as possible.

Your actual region will need to be much larger than this example, though,   
instead including all locations with a total distance of less than 10000.  
What is the size of the region containing all locations which have a total distance to all given coordinates of less than 10000?


```
For example, suppose you want the sum of the Manhattan distance to all of the coordinates to be less than 32. 
For each location, add up the distances to all of the given coordinates; 
if the total of those distances is less than 32, that location is within the desired region. 
Using the same coordinates as above, the resulting region looks like this:

..........
.A........
..........
...###..C.
..#D###...
..###E#...
.B.###....
..........
..........
........F.
In particular, consider the highlighted location 4,3 located at the top middle of the region. 
Its calculation is as follows, where abs() is the absolute value function:

Distance to coordinate A: abs(4-1) + abs(3-1) =  5
Distance to coordinate B: abs(4-1) + abs(3-6) =  6
Distance to coordinate C: abs(4-8) + abs(3-3) =  4
Distance to coordinate D: abs(4-3) + abs(3-4) =  2
Distance to coordinate E: abs(4-5) + abs(3-5) =  3
Distance to coordinate F: abs(4-8) + abs(3-9) = 10
Total distance: 5 + 6 + 4 + 2 + 3 + 10 = 30
Because the total distance to all coordinates (30) is less than 32, the location is within the region.

This region, which also includes coordinates D and E, has a total size of 16.
```

---------------------------

**Solution**  
시간복잡도 : O(n*i*j) 공간복잡도 : O(i*j) (n=문자 개수 i=grid행개수 j=grid열개수)   
정답 : 39398  
1. grid의 행 개수와 열 개수를 구한다.  
input을 순회하며 최대 행 번호와 최대 열 번호를 구한다. (시간복잡도 : O(n))
2. grid를 만든다.
1에서 구한 최대 행번호와 열번호를 이용하여 2차원 grid를 만든다.
3. 전체 좌표를 순회하며 배열에 가장 거리정보를 누적한다,
4. grid를 순회하며 누적된 길이가 1000보다 작은 영억을 카운트한다.
 
