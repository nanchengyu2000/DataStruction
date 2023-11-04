#include <stdio.h>
#include <stdlib.h>
#include "LqStack.h"

////³õÊ¼»¯Õ» 
void initStack(lqStack *stack){
	stack->top=NULL;
}
//ÈëÕ» 
void push(BiNode *value,lqStack *stack){
	stackNode *node=(stackNode*)malloc(sizeof(stackNode));
	node->value=value;
	node->next=stack->top;
	stack->top=node;
}
//³öÕ» 
BiNode* pop(lqStack *stack){
	if(stack->top){
		stackNode *node=stack->top;
		BiNode* value=node->value;
		stack->top=node->next;
		free(node);
		return value;
	}else{
		printf("Á´Õ»ÏÂÒç²Ù×÷£¡");
		return ' ';
	}
}
//ÅÐ¶ÏÁ´Õ»ÊÇ·ñÎª¿Õ 
int isEmpty(lqStack *stack){
	return stack->top?0:1;
}

