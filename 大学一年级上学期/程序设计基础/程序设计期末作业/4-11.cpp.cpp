//�ƿ�2�� 2018211958 ���
#include <iostream>
using namespace std;
class Area{
	public:
		void CK(int c=0,int k=0);
		void MJ();
	private:
		int length,width;	
};

void Area::CK(int c,int k){
	length=c;
	width=k;
}

inline void Area::MJ(){
	cout<<length*width;
}

int main(){
	Area theArea;
	cout<<"���볤�Ϳ�"<<endl;
	theArea.CK(1,2);
	theArea.MJ();
	return 0;
}

���볤�Ϳ�
2
--------------------------------
Process exited after 0.1597 seconds with return value 0
�밴���������. . .

