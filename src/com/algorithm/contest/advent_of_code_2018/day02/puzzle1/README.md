## Inventory Management System Puzzle 1

https://adventofcode.com/2018/day/2

You stop falling through time, catch your breath, and check the screen on the device.  
"Destination reached. Current Year: 1518. Current Location: North Pole Utility Closet 83N10."  
You made it! Now, to find those anomalies.

Outside the utility closet, you hear footsteps and a voice.  
"...I'm not sure either.  But now that so many people have chimneys, maybe he could sneak in that way?"  
Another voice responds, "Actually, we've been working on a new kind of suit that would let him fit through tight spaces like that.  
But, I heard that a few days ago, they lost the prototype fabric, the design plans, everything!  
Nobody on the team can even seem to remember important details of the project!"

"Wouldn't they have had enough fabric to fill several boxes in the warehouse?  
They'd be stored together, so the box IDs should be similar.  
Too bad it would take forever to search the warehouse for two similar box IDs..."  
They walk too far away to hear any more.

Late at night, you sneak to the warehouse - who knows what kinds of paradoxes you could cause if you were discovered -  
and use your fancy wrist device to quickly scan every box and produce a list of the likely candidates (your puzzle input).

To make sure you didn't miss any, you scan the likely candidate boxes again,  
counting the number that have an ID containing exactly two of any letter and then separately counting those with exactly three of any letter.  
You can multiply those two counts together to get a rudimentary checksum and compare it to what your device predicts.


```
For example, if you see the following box IDs:

abcdef contains no letters that appear exactly two or three times.
bababc contains two a and three b, so it counts for both.
abbcde contains two b, but no letter appears exactly three times.
abcccd contains three c, but no letter appears exactly two times.
aabcdd contains two a and two d, but it only counts once.
abcdee contains two e.
ababab contains three a and three b, but it only counts once.
Of these box IDs, four of them contain a letter which appears exactly twice, 
and three of them contain a letter which appears exactly three times. 
Multiplying these together produces a checksum of 4 * 3 = 12.

What is the checksum for your list of box IDs?

Your puzzle answer was 8398.
```

---------------------------

**Solution**  
시간복잡도 : O(n\*m) 공간복잡도 : O(m) (n=주어진 배열의 개수, m=주어진 문자열의 길이)  
문자열에 대해 등장한 문자를 맵에다가 카운트 한다.  
카운트가 끝나고 나면 한 문자열에 문자가 2번 등장하는 경우와 3번 등장하는 경우를 체크한다.  
(이로 인해 각 문자열에 대해 문자열 길이만큼 2번 순회하므로 정확한 시간 복잡도는 O(n\*2\*m)이 될 것이다.)  
이를 전체 문자열에 대해 수행하여 최종 checksum을 구한다.

