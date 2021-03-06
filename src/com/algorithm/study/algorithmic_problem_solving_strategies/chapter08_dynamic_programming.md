8장. 동적 계획법

* 동적계획법(dynamic programming)
	* 처음 주어진 문제를 더 작은 문제들로 나눈 뒤 각 조각의 답을 계산하고, 이 답들로부터 원래 문제에 대한 답을 계산

* 동적계획법과 분할정복의 차이
	* 문제를 나누는 방식
	* 동적 계획법에서 어떤 부분 문제는 두 개 이상의 문제를 푸는데 사용될 수 있기 때문에, 이 문제의 답을 여러번 계산하는 대신 한 번만 계산하고 계산결과를 재활용함으로써 속도의 향상을 꾀할 수 있음

* 메모리제이션
	* 캐시(cache) : 이미 계싼한 값을 저장해 두는 메모리의 장소
	* 부분 문제(overlapping subproblems) : 두 번 이상 계산되는 부분 문제
	* 구현 패턴
		1. 기저 사례 처리
			* 입력이 범위를 벗어난 경우 등을 기저사례로 처리해야 함
			* 기저 사례를 확인하지 않고 cache에 접근하면 범위를 벗어나는 등의 오류가 있을 수 있음
		2. 캐시에서 해당 부분문제에 대한 값을 얻어와서 답을 구한적이 있다면 바로 반환
		3. 답을 구현한 적이 없다면 답을 구한 후 캐시에 저장하고 반환
	* 시간 복잡도 분석
		* 일반적으로, (존재하는 부분 문제의 수) X (한 부분 문제르 풀 때 필요한 반복문의 수행 횟수)
			* 위의 식은 수행시간의 상한을 간단히 계산할 수 있는 방법 일 뿐이며, 항상 정확하지 않음
			* 존재할 수 있는 모든 부분 문제 중 일부분만을 계산해도 답을 찾을 수 있는 경우에는 위의 식보다 더 작아질 수 있음
			
* 동적계획법의 사용처
	1. 최적화 문제 :여러 개의 가능한 답 중 가장 좋은 답(최적해)을 찾아내는 문제
		* 최적 부분 구조 : 각 부분 문제의 최적해만 있으면 전체 문제의 최적해를 얻어낼 수 있는 구조 (지금까지 어떤 경로로 이 부분 문제에 도달했건 남은 부분 문제는 항상 최적으로 풀어도 상관없는 구조)
		* 최적화 문제 동적 계획법 레시피
			1. 모든 답을 만들어 보고 그 중 최적해를 반환하는 완전 탐색 알고리즘을 설계한다.
			2. 전체 답의 결과를 반환하는 것이 아니라, 앞으로 남은 선택들에 해당하는 점수만을 반환하도록 부분 문제 정의를 바꾼다.
			3. 재귀 호출의 입력에 이전의 선택에 관련된 정보가 있다면 꼭 필요한 것만 남기고 줄인다. 부분문제를 호출할 때 필요한 입력의 개수를 줄이면 더 많은 부분 문제가 중복되므로, 메모리제이션을 최대한으로 활용할 수 있다.
			4. 입력이 배열이거나 문자열인 경우 가능하다면 적절한 변환을 통해 메모리제이션을 할 수 있도록 한다.
			5. 메모리제이션을 적용한다.
		* 예제 : 아래의 예제에서 3번, 4번
	2. 경우의 수와 확률
		* 유의해야 할 점 : 오버플로
			* 경우의 수를 세는 문제에서 답은 입력의 크기에 대해 지수적으로 증가하므로, 많은 경우 답이 32bit 정수형의 한게를 초과하기 쉬움
			* 답을 어떤수 M으로 나눈 값으로 출력하기를 요구하는 경우가 많음
				* 모듈라연산
		* 예제 : 아래의 예제에서 8번, 9번, 10번, 11번, 12번
	3. 완전 탐색 알고리즘
		* 예제 : 아래의 예제에서 10번

* 예제 <br/>
	1. 외발 뛰기 (JUMPGAME) : solve(2017-10-07)
	2. 와일드카드 (WILDCARD) : solve(2018-01-18)
	3. 삼각형 위의 최대 경로 (TRIANGLEPATH) : solve(2017-10-07)
	4. 최대 증가 부분 수열 (LIS) : solve(2017-10-08)
	5. 합친 LIS (JLIS) : solve(2017-10-09)
	6. 원주율 외우기 (PI) : solve(2017-10-09)
	7. Quantization(QUANTIZE)
	8. 타일링 방법의 수 세기 (TILING2) : solve(2017-10-10)
	9. 삼각형 위의 최대 경로 개수 세기 (TRIPATHCNT) : solve(2017-10-11)
	10. 장마가 찾아왔다 (SNAIL) : solve(2017-10-11)
	11. 비대칭 타일링 (ASYMTILING) : solve(2017-10-12)
	12. 폴리오미노 (POLY) : solve(2017-10-15)
	13. 두니발 박사의 탈옥 (NUMB3RS) : solve(2017-10-15)