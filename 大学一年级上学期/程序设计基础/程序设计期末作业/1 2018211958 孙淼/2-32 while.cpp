//�ƿ�2�� 2018211958 ���
#include<iostream>
#include<stdlib.h>
#include<time.h>
using namespace std;
int main(){
	int n;
	srand(time(0));
	int num=rand()%100+1;
	cout<<"������һ������";
	cin>>n;
	while(1){
		if (n!=num)
       {
		 if (n<num)   
		  {
		  cout<<"n<num"<<endl;}
		 else 
		  {
		  cout<<"n>num"<<endl;}
		} 
		else  {
          cout<<"n=mum"<<endl;break;}
        cin>>n;
    }
    return 0;
}





������һ������50
n<num
70
n>num
60
n<num
75
n>num
65
n<num
67
n<num
69
n>num
68
n=mum

--------------------------------
Process exited after 29.51 seconds with return value 0
�밴���������. . .


	
    
	  

	
	

