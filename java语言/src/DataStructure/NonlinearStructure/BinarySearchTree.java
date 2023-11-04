package DataStructure.NonlinearStructure;
class BstNode{
    BstNode leftChild;
    BstNode rightChild;
    int value;
    public BstNode(int value) {
        this.value = value;
        this.leftChild=null;
        this.rightChild=null;
    }
}
public class BinarySearchTree{
    private BstNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    public BstNode getRoot() {
        return root;
    }

    private BstNode addNode(BstNode node, int value){
        if (node==null) return new BstNode(value);
        else{
            if (node.value>=value){
               node.leftChild=addNode(node.leftChild,value);
            }else{
                node.rightChild=addNode(node.rightChild,value);
            }
        }
        return node;
    }
    public void buildTree(int value) {
        this.root=addNode(this.root,value);
    }
    private boolean Search(BstNode node,int value){
        if (node==null) return false;
        else{
            if (node.value==value){
                return true;
            }else if (node.value>value){
               return Search(node.leftChild,value);
            }else{
              return Search(node.rightChild,value);
            }
        }
    }
    public boolean Search(int value){
        boolean result = Search(this.root, value);
        return result;
    }
    private void DlrTraverse(BstNode Root){
        if (Root==null) return;
        else{
            System.out.print(Root.value+" ");
            DlrTraverse(Root.leftChild);
            DlrTraverse(Root.rightChild);
        }
    }
    public void DlrTraverse(){
        DlrTraverse(this.root);
    }
    private void LdrTraverse(BstNode Root){
        if (Root==null) return;
        else{
            LdrTraverse(Root.leftChild);
            System.out.print(Root.value+" ");
            LdrTraverse(Root.rightChild);
        }
    }
    public void LdrTraverse(){
        LdrTraverse(this.root);
    }
}
