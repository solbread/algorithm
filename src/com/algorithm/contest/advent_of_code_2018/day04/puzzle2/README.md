## Repose Record Puzzle2

https://adventofcode.com/2018/day/4

Strategy 2: Of all guards, which guard is most frequently asleep on the same minute?

What is the ID of the guard you chose multiplied by the minute you chose?  


```
For example, consider the following records, which have already been organized into chronological order:

[1518-11-01 00:00] Guard #10 begins shift
[1518-11-01 00:05] falls asleep
[1518-11-01 00:25] wakes up
[1518-11-01 00:30] falls asleep
[1518-11-01 00:55] wakes up
[1518-11-01 23:58] Guard #99 begins shift
[1518-11-02 00:40] falls asleep
[1518-11-02 00:50] wakes up
[1518-11-03 00:05] Guard #10 begins shift
[1518-11-03 00:24] falls asleep
[1518-11-03 00:29] wakes up
[1518-11-04 00:02] Guard #99 begins shift
[1518-11-04 00:36] falls asleep
[1518-11-04 00:46] wakes up
[1518-11-05 00:03] Guard #99 begins shift
[1518-11-05 00:45] falls asleep
[1518-11-05 00:55] wakes up
Timestamps are written using year-month-day hour:minute format. 
The guard falling asleep or waking up is always the one whose shift most recently started. 
Because all asleep/awake times are during the midnight hour (00:00 - 00:59), 
only the minute portion (00 - 59) is relevant for those events.

Visually, these records show that the guards are asleep at these times:

Date   ID   Minute
            000000000011111111112222222222333333333344444444445555555555
            012345678901234567890123456789012345678901234567890123456789
11-01  #10  .....####################.....#########################.....
11-02  #99  ........................................##########..........
11-03  #10  ........................#####...............................
11-04  #99  ....................................##########..............
11-05  #99  .............................................##########.....

In the example above, Guard #99 spent minute 45 asleep more than any other guard or minute - three times in total.  
(In all other cases, any guard spent any minute asleep at most twice.)
(In the above example, the answer would be 99 * 45 = 4455.)
```

---------------------------

**Solution**  
시간복잡도 : O(n) 공간복잡도 : O(n) (n=input의 라인수)  
정답 : 76576  
시간순으로 정렬하기 위해서 주어진 문자열을 정렬한 후 guard들의 수면시간을 cache에 체크한다.   
cache는 guardId를 key로 가지며, value는 60크기의 int형 배열인데, 
index에는 각 guard가 각 분에 잠을 잔 카운트를 센다.  
전체 guard에 대해 cache를 채운 후에는, 전체 guard의 수면 테이블을 체크하면서 같은 시간에 가장 많이 잔 guard의 id와 해당 시간을 구한다.  

input을 한줄한줄 읽으면서 답을 구하기 때문에 시간복잡도는 input의 라인수이다.  
(정확하게 말하면 input을 읽으면서 guard의 수면시간에 체크를 하는 부분에서 최대 60번의 반복이 있어 60n이다.)  
공간복잡도의 경우에는 cache맵의 key의 개수는 guard의 수 인데, input에 들어온 guard가 모두 다를때가 worst case이므로 이 경우는 1/3n이다.
또한 추가적으로 map안에 60개 크기의 배열을 가지므로 1/3n*60 = 20n으로 볼 수있다.
