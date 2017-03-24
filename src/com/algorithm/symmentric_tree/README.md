## 101. Symmetric Tree

https://leetcode.com/problems/symmetric-tree/#/description

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

   1 <br/>
   / \ <br/>
  2   2 <br/>
 / \ / \ <br/>
3  4 4  3 <br/>

But the following [1,2,2,null,3,null,3] is not: <br/>
    1 <br/>
   / \ <br/>
  2   2 <br/>
   \   \ <br/>
   3    3 <br/>
   
**Show tag:** \#tree \#depth\_first\_search \#breath\_first_search

-----------------------------------

**Solution1 : using recursively** </br>
좌우가 대칭인지 판단하기 위해서는 같은 depth에서는 바깥 양쪽에서부터 안쪽으로가면서 같은지 확인하면 됨 <br/>
따라서 루트 아래의 두개의 노트에서 왼쪽노드의 left와 오른쪽 노드의 right를 비교하고, <br/>
왼쪽노드의 right와 오른쪽노드의 left를 비교하면 좌우대칭인지 판단 가능 <br/>
계속 왼쪽노드의 left와 오른쪽노드의 right / 왼쪽노드의 right와 오른쪽노드의 left 이와 같은 방법으로 재귀를 타면 됨 <br/>
이 풀이방법은 깊이우선탐색같음(이것은 나의 생각.. 아닐수도있음) 

**BestSolution : using iteratively** <br/>
위의 구현을 반복문을 사용한것으로 변환한 것 (구현이 어려워서 못풀었음) <br/>
구현방법을 간단하게 정리하면 <br/>
stack에 루트의 left와 right를 넣은 후 <br/>
while문을 반복하며 두개의 TreeNode를 pop하여 비교한 후 <br/>
노드1의 left, 노드2의 right, 노드1의 right, 노드2의 left 순서대로 다시 스택에 넣어줌 <br/>
위의 과정을 스택이 빌떄까지 반복하면 됨 <br/>
※ stack에 null을 집어넣으면 NullPointerException이 발생하므로 널 처리해줘야 함
