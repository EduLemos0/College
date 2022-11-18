#include <stdio.h>

int main(void) {
 float vd, dp, v8, v5, dif;
  printf("Digite o valor da diária:\n");
  scanf("%f", &vd);
  dp=vd*0.25;
  printf("Valor da diária promocional: %f\n", dp);
  v8=dp*60;
  printf("Valor arrecadado com 80% de ocupação: %f\n", v8);
  v5=dp*37;
  printf("Valor arrecadado com 50% de ocupação: %f\n", v5);
  dif=v8-v5;
  printf("Diferença entre os dois valores: %f\n", dif);
  return 0;
}
