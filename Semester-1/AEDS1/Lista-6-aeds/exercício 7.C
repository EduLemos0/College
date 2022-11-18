#include <stdio.h>
#include <stdlib.h>
/*Faça um procedimento que preencha 2 matrizes, A 4 x 6 e B 4 x 6. Faça uma função para cada uma das situações a seguir, que recebe duas matrizes preenchidas, calcula e retorna as matrizes indicadas :  
a) uma matriz S que seja a soma de A e B.  
b) uma matriz D que seja a diferença de A e B. (A - B).  */

 //funcao que preenche os arrays
void fillArray(int A[4][6],int B[4][6]){
  //para o array A
  for(int i=0;i < 4; i++){
    for(int j=0;j < 6;j++){
      A[i][j] = rand()% 10; //sorteia numero entre 0 e 9.
    }
  }
//para o array B
  for(int n=0;n < 4;n++){
    for(int m =0;m < 4;m++){
      B[n][m] = rand()% 10;
    }
  }
}

//funcao que é a soma de A e B
void sumS(int A[4][6],int B[4][6],int S[4][6]){
  for(int o=0;o < 4;o++){
    for(int p=0;p < 6;p++){
      S[o][p] = A[o][p] + B[o][p];
    }
  }
  printf("S:\n");
  for(int i=0;i < 4;i++){
    for(int j = 0;j < 6;j++){
      printf("%d ",S[i][j]);
    }
    printf("\n");
  }
}

//funcao que faz subtracao de A e B
void subD(int A[4][6],int B[4][6],int D[4][6]){
  for(int i = 0;i < 4; i++){
    for(int j = 0;j < 6; j++){
      D[i][j] = A[i][j] - B[i][j];
    }
  }
  printf("D:\n");
  for(int i = 0; i < 4; i++){
    for(int j = 0; j < 6; j++){
      printf("%d ",D[i][j]);
    }
    printf("\n");
  }
}


int main(void) {
  int k = 4, l = 6;
  int A[k][l];
  int B[k][l];

  //chama a funcao que preenche os arrays
  fillArray(A,B);
  

  int S[k][l];
  sumS(A,B,S);

  int D[k][l];
  subD(A,B,D);
}
