#include<iostream>
using namespace std;

// Create your class and define the data members here
//@start-editable@

class rectangle{
    public:
     int l;
     int h;
//@end-editable@

rectangle(int a, int b); 

// define the  member functions  here
//@start-editable@


void area(){
    cout<<"The area of the rectangle is "<<l*h;
}

};

rectangle :: rectangle(int a, int b){
    l = a;
    h = b;
}



//@end-editable@

int main()
{
rectangle r(5,3);
r.area();
}