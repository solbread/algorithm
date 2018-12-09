## Marble Mania Puzzle2

https://adventofcode.com/2018/day/9

Amused by the speed of your answer, the Elves are curious:

What would the new winning Elf's score be if the number of the last marble were 100 times larger?


```
생략

```

---------------------------

**Solution**  
시간복잡도 : O(n) 공간복잡도 : O(n) (n=marble 개수)   
정답 : 3444129546  
대리석 개수만큼 반복하는데, 반복할 때 마다 대리석을 맞는 자리에 하나씩 놓으면서 결과를 도출해 내는 것은 puzzle1과 동일하지만,  
대리석의 놓을 자리를 결정하는 포인터를 어떻게 다룰지가 다르다.  
(이 부분에서 time complexity가 줄어들어 puzzle2를 해결할 수 있었다.)  

puzzle2에서는 놓아진 대리석을 list를 이용하여 관리하는 것이 아니라,  
node를 이용하여 관리하였다.  
그래서 대리석을 추가할때와 삭제할 때 O(1)만에 할 수 있었고, 이로인해 시간복잡도가 줄어들어서 문제를 해결하였다.  

또한 점수가 int 범위를 벗어나는 부분이 있었어서, 문제가 제대로 해결되지 않아서,  
long형으로 바꿔주었다.