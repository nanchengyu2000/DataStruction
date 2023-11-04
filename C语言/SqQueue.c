#include <stdio.h>
#include <stdlib.h>
#include "SqQueue.h"

void initSqQueue(SqQueue *queue,int size){
	queue->base=(BiNode*)malloc(sizeof(BiNode)*size);
	queue->erer=0;
	queue->front=0;
	queue->size=size;
}
//��� 
void enqueue(SqQueue *queue,BiNode* value){
	if(((queue->erer+1)%queue->size)==queue->front){
		printf("��������\n");
	}else if(value!=NULL){
		queue->base[queue->erer%queue->size]=*value;
		queue->erer=++queue->erer%queue->size;
	}
}
//���� 
BiNode dequeue(SqQueue *queue){
	if(queue->front!=queue->erer){
		BiNode deNode=(queue->base)[queue->front];
		queue->front=++queue->front%queue->size;
		return deNode;
	}else{
		printf("�ӿղ�����\n");
	}
}

int getSize(SqQueue *queue){
	return 	(queue->erer-queue->front+queue->size)%queue->size;
}
