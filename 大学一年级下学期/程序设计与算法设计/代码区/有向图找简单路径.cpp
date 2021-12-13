#include <iostream>
using namespace std;
const int max_vex_node = 20;
const int max_edge = 40;
const int max_weight = 50;
typedef struct edge_node
{//�߱���Ķ���  
	int adjvex;//����ڽӵ��ڶ�����е�λ��  
	struct edge_node *nextarc;//ָ����һ���߱���  
	int weight;
}edge_node;

typedef struct vex_node
{//�������Ķ���   
	char vex;//��Ŷ�����Ϣ  
	edge_node * firstarc;//ָ���һ���߱���  
}vex_node;
class graph {
public:
	graph() {};
	int creat();
	int path_all1(int u, int v, int path[max_edge], int i);//i��ʼΪ0
	int path_all2(int u, int v, int k, int path[max_edge], int d);//d��ʼΪ-1
	int visited[max_edge];
	int path[max_edge];
	int chushi();
private:
	int n, e;
	vex_node adjlist[max_vex_node];
};

int graph::creat() {
	int i,j, k;
	cout << "�����붥�����ͱ���" <<endl;

	cin >> n >> e;
	for (int i = 0; i < n; i++) {
		adjlist[i].vex = i;
		adjlist[i].firstarc = NULL;
	}
	cout << "�����֮��Ĺ�ϵ" << endl;
	for (i = 0; i < e; i++) {

		cin >> j >> k;//�������뻡�������Ϣ
		edge_node *p = new edge_node;
		p->adjvex = k;

		p->nextarc = adjlist[j].firstarc;//��P���뵽������
		adjlist[j].firstarc = p;
	}
	return 1;
}
int graph::chushi() {

	for (int i = 0; i < max_vex_node; i++)
	{
		visited[i] = 0;
	}
	return 1;

}

int graph::path_all1(int u, int v, int path[], int i) {//�����u��v�����м�·��
	edge_node *p;
	int n;
	visited[u] = 1;
	p = adjlist[u].firstarc;


	while (p) {

		n = p->adjvex;
		if (n == v) {
			path[i + 1] = v;
			for (int j = 0; j <= i + 1; j++)
				cout << path[j] << " ";
			cout << endl;
		}
		else if (visited[n] == 0) {
			path[i + 1] = n;
			path_all1(n, v, path, i + 1);
		}
		p = p->nextarc;
	}
	visited[u] = 0;
	return 1;
}
int graph::path_all2(int u, int v, int k, int path[], int d) {//�����u��v����·������Ϊk��·��
	int m;
	edge_node *p;
	visited[u] = 1;

	d++;
	path[d] = u;
	if (u == v && d == k) {
		for (int i = 0; i <= d; i++)
			cout << path[i] << " ";
		cout << endl;
	}
	p = adjlist[u].firstarc;
	while (p) {


		m = p->adjvex;
		if (visited[m] == 0) {
			path_all2(m, v, k, path, d);
		}
		p = p->nextarc;

	}
	visited[u] = 0;
	return 1;
}
int main() {
	cout << "��������һ����㣬һ���յ㣬һ��·������" << endl;
	int u, v, k, d = -1, i = 0;
	cin >> u >> v >> k;
	graph t;
	t.path[0] = u;
	t.creat();
	t.chushi();
	cout << "��ͼ�����м�·��" << endl;
	t.path_all1(u, v, t.path, i);
	t.chushi();
	cout << "��ͼ������·������Ϊ" << k << "��·��" << endl;
	t.path_all2(u, v, k, t.path, d);
}
