typedef struct stackNode{
	BiNode *value;
	struct stackNode* next;
}*linkStack,stackNode; 
typedef struct lqStack{
	linkStack top;
}lqStack;

void initStack(lqStack *stack);
void push(BiNode *value,lqStack *stack);
BiNode* pop(lqStack *stack);
int isEmpty(lqStack *stack);
