## Problem C. Pony Express

https://code.google.com/codejam/contest/8294486/dashboard#s=p2

It's the year 1860, and the Pony Express is the fastest mail delivery system joining the East and West coasts of the United States. <br/>
This system serves N different cities. <br/>
In each city, there is one horse (as in the expression "one-horse town"); each horse travels at a certain constant speed and has a maximum total distance it can travel before it becomes too tired to continue.

The Pony Express rider starts off on the starting city's horse. <br/>
Every time the rider reaches a city, they may continue to use their current horse or switch to that city's horse; switching is instantaneous. <br/>
Horses never get a chance to rest, so whenever part of a horse's maximum total distance is "used up", it is used up forever! <br/>
When the rider reaches the destination city, the mail is delivered.

The routes between cities were established via complicated negotiations between company owners, lawmakers, union delegates, and cousin Pete. <br/>
That means that the distances between cities do not necessarily follow common sense: for instance, they do not necessarily comply with the triangle inequality, and the distance from city A to city B might be different from the distance from city B to city A!

You are a time traveling entrepreneur, and you have brought a fast computer from the future. <br/>
A single computer is not enough for you to set up an e-mail service and make the Pony Express obsolete, but you can use it to make optimal routing plans for the Pony Express. <br/>
Given all data about routes between cities and the horses in each city, and a list of pairs of starting and ending cities, can you quickly calculate the minimum time necessary for each delivery? <br/>
(You should treat all of these deliveries as independent; using cities/horses on one route does not make them unavailable on other routes.)

**문제 한글 해석** <br/>
Pony express는 가장 빠른 우편 배달 시스템이다. <br/>
이 시스템은 N개의 다른 도시에 서비스를 제공하며, 각 도시마다 한마리의 말이 있는데 이 말은 속력과, 해당 속력으로 이동할 수 있는 거리가 있다. <br/>
rider가 start 도시에서 출발하여 경유 도시에 도착할 때 마다 말을 교체할지 말지를 결정할 수 있다. <br/>
기수가 end(도착지) 도시에 도착하면 우편물을 배달이 종료된다. <br/>
참고로 경로는 복잡한 협상을 통해 결정되어 A에서 B의 도시의 거리가 B에서 A도시의 거리가 다를 수 있다. <br/>
시작 도시에서 출발하여 목적지 도시까지 도착하는데 걸릴 수 있는 최소 시간을 구하는 것이 목표이다. <br/>

입력은 첫줄에는 말이 있는 도시의 수(N)와 배달물의 개수(Q)가 주어진다. <br/>
다음줄부터 N개의 줄은 말이 최대 이동할 수 있는 거리 (E)와 속력(S) km/h가 주어진다. <br/>
다음줄 부터 N개의 줄은 N개의 공백으로 분류되어 N * N 행렬과 같은데, D_ij는 도시 j에서 도시 j로 가는 경로가 없다면 -1, 있다면 km 단위의 거리이다. <br/>
다음줄부터 Q개의 줄은 각각 배달물의 도시의 시작지점(start)과 목적지지점(end)이다.

```
Input 
3
3 1
2 3
2 4
4 4
-1 1 -1
-1 -1 1
-1 -1 -1
1 3
4 1
13 10
1 1000
10 8
5 5
-1 1 -1 -1
-1 -1 1 -1
-1 -1 -1 10
-1 -1 -1 -1
1 4
4 3
30 60
10 1000
12 5
20 1
-1 10 -1 31
10 -1 10 -1
-1 -1 -1 10
15 6 -1 -1
2 4
3 1
3 2

Output
Case #1: 0.583333333
Case #2: 1.2
Case #3: 0.51 8.01 8.0

In Case #1 there are two options: use the horse in city 1 for the entire trip, or change horses in city 2. <br/>
Both horses have enough endurance, so both options are viable. <br/>
Since the horse in city 2 is faster, it is better to change, for a total time of 1/3 + 1/4.

In Case #2 there are two intermediate cities in which you can change horses. <br/>
If you change horses in city 2, however, your new horse, while blazingly fast, will not have enough endurance, so you will be forced to change again in city 3. <br/>
If you keep your horse, you will have the option to change horses (or not) in city 3. <br/>
So, the three options, with their total times, are:

1. Change horses in both city 2 and 3 (1/10 + 1/1000 + 10/8 = 1.351). 
2. Change horses just in city 3 (2/10 + 10/8 = 1.45).
3. Never change horses (12/10 = 1.2).

In Case #3, there are lots of alternatives for each delivery. <br/>
The optimal one for the first delivery (city 2 to city 4) is to go to city 1 in time 10/1000, change horses, and then go to cities 2, 3 and 4, in that order, using the horse from city 1, which takes time (10 + 10 + 10) / 60.
For the second delivery (city 3 to city 1) you have no choice but to first go to city 4 which takes time 10/5. <br/>
Your relatively fast horse does not have enough endurance to get anywhere else, so you need to grab the horse in city 4. <br/>
You could use it to get directly to city 1 in time 15, but that would be slower than riding it to city 2 in time 6 and then using the blazingly fast horse in city 2 to get to city 1 in just 10/1000 extra time.

In the third delivery (city 3 to city 2) of Case #3 it is optimal to use the first two steps of the previous one, for a total time of 10/5 + 6 = 8.
```

-----------------------------------------------------

**Solution : just idea** <br/>
Dynamic programmin을 이용하려고 하였는데 구현에 실패하였다. <br/>
start 지점에서 시작하여 어떤 방향으로도 가능하다면 이동할 수 있고 이 때 말을 바꿀지 안바꿀지도 선택해서 dp를 구현한다. <br/>
때로는 이동의 방향이 start->end가 아니라 다른 방향으로 가서 빠른 말을 가지고 와서 이동하는 경로도 고려해야 하므로 굉장히 복잡하게 느껴졌다. <br/>
위의 모든 조건을 모두 고려해서 구현하는 것이 어려워서 구현하지 못하였다.