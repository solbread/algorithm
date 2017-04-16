## Problem C. Play the Dragon

https://code.google.com/codejam/contest/5304486/dashboard#s=p2

You are a friendly dragon fighting to protect your lair from a greedy knight! <br/>
You have H\_d health points and an attack power of A\_d, and the knight has H\_k health points and an attack power of A\_k. <br/>
If your health drops to 0 or below at any point; you are knocked out and you instantly lose; if the knight's health drops to 0 or below at any point, the knight is knocked out and you win!

You will battle the knight in a series of turns.  <br/>
On each turn, you go first, and you can choose and execute any one of the following actions.

* Attack: Reduce the opponent's health by your own attack power.
* Buff: Increase your attack power by B for the rest of the battle.
* Cure: Your health becomes Hd.
* Debuff: Decrease the opponent's attack power by D for the rest of the battle. If a Debuff would cause the opponent's attack power to become less than 0, it instead sets it to 0.

Then, if the knight's health is greater than 0 following your action, the knight will execute an Attack action. <br/>
After that, the turn ends. (Note that a turn in which you defeat the knight still counts as a turn even though the knight does not get to act.)

Note that buffs stack with each other; every buff adds an additional B to your attack power. Similarly, debuffs stack with each other.

You would like to defeat the knight as fast as possible (if it is possible) so that you will not be late to help the villagers roast marshmallows at tonight's festival. <br/>
Can you determine the minimum number of turns in which you can defeat the knight, or that it is IMPOSSIBLE to do so?	

**문제 한글 해석**
탐욕스러운 기사로부터 은신처를 보호하기 위해 싸우는 용이다. <br/>
용은 H\_d의 health point를 가지며 A\_d의 공격력을 가진다. <br/>
기사는 H\_k의 health point를 가지며 A\_k의 공격력을 가진다. <br/>
먼저 health_point가 0 이하로 떨어지게 하는 사람이 이기는 것이다. <br>
기사와 차례대로 싸우는데, 아래의 action 중 하나를 선택해서 실행할 수 있다. 

*공격 : 자신의 공격력만큼 상대방의 health point를 떨어 뜨린다.
*버프 : 나머지 전투 동안에 공격력을 B만큼 증가시킨다.
*치료 : health가 h\_d가 된다.
*Debuff(디버프) : 나머지 전투 동안 상대방의 공격력을 D만큼 감소시킨다. 디버프로 인해 상대방의 공격력이 0보다 작아지면 0으로 설정된다.

입력은 H\_d, A\_d, H\_k, A\_k, B, D가 한 줄로 주어진다. <br/>
출력은 기사를 이길 수 없을 경우에는 IMPOSSIBLE, 이길 수 있을 경우에는 이기는데 필요한 최소 turn의 수를 출력한다.

```
input

4
11 5 16 5 0 0
3 1 3 2 2 0
3 1 3 2 1 0
2 1 5 1 1 1

output
Case #1: 5
Case #2: 2
Case #3: IMPOSSIBLE
Case #4: 5

In Case #1, you have 11 health and 5 attack, and the knight has 16 health and 5 attack. One possible optimal sequence of actions is:

* Turn 1: Attack, reducing the knight's health to 11. Then the knight attacks and reduces your health to 6.
* Turn 2: Attack, reducing the knight's health to 6. Then the knight attacks and reduces your health to 1.
* Turn 3: Cure, restoring your health to 11. Then the knight attacks and reduces your health to 6. (If you had attacked instead this turn, the knight's next attack would have caused you to lose.)
* Turn 4: Attack, reducing the knight's health to 1. Then the knight attacks and reduces your health to 1.
* Turn 5: Attack, reducing the knight's health to -4. You instantly win and the knight does not get another attack.

In Case #2, one possible optimal sequence of actions is:

* Turn 1: Buff, increasing your attack power to 3. Then the knight attacks and reduces your health to 1.
* Turn 2: Attack, reducing the knight's health to 0. You instantly win and the knight does not get another attack.
* In Case #3, the knight only needs two attacks to defeat you, and you cannot do enough damage fast enough to defeat the knight. You can indefinitely extend the combat by executing the Cure action after every attack, but it is impossible to actually defeat the knight.

In Case #4, one possible optimal sequence of actions is: Attack, Debuff, Buff, Attack, Attack.
```
