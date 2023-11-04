#include <stdio.h>
#include <stdlib.h>


typedef struct BiNode{
	char value;
	struct BiNode *LTree;
	struct BiNode *RiTree;
}BiNode,*BiTree;

typedef struct stackNode{
	BiNode *value;
	struct stackNode* next;
}*linkStack,stackNode; 

typedef struct lqStack{
	linkStack top;
}lqStack;
////��ʼ��ջ 
void initStack(lqStack *stack){
	stack->top=NULL;
}
//��ջ 
void push(BiNode *value,lqStack *stack){
	stackNode *node=(stackNode*)malloc(sizeof(stackNode));
	node->value=value;
	node->next=stack->top;
	stack->top=node;
}
//��ջ 
BiNode* pop(lqStack *stack){
	if(stack->top){
		stackNode *node=stack->top;
		BiNode *value=node->value;
		stack->top=node->next;
		free(node);
		return value;
	}else{
		printf("��ջ���������");
		return NULL;
	}
}
//�ж���ջ�Ƿ�Ϊ�� 
int isEmpty(lqStack *stack){
	return stack->top?0:1;
}

void init(BiTree *tree){
	*tree=NULL;
}
//����һ���ڵ� 
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

//�ݹ��ǰ����� 
void DlrTraverse(BiTree tree){
	if(tree!=NULL){
		printf("%c ",tree->value);
		DlrTraverse(tree->LTree);
		DlrTraverse(tree->RiTree);
	}
}
//�ݹ��������� 
void LdrTraverse(BiTree tree){
	if(tree!=NULL){
		LdrTraverse(tree->LTree);
		printf("%c ",tree->value); 
		LdrTraverse(tree->RiTree);
	}
}
//�ǵݹ���������
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
//�ǵݹ���������
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
//�ǵݹ�ĺ������
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
//�������Ĳ�α���
void  

//���ƶ�����

//��������������

//����������Ľ������

//�����������Ҷ�ӽ�� 

int main(){
	BiTree tree;
	init(&tree);
	pushValue(&tree);
	DlrTraverse(tree);
	printf("\n");
	LdrTraverse(tree);
	printf("\n");
	LdrTraverseByStack(tree);
	printf("\n");
	DlrTraverseByStack(tree);
	printf("\n");
	LrdTraverseByStack(tree);
	printf("\n");x
	system("pause");
	return 0;
} 
