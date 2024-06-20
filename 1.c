#include <stdio.h>
#include <string.h>

int main() {
    char str[] = "Hello world";
    printf("AND operation:\n");
    for (int i = 0; i < strlen(str); i++) {
        printf("%c", str[i] & 127);
    }
    printf("\nXOR operation:\n");
    for (int i = 0; i < strlen(str); i++) {
        printf("%c", str[i] ^ 127);
    }
    printf("\n");
    return 0;
}
