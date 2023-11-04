#include <stdio.h>
#include  <stdlib.h>

#define SIZE 20
//实现哈希表的方法有两种方法：开放寻址法 、链地址法
// 开放寻址法：在开放寻址法中，所有的元素都存储在哈希表的数组中，冲突发生时会探测下一个可用的位置，直到找到一个空闲的位置。这种方法保持了元素的顺序，但可能导致聚集（clustering）。
//链地址法：链地址法使用一个数组来存储指向链表头部的指针，每个链表存储具有相同哈希值的元素。如果发生冲突，新的元素将被添加到该链表的末尾。这种方法可以避免聚集，但不保持元素的顺序。
//这个源文件写的是链地址法 
typedef struct Node {
	int value;
	int key;
	struct Node* next;
}Node;

typedef struct{
	Node *table[SIZE];
}HashTable; 

//初始化哈希表
void initHashTable(HashTable *ht){
	for (int i = 0; i < SIZE; i++) {
        ht->table[i] = NULL;
    }
} 

int getKey(int value){
	return value%SIZE;
}

//向哈希表中插入数据  hash公式就是 value%20 
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

//查看哈希表中是否包含此值 
int containValue(int value,HashTable *ht){
	int key=getKey(value);
	if(key<0){
		printf("查询非法数据！");
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

// 释放哈希表内存
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
