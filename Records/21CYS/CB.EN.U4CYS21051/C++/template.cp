#template for a function multiplying int and double as parameteres

#include <iostream>
using namespace std;

template <typename T, typename U>

U Multiply(T x, U y){
    return x*y;
}

int main()
{
	cout<<Multiply<int, double>(3,3.2);
	return 0;
}
