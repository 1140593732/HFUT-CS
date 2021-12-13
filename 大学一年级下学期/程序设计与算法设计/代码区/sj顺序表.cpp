#include<iostream>
using namespace std;
class list {
public:
	list();                                       //��ʼ����Ӧ�Ĺ��캯��
	int length()const;                            //�󳤶�
	void create(int i);                           //����˳���
	int get_element(const int i, int &x)const;    //�����ȡԪ��(��Ŵ�1���Ǵ�0��ʼ��
	int locate(const int x)const;                 //����Ԫ��
	int insert(const int i, const int x);         //����Ԫ��
	int delete_element(const int i);              //ɾ��Ԫ��
	~list();
private:
	int data[100];
	int count;
};
list::list() { count = 0; }
int list::length()const 
{
	return count;
    cout << count;
}
void list::create(int i)
{ 
	int x, int y = 1;
	cin >> x;
	while (y != n) {
		count++;
		cin >> x;
		Z
		y++;
	}
}
int list::get_element(const int i, int &x)const     //�ñ���x�����������Ԫ��
{
	if (i <= 0 || i > count)
		return -1;
	x = data[i - 1];
	return 1;
}
int list::locate(const int x)const
{
	for (int i = 0; i < length(); i++)                  //Ӧ����������for���
		if (data[i] == x)return (i + 1);            //����Ԫ�ص��±�������1
	return -1;                                      //ִ�е�����䣬����ǰ��û���ҵ�
}
int list::insert(const int i, const int x)
{
	if (count = 100)                             //�������ֵ�����������
		return -1;
	if (i<1 || i>length() + 1)
		return -1;                         //����λ��Ҫ�Ϸ�
	for (int j = count - 1; j >= i - 1; j--)
		data[j + 1] = data[j];                      //�����ƶ�Ԫ��
	data[i - 1] = x;                            //�������Ԫ��
	count++;                                        //�޸ı�
	return 0;
}
int list::delete_element(const int i)
{
	if (length() == 0)
		return -1;                           //�ձ���ɾ��Ԫ��
	if (i<1 || i>length())
		return -1;                         //ɾ��Ԫ�ز�����
	for (int j = i + 1; j <= length(); j++)
		data[j - 2] = data[j - 1];                  //��ǰ�����ƶ�Ԫ��
	count--;                                        //���ȼ�1
	return 0;
}
list::~list() 
{
	for (int i = 1; i <= count; i++)
		delete_element(i);
}
int main()
{
	list l;
	//list();�˴����Ƿ���ࣿ�ٶ�˵���캯�����ܱ�ֱ�ӵ��ã�����ͨ��new������ڴ�������ʱ�Ż��Զ����ã���һ��ķ������ڳ���ִ�е�����ʱ�򱻵��õģ�
	l.create(3);
	l.length();
	//l.get_element(10);//???
	l.locate(1);
	l.insert(1, 37);
	l.delete_element(2);
	l.~list();
	cin.get();
	cin.get();

}