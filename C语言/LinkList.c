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

//��ʼ������ 
void initChainedTable(Node **L){    //ok
	*L=(LinkList)malloc(sizeof(Node));
	(*L)->next=NULL;
}
//β������ 
Node* putNodeByTail(Book book,Node *r){   //ok
	Node *node=(Node*)malloc(sizeof(Node));
	node->book= book;
	node->next=NULL;
	r->next=node;
	return node;
}
//�׽ڵ����
void putNodeByHead(Book book,LinkList L){   //ok
	Node *node=(Node*)malloc(sizeof(Node));
	node->book=book;
	node->next=L->next;
	L->next=node;
} 
//ɾ������һ�����
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
//�������в���Ԫ��
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
//�ж������Ƿ�Ϊ��
int isEmpty(LinkList L){  //ok
	return L->next==NULL?1:0;
} 

//��ȡ��i����� 
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
//ͨ��ֵ��ȡ������λ��
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
//��ӡ�����е����� 
void printNodeData(LinkList L){    //ok
	Node *node=L->next;
	while(node){
		printf("bookname:%s;author:%s\n",node->book.bookname,node->book.author);
		node=node->next;
	}
	if(!node) printf("���������Ǹ�������\n"); 
}
//�ͷ�һ������
void freeChainedTable(LinkList L){ 
	Node *p=L->next;
	Node *q;
	while(p){  
		q=p->next;
		free(p);
		p=q; 
	}
	printf("�����ɣ�\n");
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
