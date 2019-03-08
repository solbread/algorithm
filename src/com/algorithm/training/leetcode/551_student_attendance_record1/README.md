## 551. Student Attendance Record I

**Difficulty:** Easy

https://leetcode.com/problems/student-attendance-record-i/#/description

You are given a string representing an attendance record for a student. <br/>
The record only contains the following three characters:

* 'A' : Absent.
* 'L' : Late.
* 'P' : Present.

A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).

You need to return whether the student could be rewarded according to his attendance record.

```
Input: "PPALLP"
Output: True
```

**Show tag:** \#string

--------------------------------------------

**Solution**
2번 이상 결석(A)를 하거나 3번 이상 연속으로 지각(L)을 하면 false이다. <br/>
String s에 대해서 2번 이상 결석을 하는 경우는 정규식 '\.\*A\.\*A\.\*'로 나타낼 수 있으며, <br/>
3번 이상 연속으로 지각을 하는 경우는 '\.\*LLL\.\*'로 나타낼 수 있다. <br/>
이러한 정규식을 matches 메소드로 이용해서 위의 경우에 해당되는지를 확인하면 간단하게 풀린다.