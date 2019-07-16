## 101. Symmetric Tree

**Difficulty:** Easy

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
�¿찡 ��Ī���� �Ǵ��ϱ� ���ؼ��� ���� depth������ �ٱ� ���ʿ������� �������ΰ��鼭 ������ Ȯ���ϸ� �� <br/>
���� ��Ʈ �Ʒ��� �ΰ��� ��Ʈ���� ���ʳ���� left�� ������ ����� right�� ���ϰ�, <br/>
���ʳ���� right�� �����ʳ���� left�� ���ϸ� �¿��Ī���� �Ǵ� ���� <br/>
��� ���ʳ���� left�� �����ʳ���� right / ���ʳ���� right�� �����ʳ���� left �̿� ���� ������� ��͸� Ÿ�� �� <br/>
�� Ǯ�̹���� ���̿켱Ž������(�̰��� ���� ����.. �ƴҼ�������) 

**BestSolution : using iteratively** <br/>
���� ������ �ݺ����� ����Ѱ����� ��ȯ�� �� (������ ������� ��Ǯ����) <br/>
��������� �����ϰ� �����ϸ� <br/>
stack�� ��Ʈ�� left�� right�� ���� �� <br/>
while���� �ݺ��ϸ� �ΰ��� TreeNode�� pop�Ͽ� ���� �� <br/>
���1�� left, ���2�� right, ���1�� right, ���2�� left ������� �ٽ� ���ÿ� �־��� <br/>
���� ������ ������ �������� �ݺ��ϸ� �� <br/>
�� stack�� null�� ��������� NullPointerException�� �߻��ϹǷ� �� ó������� ��
