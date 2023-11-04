#include <stdio.h>
#include <stdlib.h>
//���Ƕ���˳������ĵ�һ�ַ���������ָ�뷽ʽ������ע�ײ�ָ��Ͷ���ָ�� 
typedef struct sqStack{
	char *top;
	char *base;
	int stackSize;
}sqStack;
//���Ƕ���˳������ĵ�һ�ַ��������������±�ķ�ʽ����ע�ײ�ָ��Ͷ���ָ�� 
//typedef struct sqStack{
//	int top;
//	int base;
//	int stackSize;
//}sqStack;
//��ʼ��˳��� 
void initStack(char **chars,sqStack *stack,int stackSize){
//	char chars[stackSize]={};   //���������ʼ����Ҳ���Ƿ����ڴ����������Ҳ����ʹ��malloc���� 
	(*chars)=(char*)malloc(sizeof(char)*stackSize);
	if(!chars){
		printf("�ڴ����ʧ�ܣ�");
		exit(0);
	}
	stack->stackSize=stackSize;
	stack->top=(*chars);
	stack->base=(*chars);
}
//��ջ 
void push(sqStack *stack,char value){
	if(stack->top-stack->base==stack->stackSize){
		//��ջ��
		printf("ջ�����������"); 
	}else{
		*(stack->top)=value;
		stack->top+=1;
	} 
}
//��ջ 
char pop(sqStack *stack){
	if(stack->top==stack->base){
		printf("ջ�����������");
		return ' '; 
	}else{
		--(stack->top);
		return *stack->top;
	}
}
//�ж�ջ�Ƿ�Ϊ�� 
int isEmpty(sqStack *stack){
	return stack->base==stack->top?1:0;
}
//��ȡջ�Ĵ�С 
int getSize(sqStack *stack){
	return stack->top-stack->base;
}
//���ջ 
void clearStack(sqStack *stack){
	stack->top=stack->base;
}
//����ջ 
void destroyStack(char *chars,sqStack *stack){
	if(chars){
		free(chars);
		stack->base=NULL;
		stack->top=NULL;
		stack->stackSize=0;
	}
}


int main(){
	sqStack stack;
	char *chars;
	initStack(&chars,&stack,100);
	push(&stack,'d');
	push(&stack,'e');
	push(&stack,'t');
	push(&stack,'o');
	printf("%c\n",pop(&stack));
	system("pause");
	return 0;
}
