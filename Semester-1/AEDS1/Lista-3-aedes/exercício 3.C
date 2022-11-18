#include <stdio.h>

/*

Procedimento que recebe 3  valores inteiros por parâmetro e os exiba em ordem 
crescente.

Faça  um  programa  que  leia  N  conjuntos  de  3  valores  e  acione  o  procedimento 
para cada conjunto. (N deve ser lido do teclado) 
*/



void crescente(int num1, int num2, int num3){
  // Descobrir qual eh o maior
  if(num1 > num2){
     if(num1 > num3){
       // Num 1 maior
        printf("%d ", num1);
        if(num2 > num3){
          printf("%d ", num2);
          printf("%d ", num3);
          // num 3 menor
        } else {
          // num 3 maior que num 2
          printf("%d ", num3);
          printf("%d ", num2);
        }
    } else {
       // Num 3 maior
        printf("%d ", num3);
        if(num2 > num1){
          printf("%d ", num2);
          printf("%d ", num1);
        } else {
          printf("%d ", num1);
          printf("%d ", num2);
        }
    }
  } else {
    if(num2 > num3){
      // Num 2 maior
        printf("%d ", num2);
        if(num3 > num1){
          printf("%d ", num3);
          printf("%d ", num1);
        } else {
          printf("%d ", num1);
          printf("%d ", num3);
        }
    } else {
      // Num 3 maior.
        printf("%d ", num3);
        if(num2 > num1){
          printf("%d ", num2);
          printf("%d ", num1);
          // num 1 menor
        } else {
          // Num 2 menor
          printf("%d ", num1);
          printf("%d ", num2);
        }
    }
  }
  
  
  
}

int main(void) {
  int num1, num2, num3;
  do{
    printf("Digite 3 numeros: ");
    scanf("%d %d %d", &num1, &num2, &num3);
    crescente(num1, num2, num3);
  }while(num1 != -1);
  
 
  return 0;
}
