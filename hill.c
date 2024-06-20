#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

#define MAX_SIZE 100

void hill_encrypt(int keyMatrix[][MAX_SIZE], int n, char plain[], int cipher[]) {
    int i, j, k;

    for (i = 0; i < n; i++) {
        cipher[i] = 0;
        for (j = 0; j < n; j++)
            cipher[i] += keyMatrix[i][j] * (plain[j] - 'a');
        cipher[i] = cipher[i] % 26;
    }
}

void hill_decrypt(int keyMatrix[][MAX_SIZE], int n, int cipher[], char plain[]) {
    int i, j, k;
    int inverseKey[MAX_SIZE][MAX_SIZE];

    int det = 0;
    for (i = 0; i < n; i++)
        for (j = 0; j < n; j++)
            inverseKey[i][j] = keyMatrix[j][i];

    for (i = 0; i < n; i++)
        det = det + (keyMatrix[0][i] * (keyMatrix[1][(i + 1) % n] * keyMatrix[2][(i + 2) % n] - keyMatrix[1][(i + 2) % n] * keyMatrix[2][(i + 1) % n]));

    det = det % 26;
    det = pow(det, -1);
    if (det == 0) {
        printf("matrix not invertible\n");
        exit(1);
    }

    for (i = 0; i < n; i++) {
        plain[i] = 0;
        for (j = 0; j < n; j++)
            plain[i] += inverseKey[i][j] * cipher[j];
        plain[i] = plain[i] % 26;
    }
}

int main() {
    char plain[MAX_SIZE];
    int cipher[MAX_SIZE];
    int n;
    printf("Enter the size of key matrix (n x n): ");
    scanf("%d", &n);

    int keyMatrix[MAX_SIZE][MAX_SIZE];
    printf("Enter the key matrix (n x n) row-wise:\n");
    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
            scanf("%d", &keyMatrix[i][j]);

    printf("Enter the plaintext (in lowercase alphabets): ");
    scanf("%s", plain);

    int len = strlen(plain);
    int padding = n - (len % n);
    if (padding != n) {
        for (int i = len; i < len + padding; i++)
            plain[i] = 'x';
        plain[len + padding] = '\0';
    }

    hill_encrypt(keyMatrix, n, plain, cipher);

    printf("Ciphertext: ");
    for (int i = 0; i < len + padding; i++)
        printf("%c", cipher[i] + 'a');
    printf("\n");

    hill_decrypt(keyMatrix, n, cipher, plain);

    printf("Decrypted Plaintext: ");
    for (int i = 0; i < len + padding; i++)
        printf("%c", plain[i] + 'a');
    printf("\n");

    return 0;
}
