#include <stdio.h>
#include <stdlib.h>
#include "SqQueue.h"

void initSqQueue(SqQueue *queue,int size){
	queue->base=(BiNode*)malloc(sizeof(BiNode)*size);
	queue->erer=0;
	queue->front=0;
	queue->size=size;
}
//入队 
void enqueue(SqQueue *queue,BiNode* value){
	if(((queue->erer+1)%queue->size)==queue->front){
		printf("队满操作\n");
	}else if(value!=NULL){
		queue->base[queue->erer%queue->size]=*value;
		queue->erer=++queue->erer%queue->size;
	}
}
//出队 
BiNode dequeue(SqQueue *queue){
	if(queue->front!=queue->erer){
		BiNode deNode=(queue->base)[queue->front];
		queue->front=++queue->front%queue->size;
		return deNode;
	}else{
		printf("队空操作！\n");
	}
}

int getSize(SqQueue *queue){
	return 	(queue->erer-queue->front+queue->size)%queue->size;
}
