//�ƿƶ���  ���  2018211958
#include <iostream>
#include <string>
using namespace std;
class Employee{
	public:
		Employee(string name,string adress,string city,string postcode){
			n=name;
			a=adress;
			c=city;
			code=postcode;
		}
		void setName(string name){
			n=name;
		}
		void display();
	private:
		string n,a,c,code;
}; 

void Employee::display(){
	cout<<"����Ϊ "<<n<<endl;
	cout<<"��ַΪ "<<a<<endl;
	cout<<"����Ϊ "<<c<<endl;
	cout<<"�ʱ�Ϊ "<<code<<endl;
}

int main(){
	string n,a,c,code;
	cout<<"�������֡���ַ�����С��ʱ� "<<endl;
	cin>>n;cin>>a;cin>>c;cin>>code;
	Employee user(n,a,c,code);
	user.display();
	cout<<"������������"<<endl;
	cin>>n; 
	user.setName(n);
	user.display();
} 
