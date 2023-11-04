#include <stdio.h>
#include <stdlib.h>
#include <string.h>

//typedef struct data{
//	int number 
//}data;

typedef struct {
	int* number;
	int length;
	int capacity;
}Sqlist;
//初始化顺序表 
Sqlist *iniSize(int capacity){   
	Sqlist* L=(Sqlist*)malloc(sizeof(Sqlist));
	L->capacity=capacity;
	L->number=(int*)malloc(sizeof(int)*L->capacity);
	L->length=0;
	return L;
};
//向顺序表中添加元素 
void addData(int number[],int size,Sqlist* list){   //ok
	int i;
	for(i=0;i<size;i++){
		list->number[list->length]=number[i]; 	
		list->length++;
	}
};
//获取顺序表的元素 
int getdata(Sqlist* L,int index){   //ok
	if(index>=L->length||index<0){
		printf("Index out of bounds\n");
        exit(1);
	} 
	return L->number[index];
};

void deleteListByIndex(Sqlist *list,int index){     //ok 
	if(index>list->length||index<0){
		printf("Index out of bounds\n");
	}else {
		if(list->length-1==index){
			list->length--;
		}else{
		   int i; 
		   for(i=index;i<=list->length-1;i++){
		   		list->number[i]=list->number[i+1];
		   }
		   list->length--;
		}
	}
};
void printAllData(Sqlist *list){      //ok
	int i;
	if(list->length==0){
		printf("this sequence list is Empty !");
	}else{
		for(i=0;i<list->length;i++){
			printf("%d,",list->number[i]); 
	  	}
		printf("\n");	
	}		
} 
int main(){
	Sqlist* L=iniSize(6);
	int number1[6]={1,7,8,4,5,7};
	addData(number1,6,L);
	Sqlist* L1=iniSize(6);
	int number2[6]={2,4,6,8,10,11};
	addData(number2,6,L1);
	printAllData(L);
	printAllData(L1);
	int *l=L->number[1]; 
	int *w=L->number[7];
	printf("%d\n",(&w-&l));
	system("pause");
	return 0;
}
