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
            VALNode judgeNode = judge(node);
            if (judgeNode!=null) node=judgeNode;

            node.height=UpdateHeight(node);
        }
        return node;
    }
    //用于判别各种失衡情况
    private VALNode judge(VALNode node){
        if (Height(node.rightChild)-Height(node.leftChild)>1){
            if (Height(node.rightChild.rightChild)>=Height(node.rightChild.leftChild)){
               return RRBalance(node);
            }else{
                return RLBalance(node);
            }
        }else if (Height(node.leftChild)-Height(node.rightChild)>1){
            if (Height(node.leftChild.leftChild)>=Height(node.leftChild.rightChild)){
                return LLBalance(node);
            }else{
                return LRBalance(node);
            }
        }
        return null;
    }
    //更新操作
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
        node.height=UpdateHeight(node);
        rightChild.leftChild=node;
        return rightChild;
    }
    //LL型 右旋
    public VALNode LLBalance(VALNode node){
        VALNode leftChild = node.leftChild;
        if (leftChild.rightChild!=null){
            node.leftChild=leftChild.rightChild;
        }else{
            node.leftChild=null;
        }
        node.height=UpdateHeight(node);
        leftChild.rightChild=node;
        return leftChild;
    }
    public VALNode LRBalance(VALNode node){
        VALNode leftChild = node.leftChild;
        VALNode rightChild1 = leftChild.rightChild;
        rightChild1.leftChild=leftChild;
        leftChild.rightChild=null;
        node.leftChild=rightChild1;
        leftChild.height=UpdateHeight(leftChild);
        rightChild1.height=UpdateHeight(rightChild1);
        return LLBalance(node);
    }
    public VALNode RLBalance(VALNode node){
        VALNode rightChild = node.rightChild;
        VALNode leftChild1 = rightChild.leftChild;
        leftChild1.rightChild=rightChild;
        rightChild.leftChild=null;
        node.rightChild=leftChild1;
        rightChild.height=UpdateHeight(rightChild);
        leftChild1.height=UpdateHeight(leftChild1);
        return RRBalance(node);
//        System.out.println(node.height);
//        return node;
    }
    //插入节点
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
    //删除节点操作
/*    public void delete(int value){
        VALNode parentNode = null;
        VALNode pre=this.root;
        while (pre.value!=value&&pre!=null){
            if (pre.value<value){
                parentNode=pre;
                pre=pre.rightChild;
            }else if (pre.value>value){
                parentNode=pre;
                pre=pre.leftChild;
            }else {
                if (parentNode.value>value){
                    parentNode.leftChild=null;
                }else{
                    parentNode.rightChild=null;
                }
            }
        }
        if (pre==null) System.out.println("该平衡二叉树并没有你要删除的节点");
        else{
            VALNode judge = judge(parentNode);
            if (judge!=null)
        }
    }
    这段是开始写的错误的思想
    */
    //找到要删除节点的右子树的最小节点
    private VALNode findMinNode(VALNode node){
        VALNode MinNode;
        if (node.leftChild==null) return node;
        else{
             MinNode=findMinNode(node.leftChild);
        }
        return MinNode;
    }
    //左孩子不为空，包括了左孩子不为空，右孩子为空和两个孩子均不为空的情况 进行删除节点
    private void deleteNode(VALNode node,VALNode MinNode){
        node.value=MinNode.value;
        VALNode parent=node.rightChild;
        if (MinNode==node.rightChild) node.rightChild=node.rightChild.rightChild;
        else{
            while (parent.leftChild!=MinNode){
                parent=parent.leftChild;
            }
            parent.leftChild=MinNode.rightChild;
        }
    }
    private VALNode delete(int value,VALNode node){
        if (node==null) return null;
        else{
            if (node.value>value)
                node.leftChild=delete(value,node.leftChild);
            else if (node.value<value)
                node.rightChild=delete(value,node.rightChild);
            else{
                if (node.rightChild==null&&node.leftChild==null){ //左孩子和右孩子均为空的情况
                    return null;
                }else if (node.rightChild!=null){  //左孩子不为空，包括了左孩子不为空，右孩子为空和两个孩子均不为空的情况
                    VALNode MinNode = findMinNode(node.rightChild);
                    deleteNode(node,MinNode);
                }else if (node.rightChild==null){  //右孩子为空的情况
                    return node.leftChild;    //右孩子为空只需要返回左子树的最大节点就行
                }
            }
            UpdateHeight(node);
            return node;
        }
    }
    public void delete(int value){
        delete(value,root);
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
}
