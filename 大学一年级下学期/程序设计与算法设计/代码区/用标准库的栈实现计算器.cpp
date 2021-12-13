//������
//� 2018211966 
#include <iostream> 
#include <stack> 
using namespace std;  
const int maxlen = 100;//ջ�����洢��  
/*template <typename elementType>  
class stack {  
public:  
    stack();
    bool empty();
    bool full();
    bool get_top(elementType &x);
    bool push(elementType x);
    bool pop();  
private:  
    int count; 
    elementType data[maxlen]; 
};  
  
template <typename elementType>  
stack<elementType>::stack() {  
    count = 0;  
}  
  
template <typename elementType>  
bool stack<elementType>::empty() {  
    if (count == 0)  
        return true;  
    return false;  
}  
  
template <typename elementType>  
bool stack<elementType>::full() {  
    if (count == maxlen)  
        return true;  
    return false;  
}  
  
template <typename elementType>  
bool stack<elementType>::get_top(elementType &x) {  
    if (!empty()) {  
        x = data[count - 1];  
        return true;  
    }  
    return false;  
}  
  
template <typename elementType>  
bool stack<elementType>::push(elementType x) {  
    if (!full()) {  
        data[count++] = x;  
        return true;  
    }  
    return false;  
}  
  
template <typename elementType>  
bool stack<elementType>::pop() {  
    if (!empty()) {  
        --count;  
        return true;  
    }  
    return false;  
} */ 

//ɨ�����ֵĺ���  
bool isnumber(char x) {  
    if (x >= '0' && x <= '9')  
        return true;  
    return false;  
}  
  
//�ж���������ȼ��ĺ�����ͨ�����ִ�С�����бȽ� 
int priority(char x) {  
    if (x == '+' || x == '-')  
        return 0;  
    else if (x == '*' || x == '/')  
        return 1;  
    else if (x == '(' || x == ')')  
        return -1;  
    else if (x == '#')  
        return -2;  
}  
  
//����ĺ���  
int calculate(string s) {  
    stack<int> number;  //����ջ 
    stack<char> operate;  //�����ջ 
    char top;  
    int a, b;  
    for (unsigned int i = 0; i < s.size(); ++i) {  
        if (isnumber(s[i])) {  
            int Temp = 0;  
            string temp;  
           temp += s[i];  
            while (isnumber(s[++i]))  
                temp += s[i]; 
            for (unsigned int j = 0; j < temp.size(); ++j) {  
                Temp = Temp * 10 + temp[j] - 48;  //char���ͺ�int����ʵ��ת�� 
            }  
            number.push(Temp);    
        }//���ַ�����ת������������  
        if (!isnumber(s[i])) {  
            if (operate.empty()) {  
                operate.push(s[i]);  
            }//��ջ��һ������'#'  
            else {  
               top=operate.top();  
  
                if (priority(s[i])>priority(top) || s[i] == '(') {  
                    operate.push(s[i]);  
                }//��ջ�����ȼ��������  
                else {  
                    while (priority(s[i]) <= priority(top)) {  
                        if (top == '#'&&s[i] == '#') {  
                            int answer;  
                            operate.pop();  
                            answer=number.top();   
                            cout << "\n���ǣ�" << answer << endl;  
                            number.pop();  
                            return 0;  
                        }//�������ʵ����ȫ��ֻʣ��'#'  
                        else if (top == '('&&s[i] == ')') {  
                            ++i;  
                        }//��������������ʱ�����������ţ�ɾ��������  
                        else {  
                            a=number.top();   
                            number.pop();  
                            b=number.top();   
                            number.pop();  
                        }  
                        if (top == '+') {  
                            b += a;  
                            number.push(b);  
                        }  
                        else if (top == '-') {  
                            b -= a;  
                            number.push(b);  
                        }  
                        else if (top == '*') {  
                            b *= a;  
                            number.push(b);  
                        }  
                        else if (top == '/') {  
                            b /= a;  
                            number.push(b);  
                        }  
                        operate.pop();  
                        top=operate.top();//ȡǰһ�������������������ɨ�����������бȽ�    
                    }//�����ȼ��ߵ������ʵ�ּ���  
                    operate.push(s[i]);//���ڵ�top=='#'ʱ�������һ���������ջ  
                }  
            }  
        }//ɨ������������ж����ȼ����Լ�����  
    }//��ѭ��  
}//���������ɨ�裬�������ַ���ת�����Լ�����  
  
int main() {  
    string expression;  
    cout << "����һ����'#'��ͷ�ͽ�β�ı��ʽ��" << endl;  
    cin >> expression;  
    calculate(expression);  
    cin.get(), cin.get();  
}
 
