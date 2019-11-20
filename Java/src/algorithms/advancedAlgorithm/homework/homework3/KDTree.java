package algorithms.advancedAlgorithm.homework.homework3;

/**
 * Created by thpffcj on 2019/11/18.
 */

import java.util.*;

/**
 * Description
 * 对给定的点集合构造KD树，要求如下：将方差最大的维度作为当前的分割维度，将数据集在分割维度上排序后的中位数作为分割点。程序
 * 要检索给定点对应的最近的K个点的坐标。
 * <p>
 * Input
 * 输入第一行为测试用例个数，后面为测试用例，每一个用例包含三行，第一行为点集合（点之间用逗号隔开，两个坐标用空格隔开），第二
 * 行为检索的点，第三行为K值。
 * <p>
 * Output
 * 输出每一个用例的最近K个点，按照距离从小到大的顺序打印。
 * <p>
 */
public class KDTree {

//    public static class Node implements Comparable<Node> {
//
//        public double[] data;//树上节点的数据  是一个多维的向量
//        public double distance;//与当前查询点的距离  初始化的时候是没有的
//        public Node left, right, parent;//左右子节点  以及父节点
//        public int dim = -1;//维度  建立树的时候判断的维度
//
//        public Node(double[] data) {
//            this.data = data;
//        }
//
//        /**
//         * 返回指定索引上的数值
//         *
//         * @param index
//         * @return
//         */
//        public double getData(int index) {
//            if (data == null || data.length <= index)
//                return Integer.MIN_VALUE;
//            return data[index];
//        }
//
//        @Override
//        public int compareTo(Node o) {
//            if (this.distance > o.distance)
//                return 1;
//            else if (this.distance == o.distance)
//                return 0;
//            else return -1;
//        }
//
//        /**
//         * 计算距离 这里返回欧式距离
//         *
//         * @param that
//         * @return
//         */
//        public double computeDistance(Node that) {
//            if (this.data == null || that.data == null || this.data.length != that.data.length)
//                return Double.MAX_VALUE;//出问题了  距离最远
//            double d = 0;
//            for (int i = 0; i < this.data.length; i++) {
//                d += Math.pow(this.data[i] - that.data[i], 2);
//            }
//
//            return Math.sqrt(d);
//        }
//
//        public String toString() {
//            if (data == null || data.length == 0) {
//                return null;
//            }
//            StringBuilder sb = new StringBuilder();
//            for (int i = 0; i < data.length; i++) {
//                if (data[i] == (int) data[i]) {
//                    sb.append((int)data[i] + " ");
////                    sb.append(data[i] + " ");
//                } else {
//                    sb.append(data[i] + " ");
//                }
//            }
//
//            return sb.substring(0, sb.length() - 1).toString();
//        }
//    }
//
//    /**
//     * 构建kd树  返回根节点
//     *
//     * @param nodeList
//     * @param index
//     * @return
//     */
//    public static Node buildKDTree(List<Node> nodeList, int index) {
//        if (nodeList == null || nodeList.size() == 0)
//            return null;
//        quickSortForMedian(nodeList, index, 0, nodeList.size() - 1);//中位数排序
//        Node root = nodeList.get(nodeList.size() / 2);//中位数 当做根节点
//        root.dim = index;
//        List<Node> leftNodeList = new ArrayList<Node>();//放入左侧区域的节点  包括包含与中位数等值的节点-_-
//        List<Node> rightNodeList = new ArrayList<Node>();
//
//        for (Node node : nodeList) {
//            if (root != node) {
//                if (node.getData(index) <= root.getData(index))
//                    leftNodeList.add(node);//左子区域 包含与中位数等值的节点
//                else
//                    rightNodeList.add(node);
//            }
//        }
//
//        //计算从哪一维度切分
//        int newIndex = index + 1;//进入下一个维度
//        if (newIndex >= root.data.length)
//            newIndex = 0;//从0维度开始再算
//
//        root.left = buildKDTree(leftNodeList, newIndex);//添加左右子区域
//        root.right = buildKDTree(rightNodeList, newIndex);
//
//        if (root.left != null)
//            root.left.parent = root;//添加父指针
//        if (root.right != null)
//            root.right.parent = root;//添加父指针
//        return root;
//    }
//
//    /**
//     * 查询最近邻
//     *
//     * @param root kd树
//     * @param q    查询点
//     * @param k
//     * @return
//     */
//    public static List<Node> searchKNN(Node root, Node q, int k) {
//        List<Node> knnList = new ArrayList<Node>();
//        searchBrother(knnList, root, q, k);
//        return knnList;
//    }
//
//    /**
//     * searhchBrother
//     *
//     * @param knnList
//     * @param k
//     * @param q
//     */
//    public static void searchBrother(List<Node> knnList, Node root, Node q, int k) {
////         Node almostNNode=root;//近似最近点
//        Node leafNNode = searchLeaf(root, q);
//        double curD = q.computeDistance(leafNNode);//最近近似点与查询点的距离 也就是球体的半径
//        leafNNode.distance = curD;
//        maintainMaxHeap(knnList, leafNNode, k);
//        while (leafNNode != root) {
//            if (getBrother(leafNNode) != null) {
//                Node brother = getBrother(leafNNode);
//                if (curD > Math.abs(q.getData(leafNNode.parent.dim) - leafNNode.parent.getData(leafNNode.parent.dim)) || knnList.size() < k) {
//                    //这样可能在另一个子区域中存在更加近似的点
//                    searchBrother(knnList, brother, q, k);
//                }
//            }
//            leafNNode = leafNNode.parent;//返回上一级
//            double rootD = q.computeDistance(leafNNode);//最近近似点与查询点的距离 也就是球体的半径
//            leafNNode.distance = rootD;
//            maintainMaxHeap(knnList, leafNNode, k);
//        }
//    }
//
//    /**
//     * 获取兄弟节点
//     *
//     * @param node
//     * @return
//     */
//    public static Node getBrother(Node node) {
//        if (node == node.parent.left)
//            return node.parent.right;
//        else
//            return node.parent.left;
//    }
//
//    /**
//     * 查询到叶子节点
//     *
//     * @param root
//     * @param q
//     * @return
//     */
//    public static Node searchLeaf(Node root, Node q) {
//        Node leaf = root, next = null;
//        int index = 0;
//        while (leaf.left != null || leaf.right != null) {
//            if (q.getData(index) < leaf.getData(index)) {
//                next = leaf.left;//进入左侧
//            } else if (q.getData(index) > leaf.getData(index)) {
//                next = leaf.right;
//            } else {
//                //当取到中位数时  判断左右子区域哪个更加近
//                if (q.computeDistance(leaf.left) < q.computeDistance(leaf.right))
//                    next = leaf.left;
//                else
//                    next = leaf.right;
//            }
//            if (next == null)
//                break;//下一个节点是空时  结束了
//            else {
//                leaf = next;
//                if (++index >= root.data.length)
//                    index = 0;
//            }
//        }
//
//        return leaf;
//    }
//
//    /**
//     * 维护一个k的最大堆
//     *
//     * @param listNode
//     * @param newNode
//     * @param k
//     */
//    public static void maintainMaxHeap(List<Node> listNode, Node newNode, int k) {
//        if (listNode.size() < k) {
//            maxHeapFixUp(listNode, newNode);//不足k个堆   直接向上修复
//        } else if (newNode.distance < listNode.get(0).distance) {
//            //比堆顶的要小   还需要向下修复 覆盖堆顶
//            maxHeapFixDown(listNode, newNode);
//        }
//    }
//
//    /**
//     * 从上往下修复  将会覆盖第一个节点
//     *
//     * @param listNode
//     * @param newNode
//     */
//    private static void maxHeapFixDown(List<Node> listNode, Node newNode) {
//        listNode.set(0, newNode);
//        int i = 0;
//        int j = i * 2 + 1;
//        while (j < listNode.size()) {
//            if (j + 1 < listNode.size() && listNode.get(j).distance < listNode.get(j + 1).distance)
//                j++;//选出子结点中较大的点，第一个条件是要满足右子树不为空
//
//            if (listNode.get(i).distance >= listNode.get(j).distance)
//                break;
//
//            Node t = listNode.get(i);
//            listNode.set(i, listNode.get(j));
//            listNode.set(j, t);
//
//            i = j;
//            j = i * 2 + 1;
//        }
//    }
//
//    private static void maxHeapFixUp(List<Node> listNode, Node newNode) {
//        listNode.add(newNode);
//        int j = listNode.size() - 1;
//        int i = (j + 1) / 2 - 1;//i是j的parent节点
//        while (i >= 0) {
//
//            if (listNode.get(i).distance >= listNode.get(j).distance)
//                break;
//
//            Node t = listNode.get(i);
//            listNode.set(i, listNode.get(j));
//            listNode.set(j, t);
//
//            j = i;
//            i = (j + 1) / 2 - 1;
//        }
//    }
//
//    /**
//     * 使用快排进进行一个中位数的查找  完了之后返回的数组size/2即中位数
//     *
//     * @param nodeList
//     * @param index
//     * @param left
//     * @param right
//     */
//    private static void quickSortForMedian(List<Node> nodeList, int index, int left, int right) {
//        if (left >= right || nodeList.size() <= 0)
//            return;
//
//        Node kn = nodeList.get(left);
//        double k = kn.getData(index);//取得向量指定索引的值
//
//        int i = left, j = right;
//
//        //控制每一次遍历的结束条件，i与j相遇
//        while (i < j) {
//            //从右向左找一个小于i处值的值，并填入i的位置
//            while (nodeList.get(j).getData(index) >= k && i < j)
//                j--;
//            nodeList.set(i, nodeList.get(j));
//            //从左向右找一个大于i处值的值，并填入j的位置
//            while (nodeList.get(i).getData(index) <= k && i < j)
//                i++;
//            nodeList.set(j, nodeList.get(i));
//        }
//
//        nodeList.set(i, kn);
//
//        if (i == nodeList.size() / 2)
//            return;//完成中位数的排序了，但并不是完成了所有数的排序，这个终止条件只是保证中位数是正确的。去掉该条件，可以保证在递归的作用下，将所有的树
//            //将所有的数进行排序
//
//        else if (i < nodeList.size() / 2) {
//            quickSortForMedian(nodeList, index, i + 1, right);//只需要排序右边就可以了
//        } else {
//            quickSortForMedian(nodeList, index, left, i - 1);//只需要排序左边就可以了
//        }
//
//    }
//
//    /**
//     * Sample Input 1
//     * 1
//     * 3 5,6 2,5 8,9 3,8 6,1 1,2 9
//     * 8.2 4.6
//     * 2
//     * <p>
//     * Sample Output 1
//     * 8 6,9 3
//     *
//     */
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//        int numbers = Integer.parseInt(sc.nextLine());
//        while (numbers > 0) {
//            List<Node> nodeList = new ArrayList<Node>();
//            String[] line = sc.nextLine().split(",");
//            for (int i = 0; i < line.length; i++) {
//                nodeList.add(new Node(new double[]{Double.parseDouble(line[i].split(" ")[0]), Double.parseDouble(line[i].split(" ")[1])}));
//            }
//
//            Node root = buildKDTree(nodeList, 0);
//
//            String[] query = sc.nextLine().split(" ");
//            int k = Integer.parseInt(sc.nextLine());
//            List<Node> list = searchKNN(root, new Node(new double[]{Double.parseDouble(query[0]), Double.parseDouble(query[1])}), k);
//
//            StringBuilder sb = new StringBuilder();
//            for (int i = list.size() - 1; i >= 0; i--) {
//                sb.append(list.get(i)).append(",");
//            }
//            System.out.println(sb.substring(0, sb.length() - 1));
//
//            numbers--;
//        }
//    }

    public static class Point {

        double x;
        double y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public static double getDistance(Point p1, Point p2) {
            return Math.pow((p1.x - p2.x), 2) + Math.pow((p1.y - p2.y), 2);
        }

        public String toString() {
            String result = "";
            if (x == (int) x) {
                result += (int) x;
            } else {
                result += x;
            }

            result += " ";

            if (y == (int) y) {
                result += (int) y;
            } else {
                result += y;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numbers = Integer.parseInt(sc.nextLine());
        while (numbers > 0) {
            String[] line = sc.nextLine().split(",");
            Point[] point = new Point[line.length];
            for (int i = 0; i < line.length; i++) {
                point[i] = new Point(Double.parseDouble(line[i].split(" ")[0]),
                        Double.parseDouble(line[i].split(" ")[1]));
            }

            String[] s = sc.nextLine().split(" ");
            Point queryPoint = new Point(Double.parseDouble(s[0]), Double.parseDouble(s[1]));
            int k = Integer.parseInt(sc.nextLine());

            double[] distance1 = new double[point.length];
            List<Double> distance2 = new ArrayList<>();
            for (int i = 0; i < point.length; i++) {
                double d = Point.getDistance(point[i], queryPoint);
                distance1[i] = d;
                distance2.add(d);
            }

            Arrays.sort(distance1);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < k; i++) {
                sb.append(point[distance2.indexOf(distance1[i])]).append(",");
            }

            System.out.println(sb.substring(0, sb.length() - 1));

            numbers--;
        }
    }


}
