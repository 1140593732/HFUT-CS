//�ƿ�2�� 2018211958 ���
#include <iostream>
#include <fstream>
#include <string>
using namespace std;
int main(){
    ofstream file("test1.txt",ios::app);
    file<<"�ѳɹ�����ַ���";
    file.close();
    char ch;
    ifstream file1("test1.txt");
    while(file1.get(ch))
    cout<<ch;
    file1.close();
}

�ѳɹ�д���ļ����ѳɹ�����ַ��� 
--------------------------------
Process exited after 0.2275 seconds with return value 0
�밴���������. . .
