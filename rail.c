#include<stdio.h>
#include <string.h>

void railfence_encipher(int key, const char *plaintext, char *ciphertext) {
    int line, i, skip, length = strlen(plaintext), j = 0, k = 0;
    for (line = 0; line < key - 1; line++) {
        skip = 2 * (key - line - 1);
        k = 0;
        for (i = line; i < length;) {
            ciphertext[j] = plaintext[i];
            if ((line == 0) || (k % 2 == 0))
                i += skip;
            else
                i += 2 * (key - 1) - skip;
            j++;
            k++;
        }
    }
    for (i = line; i < length; i += 2 * (key - 1))
        ciphertext[j++] = plaintext[i];
    ciphertext[j] = '\0'; 
}
int main()
{
     char plain[]="cipher";
     char cipher[strlen(plain)+1];
     rail(3,plain,cipher);
     printf("%s",cipher);
     return 0;
}