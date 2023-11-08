package DataStructure.NonlinearStructure;
class VALNode{
    VALNode leftChild;
    VALNode rightChild;
    int value;
    int height=1;
    public VALNode(int value) {
        this.value = value;
        this.leftChild=null;
        this.rightChild=null;
    }
}

public class BalancedBinaryTree {
    private VALNode root;
    public BalancedBinaryTree() {
        this.root=null;
    }
    public VALNode getRoot() {
        return root;
    }
    private VALNode addNode(VALNode node, int value){
        if (node==null) return new VALNode(value);
           else{
            if (node.value>value){
                node.leftChild=addNode(node.leftChild,value);
            }else{
                node.rightChild=addNode(node.rightChild,value);
            }

            //满足条件采用相应的旋转
            if (Height(node.rightChild)-Height(node.leftChild)>1){
                if (node.rightChild.rightChild!=null){
                    node=RRBalance(node);
                }
                else if(node.rightChild.rightChild==null&&node.rightChild.leftChild!=null){
                    node=RLBalance(node);
                }
            }
            else if (Height(node.leftChild)-Height(node.rightChild)>1){
                if (node.leftChild.leftChild!=null){
                    node=LLBalance(node);
                }
                else if(node.leftChild.leftChild==null&&node.leftChild.rightChild!=null){
                    node=LRBalance(node);
                }
            }
            node.height=UpdateHeight(node);
        }
        return node;
    }
    private int UpdateHeight(VALNode node){
        return  Math.max(Height(node.leftChild),Height(node.rightChild))+1;
    }
    private int Height(VALNode node) {
        return node == null?0:node.height; // 空节点高度为0
    }
    //RR型 左旋
    public VALNode RRBalance(VALNode node){
        VALNode rightChild = node.rightChild;
        if (rightChild.leftChild!=null){
            node.rightChild=rightChild.leftChild;
        }else{
            node.rightChild=null;
        }
        rightChild.leftChild=node;
        return rightChild;
    }
    public VALNode LLBalance(VALNode node){
        VALNode leftChild = node.leftChild;
        if (leftChild.rightChild!=null){
            node.leftChild=leftChild.rightChild;
        }else{
            node.leftChild=null;
        }
        leftChild.rightChild=node;
        return leftChild;
    }
    public VALNode LRBalance(VALNode node){
        VALNode leftChild = node.leftChild;
        VALNode rightChild1 = leftChild.rightChild;
        rightChild1.leftChild=leftChild;
        leftChild.rightChild=null;
        node.leftChild=rightChild1;
        return LLBalance(node);
    }
    public VALNode RLBalance(VALNode node){
        VALNode rightChild = node.rightChild;
        VALNode leftChild1 = rightChild.leftChild;
        leftChild1.rightChild=rightChild;
        rightChild.leftChild=null;
        node.rightChild=leftChild1;
        return RRBalance(node);
    }
    // 计算节点的高度

    public void buildTree(int value) {
        this.root=addNode(this.root,value);
    }
    private boolean Search(VALNode node,int value){
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
    private void DlrTraverse(VALNode Root){
        if (Root==null) return;
        else{
            System.out.print(Root.value+"--height:"+ Root.height+" ");
            DlrTraverse(Root.leftChild);
            DlrTraverse(Root.rightChild);
        }
    }
    public void DlrTraverse(){
        DlrTraverse(this.root);
    }
    private void LdrTraverse(VALNode Root){
        if (Root==null) return;
        else{
            LdrTraverse(Root.leftChild);
            System.out.print(Root.value+"--height:"+ Root.height+" ");
            LdrTraverse(Root.rightChild);
        }
}
    public void LdrTraverse(){
        LdrTraverse(this.root);
    }
    //插入一个节点
    public void InsertValue(int value){
        VALNode newNode = new VALNode(value);

    }

}
