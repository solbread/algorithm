## Iterative Algorithm

** 반복 알고리즘
	* 반복적인 방법으로 문제를 해결
	* 반복 알고리즘 타당성 증명에는 변하는 성질인 루프 변성, 변하지 않는 성질인 루프 불변성을 이용

* 루프 변셩 (Loop variants)
	* 반복문을 수행하면서 변하는 성질

* 루프 불변셩 (Loop Invariants)
	* 반복문을 수행하면서 변하지 않는 성질
	* 알고리즘에서 상태는 항상 변하지만, 상태에 상관 없이 항상 참이되는 일련의 구문들
	* 수학적 귀납법을 이용하여 종종 증명 됨
	* 알고리즘의 정확성을 증명하는데 주로 사용 됨
	* 세 가지 필요조건 (이 조건들이 만족될 때 루프가 이상없다고 한다.)
		1. Initialization
			* 루프의 첫 되풀이(Iteration), 초기 조건
			* 루프에 처음들어갈때 변수의 변화 및 statement(조건)의 변화가 맞는지 판단해서, 루프에 정확하게 들어가는지 확인한다.
		2. Maintenance
			* 전 되풀이가 참일 때, 다음 되풀이도 참이 되는 구문
			* 루프가 시작하기전부터해서, 다음 루프로 넘어가기 전까지 만족해야 되는 조건으로 이 조건이 알고리즘의 목적에 부합하는지를 판단한다.
		3. Termination
			* 루프가 끝날 때 쓸 만한 정보를 내면서, 알고리즘이 맞다는 것을 보임
			* 루프가 끝났을때, 우리는 사용가능하고 유용한 결과를 얻어야 하며, 이것이 문제해결(알고리즘의 목표)에 도움이 되는 결과가 나오는지 확인한다.
	* 너무 쉬운 조건의 Loop Invariants는 얻을 수 있는 정보가 없음
	* 너무 강력한 조건의 Loop Invariants는 유지가 힘듦

1. 예시 : \[start, end\]의 합계를 구하기

```
int sum = 0;
for(int i = start; i <= end; i++) {
	sum += i;
}
```

* 루프 변성 : i (start에서 end까지 순차적으로 증가)
* 루프 불변성 : sum (반복문을 몇 번 수행하든지 언제나 \[start, i\] 합계를 가진다.
* 루프 변성과 불변성을 이용한 반복 알고리즘 타당성 증명
	* 루프 변성에 의해 i값이 end까지 변하고 루프 불변성에 의해 반복문을 모두 수행하고 나면 sum에는 \[start, end\] 범위의 합을 가진다. 수행하든지 언제나 \[start, i\] 합계를 가진다.
* 루프 변성과 불변성을 이용한 반복 알고리즘 타당성 증명
	* 루프 변성에 의해 i값이 end까지 변하고 루프 불변성에 의해 반복문을 모두 수행하고 나면 sum에는 \[start, end\] 범위의 합을 가진다.
	
2. 예시 : Insertion Sort(삽입정렬)

```
for(int i = 1; i < A.length; i++){
	int temp = A[i];
	for(j = i-1; j >= 0 && temp < A[j]; j--){
		A[j+1] = A[j];
	}
	A[j+1] = temp;
}
```
* Initialization : i=1 에 대해서, A[0...i-1] = A[0] 이 정렬된다.
* Maintenance : i가 증가하고 그에따라 A[1...i-1]가 정렬된다.
* Termination : i = A.length일때 루프는 끝이나며, 루프가 끝이 났을때는 A[1...i-1] 은 정렬이 끝나있다.

* 이진 탐색과 루프 불변성
http://ehpub.co.kr/tag/%EB%A3%A8%ED%94%84-%EB%B6%88%EB%B3%80%EC%84%B1/page/3/

```
int lo = 0, hi = n;
while (lo < hi) {
	int mid = (hi-lo)/2 + lo;
	if(조건문) {
		hi = mid;
	} else {
		lo = mid + 1;
	}
}
```

_내가 생각하는 이진탐색의 루프불변성_ <br/>
* Initialization : lo = 0, hi = n에 대해서 [lo,mid], [mid+1] 중에 찾고자 하는 답이 있는 범위로 lo와 hi가 셋팅된다.
* Maintenance : 계속해서 범위가 줄어든다.
* Termination : lo == hi 일 때 루프는 끝이나며, 루프가 끝났을때는 [lo,hi]에 찾고하자는 답이 있는데 lo=hi이므로 답을 얻을 수 있다.


**참고자료** <br/>
* https://en.wikipedia.org/wiki/Loop_invariant
* http://ehpub.co.kr/tag/%EB%A3%A8%ED%94%84-%EB%B6%88%EB%B3%80%EC%84%B1/page/3/
* https://blog.naver.com/ancom2k/90021695760
* https://blog.naver.com/soonchan86/130023452408
* http://blog.naver.com/PostView.nhn?blogId=prcrfsy&logNo=220226954871&redirect=Dlog&widgetTypeCall=true
