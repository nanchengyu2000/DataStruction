#include <stdio.h>
#include <stdlib.h>

//这个源文件描述的是不循环双向链表

typedef struct Book {
	char bookname[20];
	char author[10];
}Book;
typedef struct doLinkList{
	Book book;
	struct doLinkList *prior,*next;
	struct doLinkList *ele;
}Node,*LinkList;
//初始化链表 
void initDoLinkList(LinkList *L){
	*L=(LinkList)malloc(sizeof(Node));
	(*L)->prior=NULL;
	(*L)->next=NULL;
	(*L)->ele=*L;
}
//向链表添加结点 
void putNode(Book book,Node *listNode){
	Node *node=(Node*)malloc(sizeof(Node));
	node->book=book;
	listNode->ele->next=node;
	node->prior=listNode->ele;
	node->next=NULL;
	listNode->ele=node;
}
//打印结点数据 
void printNodeData(LinkList list){
	if(!list->next){
		printf("你所给的是个空链表！\n"); 
		return;	
	} 
	Node *node=list->next;
	while(node){
		printf("bookname:%s;author:%s\n",node->book.bookname,node->book.author);
		node=node->next;
	}
}
//查找链表数据 
Node* getNode(int i,LinkList list){
	Node *node=list->next;
	int counter=1;
	while(node&&counter!=i&&i>0){
		node=node->next;
		++counter;
	}
	if(i<0||i>counter){
		printf("索引超出范围！\n");
		return NULL;
	}
	return node;
}

//删除链表结点
void delNode(int i,LinkList list){
	Node *p;
	if(!(p=getNode(i,list))){
		printf("并没有找到该节点！\n");
	}else if(p->next){
		p->prior->next=p->next;
		p->next->prior=p->prior;
	}else{
		p->prior->next=NULL;
	}
	free(p);
	
} 

//向双向节点中插入结点（末尾节点不可以插入） 
void insertNode(int i,Book book,LinkList list){
	Node *p;
	Node *node=(Node*)malloc(sizeof(Node));
	node->book=book;
	if(p=getNode(i,list)){
		p->prior->next=node;
		node->prior=p->prior;
		node->next=p;
		p->prior=node;
	}else {
		printf("插入失败！\n");
	}
} 

int main(){
	LinkList L;
	initDoLinkList(&L);
	Book book1={"java","zhangyu"};
	Book book2={"php","zhang"};
	Book book3={"c#","nan"};
	putNode(book1,L);
	putNode(book2,L);
//	putNode(book3,L);
	insertNode(2,book3,L);
	printNodeData(L);
	system("pause");
	return 0;
}
