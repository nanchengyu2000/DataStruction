#include <stdio.h>
#include <stdlib.h>

typedef struct lqSqNode {
	char value;
	struct lqSqNode *next;
}*LinkSQ,lqSqNode;

typedef struct LqQueue {
	lqSqNode *front;
	lqSqNode *erer;
	int size;
}LqQueue;
//初始化链队列   
void initLqQueue(LqQueue *queue){
	LinkSQ linksq=(LinkSQ)malloc(sizeof(lqSqNode));
	linksq->next=NULL;
	queue->front=linksq;
	queue->erer=linksq;
	queue->size=0;
}
//入队 
void enqueue(char value,LqQueue *queue){
	lqSqNode *node=(lqSqNode*)malloc(sizeof(lqSqNode));
	node->value=value;
	node->next=NULL;
	queue->erer->next=node;
	queue->erer=node;
	++queue->size;
}
//出队 
void dequeue(LqQueue *queue){
	if(queue->front->next!=NULL){ 
		lqSqNode *node=queue->front->next;
//		printf("%c\n",node->value);
		queue->front->next=node->next;
		free(node); 
		--queue->size;
	}else{
		printf("队空操作!\n");
	}
}

int main(){
	LqQueue queue;
	initLqQueue(&queue);
	enqueue('i',&queue);
	enqueue('L',&queue);
	enqueue('k',&queue);
	enqueue('l',&queue);
//	dequeue(&queue);
//	dequeue(&queue);
//	dequeue(&queue);
//	dequeue(&queue);
//	dequeue(&queue);
	printf("%d\n",queue.size);
	system("pause");
	return 0;
}
