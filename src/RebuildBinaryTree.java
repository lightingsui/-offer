/**
 * 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请
 * 重建出该二叉树。假设输入的前序遍历和中序遍
 * 历的结果中都不含重复的数字。例如输入前序遍
 * 历序列{1,2,4,7,3,5,6,8}和中序遍历序列
 * {4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 * @author ：LightingSui
 * @since ：2020/2/15 23:29
 */
public class RebuildBinaryTree {
    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};

        TreeNode root = reConstructBinaryTree(pre, in);
        System.out.println(root);
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return reConstructBinaryTree(pre, 0, pre.length-1, in, 0, in.length-1);
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int pStart, int pEnd, int[] in, int inStart, int inEnd) {
        if(pStart > pEnd || inStart > inEnd){
            // 当数组前点大于终点时，代表此节点已经没有孩子了
            return null;
        }
        TreeNode treeNode = new TreeNode(pre[pStart]);

        for (int i = inStart; i <= inEnd; i++) {
            if(in[i] == pre[pStart]) {
                // 处理左右子树
                treeNode.left = reConstructBinaryTree(pre, pStart + 1, pStart + i - inStart, in, inStart, i - 1);
                treeNode.right = reConstructBinaryTree(pre, pStart + i -inStart + 1, pEnd, in, i + 1, inEnd);
            }
        }

        return treeNode;
    }
}


// Definition for binary tree
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
