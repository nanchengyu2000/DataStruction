#include <stdio.h>
#include <stdlib.h>

typedef struct {
	char *base;
	int front;
	int erer;
	int size;
}SqQueue;

void initSqQueue(SqQueue *queue,int size){
	queue->base=(char*)malloc(sizeof(char)*size);
	queue->erer=0;
	queue->front=0;
	queue->size=size;
}
//入队 
void enqueue(SqQueue *queue,char value){
	if(((queue->erer+1)%queue->size)==queue->front){
		printf("队满操作\n");
	}else{
		queue->base[queue->erer%queue->size]=value;
		queue->erer=++queue->erer%queue->size;
	}
}
//出队 
void dequeue(SqQueue *queue){
	if(queue->front!=queue->erer){
		printf("%c",(queue->base)[queue->front]);
		queue->front=++queue->front%queue->size;
	}else{
		printf("队空操作！\n");
	}
}

int getSize(SqQueue *queue){
	return 	(queue->erer-queue->front+queue->size)%queue->size;
}

int main(){
	SqQueue queue;
	initSqQueue(&queue,10);
	enqueue(&queue,'I');
	enqueue(&queue,' ');
	enqueue(&queue,'L');
	enqueue(&queue,'o');
	enqueue(&queue,'v');
	printf("%d\n",getSize(&queue));
	system("pause");
	return 0;
}


 
