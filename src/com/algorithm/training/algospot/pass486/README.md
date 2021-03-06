## PASS486

**Difficulty:** Medium

https://algospot.com/judge/problem/read/PASS486

재훈이는 한 번 담배를 끊겠다고 다짐할 때마다 이메일 계정 비밀번호를 바꾸는 습관이 있습니다. <br/>
재훈이는 비밀번호를 항상 "no-smok**X**" 와 같이 정하는데, 여기서 X는 1자리 이상의 자연수입니다. <br/>
재훈이에게는 k번째로 금연을 다짐할 때는 항상 정확히 k개의 약수를 갖는 숫자로 X를 선택하는 습관이 있습니다. <br/>
예를 들어 재훈이가 12번째로 금연을 다짐했을 때 쓴 비밀번호는 no-smok486 이었습니다. <br/>
486 에는 1, 2, 3, 6, 9, .., 243, 486으로 모두 12개의 약수가 있으니까요.

재훈이는 금연을 다짐하고 비밀번호를 바꾼 뒤 잠들었는데, 아침에 일어나서는 비밀번호가 기억나지 않는다는 사실을 깨달았습니다. <br/>
재훈이가 어렴풋이 기억하는 것은 비밀번호가 n개의 약수를 가진다는 사실과, 비밀번호가 아마도 [lo,hi] 범위 내에 있을 거라는 것 뿐입니다 (범위는 양 끝의 수를 포함합니다).

재훈이가 예상한 범위 내에 비밀번호가 될 수 있는 수가 몇 개나 되는지 계산하는 프로그램을 작성하세요. <br/>

입력 <br/>
입력의 첫 줄에는 테스트 케이스의 수 c(c <= 50)가 주어집니다. 그 후 c줄에 각 3개의 정수로 n (n < 400), lo , hi(1 <= lo <= hi <= 10,000,000)이 주어집니다. hi-lo 는 항상 1백만 이하입니다.

출력 <br/>
각 테스트 케이스마다, 해당 범위 내에 비밀번호가 될 수 있는 숫자가 몇 개인지 출력합니다.
```
Input:
3
2 2 10
12 486 486
200 1000000 2000000 

Output: 
4
1
19
```

**Note:**

**Show tag:** \#number\_theory

------------------------------------

**Solution** <br/>
시간복잡도 : O(nlogn) 공간복잡도 : O(n) (n=10000000)<br/>
미리 2부터 10000000까지의 각 수의 약수의 개수를 배열에 저장해두고 <br/>
input이 주어지면 해당 구간의 수에 대해서 배열에 접근하여 O(1)만에 약수의 개수를 얻어서 정답을 구한다. <br/>

시간복잡도는 미리 약수를 구해두는 작업에 영향을 받는다. <br/>
hi의 max값인 10000000를 n이라고 하면, <br/>
바깥 for문은 n만큼 수행되며 <br/>
숫자 i에 대해서 안쪽 for문은 n/i만큼 수행된다. <br/>
안쪽for문은 n * (시그마 i=1부터 n까지 1/i)로 표현 가능한데, n에 곱해지는 (시그마 i=1부터 n까지 1/i)는 조화급수(armonic seriese)로 이 값은 항의 수가 무한히 증가함에 따라 발산하지만 결국 항의 수가 아주 커지면 ln n과 거의 같아진다. <br/>
따라서 시간복잡도는 nlogn이 된다. <br/>
(알고리즘 문제해결 전략 505p에 상세하게 나와있다.) <br/>

참고자료 : 조화급수(https://ko.wikipedia.org/wiki/%EC%A1%B0%ED%99%94%EA%B8%89%EC%88%98) <br/>

**Best Main : Using Eratosthenes** <br/>
시간복잡도 : O(nloglogn) 공간복잡도 : O(n) (n=10000000) <br/>
시간복잡도는 가장 작은 소인수를 minFactor에 채우는 반복문에 의해서 결정된다. <br/>

3개의 배열을 사용하는데 각각의 배열의 의미는 아래와 같다.<br/>
* minFactor : 가장 작은 소인수를 저장
* minFactorPoew : 소인수 분해에 가장 작은 소인수가 몇승인지를 저장
* factorNumber : 약수의 개수를 저장

우선 에라토스테네스의 체를 이용하여 가장 작은 소인수를 minFactor에 저장한다. <br/>
minFactor를 이용한 소인수분해를 하여 약수의 개수를 셀 수 있지만, 소인수 분해를 하지 않고도 약수의 개수를 셀 수 있다. <br/>
약수의 개수를 구하고자 하는 수를 a라고 하면 a의 minFactor로 나눈 수 b를 얻는다. <br/>
b의 minFactorPow와 factorNumber를 가지고 a의 minFactorPow와 factorNumber를 계산할 수 있다. <br/>
* minFactorPow 계산
	* b의 minFactor가 a의 minFactor와 같을 경우에는 a의 minFactorPow는 b의 minFactorPow+1가 되며 <br/>
	* b의 minFactor가 a의 minFactor와 다를 경우에는 a의 minFactorPow는 1이 된다. <br/>
* factorNumber의 계산
	* a와 b의 차이는 a에는 a의 minFactor가 한번 더 곱해져 있다는 것이다. (a의 minFactor를 c라고 지칭)
	* 따라서 a의 약수의 개수를 구하기 위해서는 b의 약수의개수 / b에서 c의 승수+1 \* a에서 c의 승수+1 를 해주면 된다.
	* b에서의 c의 승수+1는 a의 minFactorPow와 같고 a에서의 c의 승수+1는 minFactorPow+1이다.
	* 즉, factorNumber[a] = factorNumber[b]/minFactorPow[a]\*(minFactorPow[a]+1)