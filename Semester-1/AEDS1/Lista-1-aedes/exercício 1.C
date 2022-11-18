#include <stdio.h>

int main(void) {
  int num1, num2;
  printf("Digite um número:\n");
  scanf("%d", &num1);
  printf("Digite outro número:\n");
  scanf("%d", &num2);
  if(num1>num2) {
    printf("O maior número é: %d\n", num1);
  } else if (num1<num2) {
    printf("O maior número é: %d\n", num2);
  } else if (num1==num2) {
    printf("Os números são iguais.\n");
  }
  return 0;
}
