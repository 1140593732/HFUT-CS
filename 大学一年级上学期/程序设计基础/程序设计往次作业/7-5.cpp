//�ƿƶ���  ���  2018211958
#include <iostream>
using namespace std;
const float pi=3.14;
class shape{
	public:
	float a1;
	shape(float a);
	void print();
};

shape::shape(float a){
	a1=a;
}

void shape::print(){
	cout<<"��ʼ�߳�/�뾶Ϊ "<<a1<<endl;
}


class rectangle:public shape{
	public:
		float a2;
		rectangle(float a,float b):shape(a){
			a2=b;
		}	
		void getArea();
		void print();
};
void rectangle::print(){
	cout<<"��һ�߳�Ϊ "<<a2<<endl;
}

void rectangle::getArea(){
	cout<<"�������Ϊ "<<a1*a2<<endl;
}


class square:public rectangle{
	public:	
	square(float m):rectangle(m,m){}
	void getArea(){
		cout<<"���������Ϊ "<<a1*a2<<endl;
	}
	void print();
};


void square::print(){
	cout<<"�߳�Ϊ��ʼ�߳� "<<a1<<endl;
}


class circle:public shape{
	public:
		circle(float r1):shape(r1){}
		void getArea(){
			cout<<"Բ�����Ϊ "<<a1*a1*pi<<endl;
		}
		void print();
};


void circle::print(){
	cout<<"�뾶Ϊ��ʼ�뾶 "<<a1<<endl;
}


int main(){
	float m,n;
	cout<<"������nΪ��ʼ�߳�/�뾶"<<endl;
	cin>>n;
	cout<<"�����볤���ε���һ���߳�"<<endl;
	cin>>m;
    rectangle s1(n,m);
    s1.shape::print();
    s1.print();
    s1.getArea();
    square s2(n);
    s2.square::print();
    s2.getArea();
    circle s3(n);
    s3.circle::print();
    s3.getArea();
    return 0;
}








/*
������nΪ��ʼ�߳�/�뾶
3.123
�����볤���ε���һ���߳�
6.72
��ʼ�߳�/�뾶Ϊ 3.123
��һ�߳�Ϊ 6.72
�������Ϊ 20.9866
�߳�Ϊ��ʼ�߳� 3.123
���������Ϊ 9.75313
�뾶Ϊ��ʼ�뾶 3.123
Բ�����Ϊ 30.6248

--------------------------------
Process exited after 8.849 seconds with return value 0
�밴���������. . .
*/
