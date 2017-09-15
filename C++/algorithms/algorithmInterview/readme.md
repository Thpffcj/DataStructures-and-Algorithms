## 玩儿转算法面试

## 课程源码目录 
- 算法面试优秀不意味着技术面试优秀
- 技术面试优秀不意味着能够拿到offer

- 如何准备算法面试
算法面试并没有那么难
学习切忌完美主义（高级数据结构和算法面试提及的概率很低 e.g. 红黑树 B-Tree 斐波那契堆 计算几何 数论 FFT）
不要轻视基础算法和数据结构，而只关注"有意思"的题目。
在学习和实践做题之间，要掌握平衡。

- 解决算法面试问题的整体思路

注意题目中的条件：
1. 给定一个有序数组。
2. 有一些题目中的条件本质是暗示

当没有思路的时候：
1. 自己给自己几个简单的测试用例，试验一下。
2. 不要忽视暴力解法，暴力解法通常是思考的起点。

优化算法：
1. 遍历常见的算法思路
2. 遍历常见的数据结构
3. 空间和时间的交换(哈希表)
4. 预处理信息(排序)
5. 在瓶颈初寻找答案(O(nlogn)+O(n^2);O(n^3))

- 实际编写问题
1. 极端条件的判断
2. 变量名
3. 模块化，复用性

| **第一章：算法面试到底是什么鬼** | [无代码] |
| :--- | :---: |
| 1-1 算法面试不仅仅是正确的回答问题 | [无代码] |
| 1-2 算法面试只是面试的一部分 | [无代码] |
| 1-3 如何准备算法面试 | [无代码] |
| 1-4 如何会打算发面试问题 | [无代码] |
| **第二章：面试中的复杂度分析** | [章节C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/02-Time-Complexity/Course%20Code%20(C%2B%2B)) |
| 2-1 究竟什么是大O (Big O) | [无代码] |
| 2-2 对数据规模有一个概念 | [C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/02-Time-Complexity/Course%20Code%20(C%2B%2B)/02-Time-Complexity-Basic) |
| 2-3 简单的复杂度分析 | [C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/02-Time-Complexity/Course%20Code%20(C%2B%2B)/03-Common-Code-for-Time-Complexity) |
| 2-4 亲自试验自己算法的复杂度 | [C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/02-Time-Complexity/Course%20Code%20(C%2B%2B)/04-Time-Complexity-Experiments) |
| 2-5 递归算法的时间复杂度 | [C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/02-Time-Complexity/Course%20Code%20(C%2B%2B)/05-Recursion-Time-Complexity) |
| 2-6 均摊时间复杂度分析（Amortized Time Analysis） | [C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/02-Time-Complexity/Course%20Code%20(C%2B%2B)/06-Amortized-Time) |
| 2-7 避免复杂度的震荡 | [C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/02-Time-Complexity/Course%20Code%20(C%2B%2B)/07-Amortized-Time-2) |
| 补充代码1: 动态空间的数组结构 | [C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/02-Time-Complexity/Course%20Code%20(C%2B%2B)/DynamicVector) |
| 补充代码2: 动态空间的栈结构 | [整理中] |
| 补充代码1: 动态空间的队列结构 | [整理中] |
| **第三章：数组中的问题其实最常见** | [章节C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/03-Using-Array/Course%20Code%20(C%2B%2B)) |
| 3-1 从二分查找法看如何写出正确的程序 | [C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/03-Using-Array/Course%20Code%20(C%2B%2B)/01-Binary-Search) |
| 3-2 改变变量定义，依然可以写出正确的算法 | [C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/03-Using-Array/Course%20Code%20(C%2B%2B)/02-Binary-Search-II) |
| 3-3 在LeetCode上解决第一个问题 Move Zeros | [C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/03-Using-Array/Course%20Code%20(C%2B%2B)/03-Move-Zeroes) |
| 3-4 即使简单的问题，也有很多优化的思路 | [C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/03-Using-Array/Course%20Code%20(C%2B%2B)/04-Move-Zeroes-II) |
| 3-5 三路快排partition思路的应用 Sort Color | [C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/03-Using-Array/Course%20Code%20(C%2B%2B)/05-Sort-Colors) |
| 3-6 对撞指针 Two Sum II - Input Array is Sorted | [C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/03-Using-Array/Course%20Code%20(C%2B%2B)/06-Two-Sum-II) |
| 3-7 滑动窗口 Minimum Size Subarray Sum | [C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/03-Using-Array/Course%20Code%20(C%2B%2B)/07-Minimum-Size-Subarray-Sum) |
| 3-8 在滑动窗口中做记录 Longest Substring Without Repeating Characters | [C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/03-Using-Array/Course%20Code%20(C%2B%2B)/08-Longest-Substring-Without-Repeating-Characters) |
| **第四章：查找表相关问题** | [章节C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/04-Using-Hash-Table/Course%20Code%20(C%2B%2B)) |
| 4-1 set的使用 Intersection of Two Arrays | [C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/04-Using-Hash-Table/Course%20Code%20(C%2B%2B)/01-Intersection-of-Two-Arrays) |
| 4-2 map的使用 Intersection of Two Arrays II | [C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/04-Using-Hash-Table/Course%20Code%20(C%2B%2B)/02-Intersection-of-Two-Arrays-II) |
| 4-3 set和map不同底层实现的区别 | [C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/04-Using-Hash-Table/Course%20Code%20(C%2B%2B)/03-More-About-Set-And-Map) |
| 4-4 使用查找表的经典问题 Two Sum | [C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/04-Using-Hash-Table/Course%20Code%20(C%2B%2B)/04-Two-Sum) |
| 4-5 灵活选择键值 4Sum II | [C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/04-Using-Hash-Table/Course%20Code%20(C%2B%2B)/05-4Sum-II) |
| 4-6 灵活选择键值 Number of Boomerangs | [C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/04-Using-Hash-Table/Course%20Code%20(C%2B%2B)/06-Number-of-Boomerangs) |
| 4-7 查找表和滑动窗口 Contain Duplicate II | [C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/04-Using-Hash-Table/Course%20Code%20(C%2B%2B)/07-Contains-Duplicate-II) |
| 4-8 二分搜索树底层实现的顺序性 Contain Duplicate III | [C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/04-Using-Hash-Table/Course%20Code%20(C%2B%2B)/08-Contains-Duplicate-III) |
| **第五章：在链表中穿针引线** | [章节C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/05-About-Linked-List/Course%20Code%20(C%2B%2B)) |
| 5-1 链表，在节点间穿针引线 Reverse Linked List | [C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/05-About-Linked-List/Course%20Code%20(C%2B%2B)/01-Reverse-Linked-List) |
| 5-2 测试你的链表程序 | [C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/05-About-Linked-List/Course%20Code%20(C%2B%2B)/02-Test-Your-Linked-List) |
| 5-3 设立链表的虚拟头结点 Remove Linked List Elements | [C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/05-About-Linked-List/Course%20Code%20(C%2B%2B)/03-Remove-Linked-List-Elements) |
| 5-4 复杂的穿针引线 Swap Nodes in Pairs | [C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/05-About-Linked-List/Course%20Code%20(C%2B%2B)/04-Swap-Nodes-in-Pairs) |
| 5-5 不仅仅是穿针引线 Delete Node in a Linked List | [C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/05-About-Linked-List/Course%20Code%20(C%2B%2B)/05-Delete-Node-in-a-Linked-List) |
| 5-6 链表与双指针 Remove Nth Node From End of List | [C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/05-About-Linked-List/Course%20Code%20(C%2B%2B)/06-Remove-Nth-Node-From-End-of-List) |
| **第六章：栈，队列，优先队列** | [章节C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/06-Stack-and-Queue/Course%20Code%20(C%2B%2B)) |
| 6-1 栈的基础应用 Valid Parentheses | [C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/06-Stack-and-Queue/Course%20Code%20(C%2B%2B)/01-Valid-Parentheses) |
| 6-2 栈和递归的紧密联系 Binary Tree Preoder, Inorder and Posorder Traversal | [C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/06-Stack-and-Queue/Course%20Code%20(C%2B%2B)/02-Recursion-and-Stack) |
| 6-3 运用栈模拟递归 | [C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/06-Stack-and-Queue/Course%20Code%20(C%2B%2B)/03-Non-Recursive-Implementation-of-a-Recursive-Algorithm) |
| 6-4 队列的典型应用 Binary Tree Level Order Traversal | [C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/06-Stack-and-Queue/Course%20Code%20(C%2B%2B)/04-Binary-Tree-Level-Order-Traversal) |
| 6-5 BFS和图的最短路径 Perfect Squares | [C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/06-Stack-and-Queue/Course%20Code%20(C%2B%2B)/05-Perfect-Squares) |
| 6-6 优先队列 | [C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/06-Stack-and-Queue/Course%20Code%20(C%2B%2B)/06-Priority-Queue) |
| 6-7 优先队列相关的算法问题 Top K Frequent Elements | [C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/06-Stack-and-Queue/Course%20Code%20(C%2B%2B)/07-Top-K-Frequent-Elements) |
| **第七章：二叉树和递归** | [章节C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/07-Binary-Tree-and-Recursion/Course%20Code%20(C%2B%2B)) | 
| 7-1 二叉树天然的递归结构 | [C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/07-Binary-Tree-and-Recursion/Course%20Code%20(C%2B%2B)/01-Maximum-Depth-of-Binary-Tree) |
| 7-2 一个简单的二叉树问题引发的血案 Invert Binary Tree | [C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/07-Binary-Tree-and-Recursion/Course%20Code%20(C%2B%2B)/02-Invert-Binary-Tree) |
| 7-3 注意递归的终止条件 Path Sum | [C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/07-Binary-Tree-and-Recursion/Course%20Code%20(C%2B%2B)/03-Path-Sum) |
| 7-4 定义递归问题 Binary Tree Path | [C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/07-Binary-Tree-and-Recursion/Course%20Code%20(C%2B%2B)/04-Binary-Tree-Paths) |
| 7-5 稍复杂的递归逻辑 Path Sum III | [C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/07-Binary-Tree-and-Recursion/Course%20Code%20(C%2B%2B)/05-Path-Sum-III) |
| 7-6 二分搜索树中问题 Lowest Common Ancestor of a Binary Search Tree | [C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/07-Binary-Tree-and-Recursion/Course%20Code%20(C%2B%2B)/06-Lowest-Common-Ancestor-of-a-Binary-Search-Tree) |
| **第八章：递归和回溯法** | [章节C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/08-Recurion-and-Backstracking/Course%20Code%20(C%2B%2B)) |
| 8-1 树形问题 Letter Combinations of a Phone Number | [C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/08-Recurion-and-Backstracking/Course%20Code%20(C%2B%2B)/01-02-Letter-Combinations-of-a-Phone-Number) |
| 8-2 什么是回溯 | [C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/08-Recurion-and-Backstracking/Course%20Code%20(C%2B%2B)/01-02-Letter-Combinations-of-a-Phone-Number) |
| 8-3 排列问题 Permutations | [C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/08-Recurion-and-Backstracking/Course%20Code%20(C%2B%2B)/03-Permutations) |
| 8-4 组合问题 Combinations | [C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/08-Recurion-and-Backstracking/Course%20Code%20(C%2B%2B)/04-Combinations) |
| 8-5 回溯法解决组合问题的优化 | [C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/08-Recurion-and-Backstracking/Course%20Code%20(C%2B%2B)/05-Combinations-optimized) |
| 8-6 二维平面上的回溯法 Word Search | [C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/08-Recurion-and-Backstracking/Course%20Code%20(C%2B%2B)/06-Word-Search) |
| 8-7 floodfill算法，一类经典问题 Number of Islands | [C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/08-Recurion-and-Backstracking/Course%20Code%20(C%2B%2B)/07-Number-of-Islands) |
| 8-8 回溯法是人工智能的基础 N Queens | [C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/08-Recurion-and-Backstracking/Course%20Code%20(C%2B%2B)/08-N-Queens) |
| **第九章：动态规划基础** | [章节C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/09-Dynamic-Programming/Course%20Code%20(C%2B%2B)) |
| 9-1 什么是动态规划 | [C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/09-Dynamic-Programming/Course%20Code%20(C%2B%2B)/01-Fibonacci) | 
| 9-2 第一个动态规划问题 Climbing Stairs | [C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/09-Dynamic-Programming/Course%20Code%20(C%2B%2B)/02-Climbing-Stairs) |
| 9-3 发现重叠子问题 Integer Break | [C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/09-Dynamic-Programming/Course%20Code%20(C%2B%2B)/03-Integer-Break) |
| 9-4 状态的定义和状态转移 House Robber | [C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/09-Dynamic-Programming/Course%20Code%20(C%2B%2B)/04-House-Robber) |
| 9-5 0-1背包问题 | [C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/09-Dynamic-Programming/Course%20Code%20(C%2B%2B)/05-0-1-knapsack) |
| 9-6 0-1背包问题的优化和变种 | [C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/09-Dynamic-Programming/Course%20Code%20(C%2B%2B)/06-0-1-knapsack-optimized) |
| 9-7 面试中的0-1背包问题 Partition Equal Subset Sum | [C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/09-Dynamic-Programming/Course%20Code%20(C%2B%2B)/07-Partition-Equal-Subset-Sum) |
| 9-8 LIS问题 Longest Increasing Subsequence | [C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/09-Dynamic-Programming/Course%20Code%20(C%2B%2B)/08-Longest-Increasing-Subsequence) |
| 9-9 LCS，最短路，求动态规划的具体解以及更多 | [C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/09-Dynamic-Programming/Course%20Code%20(C%2B%2B)/09-Longest-Common-Subsequence) |
| **第十章：贪心算法** | [章节C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/10-Greedy-Algorithms) |
| 10-1 贪心基础 Assign Cookies | [C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/10-Greedy-Algorithms/01-Assign-Cookies) |
| 10-2 贪心算法与动态规划的关系 Non-overlapping Intervals | [C++源码](https://github.com/liuyubobobo/Play-with-Algorithm-Interview/tree/master/10-Greedy-Algorithms/02-Non-overlapping-Intervals) |
| 10-3 贪心选择性质的证明 | [无代码] |
| **第十一章：课程结语** | [无代码] |
| 11-1 结语 | [无代码] |

