## 804. Unique Morse Code Words

**Difficulty:** Easy

https://leetcode.com/problems/unique-morse-code-words/description/

International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.  

For convenience, the full table for the 26 letters of the English alphabet is given below:  
\[".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."\]  

Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter.  
For example, "cab" can be written as "-.-.-....-", (which is the concatenation "-.-." + "-..." + ".-"). We'll call such a concatenation, the transformation of a word.  

Return the number of different transformations among all words we have.  

```
Example:
Input: words = ["gin", "zen", "gig", "msg"]
Output: 2
Explanation: 
The transformation of each word is:
"gin" -> "--...-."
"zen" -> "--...-."
"gig" -> "--...--."
"msg" -> "--...--."

There are 2 different transformations, "--...-." and "--...--.".
```

**Note:**
* The length of words will be at most 100.
* Each words[i] will have length in range [1, 12].
* words[i] will only consist of lowercase letters.

**Show tag:** None

-------------------------------------

**Solution** <br/>
시간복잡도 : O(n\*m) 공간복잡도 : O(n) (n : word 개수, m : word 길이)  
각 word의 morse 표현식을 구한 후에 해당 표현식을 중복이 허용되지 않는 자료구조인 set에 넣은 후에, 최종적으로 만들어진 set의 크기를 반환하면 된다  
매우 간단하고 또 간단한 문제였다.
