//�ƿ�2�� 2018211958 ���
#include<iostream>
using namespace std;
class BaseClass{
	public:
		virtual ~BaseClass(){cout<<"BaseClassָ���Ѿ�ɾ��"<<endl;}; 
};

class DerivedClass:public BaseClass{
	public:
		~DerivedClass(){cout<<"DerivedClassָ���ѱ�ɾ��"<<endl;}
};

int main(){
	BaseClass *b=new DerivedClass();
	delete b;
}

DerivedClassָ���ѱ�ɾ��
BaseClassָ���Ѿ�ɾ��

--------------------------------
Process exited after 0.5249 seconds with return value 0
�밴���������. . .
 
