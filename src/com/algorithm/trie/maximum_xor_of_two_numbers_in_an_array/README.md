## 421. Maximum XOR of Two Numbers in an Array

https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/#/description

Given a non-empty array of numbers, a\_0, a\_1, a\_2, … , a\_n-1, where 0 ≤ a\_i < 2^31.

Find the maximum result of a\_i XOR a\_j, where 0 ≤ i, j < n.

Could you do this in O(n) runtime?

```
Input: [3, 10, 5, 25, 2, 8]
Output: 28
Explanation: The maximum result is 5 ^ 25 = 28.
```

**Show tag:** \#bit_manipulation \#trie

-----------------------------------------------

**Solution**
주어진 배열의 원소들을 모두 trie에 넣는다. <br/>
trie는 length가 2인 Object배열이며 배열안에 배열안에 배열.. 이런식으로 연결하면서 trie구조를 만든다. <br/>
예를들어 1010 이 주어지면 32bit 기준으로 0000 0000 0000 0000 0000 0000 0000 1010 이므로 배열의 depth는 32까지 내려가는데 root 배열의 0인덱스에 Object[] 배열을 연결하고 이 배열의 0 인덱스에 Object[] 배열을 연결하고.. 이런식으로 맨왼쪽 자리부터(가장 큰자릿수) 이어나가서 trie 구조를 만드는 것이다. <br/>
32*n만큼의 루프를 이용하여 trie구조를 만들 수 있다. <br/>
이후에는 다시 배열의 원소들을 하나씩 순회하면서 maximumXOR값을 찾는다. <br/>
해당 원소가 다른원소들과 XOR을 해서 만들 수 있는 currentMaximumXOR값을 trie구조를 이용해서 찾으며 이를 이용해서 최종 maximumXor값을 찾는다. <br/>
currentMaximumXOR값을 찾는방법은 원소의 각 자릿수마다 비트값을 얻어서 현재 trie의 비트값^1 인덱스가 null이면 그 자릿수와 xor했을 때 1인 원소가 없다는 의미이므로 다음 current trie를 current[bit]로 해준다. <br/>
반면에 null이 아니면 그 자릿와 수xor했을 때 1인 원소가 있다는 의미이므로 currentMaximumXor에 (1<<i)를 더해주고 current trie를 current[bit^1]로 이동해준다. <br/>
(1<<i)의 의미는 해당 자릿수의 실제값을 찾는것이다. <br/>
위의 과정을 반복하여 currentMaximumXor을 찾고 최종적으로는 maximumXor을 찾을 수 있다. <br/>
**※** 참고로 trie구조를 만들때와 currentMaximumXor을 찾을때 해당숫자의 가장 왼쪽 자릿수의 비트(가장 큰 자릿수)에서 오른쪽 방향으로 봐야한다. <br/>
왜냐하면 1000은 0xxxx보다 무조건 크다(4bit숫자를기준으로). 즉 큰자릿수의 비트가 1인것을 발견하면 무조건 최대값으로 볼 수 있다. 따라서 xor을 할 때도 큰 자릿수부터 비교해서 currentMaximum값을 찾는 것이다. <br/>

**Best Solution**<br/>
출처 : https://discuss.leetcode.com/topic/63213/java-o-n-solution-using-bit-manipulation-and-hashmap/8 <br/>
설명을 시작하기 전에 아래의 공식을 이해하는 것이 중요 <br/>
**※** a^b=c 라고하면 a^c=b b^c=a <br/>
맨 왼쪽 자릿수가 가장 커야 maxXOR 값을 찾을 수 있으므로 맨 왼쪽 자릿수부터 for loop를(32번 반복) 봄 <br/>
32번 반복하는 for loop안에서 각각의 단어의 맨왼쪽에서첫번째자리수~i번째자릿수 까지를 뽑아내서 set안에 저장한 후 i번째 자릿수까지의 최대값을 구하면서 maximumXOR값을 찾음 <br/>
i번째 자릿수까지의 최대값을 구하는 방법은 아래와 같음 <br/>
a^b = c 라고 할 때 우리가 원하는 c 값은 i-1번째 자릿수까지의 최대값에서 i번째 자릿수가 1bit이 값임 (즉, max|(1<<i) <br/>
c를 구한 후 a와 b가 모두 set안에 있는지를 확인하면 됨 <br/>
c가 있으므로 c^a = b, c^b = a 이므로 set을 순회하면서 c와 xor한 것이 set안에 있는지를 확인하여 set 안에 있다면 c가 max값이 됨 

이 solution의 이해를 돕는 예시 ↓
```
example: Given [14, 11, 7, 2], which in binary are [1110, 1011, 0111, 0010].
Since the MSB is 3, I'll start from i = 3 to make it simplify.

i = 3, set = {1000, 0000}, max = 1000
i = 2, set = {1100, 1000, 0100, 0000}, max = 1100
i = 1, set = {1110, 1010, 0110, 0010}, max = 1100
i = 0, set = {1110, 1011, 0111, 0010}, max = 1100
```

