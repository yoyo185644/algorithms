package mainIdea.datasturcter.BT;

public class BinaryTree {
    //将二叉树的元素加一
    public static void addOne(TreeNode root){
        if (root == null) return;
        root.val += 1;
        addOne(root.left);
        addOne(root.right);
    }
    //判断这两棵树是相同
    public static boolean isTrue(TreeNode root1,TreeNode root2){
        if (root1==null && root2==null)  return true;
        if (root1==null || root2 == null) return false;
        if (root1.val != root2.val) return false;
        return isTrue(root1.left,root2.left)&& isTrue(root1.right,root2.right);
    }

    //二叉搜索树BST 左节点一定比父节点小 右节点一定比父节点大
    public static boolean isValidBST(TreeNode root,TreeNode min, TreeNode max){
        if (root == null) return true;
        if (min!=null && min.val >= root.val) return false;
        if (max!=null && max.val <= root.val) return false;
        return isValidBST(root.left,min,root)&&isValidBST(root.right,root,max);
    }
    //isValidBST(TreeNode, null ,null)

    //在BST中查找一个元素是否存在
    public static boolean isExist(TreeNode root, int data){
        if (root == null) return false;
        if (root.val == data) return true;
        else if (root.val > data)
            return isExist(root.left,data);
        else
            return isExist(root.right,data);

    }

    //在 BST 中插入一个数 返回TreeNode
    public static TreeNode insertBST(TreeNode root, int data){
        //找到空白位置之后删除
        if (root == null) return new TreeNode(data);
        else if (root.val > data) root.left =  insertBST(root.left ,data);
        else root.right = insertBST(root.right,data);
        return root;
    }

    //在 BST 中删除一个数
    public static TreeNode delBST(TreeNode root ,int data){
        if (root.val == data){
            if (root.right == null) return root.left;
            if (root.left == null) return root.right;
            //找到右子树的最大小节点
            TreeNode min = getMin(root.right);
            root.val = min.val;
            root.right = delBST(root.right,min.val);
        }else if (root.val>data) root.left = delBST(root.left ,data);
        else root.right = delBST(root.right,data);
        return root;
    }
    public static TreeNode getMin(TreeNode node) {
        // BST 最左边的就是最小的
        while (node.left != null) node = node.left;
        return node;
    }

    //计算二叉树的节点数
    private static int count;
    public static int coutBT(TreeNode root){
        if (root==null) return 0;
        return 1+coutBT(root.left)+coutBT(root.right);
    }
    //计算完全二叉树的节点优化方法 时间复杂度O(logN*logN)
    public static int countComBT(TreeNode root){
        int ldepth =0 ,rdepth = 0;
        TreeNode  p = root , q =root;
        while (p!= null){
            ldepth ++;
            p = p.left;
        }
        while (q != null){
            rdepth ++;
            q = q.right;
        }
        // 如果左右子树的高度相同，则是一棵满二叉树
        if (ldepth==rdepth){
            return (int) Math.pow(2,ldepth)-1;
        }
        // 如果左右高度不同，则按照普通二叉树的逻辑计算
        return 1+countComBT(root.left) + countComBT(root.right);
    }

    //判断是否是平衡二叉树
    public static boolean isBST(TreeNode root){
        if (root == null) return  true;
        int left = dep(root.left);
        int right = dep(root.right);
        if (Math.abs(left-right)>1) return false;
        return isBST(root.left)&&isBST(root.right);

    }
    //求节点的深度
    public static int dep(TreeNode root){
        if (root == null ) return 0;
        int left = dep(root.left);
        int right = dep(root.right);
        return left>right?left+1:right+1;
    }
}
