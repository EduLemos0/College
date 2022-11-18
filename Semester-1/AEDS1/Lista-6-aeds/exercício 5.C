#include <stdio.h>
#include <stdlib.h>
/*Faça um procedimento que preencha uma matriz M 5 x 5. Faça uma função que receba 
uma matriz preenchida, calcule e retorne cada uma das somas a seguir (uma função para cada letra abaixo):  
 
a) da linha 4 de M  
b) da coluna 2 de M  
c) da diagonal principal  
d) da diagonal secundária  
e) de todos os elementos da matriz. */

//Declarar variáveis globais para operadores de soma.
int md=0,sd=0,l4=0,c2=0,total;

//Funcao que preenche o array
void fillArr(int i,int j,int m[5][5]){
  for(i = 0;i < 5; i++){
    for(j = 0; j < 5; j++){
      scanf("%d",&m[i][j]);
    }
  }
  //escreve a matriz, para conferir os dados
  for (i=0; i<5; i++) {
  for (j=0; j<5; j++){
    printf ("%d", m[i][j]);
    printf (" ");
    }
  printf ("\n");
  }
}  
  
//funcao que soma os elementos da linha 4 de M.
int line4(int m[5][5],int j){
  for(j=0; j < 5; j++){
    l4 += m[4][j]; //Seleciona todos os elementos da linha 4.
  }
  return l4;
}

//funcao que soma os elementos da coluna 2 de m
int column2(int m[5][5],int i){
  for(i=0; i < 5; i++){
    c2 += m[i][2];
  }
  return c2;
}

//funcao que soma os elementos da diagonal principal
int mainDiag(int m[5][5],int i,int j){
  for(i =0;i < 5;i++){
    for(j=0;j < 5;j++){
     if(i==j){
      md += m[i][j];
      } 
    }
  }
  return md;
}

//funcao que soma os elementos da diagonal secundária.
int secondaryDiag(int m[5][5],int i,int j){
  int tam = 5;
  for(i=0;i < tam;i++){
    for(j=0; j < tam; j++){
      if(i+j == 6){
        sd += m[i][j];
      }
    }
  }
  
  return sd;
}

//funcao que soma todos os elementos
int sumAll(int m[5][5],int i,int j){
  for(i=0;i < 5; i++){
    for(j=0;j < 5;j++){
      total += m[i][j];
    }
  }
  return total;
}




int main(void) {
  int m[5][5];
  int i,j,k; //variaveis utilizadas no for
  
  fillArr(i,j,m);
  printf("\n");
  
  line4(m,j);
  printf("a soma dos elementos da 4°a linha é: %d\n",l4);

  column2(m,i);
  printf("a soma dos elementos da 2°a coluna é:%d\n",c2);

  mainDiag(m,i,j);
  printf("a soma dos elementos da diagonal principal é:%d\n",md);

  secondaryDiag(m,i,j);
  printf("a soma dos elementos da matriz secundária é:%d\n",sd);

  sumAll(m,i,j);
  printf("a soma de todos os elementos é:%d\n",total);
  
  return 0;
}
