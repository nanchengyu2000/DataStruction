#include <stdio.h>
#include <stdlib.h>

typedef struct TreeNode{
	int value;
	int size;
	struct TreeNode *childs;
}*Tree,Node;

void initTree(Tree *tree,int value){
	*tree=(Tree)malloc(sizeof(Node));
	(*tree)->value=value;
}
//创建结点 
Node* creatNode(int value){
	Node *node=(Node*)malloc(sizeof(Node));
	node->value=value;
	node->childs=NULL;}
//向结点添加孩子 
void addChild(Node *node,int childs[],int size){
	int i;
	node->childs=(Node*)malloc(sizeof(int)*size);
	node->size=size;
	for(i=0;i<size;i++){
		Node *child=creatNode(childs[i]);
		node->childs[i]=*child;
	}
}
//获取某个结点 
Node* getNode(Tree tree,int index){
	return &tree->childs[index]; 
}
//先根遍历 
void preorderTraverse(Tree tree){
	if(!tree) return;
	printf("%d ",tree->value);
	if(tree->childs!=NULL){
		int i;
		for(i=0;i<tree->size;i++){
			preorderTraverse(&tree->childs[i]);	
		}
	} 
}

int main(){
	Tree tree;
	initTree(&tree,10);
	int i[]={1,2,3,4};
	addChild(tree,i,4);
	Node* node=getNode(tree,2);
	int j[]={9,8,0};
	addChild(node,j,3);	
	preorderTraverse(tree);
	printf("\n");
	system("pause");
	return 0;
} 
