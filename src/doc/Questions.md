# Open questions

Why is it not a good idea to simply encrypt the plaintext with the receiver’s public key?



Why bother to generate Key1, IV, and encrypt them?



Suppose the receiver (i.e. you) does not share any secret with the sender before she/he
receives the encrypted keys in ciphertext.enc (i.e. the ciphertext + the encrypted symmetric
keys). Does a verified correct message authentication code (MAC) (e.g. the one received by
applying HmacMD5 in this exercise) authenticate the sender or can we trust the origin of the
message in this case? Why or why not? (Note that we are assuming that digital signature is not used)













