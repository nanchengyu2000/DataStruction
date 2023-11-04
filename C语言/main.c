#include <stdio.h>
#include <stdlib.h>
#include "SqBiTree.h"

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
//
int main(int argc, char *argv[]) {
	BiTree tree;
	init(&tree);
	pushValue(&tree);
	printf("树的深度：\n");
	printf("%d",Depth(tree));
	printf("\n");
	printf("树的结点总个数：\n");
	printf("%d",nodeCount(tree));
	printf("\n");
	printf("树的叶子结点个数：\n");
	printf("%d",LeadCount(tree));
	printf("\n");
	printf("树的前序遍历：\n");
	DlrTraverse(tree);
	printf("\n");
	printf("树的中序遍历：\n");
	LdrTraverse(tree);
	printf("\n");
	printf("树的后序遍历：\n");
	LrdTraverse(tree);
	printf("\n");
	printf("树的非递归前序遍历：\n");
	DlrTraverseByStack(tree);
	printf("\n");
	printf("树的非递归中序遍历：\n");
	LdrTraverseByStack(tree);
	printf("\n");
	printf("树的非递归后序遍历：\n");
	LrdTraverseByStack(tree);
	printf("\n");
	printf("复制的树的前序遍历和中序遍历：\n");
	BiTree newtree=NULL;
	copyTree(tree,&newtree);
	DlrTraverse(newtree);
	printf("\n");
	LdrTraverse(newtree);
	printf("\n");
	printf("树层次遍历：\n");
	levelTraverse(tree);  //这个函数会将原树变化 
	printf("\n");
	printf("=============\n");
	
	system("pause");
	return 0;
}
