## Repose Record Puzzle1

https://adventofcode.com/2018/day/4

You've sneaked into another supply closet - this time, it's across from the prototype suit manufacturing lab.  
You need to sneak inside and fix the issues with the suit, but there's a guard stationed outside the lab, so this is as close as you can safely get.

As you search the closet for anything that might help, you discover that you're not the first person to want to sneak in.  
Covering the walls, someone has spent an hour starting every midnight for the past few months secretly observing this guard post!  
They've been writing down the ID of the one guard on duty that night - the Elves seem to have decided that one guard was enough for the overnight shift - as well as when they fall asleep or wake up while at their post (your puzzle input).

Find the guard that has the most minutes asleep. What minute does that guard spend asleep the most?
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
The columns are Date, which shows the month-day portion of the relevant day; 
ID, which shows the guard on duty that day; 
and Minute, which shows the minutes during which the guard was asleep within the midnight hour. 
(The Minute column's header shows the minute's ten's digit in the first row and the one's digit in the second row.)
Awake is shown as ., and asleep is shown as #.

Note that guards count as asleep on the minute they fall asleep, 
and they count as awake on the minute they wake up. 
For example, because Guard #10 wakes up at 00:25 on 1518-11-01, minute 25 is marked as awake.

If you can figure out the guard most likely to be asleep at a specific time, 
you might be able to trick that guard into working tonight so you can have the best chance of sneaking in. 
You have two strategies for choosing the best guard/minute combination.

Strategy 1: Find the guard that has the most minutes asleep. What minute does that guard spend asleep the most?

In the example above, Guard #10 spent the most minutes asleep, a total of 50 minutes (20+25+5), 
while Guard #99 only slept for a total of 30 minutes (10+10+10). 
Guard #10 was asleep most during minute 24 
(on two days, whereas any other minute the guard was asleep was only seen on one day).

While this example listed the entries in chronological order, 
your entries are in the order you found them. You'll need to organize them before they can be analyzed.

What is the ID of the guard you chose multiplied by the minute you chose? 
(In the above example, the answer would be 10 * 24 = 240.)
```

---------------------------

**Solution**  
시간복잡도 : O(n) 공간복잡도 : O(n) (n=input의 라인수)  
정답 : 20859  
시간순으로 정렬하기 위해서 주어진 문자열을 정렬한 후 guard들의 수면시간을 cache에 체크한다.   
cache는 guardId를 key로 가지며, value는 61크기의 int형 배열인데,  
0~59 index에는 각 guard가 각 분에 잠을 잔 카운트를 세며, 마지막 60번째 index에는 수면시간의 합을 저장한다.  
이런식으로 cache를 채워나가면서 가장 많이 자는 guard id를 구한 후, 미리 체크해놓은 해당 guard의 수면 테이블을 보고 가장 많이 잔 시간을 구한다.  

input을 한줄한줄 읽으면서 답을 구하기 때문에 시간복잡도는 input의 라인수이다.  
(정확하게 말하면 input을 읽으면서 guard의 수면시간에 체크를 하는 부분에서 최대 60번의 반복이 있어 60n이다.)  
공간복잡도의 경우에는 cache맵의 key의 개수는 guard의 수 인데, input에 들어온 guard가 모두 다를때가 worst case이므로 이 경우는 1/3n이다.
또한 추가적으로 map안에 61개 크기의 배열을 가지므로 1/3n*60 = 20n으로 볼 수있다.
