## 532. K-diff Pairs in an Array

https://leetcode.com/problems/k-diff-pairs-in-an-array/#/description

Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array.
Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.

`
Input: [3, 1, 4, 1, 5], k = 2
Output: 2
Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
Although we have two 1s in the input, we should only return the number of unique pairs.
`

**Solution**
Time complexity : 최선O(nlogn) 최악(n^2)
해당 배열을 정렬한 후 중첩for문으로 배열을 모두 돌면서 수의 차이가 k인 쌍을 찾음
만약 두 수의 차이가 k보다 크게되면 두번째 for문은 종료
중복 체크는 Set컬렉션을 사용

**Best Solution**
Time complexity : O(n)
Map에 번호와 번호가 몇번등장했는지를 저장
Map을 순회하면서 두 수의 차이가 k인경우가 있는지 확인
이 경우에는 k가 마이너스인 경우에 대한 예외처리가 필요
