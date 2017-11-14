11장. 최적화 문제 결정 문제로 바꿔 풀기

* 최적화 문제를 결정 문제로 바꾼 뒤 이분법을 이용해 해결
	* 결정 문제 : 예 or 아니오의 결과가 나옴 -> 답의 수가 2가지
	* 최적화 문제 : 실수 or 정수 형태의 결과가 나옴  -> 답의 수가 무제한
	* 예시
		* 여행하는 외판원 문제(TSP)
			* 최적화 문제 : optimize(G) = 그래프 G의 모든 정점을 한 번씩 방문하고 시작점으로 되돌아오는 최단 경로의 길이를 반환
			* 결정 문제 : decision(G, x) = 그래프 G의 모든 정점을 한 번씩 방문하고 시작점으로 되돌아오면서 길이가 x이하인 경로의 존재 여부를 반환
			* optimize(G)는 가장 짧은 경로의 길이를 실수로 반환하지만, decision(G)은 최단 경로건 아니건 간에 x보다 짧은 경로가 있는지만을 확인하면 됨

* 최적화 문제와 결정 문제의 관계
	* 결정문제가 최적화 문제보다 어렵거나 시작복잡도가 클 일은 절대 없음
	```
	//최적화 문제
	double optimize(const Graph& g);
	
	//결정문제
	bool decision(const Graph& g, double x) {
		return optimize(g) < x;
	}
	``
	
* 예제
	1. DARPA Grand Challenge (DARPA)
	2. 남극기지 (ARCTIC)
	3. 캐나다 여행 (CANADATRIP)
	4. 수강 철회 (WITHDRAWAL)
	