#include <iostream>
#include <string> 
#include "tree.h"
using namespace std;
int main(){
	tree Bitree;
	cout<<"�������������"<<endl;
	string n;
	cin>>n;
	Bitree.root->data=n;
	cout<<"ÿ��߶ȴ����������룬�ԡ�#��������#����֮��û�н�㣩"<<endl;
	Bitree.nbuild(Bitree.root);
	cout<<endl;
	Bitree.preorder(Bitree.root);
	cout<<endl;
	Bitree.inorder(Bitree.root);
	cout<<endl;
	Bitree.postorder(Bitree.root);
	cout<<endl;
    Bitree.nbclue(Bitree.root);
    Bitree.postClueOrder(Bitree.root);
    cout<<endl;

return 0; 
} 
