## 518. Coin Change 2

https://leetcode.com/problems/coin-change-2/

You are given coins of different denominations and a total amount of money. <br/>
Write a function to compute the number of combinations that make up that amount. <br/>
You may assume that you have infinite number of each kind of coin.

**Note:** You can assume that <br/>
0 <= amount <= 5000 <br/>
1 <= coin <= 5000 <br/>
the number of coins is less than 500 <br/>
the answer is guaranteed to fit into signed 32-bit integer <br/>

**Show tag:** \#dynamic\_programming

----------------------------------------------

**Solution : using recursively** <br/>
dp(int amount, int[] coins, int startIndex) 라는 메소드를 구현해서 재귀호출을 통해 해결했다. <br/>
dp함수의 의미는 startIndex부터 coins.length-1 범위까지의 coins를 가지고 있을 때 해당 coin들로 amount of money를 만들 수 있는 개수를 의미한다. <br/>
dp함수 안에서 startIndex부터 coins.length-1까지를 for loop 돌면서 <br/>
1. 해당 coin이 amount랑 같으면 횟수를 +1 해준다. <br/>
2. 해당 coin이 amount보다 작으면 dp(amoint-coint, coins, 해당index)를 호출한다. <br/>

이를 반복하여 주어진 coins로 amount를 만들 수 있는 가짓수를 찾는다.<br/>
또한 cache[amount][startIndex]를 사용하여 속도를 향상시킬 수 있다. <br/>

**refactoring** <br/>
1. 처음에는 coins함수를 sort를 해줬었는데 sort가 필요없음을 깨달았다 <br/>
가장 큰 코인값부터 amount에서 빼주려고 sort를 했는데 굳이 가장 큰 코인값부터 빼줄 이유가 없었다 <br/>
dp함수를 호출할 때 startIndex에 의해서 1,2 = 2,1 과 같은 중복처리가 되므로 sort는 필요없는 작업이다 <br/>
2. 2차원 행렬의 cache의 열 크기는 coins.length+1이 아니라 coins.length여도 된다. <br/>
안쓰는 공간을 낭비하고 있었다.

**반복문을 이용한 dp를 구현하기 위해서 해당 코드를 몇가지 방식으로 바꿔보았다** <br/>
**commit은 하지 않았다.** <br/>
1. 첫번째 시도 <br/>
기존에는 sort를 넣어서 큰값부터 빼줘야 한다는 생각에 startIndex는 length-1이었으며, for문은 i=startIndex부터 0까지 감소하면서 loop하였다. <br/>
그러나 sort가 제거되었으므로 startIndex를 0부터로 변경하였고 <br/>
dp함수의 for문도 startIndex부터 length-1로 변경하였다.

```
public class Solution {
    public int[][] cache;
    public int change(int amount, int[] coins) {
        if(amount==0) return 1;
        if(coins.length==0) return 0;
        cache = new int[amount + 1][coins.length + 1];
        for(int i = 0; i < cache.length; i ++) {
            for(int j = 0; j < cache[0].length; j++) {
                cache[i][j] = -1;
            }
        }
        return dp(amount, coins, 0);
    }
    
    public int dp(int amount, int[] coins, int startIndex) {
        if(cache[amount][startIndex] != -1) return cache[amount][startIndex];
        
        int result = 0;
        for(int i = startIndex; i < coins.length; i++) {
            if(amount-coins[i]==0) result++;
            else if(amount-coins[i]>0) result += dp(amount-coins[i], coins, i);
        }       
        cache[amount][startIndex] = result;
        return cache[amount][startIndex];
    }
}
```
2. 두번째 시도 <br/>
dp함수를 startIndex를 사용하는것에서 lastIndex를 사용하는것으로 변경하였다 <br/>
즉 dp(int amount, int[] coins, int lastIndex)의 의미는 coins의 0~lastIndex까지의 coin으로 amount를 만들 수 있는 가짓수 이다. <br/>
dp안의 for문은 lastIndex부터 0번째 인덱스까지 loop 돌면서 가짓수를 찾도록 하였다. <br/>
만약 amount=5, coins={5, 1, 2}가 주어질 때 최종 cache 행렬은 아래와 같다. <br/>
-1 -1 -1 <br/>
 1  1  1 <br/>
-1  1 -1 <br/>
-1  1  2 <br/>
-1 -1 -1 <br/>
-1 -1  4 <br/>
cache[i][j]가 의미하는 것은 coins 0부터j까지의 coin으로 money i를 만들 수 있는 가짓수 이다.<br/>
**이 코드를 기반으로 반복 dp로 옮겼다.** </br>

```
public class Solution {
    public int[][] cache;
    public int change(int amount, int[] coins) {
        if(amount==0) return 1;
        if(coins.length==0) return 0;
        cache = new int[amount + 1][coins.length + 1];
        for(int i = 0; i < cache.length; i ++) {
            for(int j = 0; j < cache[0].length; j++) {
                cache[i][j] = -1;
            }
        }
        return dp(amount, coins, coins.length-1);
    }
    
    public int dp(int amount, int[] coins, int lastIndex) {
        if(cache[amount][lastIndex] != -1) return cache[amount][lastIndex];
        
        int result = 0;
        for(int i = lastIndex; i >= 0; i--) {
            if(amount-coins[i]==0) result++;
            else if(amount-coins[i]>0) result += dp(amount-coins[i], coins, i);
        }       
        cache[amount][lastIndex] = result;
        return cache[amount][lastIndex];
    }
}
```
**Solution2 : using iteratively** <br/>
1 1 1 <br/>
0 1 1 <br/>
0 1 2 <br/>
0 1 2 <br/>
0 1 3 <br/>
1 2 4 <br/>

