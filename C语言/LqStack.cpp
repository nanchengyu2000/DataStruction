#include <stdio.h>
#include <stdlib.h>

typedef struct stackNode{
	char value;
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
void push(char value,lqStack *stack){
	stackNode *node=(stackNode*)malloc(sizeof(stackNode));
	node->value=value;
	node->next=stack->top;
	stack->top=node;
}
//��ջ 
char pop(lqStack *stack){
	if(stack->top){
		stackNode *node=stack->top;
		char value=node->value;
		stack->top=node->next;
		free(node);
		return value;
	}else{
		printf("��ջ���������");
		return ' ';
	}
}
//�ж���ջ�Ƿ�Ϊ�� 
int isEmpty(lqStack *stack){
	return stack->top?0:1;
}

int main(){
	lqStack stack;
	linkStack node;
	initStack(&stack);
	push('d',&stack);
	push('q',&stack);
	push('r',&stack);
	printf("%c\n",pop(&stack));
	printf("%c\n",pop(&stack));
	printf("%c\n",pop(&stack));
	printf("%c\n",pop(&stack));
	system("pause");
	return 0;
}
