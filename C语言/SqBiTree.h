#ifndef _SQBITREE_H_ 
#define _SQBITREE_H_
typedef struct BiNode{
	char value;
	struct BiNode *LTree;
	struct BiNode *RiTree;
}BiNode,*BiTree;
#endif

void init(BiTree *tree);
BiNode* createNode(char value);
void pushValue(BiTree *tree);
void DlrTraverse(BiTree tree);
void LdrTraverse(BiTree tree);
void  LdrTraverseByStack(BiTree tree);
void  DlrTraverseByStack(BiTree tree);
void LrdTraverseByStack(BiTree tree);
void  levelTraverse(BiTree tree); 
