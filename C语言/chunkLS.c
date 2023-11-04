#include <stdio.h>
#include <stdlib.h>

#define MaxSize  3
 typedef struct Chuck{
 	char chars[MaxSize];
 	struct Chuck *next;
 	int count;
 }Chuck;
 	
 typedef struct Node{
 	Chuck *head,*tail;
 	int length;
 }*ChlNode,Node;
 
 //初始化一个块链式串 
 void initChuckLS(ChlNode *chlnode){
 	Chuck *chucks=(Chuck*)malloc(sizeof(Chuck));
 	(*chlnode)=(ChlNode)malloc(sizeof(Node));
 	chucks->next=NULL;
 	chucks->count=0;
 	(*chlnode)->head=chucks;
 	(*chlnode)->tail=chucks;
 	(*chlnode)->length=1;
 }
 //添加数据 	
 void pushValue(char value,ChlNode chlnode){
 	if(chlnode->head==chlnode->tail){
 		chlnode->head->chars[chlnode->head->count]=value;
		++chlnode->head->count;
	 }else{
	 	chlnode->tail->chars[chlnode->tail->count]=value;
	 	++chlnode->tail->count;
	 }
	 if(chlnode->head->count==MaxSize){
 			Chuck *chuck=(Chuck*)malloc(sizeof(Chuck));
 			chuck->count=0;
 			chuck->next=NULL;
 			chlnode->tail->next=chuck; 
 			chlnode->tail=chuck;
 			++chlnode->length;
	}
 }
 //打印块链串 
 void printAll(ChlNode chlnode){
 	if(chlnode->head==chlnode->tail&&chlnode->head->count==0){
 		printf("空块链串");
 		return ;
	 }else{
	 	 int tmp;
	 	 Chuck *tmpPort=chlnode->head;
		 do{
		 	for(tmp=0;tmp<tmpPort->count;++tmp){
	     		char value=tmpPort->chars[tmp];
	     		printf("%c ",value);
		 	}
			tmpPort=tmpPort->next;	
		 }while(tmpPort);
	 } 
 	
 }
  
 
 
 int main(){
 	ChlNode chlnode;
 	initChuckLS(&chlnode);
 	pushValue('I',chlnode);
 	pushValue('L',chlnode);
 	pushValue('O',chlnode);
 	pushValue('V',chlnode);
 	pushValue('E',chlnode);
 	pushValue('Y',chlnode);
 	pushValue('O',chlnode);
 	pushValue('U',chlnode);
 	printAll(chlnode);
 	
 	system("pause");
 	return 0;
 }
