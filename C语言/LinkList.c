#include <stdio.h>
#include <stdlib.h>
#include <string.h>	

typedef struct Book {
	char bookname[20];
	char author[10];
}Book;

typedef struct Node {
	Book book;
	struct Node *next;
}Node,*LinkList;

//初始化链表 
void initChainedTable(Node **L){    //ok
	*L=(LinkList)malloc(sizeof(Node));
	(*L)->next=NULL;
}
//尾结点插入 
Node* putNodeByTail(Book book,Node *r){   //ok
	Node *node=(Node*)malloc(sizeof(Node));
	node->book= book;
	node->next=NULL;
	r->next=node;
	return node;
}
//首节点插入
void putNodeByHead(Book book,LinkList L){   //ok
	Node *node=(Node*)malloc(sizeof(Node));
	node->book=book;
	node->next=L->next;
	L->next=node;
} 
//删除其中一个结点
void deleteNode(int i,LinkList L){   //ok
	Node *node=L->next;
	int counter=1;
	if (i == 1) {
        if (node != NULL) {
            L->next = node->next;
            free(node);
        } else {
            printf("List is empty, cannot delete.\n");
        }
        return;
    }

	while(node&&counter<(i-1)){
		node=node->next;
		++counter;
	}
	if(!node||i<=0){
		printf("index is out of bound \n");
	}else{
		Node* delnode = node->next;
        if (delnode) {
            node->next = delnode->next;
            free(delnode);
        } else {
            printf("Node at index %d does not exist\n", i);
        }
	}
	
}
//向链表中插入元素
void insertNode(Book book,int i,LinkList L){   //ok
	Node *newnode=(Node*)malloc(sizeof(Node));
	Node *node=L->next;
	newnode->book=book;
	int count=1;
	while(node&&count<(i-1)){
		node=node->next;
		++count;
	}
	if(!node||i<=0){
		printf("index is out of bound\n");
	}else{
		newnode->next=node->next;
		node->next=newnode;	
	}
	
} 
//判断链表是否为空
int isEmpty(LinkList L){  //ok
	return L->next==NULL?1:0;
} 

//获取第i个结点 
Node*  getNode(int i,LinkList L){  //ok
	Node* node=L->next;
	int count=1;
	while(node&&count<i){
		node=node->next;
		++count;
	}
	if(node&&i>0) return node;
	printf("index is out of bound\n"); 
} 
//通过值获取到它的位置
int getIndex(Book book,LinkList L){  //ok
	Node* node=L->next;
	int count=1;
	while(node&&strcmp(node->book.author,book.author)&&strcmp(node->book.bookname,book.bookname)){
		node=node->next;
		++count;
	}
	if(node) return -1;
	return count;
} 
//打印链表中的数据 
void printNodeData(LinkList L){    //ok
	Node *node=L->next;
	while(node){
		printf("bookname:%s;author:%s\n",node->book.bookname,node->book.author);
		node=node->next;
	}
	if(!node) printf("你所给的是个空链表！\n"); 
}
//释放一个链表
void freeChainedTable(LinkList L){ 
	Node *p=L->next;
	Node *q;
	while(p){  
		q=p->next;
		free(p);
		p=q; 
	}
	printf("清除完成！\n");
	L->next=NULL;
}


int main(){
	LinkList L;
	initChainedTable(&L);
	Book book1={"java","zhangyu"};
	Book book2={"php","zhang"};
	Book book3={"c#","nanchengyu"};
	putNodeByHead(book1,L);
	putNodeByHead(book2,L);
	putNodeByHead(book3,L);
	Book book4={"java","zhang"};
	freeChainedTable(L);
	printNodeData(L);
	system("pause");
	return 0;
}
