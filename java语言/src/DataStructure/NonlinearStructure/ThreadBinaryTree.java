package DataStructure.NonlinearStructure;

class TreeNode1{
    public static final int CHILDTREE=0;
    public static final int PREOURSOR=1;
    TreeNode1 leftNode;
    int LeftModel;
    TreeNode1 rightNode;
    int rightModel;
    char value;
    public TreeNode1(char value) {
        this.value = value;
        this.LeftModel=TreeNode1.CHILDTREE;
        this.rightModel=TreeNode1.PREOURSOR;
    }

}
public class ThreadBinaryTree extends BinaryTree{
    private TreeNode1 root;
    private TreeNode1 pre;
    private static int index = 0;

    public TreeNode1 getRoot() {
        return root;
    }

    public boolean isEmptyTree(){
        return root==null?true:false;
    }
    public ThreadBinaryTree() {
        this.root = null;
    }
    //添加节点
    private TreeNode1 addNode(String input){
        if (index >= input.length() || input.charAt(index) == '#') {
            index++;
            return null;
        }
        TreeNode1 node = new TreeNode1(input.charAt(index));
        index++;
        node.leftNode = addNode(input);
        node.rightNode = addNode(input);
        return node;
    }
    public void buildTree(String input){
        this.root = addNode(input);
        this.pre=this.root;
    }
    //中序遍历的线索化
    public void buildThread(TreeNode1 node){
        if (node!=null){
            buildThread(node.leftNode);
            //该结点没有左孩子
            if (node.leftNode==null){
                node.LeftModel=TreeNode1.PREOURSOR;
                node.leftNode=pre;
            }
            //该
            if (pre.rightNode==null){
                node.rightModel=TreeNode1.PREOURSOR;
                pre.rightNode=node;
            }
            pre=node;
            if (node==root) return;
            buildThread(node.rightNode);
        }

    }
    //遍历序列化线索树
    public void inThreadList(TreeNode1 root) {
        if (root == null) {
            return;
        }
        //查找中序遍历的起始节点
        while (root != null && root.LeftModel!=1) {
            root = root.leftNode;
        }

        while (root != null) {
            System.out.print(root.value + ",");
            // 如果右子节点是线索
            if (root.rightModel!=0) {
                root = root.rightNode;
            } else {
                //有右子节点，遍历右子节点
                root = root.rightNode;
                //如果右子节点不为null，并且右子节点的左子结点存在
                while (root != null && root.LeftModel!=1) {
                    root = root.leftNode;
                }
            }
        }

    }
}
