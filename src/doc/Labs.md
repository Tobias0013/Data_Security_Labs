# Labs
This is a document combining the labs task into one document 
with simple requirements

This image explains how the
text message has been encrypted
![image from lab 1 instructions](C:\Users\tv-dr\IdeaProjects\data_security_lab\src\doc\img\lab1_figure1.png)


In the ‘lab1\files’ you have the following files:
- Lab1Store – A keystore with a private key for decryption
- Lab1Sign.cert – Certificate with public key for verification of digital signatures
- Ciphertext.enc – Encrypted file
- Ciphertext.enc.sig1 and Ciphertext.enc.sig2 – two digital signatures
- Ciphertext.mac1.txt and ciphertext.mac2.txt – two message authentication codes

---
## Task 1: Get Key1, IV and Key2

### Task description:

1. Split the content of ciphertext.enc into its different parts. The structure of the
   encrypted file is the following: First we have 128-bytes (1024 bits) of a symmetric key
   encrypted with RSA using the public key “lab1EncKeys” then we have 128-byte of
   encrypted IV-value to be used in the decryption of the data. Before the actual
   encrypted data, there is another block of 128-byte containing encrypted key for a
   HmacMD5. Finally we have the encrypted data. The encryption is made with AES in
   CBC mode, using PKCS5 padding.
   (The reason that the encrypted symmetric keys have 128 bytes instead of 128 bits is
   because Java RSA algorithm pad the keys to the same size of the RSA key before
   encryption)
2. To get the keys and IV to be used to decrypt we need a private key. The key is stored
   in the keystore “lab1Store”. The password to access lab1Store is “lab1StorePass”. The
   alias for the private key is “lab1EncKeys” (bad name as already used to name its
   associated public key), and the password is “lab1KeyPass”.

### Requirements:

- [x] Read file "ciphertext.enc"
- [x] Split content of file according to task description
- [x] Get the private key from the KeyStore file

---

## Task 2: Get the plaintext

### Task description:

When Key1 and IV are recovered you can decrypt and get the message.

### Requirements:

- [x] Decrypt the message from "ciphertext.enc"

---

## Task 3: Verify the Message Authentication Code

### Task description:

Now that you have decrypted the ciphertext and it is time to calculate the message
authentication code (MAC). Use key2 and your decrypted plaintext to calculate a mac.
Compare your calculated mac with the two mac files (in hex string) in the .zip file. Which mac
is the correct one?

### Requirements:

- [x] Get the MAC (message authentication code) from files: "ciphertext.mac1.txt" and "ciphertext.mac2.txt"
- [x] Calculate MAC from plaintext (message) 
- [x] Compare MAC from plaintext to find out which of the files contain the real MAC

---

## Task 4: Verify the Digital Signature

### Task description:

As a receiver, to verify the digital signature we need to read the sender’s public key that is
currently stored in the public key certificate file lab1Sign.cert. You need to read the file and
then load the public key with the java class CertificateFactory, or with the command window
tool ‘keytool’ (not recommended). When you have the public key, you can check which of
the two given signature files is correct.
The digital signature has been signed using the SHA1withRSA algorithm, and used the
plaintext and the sender’s private key as inputs.

### Requirements:

- [x] Get the digital signatures from files: "ciphertext.enc.sig1" and "ciphertext.enc.sig2"
- [x] Get the public key from "lab1Sign.cert", with the java class CertificateFactory
- [x] Calculate the digital signature
- [x] Compare digital signature with files to find out which one is real

---











