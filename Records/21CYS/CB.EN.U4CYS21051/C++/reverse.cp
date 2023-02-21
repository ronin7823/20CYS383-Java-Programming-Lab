#include <iostream>
#include <cctype>
using namespace std;

void reverse(const string& str) {

  size_t numOfChars = str.size();

  if(numOfChars == 1) {
      char ch;
      
      ch = str[0];
      if(isupper(ch)){
          ch = tolower(ch);
      }
      else{
          ch = toupper(ch);
      }
    cout<<ch<<"";
  }
  else {
      char ch;
      
      if(isupper(str[numOfChars - 1 ])){
        ch = tolower(str[numOfChars - 1]);
      }
      else{
          ch = toupper(str[numOfChars - 1]);
      }
      
    cout<<ch<<"";
    reverse(str.substr(0, numOfChars - 1));
  }
  
}

int main() {
  string str;

  getline(cin, str);
  reverse(str);

  return 0;    
}

