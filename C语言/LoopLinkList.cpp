#include <stdio.h>
#include <stdlib.h>

//���Դ������Ƶ���ѭ������������Ƶ�βָ�룬����ѭ���������ϣ��������������������������Ͳ�ȥд��
// ������βָ���Ŀ�����ڶԱ����β���ֽ��в�����ʱ����Խ���ʱ�临�Ӷ�
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
//��ʼ��ѭ���б� 
void initLoopLinkList(LoopList *L){  //ok
	Node *headNode=(Node*)malloc(sizeof(Node));
	*L=(LoopList)malloc(sizeof(LoopList));
	(*L)->headNode=headNode;
	(*L)->tailNode=headNode;
}
//��ѭ����������ӽ�� 
void putNode(Book book,LoopList L){   //ok
	Node *node=(Node*)malloc(sizeof(Node));
	node->book=book;
	L->tailNode->next=node;
	L->tailNode=node;
	node->next=L->headNode;
}

//���ڶ���ѭ��������ӵ���һ��ѭ�������
LoopList  connectTable(LoopList L1,LoopList L2){   //0k
	L1->tailNode->next=L2->headNode->next;
	free(L2->headNode);
	L2->tailNode->next=L1->headNode;
	L1->tailNode=L2->tailNode;
	return L1;
}

//��ӡ�����е����� 
void printNodeData(LoopList L){      //ok
	Node *node=L->headNode->next;
	while(node!=L->headNode){
		printf("bookname:%s;author:%s\n",node->book.bookname,node->book.author);
		node=node->next;
	}
	if(!node) printf("���������Ǹ�������\n"); 
}
//��ȡѭ���б�ĳ��� 
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
	printf("��1��\n");
	printNodeData(L);
	LoopList L2;
	initLoopLinkList(&L2);
	Book book4={"jaa","hangyu"};
	Book book5={"ph","zhng"};
	Book book6={"c","an"};
	putNode(book4,L2);
	putNode(book5,L2);
	putNode(book6,L2);
	printf("��2��\n");
	printNodeData(L2);
	LoopList list=connectTable(L,L2);
	printf("���Ӻ�ı�\n");
	printNodeData(list);
	system("pause");
	return 0;
}


