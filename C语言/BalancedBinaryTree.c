#include <stdio.h>
#include <stdlib.h>
/*
   创建一颗平衡二叉树 
*/

typedef struct Tree{
	int value;
	int height; 
	struct Tree *left;
	struct Tree *right;
}*Tree,Node;
//初始化一颗树 
void initTree(Tree *tree){
	*tree=NULL;
}

//创建一个节点
Node* createNode(int value){
	Node *node=(Node*)malloc(sizeof(Node));
	node->value=value;
	node->height=1;
	node->left=NULL;
	node->right=NULL;
	return node;
}
//更新高度
int UpdateHeight(Node* node){
	int leftHeight=Heigth(node->left);
	int rightHeight=Heigth(node->right);	
	return leftHeight>rightHeight?leftHeight+1:rightHeight+1;
} 
int Heigth(Node *node){
	return node!=NULL?node->height:0;
}
//RR型失衡  左旋 
Node* RRBalance(Tree *tree){
	Tree right=(*tree)->right;
	if(right->left){
		(*tree)->right=right->left;
	}else{
		(*tree)->right=NULL;
	}
	right->left=(*tree);
	return right;
} 
//LL型失衡  右旋
Node* LLBalance(Tree *tree){
	Tree left=(*tree)->left;
	if(left->right){
		(*tree)->left=left->right;
	}else{
		(*tree)->left=NULL;
	}
	left->right=(*tree);
	return left;	
} 
//LR型失衡
Node* LRBalance(Tree *tree){
	Tree left=(*tree)->left;
	Tree Lright=left->right;
	Lright->left=left;
	left->right=NULL;
	(*tree)->left=Lright;
	left->height=UpdateHeight(left);
	Lright->height=UpdateHeight(Lright);
	return Lright;
}
//RL型失衡 
Node* RLBalance(Tree *tree){
	Tree right=(*tree)->right;
	Tree Rleft=right->left;
	Rleft->right=right;
	right->left=NULL;
	(*tree)->right=Rleft;
	right->height=UpdateHeight(right);
	Rleft->height=UpdateHeight(Rleft);
	return Rleft;
}

//判断树是否失衡
Node* judge(Tree *tree){
	if(Heigth((*tree)->left)-Heigth((*tree)->right)>1){   //左树失衡 
		if(Heigth((*tree)->left->left)>=Heigth((*tree)->left->right)){
			return LLBalance(&(*tree));
		}else{
			return LRBalance(&(*tree));
		}
	}else if(Heigth((*tree)->right)-Heigth((*tree)->left)>1){  //右树失衡 
		if(Heigth((*tree)->right->right)>=Heigth((*tree)->right->left)){
			return RRBalance(&(*tree));
		}else{
			return RLBalance(&(*tree));
		}
	}
	return NULL;
}
//向树添加节点  
Tree addNode(Tree *tree,int value){
	if(!*tree) return createNode(value);
	if((*tree)->value>value) (*tree)->left=addNode(&(*tree)->left,value);
	else if((*tree)->value<=value) (*tree)->right=addNode(&(*tree)->right,value);	
	Node* newtree=judge(&(*tree));
	if(newtree!=NULL) (*tree)=newtree;
	(*tree)->height=UpdateHeight(*tree);
	return *tree;	
}
//前序遍历
void DLrTraverse(Tree tree){
	if(!tree) return;
	printf("%d ",tree->value);
	DLrTraverse(tree->left);
	DLrTraverse(tree->right);
} 
//中序遍历
void LdrTraverse(Tree tree){
	if(!tree) return;
	LdrTraverse(tree->left);
	printf("%d ",tree->value);
	LdrTraverse(tree->right);
} 
int main(){
	Tree tree;
	initTree(&tree);
	tree=addNode(&tree,6);
	tree=addNode(&tree,2);
	tree=addNode(&tree,1);
	printf("\n");
	DLrTraverse(tree);
	printf("\n");
	LdrTraverse(tree);
	printf("\n");
	system("pause");
	return 0;
}
