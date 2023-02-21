#include <iostream> 
using namespace std; 

//Base class 
class Parent 
{ 
	public: 
	int id_p; 
}; 

// Sub class inheriting from Base Class(Parent) 
class Child : public Parent 
{ 
	public: 
	int id_c; 
}; 

//main function 
int main() 
{ 
	
		Child obj1; 
		
		// An object of class child has all data members 
		// and member functions of class parent 
		//obj1.id_c is the name given for the child object
		//obj1.id_p is the name to be given for the parent object
//@start-editable@

cin>>obj1.id_c;
cin>>obj1.id_p;


//@end-editable@
 
		cout << "Child id is " << obj1.id_c << endl; 
		cout << "Parent id is " << obj1.id_p << endl; 
		
		return 0; 
}
