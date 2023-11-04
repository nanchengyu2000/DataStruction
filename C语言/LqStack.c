#include <stdio.h>
#include <stdlib.h>
#include "LqStack.h"

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
		BiNode* value=node->value;
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

