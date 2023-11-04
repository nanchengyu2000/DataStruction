#include <stdio.h>
#include <stdlib.h>
#include "SqBiTree.h" 
#include "LqStack.h"
#include "SqQueue.h"

void init(BiTree *tree){
	*tree=NULL;
}
//创造一个节点 
BiNode* createNode(char value){
	BiNode *newNode=(BiNode*)malloc(sizeof(BiNode));
	newNode->LTree=NULL;
	newNode->RiTree=NULL;
	newNode->value=value;
	return newNode;
}
void pushValue(BiTree *tree){
	char value; 
	scanf("%c", &value);
	if(value=='#') *tree=NULL;
	else{
		*tree=createNode(value);
		pushValue(&((*tree)->LTree));
		pushValue(&((*tree)->RiTree));
	}
	return;
}
//递归的前序遍历 
void DlrTraverse(BiTree tree){
	if(tree!=NULL){
		printf("%c ",tree->value);
		DlrTraverse(tree->LTree);
		DlrTraverse(tree->RiTree);
	}
}
//递归的中序遍历 
void LdrTraverse(BiTree tree){
	if(tree!=NULL){
		LdrTraverse(tree->LTree);
		printf("%c ",tree->value); 
		LdrTraverse(tree->RiTree);
	}
}
//递归的后序遍历 
void LrdTraverse(BiTree tree){
	if(tree!=NULL){
		LrdTraverse(tree->LTree);
		LrdTraverse(tree->RiTree);
		printf("%c ",tree->value); 
	}
}
//非递归的中序遍历
void  LdrTraverseByStack(BiTree tree){
	BiTree p;
	lqStack stack;
	initStack(&stack);
	p=tree;
	while(p||!isEmpty(&stack)){
		if(p){
			push(p,&stack);
			p=p->LTree; 
		}else{
			BiNode *node=pop(&stack);
			printf("%c ",node->value);
			p=node->RiTree;
		}
	}
}
//非递归的先序遍历
void  DlrTraverseByStack(BiTree tree){
	if(tree==NULL) return;
	lqStack stack;
	initStack(&stack);
	push(tree,&stack);
	while(!isEmpty(&stack)){
		BiNode *node=pop(&stack);
		printf("%c ",node->value);
		if(node->RiTree!=NULL){
			push(node->RiTree,&stack);
		}
		if(node->LTree!=NULL){
			push(node->LTree,&stack);
		}	
	}
}
//非递归的后序遍历
void LrdTraverseByStack(BiTree tree){
	if(tree==NULL) return;
	lqStack stack;
	initStack(&stack);
	lqStack stack1;
	initStack(&stack1);
	push(tree,&stack);
	
	while(!isEmpty(&stack)){
		BiNode *node=pop(&stack);
		push(node,&stack1);
		if(node->LTree)
			push(node->LTree,&stack);
		if(node->RiTree)
			push(node->RiTree,&stack);
	}
	
	while(!isEmpty(&stack1)){
		printf("%c ",pop(&stack1)->value); 
	}	
}	
//二叉树的层次遍历
void  levelTraverse(BiTree tree){
	BiNode *p;
	SqQueue queue;
	initSqQueue(&queue,20);
	p=tree;
	enqueue(&queue,p);
	while(getSize(&queue)!=0){ 
		*p=dequeue(&queue);
		if(p!=NULL){
			printf("%c ",p->value);
			enqueue(&queue,p->LTree);
			enqueue(&queue,p->RiTree);
		}
	}
} 
//复制二叉树
void copyTree(BiTree tree,BiTree *newtree){  
	if(tree==NULL){ //空树停止拷贝 
		newtree=NULL;
	}else{
		*newtree=createNode(tree->value);
		copyTree(tree->LTree,&((*newtree)->LTree));
		copyTree(tree->RiTree,&((*newtree)->RiTree));
	}
	
}
//计算二叉树的深度
int Depth(BiTree tree){
	if(tree==NULL) return 0;
	int m,n;
	m=Depth(tree->LTree);
	n=Depth(tree->RiTree);
	if(m>n) return (m+1);
	 else return (n+1);
} 
//计算二叉树的结点总数
int nodeCount(BiTree tree){
	if(tree==NULL) return 0;
	else
		return nodeCount(tree->LTree)+nodeCount(tree->RiTree)+1;
} 
//计算二叉树的叶子结点 
int  LeadCount(BiTree tree){
	if(tree==NULL) return 0;
	if(tree->LTree==NULL&&tree->RiTree==NULL) return 1;
	else
		return LeadCount(tree->LTree)+LeadCount(tree->RiTree);
} 
