#include <stdio.h>
#include  <stdlib.h>

#define SIZE 100

typedef struct Node {
	int value;
	int key;
	struct Node* next;
}Node;

typedef struct {
	Node* node[SIZE];
	int magnification;
}HashTable;

void initHashTable(HashTable *ht){
	int i;
	for(i=0;i<SIZE;i++){
		ht->node[i]=NULL;
	}
	ht->magnification=1;
}

//��ȡ������-2:��Ԫ���Ѿ��޷����룬-1:�Ƿ�ֵ 
int getKey(int value,HashTable *ht){
	int key=value%SIZE;
	if(key>=0&&ht->node[key]!=NULL){
		int i;
		for(i=key+1;i<SIZE;i++){
			if(ht->node[i]==NULL) return i;
		}
		return -2;
	}else if(ht->node[key]==NULL){
		return key;
	}
	return -1;
}

void pushToHt(int value,HashTable *ht){
	int key=getKey(value,ht);
	if(key==-1){
		printf("�Ƿ�ֵ�Ĳ��ң�\n");
	}else if(key==-2){
		printf("%d����ʧ�ܣ�\n",value);
	}else{
		Node *node=(Node*)malloc(sizeof(Node));
		node->key=key;
		node->value=value;
		node->next=NULL;
		ht->node[key]=node;
	} 
}

int containValue(int value,HashTable *ht){
	int key=value%SIZE;
	if(key==-1){
		printf("��ѯ�Ƿ����ݣ�\n");
		return -1;
	}else{
		return ht->node[key]!=NULL&&ht->node[key]->value==value?1:0;
	}
}

int main(){
	HashTable ht;
	initHashTable(&ht);
	pushToHt(1,&ht);
	pushToHt(2,&ht);
	pushToHt(23,&ht);
	pushToHt(11,&ht);
	pushToHt(12,&ht);
	pushToHt(14,&ht);
	pushToHt(5,&ht);
	pushToHt(15,&ht);
	pushToHt(31,&ht);
	printf("%d\n",containValue(14,&ht));
	system("pause");
	return 0;
}

