#incude <stdio.h>
#include <stdlib.h>

typedef struct TreeNode{
	char value;
	struct TreeNode *leftNode;
	struct TreeNode *rightNode;
}*Tree,LeftNode,RightNode; 
void initTree(Tree tree){
	tree=NULL;
}
void addTree(Tree tree,char value){
	if(tree==NULL){
		Tree newtree=(Tree)malloc(sizeof(LeftNode));
		newtree->value=value;
		newtree->leftNode=NULL;
		newtree->rightNode=NULL;
			
	}
}

int main(){
	
	system("pause");
	return 0;
} 
