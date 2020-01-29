package algorithms.swordRefersToOffer;

/**
 * Created by thpffcj on 2020/1/13.
 *
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 * 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，从而使得内存中建立起来的二叉树可以持久保存。序列化可以
 * 基于先序、中序、后序、层序的二叉树遍历方式来进行修改，序列化的结果是一个字符串，序列化时通过某种符号表示空节点（#），以 ！ 表示一个
 * 结点值的结束（value!）。
 * 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
 */
public class Offer37 {

    String Serialize(TreeNode root) {

        String s = "";
        if (root == null) {
            return "#,";
        }

        s = s + root.val + ",";

        return s + Serialize(root.left) + Serialize(root.right);
    }

    int position = -1;
    TreeNode Deserialize(String str) {
        position = -1;
        return Deserialize(str.split(","));
    }

    TreeNode Deserialize(String[] str) {

        position++;
        TreeNode node = null;
        if (position < str.length && !"#".equals(str[position])) {
            node = new TreeNode(Integer.parseInt(str[position]));

            node.left = Deserialize(str);
            node.right = Deserialize(str);

            return node;
        }

        return node;
    }

    public static void main(String[] args) {
        Offer37 s = new Offer37();
        System.out.println(s.Deserialize("1,2,4,#,#,#,3,5,#,#,6,#,#"));
        TreeNode root = s.Deserialize("1,2,4,#,#,#,3,5,#,#,6,#,#");
        System.out.println(s.Serialize(root));
    }
}
