#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int* getNext(char proStr[],int protable[],int length){
	if(length>0){
		protable[0]=0;
		protable[1]=1;
		int i;
		for(i=2;i<length;i++){
			int promun=1;
			int j;
			char *prefix=malloc(sizeof(char)*(i-1));
			char *suffix=malloc(sizeof(char)*(i-1));
			for(j=0;j<i-1;j++){
				prefix[j]=proStr[j];
				suffix[i-j-1]=proStr[i-j-1];
				int comp=strcmp(prefix,suffix);
				if(comp==0){
					promun=j+2>promun?j+1:promun;
				}
			}
			printf("%d ",promun);
			protable[i]=promun;
		}
	}
	return protable;
}

int main(){
	char provalue[5]={'A','B','A','B','A'};
	int next[5];
	getNext(provalue,next,5);
//	int i;
//	for(i=0;i<5;i++){
//		printf("%d ",next[i]);
//	}
	system("pause");
	return 0;
} 
