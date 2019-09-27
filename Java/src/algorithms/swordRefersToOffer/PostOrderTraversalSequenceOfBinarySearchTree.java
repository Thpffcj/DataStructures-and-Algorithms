package algorithms.swordRefersToOffer;

/**
 * Created by thpffcj on 2019/9/18.
 */

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。
 * 假设输入的数组的任意两个数字都互不相同。
 */
public class PostOrderTraversalSequenceOfBinarySearchTree {

    public boolean VerifySquenceOfBST(int [] sequence) {

        if (sequence == null || sequence.length <= 0) {
            return false;
        }

        return isPostSequence(sequence, sequence.length);
    }

    public boolean isPostSequence(int[] sequence, int length) {
        if (length == 0) {
            return true;
        }
        int root = sequence[length - 1];
        int[] left = new int[length];
        int[] right = new int[length];

        int leftPosition = 0;
        int rightPosition = 0;
        boolean isRight = false;
        for (int i = 0; i < length; i++) {
            if (isRight) {
                if (sequence[i] < root) {
                    return false;
                }
            }
            if (sequence[i] < root) {
                left[leftPosition] = sequence[i];
                leftPosition++;
            }
            if (sequence[i] > root) {
                isRight = true;
                right[rightPosition] = sequence[i];
                rightPosition++;
            }
        }
        return isPostSequence(left, leftPosition) && isPostSequence(right, rightPosition);
    }

    public static void main(String[] args) {
        PostOrderTraversalSequenceOfBinarySearchTree p = new PostOrderTraversalSequenceOfBinarySearchTree();
        int[] input = new int[]{5, 7, 6, 9, 10, 11, 8};
        System.out.println(p.VerifySquenceOfBST(input));
    }

}
