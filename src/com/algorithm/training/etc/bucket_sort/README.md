## Bucket Sort

**Difficulty:** None

균등하게 분포되어 있는 [0~n/10] 범위의 float 배열이 주어질 때 bucket sort를 이용하여 정렬한 배열을 반환하라.

```
Input:
[0.1, 0.3, 0,2, 0,4]

Ouput:
[0.1, 0.2, 0.3, 0.4]
```

**Note:** 

**Show tag:** \#sort

-----------------------------------------------

**Solution** <br/>
시간복잡도 : O(n) 공간복잡도 : O(n)
1. 빈 버킷을 n만큼 생성
2) 모든 원소들을 값에 따라 적절한 버킷에 넣음
3) 각각의 버킷을 삽입정렬을 사용하여 정렬
	* 자바에서 sort메소드
		* 7 미만의 작은 배열의 경우 insertion sort
		* integer 등의 정수는 merge sort
		* float 등의 부동 소수점 수는 quick sort 
4) 버킷 순서에 따라 데이터를 합침
