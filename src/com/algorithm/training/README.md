TODO LIST

* 미해결 문제
	* dynamic_programming.quantize
	* dynamic_programing.ocr
	* dynamic_programming.klis (런타임에러)
	* greedy.minastirith
	* design.lfu_cache
	* design.lru_cache
	* combinatorial\_search.boardcover2 (추후 C++로 바꿔풀어볼것)
	* combinatorial\_search.allergy.Main (wrong answer 원인 찾기)
	* array.mycalendar2
	
* 공부해야할 부분
	* Knapsack Problem
		* Bounded Knapsack Problem
		* Unbounded Knapsack Problem
		* Fractional Knapsack Problem
	* LIS (dynamic_programming.lis)
		* 인덱스트리를 이용한 LIS 구현
	* dynamic\_programming.morse Main2
	* dynamic\_programming.graduation Main
		* 비트마스크를 만들어줄 때 +연산으로 하면 wrong answer가 되는 이유
	* dynamic\_programming.tictactoe
		* 틱택토 게임의 중복을 제거 하여 더 빠르게 구현하기
	* dynamic_programming.numbergame	
		* 미니맥스 알고리즘을 이용한 구현
	* 알고리즘문제해결전략 351p 행렬 거듭 제곱을 이용한 동적 계획법(피보나치)
	* 알고리즘문제해결전략 515p~156p
		* 확장유클리드 알고리즘
		* 중국인 나머지정리
		* 루카스의 정리
		* 참고자료
			* 중국인의 나머지 정리와 확장 유클리드 알고리즘 http://blog.myungwoo.kr/55
			* 나머지 연산의 곱셈 역원 https://www.acmicpc.net/blog/view/29
	* 거듭제곱 연산할 때 O(1)만에 하기
		* skill.pow.CalculatePow3
	* 알고리즘문제해결전략 402p~421p 조합탐색기법들 공부 후 정리
	* combinatorial\_search.allergy
		* 음식을 선택할 때, 가장 많은 사람이 먹을 수 있는 음식부터 시도하는 방향으로 알고리즘 최적화하기
	* combinatorial\_search.kakuro2
		* fillBoard에서 후보의 수가 가장 적은 칸을 찾기위해 호출되는 부분을 더 최적화하기
	* binar\_search.arctic
		* 이진탐색을 반복하는 반복문의 횟수를 너프하게 잡은 100번 말고 소수점 셋째자리 이상의 자릿수의 변화가 없어서, 더이상의 연산이 무의미해질때 만큼만 반복하도록 반복문의 조건을 개선하기
		* 참고로 while(hi - lo >= 0.005)은 wrong answer
