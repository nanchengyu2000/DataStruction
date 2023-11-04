#include <stdio.h>
#include <stdlib.h>

typedef struct stackNode{
    struct stackNode* next;
    char value; 
}*LinkNode,Node;

typedef struct lqStack{
    LinkNode top;
}lqStack;

void init(lqStack *stack){
    stack->top=NULL;
}
char pop(lqStack **stack){
	if((*stack)->top){
		stackNode *node=(*stack)->top;
		(*stack)->top=node->next;
		free(node);
	}
} 


void push(char value,lqStack *stack){
    if(value=='}'&&stack->top->value=='{'){
        pop(&stack);
    }else if(value==']'&&stack->top->value=='['){
        pop(&stack);
    }else if(value==')'&&stack->top->value=='('){
        pop(&stack);
    }else{
        Node *node=(Node*)malloc(sizeof(Node));
        node->next=stack->top;
        node->value=value;
        stack->top=node;
    }
    
}

int isValid(char * s,lqStack *stack,int length){
	if(length%2==0){
		int i;
	for(i=0;i<length;i++){
		push(s[i],stack);
	}
    return stack->top?0:1;
	}
	return 0;
}

int main(){
	lqStack stack;
	init(&stack);
	char c[]={'[',']','{','(',']','}'};
	int length=sizeof(c)/sizeof(c[0]);
	printf("%d",isValid(c,&stack,length));
	system("pause");
	return 0;
}

