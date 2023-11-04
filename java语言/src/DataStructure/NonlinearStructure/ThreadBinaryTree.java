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
    //��ӽڵ�
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
    //���������������
    public void buildThread(TreeNode1 node){
        if (node!=null){
            buildThread(node.leftNode);
            //�ý��û������
            if (node.leftNode==null){
                node.LeftModel=TreeNode1.PREOURSOR;
                node.leftNode=pre;
            }
            //��
            if (pre.rightNode==null){
                node.rightModel=TreeNode1.PREOURSOR;
                pre.rightNode=node;
            }
            pre=node;
            if (node==root) return;
            buildThread(node.rightNode);
        }

    }
    //�������л�������
    public void inThreadList(TreeNode1 root) {
        if (root == null) {
            return;
        }
        //���������������ʼ�ڵ�
        while (root != null && root.LeftModel!=1) {
            root = root.leftNode;
        }

        while (root != null) {
            System.out.print(root.value + ",");
            // ������ӽڵ�������
            if (root.rightModel!=0) {
                root = root.rightNode;
            } else {
                //�����ӽڵ㣬�������ӽڵ�
                root = root.rightNode;
                //������ӽڵ㲻Ϊnull���������ӽڵ�����ӽ�����
                while (root != null && root.LeftModel!=1) {
                    root = root.leftNode;
                }
            }
        }

    }
}
