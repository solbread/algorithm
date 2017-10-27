package com.algorithm.training.hash_table.employee_importance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    Map<Integer, Employee> linkEmployeesMap;
    public int getImportance(List<Employee> employees, int id) {
        linkEmployeesMap = new HashMap<>();
        for(Employee employee : employees) {
            linkEmployeesMap.put(employee.id, employee);
        }
        return calSubordinatesImportance(id);
    }
    public int calSubordinatesImportance(int id) {
        int importance = linkEmployeesMap.get(id).importance;
        for(int subordinatesId : linkEmployeesMap.get(id).subordinates) {
            importance += calSubordinatesImportance(subordinatesId);
        }
        return importance;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, 5, Arrays.asList(2, 3)));
        employees.add(new Employee(2, 3, Arrays.asList()));
        employees.add(new Employee(3, 3, Arrays.asList()));
        System.out.println(solution.getImportance(employees, 1));
    }
}

/*
시간복잡도 : O(n) 공간복잡도 : O(n) <br/>
map에다가 employee id를 key로 하여 정보를 저장해두고 <br/>
(처음에는 map의 value에 entry로 employee의 importance와 subordinates를 저장하는 방법으로 구현하였는데, 그냥 employee 객체를 넣는것으로 리펙토링) <br/>
찾고자 하는 id에서 출발하여 함수를 재귀호출 하며 dfs로 모든 부하직원들을 타고 내려가서 최종적인 importance를 구하였다. <br/>
 */
