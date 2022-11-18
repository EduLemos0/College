#include <stdio.h>

int main(void) {
  int an, id;
  char op;
  printf("Digite seu ano de nascimento:\n");
  scanf("%d", &an);
  printf("Você já fez aniversário este ano? (s/n)\n");
  scanf(" %c",&op);
  switch(op) {
    case 's':id=2022-an;
    break;
    case 'n':id=2021-an;
    break;
  }
  if (id>=18) {
    printf("Você já tem idade para tirar CNH.\n");
  } else {
    printf("Você ainda não tem idade para tirar CNH.\n");
  }
  printf("Sua idade: %d", id);
  return 0;
}
