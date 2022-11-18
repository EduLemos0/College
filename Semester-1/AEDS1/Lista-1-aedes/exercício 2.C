#include <stdio.h>

int main(void) {
  int a, b, soma, resultado;
  printf("Digite 2 números:\n");
  scanf("%d %d", &a, &b);
  soma=a+b;
  if (soma>=10) {
    res=soma+5;
  } else {
    res=soma+7;
  }
  printf("Resultado : %d\n", resultado);
  return 0;
}
