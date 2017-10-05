** 알고리즘 문제해결전략 **

6장. 무식하게 풀기
* 최적화 문제 (Optimization problem)
	* 문제의 답이 하나가 아니라 여러 개이고, 그 중에서 어떤 기준에 따라 가장 좋은 답을 찾아내는 문제
	* n개의원소 중에서 r개를 순서없이 골라내는 방법의 수를 계산하는 것은 답이 하나밖에 없고, 더 좋은 답이나 덜 좋은 답이 없으므로 Optimization problem이 아님
	* n개의 사과 중에서 r개를 골라서 무게의 합을 최대화 하는 문제 or 가장 무거운 사과와 가장 가벼운 사과의 무게 차이를 최소화하는 문는 Optimization problem
	* 최적화문제를 풀기위한 가장 기초적인 것이 완전탐색 : 가능한 답을 모두 생성해 보고 그중 가장 좋은 것을 찾아냄

예제 <br/>
1. 보글게임(BOGGLE) : solve(10/3)
2. 소풍(PICNIC) : solve(10/3) 
3. 게임판덮기(BOARDCOVER)
4. 여행하는 외판원 문제(Traveling Sales-man Problem, TSP)
5. 시계 맞추기(CLOCKSYNC)

7장. 분할정복