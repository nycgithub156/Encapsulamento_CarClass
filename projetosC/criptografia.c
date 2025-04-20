#include <stdio.h>
#include <stdbool.h>

// Verifica se 'a' é coprimo com 95 (não divisível por 5 ou 19)
bool isCoprime(int a) {
    return (a % 5 != 0) && (a % 19 != 0);
}

// Calcula o inverso modular de 'a' mod 95 (força bruta)
int modInverse(int a) {
    a = a % 95;
    for (int x = 1; x < 95; x++) {
        if ((a * x) % 95 == 1) {
            return x;
        }
    }
    return -1; // Inverso não existe
}

// Cifra: E(x) = (a * (x - 32) + b) mod 95 + 32
void encrypt(char *text, int a, int b) {
    for (int i = 0; text[i] != '\0'; i++) {
        int x = (int)text[i] - 32; // Mapeia para 0-94
        int y = (a * x + b) % 95;
        text[i] = (char)(y + 32); // Volta para 32-126
    }
}

// Decifra: D(y) = a⁻¹ * (y - 32 - b) mod 95 + 32
void decrypt(char *ciphertext, int a, int b) {
    int a_inv = modInverse(a);
    if (a_inv == -1) {
        printf("Erro: 'a' não tem inverso. Escolha outro valor.\n");
        return;
    }

    for (int i = 0; ciphertext[i] != '\0'; i++) {
        int y = (int)ciphertext[i] - 32; // Mapeia para 0-94
        int x = (a_inv * (y - b)) % 95;
        if (x < 0) x += 95; // Corrige negativos
        ciphertext[i] = (char)(x + 32); // Volta para 32-126
    }
}

int main() {
    int a = 7;  // Coprimo com 95 (não múltiplo de 5 ou 19)
    int b = 10; // Qualquer valor entre 0 e 94

    char mensagem[] = "PROD24";
    printf("Original: %s\n", mensagem);

    encrypt(mensagem, a, b);
    printf("Cifrada:  %s\n", mensagem);

    decrypt(mensagem, a, b);
    printf("Decifrada: %s\n", mensagem);

    return 0;
}