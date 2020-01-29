package algorithms.swordRefersToOffer;

/**
 * Created by thpffcj on 2019-08-07.
 *
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，
 * 同时包含指向父结点的指针。
 */
public class Offer8 {

    public TreeLinkNode GetNext(TreeLinkNode pNode) {

        if (pNode == null) {
            return null;
        }

        TreeLinkNode result = pNode;

        if (pNode.right != null) {
            result = pNode.right;
            while (result.left != null) {
                result = result.left;
            }
            return result;
        } else {
            while (result.next != null && result.next.left != result) {
                result = result.next;
            }
            return result.next;
        }
    }
}
