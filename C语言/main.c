#include <stdio.h>
#include <stdlib.h>
#include "SqBiTree.h"

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
//
int main(int argc, char *argv[]) {
	BiTree tree;
	init(&tree);
	pushValue(&tree);
	printf("������ȣ�\n");
	printf("%d",Depth(tree));
	printf("\n");
	printf("���Ľ���ܸ�����\n");
	printf("%d",nodeCount(tree));
	printf("\n");
	printf("����Ҷ�ӽ�������\n");
	printf("%d",LeadCount(tree));
	printf("\n");
	printf("����ǰ�������\n");
	DlrTraverse(tree);
	printf("\n");
	printf("�������������\n");
	LdrTraverse(tree);
	printf("\n");
	printf("���ĺ��������\n");
	LrdTraverse(tree);
	printf("\n");
	printf("���ķǵݹ�ǰ�������\n");
	DlrTraverseByStack(tree);
	printf("\n");
	printf("���ķǵݹ����������\n");
	LdrTraverseByStack(tree);
	printf("\n");
	printf("���ķǵݹ���������\n");
	LrdTraverseByStack(tree);
	printf("\n");
	printf("���Ƶ�����ǰ����������������\n");
	BiTree newtree=NULL;
	copyTree(tree,&newtree);
	DlrTraverse(newtree);
	printf("\n");
	LdrTraverse(newtree);
	printf("\n");
	printf("����α�����\n");
	levelTraverse(tree);  //��������Ὣԭ���仯 
	printf("\n");
	printf("=============\n");
	
	system("pause");
	return 0;
}
