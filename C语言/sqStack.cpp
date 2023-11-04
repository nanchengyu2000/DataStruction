#include <stdio.h>
#include <stdlib.h>
//这是定义顺序链表的第一种方法，采用指针方式的来标注底部指针和顶部指针 
typedef struct sqStack{
	char *top;
	char *base;
	int stackSize;
}sqStack;
//这是定义顺序链表的第一种方法，采用数组下标的方式来标注底部指针和顶部指针 
//typedef struct sqStack{
//	int top;
//	int base;
//	int stackSize;
//}sqStack;
//初始化顺序表 
void initStack(char **chars,sqStack *stack,int stackSize){
//	char chars[stackSize]={};   //对于数组初始化，也就是分配内存可以这样，也可以使用malloc函数 
	(*chars)=(char*)malloc(sizeof(char)*stackSize);
	if(!chars){
		printf("内存分配失败！");
		exit(0);
	}
	stack->stackSize=stackSize;
	stack->top=(*chars);
	stack->base=(*chars);
}
//入栈 
void push(sqStack *stack,char value){
	if(stack->top-stack->base==stack->stackSize){
		//满栈了
		printf("栈上溢出操作！"); 
	}else{
		*(stack->top)=value;
		stack->top+=1;
	} 
}
//出栈 
char pop(sqStack *stack){
	if(stack->top==stack->base){
		printf("栈下溢出操作！");
		return ' '; 
	}else{
		--(stack->top);
		return *stack->top;
	}
}
//判断栈是否为空 
int isEmpty(sqStack *stack){
	return stack->base==stack->top?1:0;
}
//获取栈的大小 
int getSize(sqStack *stack){
	return stack->top-stack->base;
}
//清空栈 
void clearStack(sqStack *stack){
	stack->top=stack->base;
}
//销毁栈 
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
