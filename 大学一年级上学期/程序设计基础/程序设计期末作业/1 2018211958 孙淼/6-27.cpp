//�ƿ�2�� 2018211958 ��� 
#include <iostream>
#include <string>
using namespace std;
class Employee{
	public:
		Employee(string mz,string dz,string cs,string yb);
	    setName(string x);
	    display();
	private:
		string name,location,city,postcode;
};

Employee::Employee(string mz,string dz,string cs,string yb){
	name=mz;
	location=dz;
	city=cs;
	postcode=yb;
}

Employee::setName(string n){
	name=n;
}
 
Employee::display(){
	cout<<name<<","<<location<<","<<city<<","<<postcode;
}


int main(){
	Employee zzt("֣����","�Ϸʹ�ҵ��ѧ����У��","�ɹ�","5438");
	zzt.display();
	cout<<endl;
	zzt.setName("��ͷ");
	zzt.display();
}

֣����,�Ϸʹ�ҵ��ѧ����У��,�ɹ�,5438
��ͷ,�Ϸʹ�ҵ��ѧ����У��,�ɹ�,5438
--------------------------------
Process exited after 0.2056 seconds with return value 0
�밴���������. . .
