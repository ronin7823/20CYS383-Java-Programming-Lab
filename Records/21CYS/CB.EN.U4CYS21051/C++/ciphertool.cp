#include <iostream>
using namespace std;


void encrypt(string message, string key) {
    char chr, keychar;
    string cipher;
    int x;
    
    for(int i=0; i<message.length(); i++){
                    chr = message[i];
                    keychar = key[i];
            
                    if (int(chr) < 90){
                        x = ((int(chr) + int(keychar) - 130) % 26 + 65);
                        cipher[i] = char(x);
                    }
                
                    else{
                       x = ((int(chr) + int(keychar) - 194) % 26 + 97);
                       cipher[i] = char(x);
                    }
    }
    cout<<"Your decrypted message is: ";
    for(int i=0; i<message.length(); i++) {
         cout<<cipher[i];
    }
}

void decrypt(string cipher, string key) {
    char chr, keychar;
    string message;
    int x;
    
    for(int i=0; i<cipher.length(); i++){
                    chr = cipher[i];
                    keychar = key[i];
            
                    if (int(chr) < 90){
                        x = ((int(chr) - int(keychar) - 130) % 26);
                        if(x<0)
                           x += 91;
                        else
                           x += 65;
                        message[i] = char(x);
                    }
                    else{
                       x = ((int(chr) - int(keychar)) %26);
                       if(x<0)
                           x += 123;
                       else
                           x += 97;
                       message[i] = char(x);
                    }
    }
    cout<<"Your decrypted message is: ";
    for(int i=0; i<cipher.length(); i++) {
         cout<<message[i];
    }
}

string newkey(string text, string key){
    string newkey[text.length()];
    int length = 0;
    
    while(length < text.length()) {
        for(int i=0; i<key.length(); i++) {
            if(length <= text.length()) {
                newkey[length] = key[i];
                length += 1;
            }
            else
                break;
        }
    }
    return newkey;          
}

int main() {
    int Choice, option;
    
    cout << "1.Caesar Cipher \n 2.Vernam Cipher \n 3.Vigenere Cipher \n 4.Transposition Cipher \n 5.RSA \n Choose one of the options above: ";
    cin >> Choice;
    
    switch(Choice) {
        case 1:
            cout <<"1.Encrypt a message \n 2.Decrypt a message \n Choose one option from above: ";
            cin >>option;
            
            if(option == 1) {
                string message, cipher;
                char chr;
                int shift, x;
                
                cout <<"Enter your message: ";
                cin >> message;
                
                cout <<"Enter the shift value: ";
                cin >> shift;
        
                for(int i=0; i<message.length(); i++) {
                    chr = message[i];
        
                    if (int(chr) <= 90){
                        x = ((int(chr) + shift - 65) % 26 + 65);
                        cipher[i] = char(x);
                    }
                    else {
                        x = ((int(chr) + shift - 97) % 26 + 97);
                        cipher[i] = char(x);
                    }
                }
                cout<<"Your cipher text is: ";
                for(int i=0; i<message.length(); i++) {
                    cout<<cipher[i];
                }
            }
            else if(option == 2) {
                string message, cipher;
                char chr;
                int shift, x;
                
                cout<<"Enter your cipher text: ";
                cin>>cipher;
                
                cout<<"Enter the shift value: ";
                cin>>shift;
                
                for(int i=0; i<cipher.length(); i++) {
                    chr = cipher[i];
                    
                    if(int(chr) < 90) {
                         x = ((int(chr) - shift - 65) % 26 + 65);
                         message[i] = char(x);
                    }
                    else {
                         x = ((int(chr) - shift - 97) % 26 + 97);
                         message[i] = char(x);
                    }
                }
                cout<<"Your decrypted message is: ";
                for(int i=0; i<cipher.length(); i++) {
                    cout<<message[i];
                }
            }
        break;
        case 2:
            cout <<"1.Encrypt a message \n 2.Decrypt a message \n Choose one option from above";
            cin >>option;
            
            if(option == 1) {
                string message,key;
                
                cout <<"Enter your message: ";
                cin >> message;
                
                cout <<"Enter the key: ";
                cin >>key;
                
                encrypt(message, key);
            }
            if(option == 2) {
                string cipher,key;
                
                cout <<"Enter the cipher text: ";
                cin >> cipher;
                
                cout <<"Enter the key: ";
                cin >>key;
                
                decrypt(cipher,key);
            }
        break;
        case 3:
            cout <<"1.Encrypt a message \n 2.Decrypt a message \n Choose one option from above";
            cin >>option;
            
            if(option == 1) {
                string message,key;
                
                cout <<"Enter your message: ";
                cin >> message;
                
                cout <<"Enter the key: ";
                cin >>key;
                
                key = newkey(message, key);
                encrypt(message, key);
            }
            if(option == 2) {
                string cipher,key;
                
                cout <<"Enter the cipher text: ";
                cin >> cipher;
                
                cout <<"Enter the key: ";
                cin >>key;
                
                key = newkey(cipher, key);
                decrypt(cipher, key);
            }
        break;
    }
    return 0;
}