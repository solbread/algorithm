## Marble Mania Puzzle1

https://adventofcode.com/2018/day/9


You talk to the Elves while you wait for your navigation system to initialize.  
To pass the time, they introduce you to their favorite marble game.  

The Elves play this game by taking turns arranging the marbles in a circle according to very particular rules.  
The marbles are numbered starting with 0 and increasing by 1 until every marble has a number.  

First, the marble numbered 0 is placed in the circle.  
At this point, while it contains only a single marble,  
it is still a circle: the marble is both clockwise from itself and counter-clockwise from itself.  
This marble is designated the current marble.

Then, each Elf takes a turn placing the lowest-numbered remaining marble into the circle between the marbles that are 1 and 2 marbles clockwise of the current marble.  
(When the circle is large enough, this means that there is one marble between the marble that was just placed and the current marble.)  
The marble that was just placed then becomes the current marble.

However, if the marble that is about to be placed has a number which is a multiple of 23, something entirely different happens.  
First, the current player keeps the marble they would have placed, adding it to their score.  
In addition, the marble 7 marbles counter-clockwise from the current marble is removed from the circle and also added to the current player's score.  
The marble located immediately clockwise of the marble that was removed becomes the new current marble.  

What is the winning Elf's score?



```
For example, suppose there are 9 players. After the marble with value 0 is placed in the middle, 
each player (shown in square brackets) takes a turn. 
The result of each of those turns would produce circles of marbles like this, 
where clockwise is to the right and the resulting current marble is in parentheses:

[-] (0)
[1]  0 (1)
[2]  0 (2) 1 
[3]  0  2  1 (3)
[4]  0 (4) 2  1  3 
[5]  0  4  2 (5) 1  3 
[6]  0  4  2  5  1 (6) 3 
[7]  0  4  2  5  1  6  3 (7)
[8]  0 (8) 4  2  5  1  6  3  7 
[9]  0  8  4 (9) 2  5  1  6  3  7 
[1]  0  8  4  9  2(10) 5  1  6  3  7 
[2]  0  8  4  9  2 10  5(11) 1  6  3  7 
[3]  0  8  4  9  2 10  5 11  1(12) 6  3  7 
[4]  0  8  4  9  2 10  5 11  1 12  6(13) 3  7 
[5]  0  8  4  9  2 10  5 11  1 12  6 13  3(14) 7 
[6]  0  8  4  9  2 10  5 11  1 12  6 13  3 14  7(15)
[7]  0(16) 8  4  9  2 10  5 11  1 12  6 13  3 14  7 15 
[8]  0 16  8(17) 4  9  2 10  5 11  1 12  6 13  3 14  7 15 
[9]  0 16  8 17  4(18) 9  2 10  5 11  1 12  6 13  3 14  7 15 
[1]  0 16  8 17  4 18  9(19) 2 10  5 11  1 12  6 13  3 14  7 15 
[2]  0 16  8 17  4 18  9 19  2(20)10  5 11  1 12  6 13  3 14  7 15 
[3]  0 16  8 17  4 18  9 19  2 20 10(21) 5 11  1 12  6 13  3 14  7 15 
[4]  0 16  8 17  4 18  9 19  2 20 10 21  5(22)11  1 12  6 13  3 14  7 15 
[5]  0 16  8 17  4 18(19) 2 20 10 21  5 22 11  1 12  6 13  3 14  7 15 
[6]  0 16  8 17  4 18 19  2(24)20 10 21  5 22 11  1 12  6 13  3 14  7 15 
[7]  0 16  8 17  4 18 19  2 24 20(25)10 21  5 22 11  1 12  6 13  3 14  7 15

The goal is to be the player with the highest score after the last marble is used up. 
Assuming the example above ends after the marble numbered 25, the winning score is 23+9=32 
(because player 5 kept marble 23 and removed marble 9, while no other player got any points in this very short example game).

Here are a few more examples:

10 players; last marble is worth 1618 points: high score is 8317
13 players; last marble is worth 7999 points: high score is 146373
17 players; last marble is worth 1104 points: high score is 2764
21 players; last marble is worth 6111 points: high score is 54718
30 players; last marble is worth 5807 points: high score is 37305

```

---------------------------

**Solution**  
시간복잡도 : O(n\*n)? 공간복잡도 : O(n) (n=marble 개수)   
정답 : 412117  
대리석 개수만큼 반복하는데, 반복할 때 마다 대리석을 맞는 자리에 하나씩 놓는다.  
대리석을 놓을 자리를 결정하는 것은 curMarblePointer의 포인터 변수를 이용하였다.  
그래서 대리석을 놓을 때는 현재 포인터의 다다음 위치에 놓고,  
대리석의 번호가 23의 배수일 때는 현재 포인터의 7번째 전 위치의 대리석을 제거하고, 해당 플레이어의 점수를 계산하였다.  
점수는 map을 이용하여 요정번호와 해당 요정의 점수를 누적하였으며,  
최종적인 정답은 최고점이 된다.  

대리석 개수만큼 반복하고 그 안에서 리스트에 대리석을 놓거나 제거하는 과정에서,  
리스트의 크기만큼의 시간이 추가로 소요되기 떄문에 이 풀이는 느린 방식이다.  
적당하게 너프하게 잡아서 시간복잡도를 O(n\*n)으로 보았다. (정확하게는 잘 모르겠다.)  
(puzzle2에서는 대리석의 개수를 100배 늘리는데, 이 풀이로는 너무 오래걸려서 답을 얻을수가 없다.)  