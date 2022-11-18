#include <stdio.h>

int main(void) {
  int n=0;
  float E=1;
  printf("Digite um número: ");
  scanf("%d",&n);
  for(float x = 1; x <= n; x++){
    E += 1 / x;                                 //mesmo princípio da questão 4, mas sem o fatorial.
    printf("%f \n",E);
  }
  printf("\nResultado: %f",E);
}
