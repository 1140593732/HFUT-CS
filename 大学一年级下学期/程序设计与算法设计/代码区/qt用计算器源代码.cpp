#include <iostream>
#include <string>
#include "calculate.h" 

int main(){
	cout<<"������ʽ�ӣ�����\"#\"��ʼ�ͽ���,"<<endl;
	string str1;
	cin>>str1;
	while(!normalize(str1))	cin>>str1;	
	cout<<calculate(str1)<<endl;
	cout<<"Ҫ������������Y"<<endl;
	string b;
	cin>>b;
	if(b=="Y"||b=="y") goto L1; 
	system("pause");
return 0; 
}
