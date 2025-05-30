#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

typedef struct {
    int linha;         
    int coluna;        
} Posicao;

typedef struct {
    Posicao pos_inicial;    
    Posicao pos_atual;      
    bool capturada;         
    char simbolo;           
    char cor;             
} Peca;

typedef struct {
    Peca base;
    bool primeiro_movimento; 
} Peao;

typedef struct {
    Peca base;
    bool em_xeque;
    bool roque_disponivel;  
} Rei;

typedef struct {
    Peca base;
    bool roque_disponivel;  
} Torre;

typedef struct {
    Peca base;
} Cavalo;

typedef struct {
    Peca base;
} Bispo;

typedef struct {
    Peca base;
} Dama;

Peca tabuleiro[8][8];  

void inicializar_peca(Peca *peca, char simbolo, char cor, int linha, int coluna);
void inicializar_tabuleiro();

int main() {

}

void inicializar_peca(Peca *peca, char simbolo, char cor, int linha, int coluna) {
    peca->pos_inicial.linha = linha;
    peca->pos_inicial.coluna = coluna;
    peca->pos_atual = peca->pos_inicial;
    peca->capturada = false;
    peca->simbolo = simbolo;
    peca->cor = cor;
}

void inicializar_tabuleiro() {
    for (int col = 0; col < 8; col++) {
        inicializar_peca(&tabuleiro[1][col], 'P', 'B', 1, col); 
        inicializar_peca(&tabuleiro[6][col], 'P', 'P', 6, col); 
    }

    inicializar_peca(&tabuleiro[0][0], 'T', 'B', 0, 0); 
    inicializar_peca(&tabuleiro[0][7], 'T', 'B', 0, 7);
    inicializar_peca(&tabuleiro[0][1], 'C', 'B', 0, 1); 
    inicializar_peca(&tabuleiro[0][6], 'C', 'B', 0, 6);
    inicializar_peca(&tabuleiro[0][2], 'B', 'B', 0, 2); 
    inicializar_peca(&tabuleiro[0][5], 'B', 'B', 0, 5);
    inicializar_peca(&tabuleiro[0][3], 'D', 'B', 0, 3); 
    inicializar_peca(&tabuleiro[0][4], 'R', 'B', 0, 4); 

    inicializar_peca(&tabuleiro[7][0], 'T', 'P', 7, 0); 
    inicializar_peca(&tabuleiro[7][7], 'T', 'P', 7, 7);
    inicializar_peca(&tabuleiro[7][1], 'C', 'P', 7, 1); 
    inicializar_peca(&tabuleiro[7][6], 'C', 'P', 7, 6);
    inicializar_peca(&tabuleiro[7][2], 'B', 'P', 7, 2); 
    inicializar_peca(&tabuleiro[7][5], 'B', 'P', 7, 5);
    inicializar_peca(&tabuleiro[7][3], 'D', 'P', 7, 3); 
    inicializar_peca(&tabuleiro[7][4], 'R', 'P', 7, 4); 
}
