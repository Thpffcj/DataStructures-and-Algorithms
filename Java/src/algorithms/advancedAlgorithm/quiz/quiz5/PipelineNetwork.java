package algorithms.advancedAlgorithm.quiz.quiz5;

/**
 * Created by thpffcj on 2019/11/28.
 */

import java.util.*;

/**
 * Description
 * Every house in the colony has at most one pipe going into it and at most one pipe going out of it. Tanks and
 * taps are to be installed in a manner such that every house with one outgoing pipe but no incoming pipe gets a
 * tank installed on its roof and every house with only an incoming pipe and no outgoing pipe gets a tap. Find
 * the efficient way for the construction of the network of pipes.
 *
 * Input
 * The first line contains an integer T denoting the number of test cases. For each test case, the first line
 * contains two integer n & p denoting the number of houses and number of pipes respectively. Next, p lines
 * contain 3 integer inputs a, b & d, d denoting the diameter of the pipe from the house a to house b.
 * Constraints:1<=T<=50，1<=n<=20，1<=p<=50，1<=a, b<=20，1<=d<=100
 *
 * Output
 * For each test case, the output is the number of pairs of tanks and taps installed i.e n followed by n lines
 * that contain three integers: house number of tank, house number of tap and the minimum diameter of pipe between
 * them.
 *
 * Sample Input 1
 * 1
 * 9 6
 * 7 4 98
 * 5 9 72
 * 4 6 10
 * 2 8 22
 * 9 7 17
 * 3 1 66
 *
 * Sample Output 1
 * 3
 * 2 8 22
 * 3 1 66
 * 5 6 10
 */
public class PipelineNetwork {

    static class Connection {

        int n;
        List<Integer>[] adjList;
        List<Integer>[] weightList;

        Connection(int n) {
            this.n = n;
            adjList = new ArrayList[n];
            weightList = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                adjList[i] = new ArrayList<Integer>();
                weightList[i] = new ArrayList<Integer>();
            }
        }

        public void createConnections(int src, int dest, int weight) {
            adjList[src-1].add(dest-1);
            weightList[src-1].add(weight);
        }

        public void DFS(int start, List<Integer> li, List<Integer> we) {
            List<Integer> conn = adjList[start];
            List<Integer> weight = weightList[start];
            if (conn.isEmpty()) {
                return;
            }
            for (int i = 0; i < conn.size(); i++) {
                li.add(conn.get(i));
                we.add(weight.get(i));
                DFS(conn.get(i), li, we);
            }
        }
    }
    
    public static void main (String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t > 0){
            int n = s.nextInt();
            int pipes = s.nextInt();
            boolean[] checked = new boolean[n];
            Connection c = new Connection(n);
            while(pipes > 0){
                c.createConnections(s.nextInt(),s.nextInt(),s.nextInt());
                pipes--;
            }
            List<String> res = new ArrayList<>();
            List<Integer> all = new ArrayList<>();
            Set<Integer> start = new HashSet<>();
            for (int i = 0; i < n; i++) {
                all.add(i);
                start.addAll(c.adjList[i]);
            }
            all.removeAll(start);
            for (int i : all) {
                StringBuilder sb = new StringBuilder();
                List<Integer> li = new ArrayList<>();
                List<Integer> we = new ArrayList<>();
                c.DFS(i, li, we);
                Collections.sort(we);
                if(li.size()>0){
                    sb.append(String.valueOf(i + 1) + " ");
                    sb.append(String.valueOf(li.get(li.size() - 1) + 1));
                    sb.append(" " + String.valueOf(we.get(0)));
                    res.add(sb.toString());
                }
            }
            System.out.println(res.size());
            for (String str : res) {
                System.out.println(str);
            }
            t--;
        }
    }
}
