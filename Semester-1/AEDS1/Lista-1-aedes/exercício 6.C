#include <stdio.h>

int main (void){
double a, x, b, y;

  printf("Digite o valor de a, b e x, respectivamente : ");
  scanf("%lf %lf %lf", &a, &b, &x);
  if (a == 0) {
    printf("Operação Inválida.");
  } else{
  y = a * x + b;
   }
  printf("O resultado da equação é : %0.lf", y);
  return 0; 
} 
