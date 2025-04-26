#include <stdio.h>
#include <stdbool.h>

// Verifica se 'a' tem inverso (coprimo com 95)
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
    int a = 7;   // Deve ser o mesmo 'a' usado na cifra
    int b = 10;  // Deve ser o mesmo 'b' usado na cifra

    char mensagem_cifrada[] = "<<<"; // Substitua pela mensagem cifrada
    printf("Cifrada:  %s\n", mensagem_cifrada);

    decrypt(mensagem_cifrada, a, b);
    printf("Decifrada: %s\n", mensagem_cifrada);

    return 0;
}