//�ƿ�2�� 2018211958 ��� 
#include<iostream>
using namespace std;
unsigned fac(unsigned n){
	unsigned f;
	if(n==0)
	   f=1;
	else
	   f=fac(n-1)*n;
	   return f;   
}

int main(){
	double e=(double)fac(3)*(fac(5)/(fac(3)*fac(2)));
	cout<<e<<endl;
	return 0;
}






60

--------------------------------
Process exited after 0.06978 seconds with return value 0
�밴���������. . .








      
	
	
	
	

