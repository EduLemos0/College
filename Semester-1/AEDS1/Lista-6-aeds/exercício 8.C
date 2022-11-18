#include <stdio.h>

int letraA(int A[10][10]){
  int T[10], A2[10][10];

  //está copiando a matriz, para modificar a cópia, e não a original
  for(int i = 0; i < 10; i++){
    for(int j = 0; j < 10; j++){
      A2[i][j] = A[i][j];
    }
  }

  //está trocando a linha de índice 1 com a de índice 7. Para realizar isso, usou-se um vetor temporário para armazenar a linha de índice 1
  for(int i = 0; i < 10; i++){
    T[i] = A2[1][i];
    A2[1][i] = A2[7][i];
    A2[7][i] = T[i];
  }


  //imprime a nova matriz
  printf("\nLetra A:\n");
  for(int i = 0; i < 10; i++){
    for(int j = 0; j < 10; j++){
      printf("%d ", A2[i][j]);
    }
    printf("\n");
  }
  
}


int letraB(int B[10][10]){
  int Temp[10], B2[10][10];

  //está copiando a matriz, para modificar a cópia, e não a original
  for(int i = 0; i < 10; i++){
    for(int j = 0; j < 10; j++){
      B2[i][j] = B[i][j];
    }
  }

  //está trocando a coluna de índice 3 com a de índice 9. Para realizar isso, usou-se um vetor temporário para armazenar a coluna de índice 3
  for(int j = 0; j < 10; j++){
    Temp[j] = B2[j][3];
    B2[j][3] = B2[j][9];
    B2[j][9] = Temp[j];
  }


  //imprime a nova matriz
  printf("\nLetra B:\n");
  for(int i = 0; i < 10; i++){
    for(int j = 0; j < 10; j++){
      printf("%d ", B2[i][j]);
    }
    printf("\n");
  }
}


int letraC(int C[10][10]){
  int T[10], C2[10][10];

  //está copiando a matriz, para modificar a cópia, e não a original
  for(int i = 0; i < 10; i++){
    for(int j = 0; j < 10; j++){
      C2[i][j] = C[i][j];
    }
  }

  //está trocando a diagonal principal com a secundária. Para realizar isso, usou-se um vetor temporário para armazenar a diagonal secundária
  for(int h = 0; h < 10; h++){
    for(int g = 0; g < 10 ; g++){
      if(h + g == 9 || h == g){
        T[h] = C2[h][h];
        C2[h][h] = C2[h][g];
        C2[h][g] = T[h];
      }
    }
  }

  //imprime a nova matriz
  printf("\nLetra C:\n");
  for(int i = 0; i < 10; i++){
    for(int j = 0; j < 10; j++){
      printf("%d ", C2[i][j]);
    }
    printf("\n");
  }
}


int letraD(int D[10][10]){
  int T[10], D2[10][10];

  //está copiando a matriz, para modificar a cópia, e não a original
  for(int i = 0; i < 10; i++){
    for(int j = 0; j < 10; j++){
      D2[i][j] = D[i][j];
    }
  }

  //está trocando a linha de índice 4 com a coluna de índice 9. Para realizar isso, usou-se um vetor temporário para armazenar a linha de índice 4
  for(int k = 0; k < 10; k++){
    T[k] = D2[4][k];
    D2[4][k] = D2[k][9];
    D2[k][9] = T[k];
  }

  //imprime a nova matriz
  printf("\nLetra D:\n");
  for(int i = 0; i < 10; i++){
    for(int j = 0; j < 10; j++){
      printf("%d ", D2[i][j]);
    }
    printf("\n");
  }
}


int main(void) {
  int M[10][10];

  //seleção e leitura dos elementos que compõe a matriz. Usou a função randômica para fazer isso
  for(int i = 0; i < 10; i++){
    for(int j = 0; j < 10; j++){
      M[i][j] = rand() % 10;
    }
  }

  //impressão da matriz M
  printf("\nMatriz:\n");
  for(int i = 0; i < 10; i++){
    for(int j = 0; j < 10; j++){
      printf("%d ", M[i][j]);
    }
    printf("\n");
  }

  //chamadas dos métodos que realizam as trocas entre linhas, colunas e diagonais
  letraA(M);
  letraB(M);
  letraC(M);
  letraD(M);
  return 0;
}
