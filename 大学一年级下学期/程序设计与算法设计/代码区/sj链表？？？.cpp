#include <iostream>
using namespace std;
struct node {
	int data;
	node *next;//*next������ڵ�ָ����һ���ڵ��ָ�룬���������һ���ڵ�ĵ�ַ�����������һ�̶ֹ��ṹ 
};
class list {
public:
	list();
	~list();
	int length()const;//const���ڳ�Ա��������Ҫ��������const����const����˵������һ������������ֵ�ǲ��ܱ��޸ĵġ�û��ʲô�ط��Ǳ���Ҫ�õģ���ֻҪ������������㲻��ı�Ϳ����á�һ���ں������ݲ������õıȽ϶࣬��ô����Ϊ�˷�ֹ���ں����жԲ�Ӧ��������ı������С�Ľ����˸ı䡣�����ĺ����г���Ա����������Ա�����������Ϊ��һ����ֻ�������������Ȳ��ܸ������ݳ�Ա��ֵ��Ҳ���ܵ�����Щ���������ݳ�Աֵ�仯�ĳ�Ա������ֻ�ܵ���const��Ա������
	vo  id create(int n);
	int get(const int i, int &x)const;//�˴�const�ں����ڲ���ǰҲ���ڣ������ñ�����Ҫ��ĳ��int��ƽ����дһ��square����int square�� const int& a ��{ return a*a; }���д����û���޸�a��ֵ�������ȷ����д��int square�� const int& a ��{ a=a*a; return a;}�����ᱨ��������Ϊ���޸���a��ֵ������const��������ġ�						  
	int insert(const int i, const int x)
	int delete_data(const int i);
	void print();
	node *findk(node *head, int k);
	node *& get_ptr(int pos);
	int count;
	node *head;
};
list::list() {
	head = new node;
	head->next = NULL;
	count = 0;
}
void list::create(int n) {//�����p��p->next���𣬷���ָ����������������������Ĺؼ�������p��ָ�룬ָ��p��ָ�Ľ�㣬p->next��p��ָ�Ľ�����һ�����
	int x; int y = 1;
	cin >> x;
	node *rear = head;
	while (y != n) {
		count++;
		node *s = new node;
		s->data = x;
		rear->next = s;
		rear = s;
		rear->next = NULL;
		cin >> x;
		y++;
	}
}
int list::length()const {
	node *p = head->next;
	int n = 0;
	while (p != NULL) {
		n++;
		p = p->next;
	}
	return n;
}
int list::get(const int i, int &x)const {//�˴����õ����ã�������������
	node*p;
	p = head->next;
	int j = 1;
	while (p != NULL && j != i) {
		p = p->next;
		j++;
	}
	if (p == NULL) {
		cout << "error" << endl;
		return 0;
	}
	x = p->data;
	return 1;
}
int list::insert(const int i, const int x) {
	node *p;
	p = head;
	int j = 0;
	while (p != NULL && j != i) {
		p = p->next; j++;
	}
	if (i<1 || i>count + 1) {
		cout << "error" << endl;
		return 0;
	}
	node *s = new node;
	s->data = x;
	s->next = p->next;
	p->next = s;
	count++;
	return 1;
}
int list::delete_data(const int i) {
	node *p; node *u;
	p = head;
	int j = 0;
	while (p != NULL && j != i) {
		p = p->next; j++;
	}
	if (i<1 || i>count + 1) {
		cout << "error" << endl;
		return 0;
	}
	u = p->next;
	p->next = u->next;
	delete u;
	count--;
	return 1;
}
void list::print() {
	node *p = head->next;
	while (p != NULL) {
		cout << p->data << " ";
		p = p->next;
	}
}
list::~list() {
	for (int i = 1; i <= count; i++) {
		delete_data(i);
	}
}
node*& list::get_ptr(int pos) {
	if (pos == 0) return head;
	node * p = head;
	for (int i = 1; i < pos; i++)
		p = p->next;
	return p->next;
}
node * list::findk(node *head, int k) {
	node *p1 = head;
	node *p2 = NULL;
	for (int i = 0; i < k - 1; i++) {
		if (p1->next != NULL) p1 = p1->next;
		else return NULL;
	}
	p2 = head;
	while (p1->next != NULL) {
		p1 = p1->next;
		p2 = p2->next;
	}
	return p2->next;
}

int main() {
	list l;
	l.create(10);
	node *t = l.findk(l.head, 3);
	cout << t->data;
	l.~list();
}