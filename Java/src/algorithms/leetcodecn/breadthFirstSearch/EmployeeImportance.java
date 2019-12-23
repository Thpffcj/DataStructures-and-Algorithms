package algorithms.leetcodecn.breadthFirstSearch;

/**
 * Created by thpffcj on 2019/12/23.
 */

import java.util.*;

/**
 * 给定一个保存员工信息的数据结构，它包含了员工唯一的id，重要度 和 直系下属的id。
 * 比如，员工1是员工2的领导，员工2是员工3的领导。他们相应的重要度为15, 10, 5。那么员工1的数据结构是[1, 15, [2]]，员工2的数据结
 * 构是[2, 10, [3]]，员工3的数据结构是[3, 5, []]。注意虽然员工3也是员工1的一个下属，但是由于并不是直系下属，因此没有体现在员工1的
 * 数据结构中。
 * 现在输入一个公司的所有员工信息，以及单个员工id，返回这个员工和他所有下属的重要度之和。
 *
 * 示例 1:
 * 输入: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
 * 输出: 11
 * 解释:
 * 员工1自身的重要度是5，他有两个直系下属2和3，而且2和3的重要度均为3。因此员工1的总重要度是 5 + 3 + 3 = 11。
 *
 * 注意:
 * 一个员工最多有一个直系领导，但是可以有多个直系下属
 * 员工数量不超过2000。
 */
public class EmployeeImportance {

    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }


    public int getImportance(List<Employee> employees, int id) {

        Map<Integer, Employee> map = new HashMap<>();
        for (int i = 0; i < employees.size(); i++) {
            map.put(employees.get(i).id, employees.get(i));
        }

        Queue<Employee> queue = new LinkedList<>();
        Employee leader = map.get(id);
        queue.offer(leader);

        int result = 0;
        while (!queue.isEmpty()) {
            Employee employee = queue.poll();
            result += employee.importance;
            // 这个写法有点酷
            for (int employeeId : employee.subordinates) {
                queue.offer(map.get(employeeId));
            }
        }

        return result;
    }

    Map<Integer, Employee> emap;

    /**
     * 深度优先遍历
     * @param employees
     * @param queryid
     * @return
     */
    public int getImportance2(List<Employee> employees, int queryid) {
        emap = new HashMap();
        for (Employee e: employees) {
            emap.put(e.id, e);
        }
        return dfs(queryid);
    }

    public int dfs(int eid) {
        Employee employee = emap.get(eid);
        int ans = employee.importance;
        for (Integer subId: employee.subordinates) {
            ans += dfs(subId);
        }
        return ans;
    }
}
