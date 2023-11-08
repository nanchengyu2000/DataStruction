#include <stdio.h>
#include <stdlib.h>

#define MaxSize 20
typedef struct student{
	char *name;
	int aveScores;
	int achScores;
	char isCadre;
	char isWest;
	int qOfPaper;
}student;

char* getName(){
	int i;
	char* name;
	for(i=0;i<MaxSize;i++){
		
	}
}
void getGrade(){
	
}
void getPrecise90(){
	
}
void getStuInfo(student *stu){
	stu->name=getName();
	stu->achScores=getGrade();
	
}



int main(){
	
	int a,b,d,e;
	scanf("%d%d%d%d",&a,&b,&d,&e);
	
    printf("%d\n",a+b); 
	system("pause");
	return 0;
} 
