#include <stdio.h>
#include <stdlib.h>

//这个源代码设计的是循环链表，包括设计的尾指针，两个循环链表的组合，但是链表的其他操作我们在这就不去写了
// 设计这个尾指针的目的是在对表的首尾部分进行操作的时候可以降低时间复杂度
typedef struct Book {
	char bookname[20];
	char author[10];
}Book;

typedef struct Node{
	Book book;
	struct Node *next;
}Node;

typedef struct LoopLinkList{
	Node *headNode;
	Node *tailNode;
} *LoopList;
//初始化循环列表 
void initLoopLinkList(LoopList *L){  //ok
	Node *headNode=(Node*)malloc(sizeof(Node));
	*L=(LoopList)malloc(sizeof(LoopList));
	(*L)->headNode=headNode;
	(*L)->tailNode=headNode;
}
//向循环链表中添加结点 
void putNode(Book book,LoopList L){   //ok
	Node *node=(Node*)malloc(sizeof(Node));
	node->book=book;
	L->tailNode->next=node;
	L->tailNode=node;
	node->next=L->headNode;
}

//将第二个循环链表添加到第一个循环链表后
LoopList  connectTable(LoopList L1,LoopList L2){   //0k
	L1->tailNode->next=L2->headNode->next;
	free(L2->headNode);
	L2->tailNode->next=L1->headNode;
	L1->tailNode=L2->tailNode;
	return L1;
}

//打印链表中的数据 
void printNodeData(LoopList L){      //ok
	Node *node=L->headNode->next;
	while(node!=L->headNode){
		printf("bookname:%s;author:%s\n",node->book.bookname,node->book.author);
		node=node->next;
	}
	if(!node) printf("你所给的是个空链表！\n"); 
}
//获取循环列表的长度 
int getSize(LoopList L){    //ok
	Node *node=L->headNode->next;
	int counter=0;
	while(L->headNode!=L->tailNode&&node!=L->headNode){
		node=node->next;
		++counter;
	}
	return counter;
}

int main(){
	LoopList L;
	initLoopLinkList(&L);
	Book book1={"java","zhangyu"};
	Book book2={"php","zhang"};
	Book book3={"c#","nan"};
	putNode(book1,L);
	putNode(book2,L);
	putNode(book3,L);
	printf("表1：\n");
	printNodeData(L);
	LoopList L2;
	initLoopLinkList(&L2);
	Book book4={"jaa","hangyu"};
	Book book5={"ph","zhng"};
	Book book6={"c","an"};
	putNode(book4,L2);
	putNode(book5,L2);
	putNode(book6,L2);
	printf("表2：\n");
	printNodeData(L2);
	LoopList list=connectTable(L,L2);
	printf("连接后的表：\n");
	printNodeData(list);
	system("pause");
	return 0;
}


