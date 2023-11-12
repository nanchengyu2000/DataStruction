#include <stdio.h>
#include <stdlib.h>
/*
   ����һ�Ŷ��������� 
*/
typedef struct Tree{
	int value;
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
	node->left=NULL;
	node->right=NULL;
	return node;
} 

//������ӽڵ�  
Node* addNode(Tree *tree,int value){
	if(!*tree) return createNode(value);
	if((*tree)->value>value) (*tree)->left=addNode(&(*tree)->left,value);
	else if((*tree)->value<=value) (*tree)->right=addNode(&(*tree)->right,value);
	return *tree;
}

//����һ�Ŷ�����
int Search(Tree tree,int value){
	if(!tree) return 0;
	int flag;
	if(tree->value>value) flag=Search(tree->left,value);
	else flag=Search(tree->right,value);
	else return 1;
	return flag;
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
	addNode(&tree,2);
	addNode(&tree,1);
	addNode(&tree,4);
	addNode(&tree,7);
	addNode(&tree,8);
    printf("%d",Search(tree,6));
    printf("\n");
	DLrTraverse(tree);
	printf("\n");
	LdrTraverse(tree);
	printf("\n");
	system("pause");
	return 0;
} 
