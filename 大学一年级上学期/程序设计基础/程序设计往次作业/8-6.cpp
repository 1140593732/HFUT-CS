//�ƿƶ���  ���   2018211958
#include <iostream>
using namespace std;
const float pi=3.1415;
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
		void getPerim(); 
};
void rectangle::print(){
	cout<<"��һ�߳�Ϊ "<<a2<<endl;
}

void rectangle::getArea(){
	cout<<"�������Ϊ "<<a1*a2<<endl;
}

void rectangle::getPerim(){
	cout<<"�����ܳ�Ϊ "<<2*(a1+a2)<<endl;
}


class circle:public shape{
	public:
		circle(float r1):shape(r1){}
		void getArea(){
			cout<<"Բ�����Ϊ "<<a1*a1*pi<<endl;
		}
		void print();
		void getPerim(); 
};


void circle::print(){
	cout<<"�뾶Ϊ��ʼ�뾶 "<<a1<<endl;
}

void circle::getPerim(){
	cout<<"Բ���ܳ�Ϊ "<<2*pi*a1<<endl;
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
    s1.getPerim();
    circle s2(n);
    s2.circle::print();
    s2.getArea();
    s2.getPerim();
    return 0;
}
   

/*
������nΪ��ʼ�߳�/�뾶
6.543
�����볤���ε���һ���߳�
5.345
��ʼ�߳�/�뾶Ϊ 6.543
��һ�߳�Ϊ 5.345
�������Ϊ 34.9723
�����ܳ�Ϊ 23.776
�뾶Ϊ��ʼ�뾶 6.543
Բ�����Ϊ 134.49
Բ���ܳ�Ϊ 41.1097

--------------------------------
Process exited after 49.88 seconds with return value 0
�밴���������. . .

