#ifndef STACK_H
#define STACK_H    
#include <iostream>  
using namespace std;    
const int maxlen = 100;
template <typename elementType>  
class stack 
{
public:
	stack();//��ʼ��
	bool empty();//�жϿ�
	bool full();//�ж���
	bool get_top(elementType &x);//ȡջ��Ԫ��
	bool push(elementType x);//��ջ
	bool pop();//��ջ
private:
	int count;
	elementType data[maxlen];
};
template <typename elementType>
stack<elementType>::stack()
{
	count = 0;
}
template <typename elementType>
bool stack<elementType>::empty() 
{
	if (count == 0)
		return true;
	return false;
}
template <typename elementType>
bool stack<elementType>::full() 
{
	if (count == maxlen)
		return true;
	return false;
}
template <typename elementType> 
bool stack<elementType>::get_top(elementType &x) 
{ 
	if (!empty()) 
	{ 
		x = data[count - 1];          
	    return true; 
	}     
	return false;
}
template <typename elementType> 
bool stack<elementType>::push(elementType x) 
{ 
	if (!full()) 
	{
		data[count++] = x;
		return true; 
	}      
	return false; 
}
template <typename elementType>  
bool stack<elementType>::pop() 
{ 
	if (!empty()) 
	{ 
		--count;          
		return true; 
	}      
	return false; 
}
#endif
#include <iostream>  
#include <cctype>
#include <string>
#include <cstring>
/*#include <cstack>*/
using namespace std;
    int priority(char x)
	{
		if (x == '+' || x == '-')
			return 0;
		else if (x == '*' || x == '/')
			return 1;
		else if (x == '(' || x == ')')
			return -1;
		else if (x == '#')
			return -2;
	}
	int calculate(string s)
	{
		stack<int> number;
		stack<char> operate;
		char top;
		int a, b;
		for (unsigned int i = 0; i < s.size(); ++i)
		{
			if (isdigit(s[i]))
			{
				int Temp = 0;
				string temp;
				temp += s[i];
				while (isdigit(s[++i]))
					temp += s[i];
				for (unsigned int j = 0; j < temp.size(); ++j)
				{
					Temp = Temp * 10 + temp[j] - 48;
				}
				number.push(Temp);
				temp.clear();
			}//���ַ�����ת������������
			if (!isdigit(s[i]))
			{
				if (operate.empty())
				{
					operate.push(s[i]);
				}//��ջ��һ������'#'
				else
				{
					operate.get_top(top);
					if (priority(s[i]) > priority(top) || s[i] == '(')
					{
						operate.push(s[i]);
					}//��ջ�����ȼ��������
					else
					{
						while (priority(s[i]) <= priority(top))
						{
							if (top == '#'&&s[i] == '#')
							{
								int answer;
								operate.pop();
								number.get_top(answer);
								cout << "\n���ǣ�" << answer << endl;
								number.pop();
								return 0;
							}//�������ʵ����ȫ��ֻʣ��'#'                          
							else if (top == '('&&s[i] == ')')
							{
								++i;
							}//��������������ʱ�����������ţ�ɾ��������
							else
							{
								number.get_top(a);
								number.pop();
								number.get_top(b);
								number.pop();
							}
							if (top == '+')
							{
								b += a;
								number.push(b);
							}
							else if (top == '-')
							{
								b -= a;
								number.push(b);
							}
							else if (top == '*')
							{
								b *= a;
								number.push(b);
							}
							else if (top == '/')
							{
								b /= a;
								number.push(b);
							}
							operate.pop();
							operate.get_top(top);
						}
						operate.push(s[i]);
					}
				}
			}
		}
	}
	int main()
	{
		string expression;
		cout << "����һ����'#'��ͷ�ͽ�β�ı��ʽ��" << endl;
		getline(cin, expression);
		calculate(expression);
		cin.get();
		cin.get();
	}
	