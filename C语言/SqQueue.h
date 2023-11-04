#include "SqBiTree.h" 
#ifndef _SQQUEUE_H_ 
#define _SQQUEUE_H_
typedef struct {
	BiNode *base;
	int front;
	int erer;
	int size;
}SqQueue;
#endif

void initSqQueue(SqQueue *queue,int size);
void enqueue(SqQueue *queue,BiNode* node);
BiNode dequeue(SqQueue *queue);
int getSize(SqQueue *queue);
