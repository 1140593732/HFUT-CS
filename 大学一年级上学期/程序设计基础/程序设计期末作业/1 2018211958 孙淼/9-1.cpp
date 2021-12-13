//�ƿ�2�� 2018211958 ���
//Array.h
#ifndef ARRAY_H
#define ARRAY_H
#include<cassert>

template<class T>
class Array{
	private:
		T*list;
		int size;
	public:
		Array(int sz=50);
		Array(const Array<T>&a);
        ~Array();
        Array<T>&operator=(const Array<T>&rhs);
        T & operator [] (int i);
        T & operator [] (int i) const;
        operator const T*()const;
        int getSize()const;
        void resize(int sz);
};

template<class T>
Array<T>::Array(int sz){
	assert(sz>=0);
	size=sz;
	list=new T[size];
}

template<class T>
Array<T>::~Array(){
	delete [] list;
}

template<class T>
Array<T>::Array(const Array<T>&a){
	size=a.size;
	list=new T[size];
	for(int i=0;i<size;i++)
	  list[i]=a.list[i];
}

template<class T>
Array<T>&Array<T>::operator=(const Array<T>&rhs){
	if(&rhs!=this){
		if(size!=rhs.size){
			delete[]list;
			size=rhs.size;
			list=new T[size];
		}
		for(int i=0;i<size;i++)
		  list[i]=rhs.list[i];
	}
	return * this;
}

template<class T>
T &Array<T>::operator[] (int n){
	assert(n>=0 && n<size);
	return list[n];
}


template<class T>
int Array<T>::getSize()const{
	return size;
}

template<class T>
void Array<T>::resize(int sz){
	assert(sz>=0);
	if(sz==size)
	  return;
	T*newList=new T [sz];
	int n=(sz<size)?sz:size;
	for(int i=0;i<n;i++)
	  newList[i]=list[i];
	delete[] list;
	list=newList;
	size=sz;  
}
#endif //ARRAY_H


#include <iostream>
using namespace std;
int main(){
	int n;
	cout<<"������༶����n:"<<endl; 
	cin>>n;
	Array<double>a(n);
	for(int i=0;i<n;i++){
	    cin>>a[i];
	}
	double b=a[0];
	for(int i=1;i<n;i++)
	  b=b+a[i];
	cout<<"ƽ����Ϊ��"<<b/n;
}


������༶����n:
5
50 25 75 100 0
ƽ����Ϊ��50
--------------------------------
Process exited after 11.27 seconds with return value 0
�밴���������. . .


