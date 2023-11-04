#include <stdio.h>
#include  <stdlib.h>

#define SIZE 20
//ʵ�ֹ�ϣ��ķ��������ַ���������Ѱַ�� ������ַ��
// ����Ѱַ�����ڿ���Ѱַ���У����е�Ԫ�ض��洢�ڹ�ϣ��������У���ͻ����ʱ��̽����һ�����õ�λ�ã�ֱ���ҵ�һ�����е�λ�á����ַ���������Ԫ�ص�˳�򣬵����ܵ��¾ۼ���clustering����
//����ַ��������ַ��ʹ��һ���������洢ָ������ͷ����ָ�룬ÿ������洢������ͬ��ϣֵ��Ԫ�ء����������ͻ���µ�Ԫ�ؽ�����ӵ��������ĩβ�����ַ������Ա���ۼ�����������Ԫ�ص�˳��
//���Դ�ļ�д��������ַ�� 
typedef struct Node {
	int value;
	int key;
	struct Node* next;
}Node;

typedef struct{
	Node *table[SIZE];
}HashTable; 

//��ʼ����ϣ��
void initHashTable(HashTable *ht){
	for (int i = 0; i < SIZE; i++) {
        ht->table[i] = NULL;
    }
} 

int getKey(int value){
	return value%SIZE;
}

//���ϣ���в�������  hash��ʽ���� value%20 
void addvalue(int value,HashTable *ht){
	Node *node=(Node*)malloc(sizeof(Node));
	node->value=value;
	int key=getKey(value);
	node->key=key;
	node->next=NULL;
	Node *tmp=ht->table[key];
	if(tmp!=NULL){
		while(tmp->next){
			tmp=tmp->next;	
		}
		tmp->next=node;
	}else{
		ht->table[key]=node; 
	} 
}

//�鿴��ϣ�����Ƿ������ֵ 
int containValue(int value,HashTable *ht){
	int key=getKey(value);
	if(key<0){
		printf("��ѯ�Ƿ����ݣ�");
		return -1;
	}
	Node* tmp=ht->table[key];
	if(tmp==NULL) return 0;
	while(tmp){
		if(tmp->value==value) return 1;
		tmp=tmp->next;
	}
	return 0;
}

// �ͷŹ�ϣ���ڴ�
void freeHashTable(HashTable *ht) {
    for (int i = 0; i < SIZE; i++) {
        Node *current = ht->table[i];
        while (current != NULL) {
            Node *temp = current;
            current = current->next;
            free(temp);
        }
    }
}



int main(){
	HashTable table;
	initHashTable(&table);
	addvalue(1,&table);
	addvalue(3,&table);
	addvalue(6,&table);
	addvalue(7,&table);
	addvalue(11,&table);
	addvalue(23,&table);
	addvalue(21,&table);
	addvalue(27,&table);
	addvalue(87,&table);
	
	printf("%d\n",containValue(-1,&table));
	freeHashTable(&table);
	system("pause");
	return 0;
}
