import math
from random import getrandbits


def encrypt(message, key):
    cipher = ""
    
    for i in range(len(message)):
            char = message[i]
            keychar = key[i]
            
            if (char.isupper()):
                cipher += chr((ord(char) + ord(keychar) - 130) % 26 + 65)
                
            else:
                cipher += chr((ord(char) + ord(keychar) - 194) % 26 + 97)
        
    return cipher

def decrypt(cipher, key):
    message = ""
    
    for i in range(len(cipher)):
            char = cipher[i]
            keychar = key[i]
            
            if (char.isupper()):
                message += chr((ord(char) - ord(keychar) - 130) % 26 + 65)
                
            else:
                message += chr((ord(char) - ord(keychar)) % 26 + 97)
                
    return message
    
def newkey(text, key):
    newkey = ""
    length = 1
        
    while length <= len(text):
        for i in range(len(key)):
            if length <= len(text):
                newkey += key[i]
                length += 1
            else:
                break;
    return newkey
    
def gcd(a, b):
    while b != 0:
        a, b = b, a % b
    return a

def modinv(a, m):
    for x in range(1, m):
        if (a * x) % m == 1:
            return x
    return None

def is_prime(n):
    if n in [2, 3]:
        return True
    if n == 1 or n % 2 == 0:
        return False
    for i in range(3, int(n ** 0.5) + 1, 2):
        if n % i == 0:
            return False
    return True

def generate_keypair(p, q):
    if not (is_prime(p) and is_prime(q)):
        raise ValueError('Both numbers must be prime.')
    elif p == q:
        raise ValueError('p and q cannot be equal')

    n = p * q
    phi = (p - 1) * (q - 1)

    e = getrandbits(phi.bit_length())
    g = gcd(e, phi)
    while g != 1:
        e = getrandbits(phi.bit_length())
        g = gcd(e, phi)

    d = modinv(e, phi)

    return ((e, n), (d, n))

def encrypt4(pk, plaintext):
    key, n = pk
    cipher = [(ord(char) ** key) % n for char in plaintext]
    return cipher

def decrypt4(pk, ciphertext):
    key, n = pk
    plain = [chr((char ** key) % n) for char in ciphertext]
    return ''.join(plain)

def encryptMessage(key, message):
    
    cipherText = [""] * key
    for col in range(key):
        pointer = col
        while pointer < len(message):
            cipherText[col] += message[pointer]
            pointer += key
    return "".join(cipherText)

def decryptMessage(key, message):
    
    numCols = math.ceil(len(message) / key)
    numRows = key
    numShadedBoxes = (numCols * numRows) - len(message)
    plainText = [""] * numCols
    col = 0
    row = 0
 
    for symbol in message:
        plainText[col] += symbol
        col += 1
 
        if (
            (col == numCols)
            or (col == numCols - 1)
            and (row >= numRows - numShadedBoxes)
        ):
            col = 0
            row += 1
 
    return "".join(plainText)
    
x = 1
while(x==1):
    print("1.Caesar Cipher \n 2.Vernam Cipher \n 3.Vigenere Cipher \n 4.RSA \n 5.Transposition Cipher \n")
    Choice = int(input("Choose one of the options above: "))
 
    if Choice == 1:
        print("\n1.Encrypt a message \n 2.Decrypt a message\n")
        option = int(input("Choose one option from above: "))
    
        if option == 1:
            cipher = ""
            message = input("Enter your message: ")
            shift = int(input("Enter the shift value: "))
        
            for i in range(len(message)):
                char = message[i]
            
                if (char.isupper()):
                    cipher += chr((ord(char) + shift - 65) % 26 + 65)

                else:
                    cipher += chr((ord(char) + shift - 97) % 26 + 97)
                
            print("Your cipher text = ",cipher)
 
        if option == 2:
            message = ""
            cipher = input("Enter your Cipher text: ")
            shift = int(input("Enter the shift value: "))
        
            for i in range(len(cipher)):
                char = cipher[i]
            
                if (char.isupper()):
                    message += chr((ord(char) - shift - 65) % 26 + 65)
        
                else: 
                    message += chr((ord(char) - shift - 97) % 26 + 97)
            print("Your decrypted message = ",message)
 
    elif Choice == 2:
        print("1.Encrypt a message \n 2.Decrypt a message")
        option = int(input("Choose one option from above: "))
    
        if option == 1:
            message = input("Enter your message : ")
            key = input("Enter the key: ")
        
            print("Your cipher text = ",encrypt(message, key))
        
        elif option == 2:
            cipher = input("Enter the cipher text: ")
            key = input("Enter the key: ")
        
            print("Your decrypted message = ",decrypt(cipher, key))
 
    elif Choice == 3:
        print("1.Encrypt a message \n 2.Decrypt a message")
        option = int(input("Choose one option from above: "))
    
        if option == 1:
            message = input("Enter your message: ")
            key = input("Enter the key: ")
        
            key = newkey(message, key)
            print("Your cipher text = ",encrypt(message,key))
        
        elif option == 2:
            message = ""
            cipher = input("Enter the cipher text: ")
            key = input("Enter the key: ")
        
            key = newkey(cipher, key)
            print("Your decrypted message = ",decrypt(cipher,key))
    
    elif Choice == 4:
        print("1.Encrypt or Decrypt message after key generation")
        opt = int(input("Choose one option from above: "))
        
        if opt == 1:
            p = int(input("Enter a prime number (17, 19, 23 etc): "))
            q = int(input("Enter another prime number (Not one you entered above): "))
            print("Generating your public and private keypairs...")
            public, private = generate_keypair(p, q)
            print("Your public key = ", public, " and your private key = ", private)
            message = input("Enter a message to encrypt with your key: ")
            encrypted_msg = encrypt4(private, message)
            print("Your encrypted message is: ")
            print(''.join(map(lambda x: str(x), encrypted_msg)))
            print("Your message is:")
            print(decrypt4(public, encrypted_msg))
        
        else:
            print("You entered a wrong option")
    
    elif Choice == 5:
        print("1.Encryption \n 2.Decryption")
        option = int(input("\nChoose one option from above: "))

        if option == 1:
            message = input("Enter message: ")
            key = int(input("Enter key [2-%s]: " % (len(message) - 1)))
            text = encryptMessage(key, message)
            print("Your encrypted message = ",text)
        elif option == 2:
            cipher = input("Enter message: ")
            key = int(input("Enter key [2-%s]: " % (len(cipher) - 1)))
            text = decryptMessage(key, cipher)
            print("Your encrypted message = ",text)
        
    opt = input("\nDo you want to continue?(y/n): ")
    if opt == 'n':
        x = 0
    elif opt == 'y':
        x = 1
        
        