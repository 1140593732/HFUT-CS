#include <iostream>
#include <string>
#include "compress.h"
#include "decompress.h"
using namespace std;
int main(){
	int count[26]={0};              
	string code[26];                 
	static int n=0;                  
	int c;
	count1(count);
	for(int i=0;i<26;i++)
	{
		if(count[i]!=0) n++; 
	}
	element hufftree[2*n-1]; 
	createHuffman(hufftree,n,count);    
	cout<<endl<<"������..."<<endl;
	encode(hufftree,code,count,n);       
	for(int i=0;i<26;i++)
	{             
		if(count[i]!=0)
		cout<<"��ĸ "<<char(i+65)<<" �ı���Ϊ��"<<code[i]<<endl;			
	}	
	int len=trans(code,c);
	cout<<"ѹ����ɣ�"<<endl;
    cout<<"��ѹ��..."<<endl; 
	decompress(read(len,c),code); 
	cout<<"��ѹ����ɣ�"<<endl;                                   
	system("pause");
return 0; 
}
