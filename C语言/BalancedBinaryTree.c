#include <stdio.h>
#include <stdlib.h>
/*
   ����һ��ƽ������� 
*/

typedef struct Tree{
	int value;
	int height; 
	struct Tree *left;
	struct Tree *right;
}*Tree,Node;
//��ʼ��һ���� 
void initTree(Tree *tree){
	*tree=NULL;
}

//����һ���ڵ�
Node* createNode(int value){
	Node *node=(Node*)malloc(sizeof(Node));
	node->value=value;
	node->height=1;
	node->left=NULL;
	node->right=NULL;
	return node;
}
//���¸߶�
int UpdateHeight(Node* node){
	int leftHeight=Heigth(node->left);
	int rightHeight=Heigth(node->right);	
	return leftHeight>rightHeight?leftHeight+1:rightHeight+1;
} 
int Heigth(Node *node){
	return node!=NULL?node->height:0;
}
//RR��ʧ��  ���� 
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
//LL��ʧ��  ����
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
//LR��ʧ��
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
//RL��ʧ�� 
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

//�ж����Ƿ�ʧ��
Node* judge(Tree *tree){
	if(Heigth((*tree)->left)-Heigth((*tree)->right)>1){   //����ʧ�� 
		if(Heigth((*tree)->left->left)>=Heigth((*tree)->left->right)){
			return LLBalance(&(*tree));
		}else{
			return LRBalance(&(*tree));
		}
	}else if(Heigth((*tree)->right)-Heigth((*tree)->left)>1){  //����ʧ�� 
		if(Heigth((*tree)->right->right)>=Heigth((*tree)->right->left)){
			return RRBalance(&(*tree));
		}else{
			return RLBalance(&(*tree));
		}
	}
	return NULL;
}
//������ӽڵ�  
Tree addNode(Tree *tree,int value){
	if(!*tree) return createNode(value);
	if((*tree)->value>value) (*tree)->left=addNode(&(*tree)->left,value);
	else if((*tree)->value<=value) (*tree)->right=addNode(&(*tree)->right,value);	
	Node* newtree=judge(&(*tree));
	if(newtree!=NULL) (*tree)=newtree;
	(*tree)->height=UpdateHeight(*tree);
	return *tree;	
}
//ǰ�����
void DLrTraverse(Tree tree){
	if(!tree) return;
	printf("%d ",tree->value);
	DLrTraverse(tree->left);
	DLrTraverse(tree->right);
} 
//�������
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
