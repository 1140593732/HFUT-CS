#include <iostream>
using namespace std;
class stack
{
public://������ԱӦΪ���г�Ա
	stack();
	bool empty()const;//������һ�жϺ����������̲���ı�ջ��������������ݣ���ˣ����ں���ͷ�ĺ������const��������//������ʱ��const������ʱҲӦ��const
	bool full()const;
	int get_top(int &x)const;//�����õ����:
	int push(const int x);
	int pop();
private://���ݳ�ԱӦΪ˽�г�Ա
	int count;
	int data[100];
};
stack::stack() { count = 0; }
bool stack::empty()const { if (count == 0) return true; return false; }
bool stack::full()const { if (count == 100)return true; return false; }
int stack::get_top(int &x)const
{
	if (count==0)//�μ��ж����(==)��ͬ�ڸ�ֵ���(=)
		return -1;
	else
	{
		x = data[count - 1];
		return 1;
	}
}
int stack::push(const int x)
{
	if (full())return -1;
	data[count] = x;
	count++;
	return 0;
}
int stack::pop()
{
	if (empty())return -1;
	count--;
	return 0;
}
