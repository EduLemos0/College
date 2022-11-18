#include <stdio.h>
#include <stdlib.h>
/*Faça um programa para preencher uma matriz 4 x 4, em seguida apresentar na tela a soma  dos  elementos  abaixo  da  diagonal  principal.  Mostre  na  tela  os  elementos  da  diagonal principal também.*/

//declarar variavel global de soma
int sum = 0;

//procedimento que imprime apenas os numeros que fazem parte da diagonal principal
void diagonal(int arr[4][4],int t){
  for(int k=0;k < t; k++){
    for(int g = 0; g < t; g++){
      if(k > g){
        printf("%d",arr[k][g]);
        sum += arr[k][g];
      }else{
        printf("- ");
      }
    }
    printf("\n");
  }
}



int main(void) {
  int t = 4;
  int arr[t][t];

  //criamos um for para compor os elementos da matriz
  for(int i=0;i < t;i++){
    for(int j=0;j < t;t++){
      arr[i][j]= rand()% 10;
    }
   
  }
   diagonal(arr,t);
  printf("\nA soma dos elementos da diagonal é:%d\n",sum);
  
}
