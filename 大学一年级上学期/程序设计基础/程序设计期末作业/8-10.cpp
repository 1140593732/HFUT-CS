//�ƿ�2�� 2018211958 ���
#include<iostream>
using namespace std;
class Point{
	public:
		Point(int a,int b){x=a,y=b;}
		friend Point operator+(Point &e,Point &f);
		display(){cout<<"("<<x<<","<<y<<")";};
	private:
	    int x,y;	
}; 

Point operator+(Point &e,Point &f){
     Point d(0,0);
     d.x=e.x+f.x;
     d.y=e.y+f.y;
     return d;
};

int main(){
	Point a(2,3),b(3,4);
	Point c=a+b;
	c.display();
}

(5,7)
--------------------------------
Process exited after 0.2189 seconds with return value 0
�밴���������. . .
