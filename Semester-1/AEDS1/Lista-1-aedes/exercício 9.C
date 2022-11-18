#include <stdio.h>

int main(void) {
  char(op);
  printf("Digite o Símbolo desejado: \n");
  scanf("%c",&op);

  switch(op){
    case '<': printf("Sinal de menor");
    break;

    case '>': printf("Sinal de maior");
    break;

    case '=': printf("Sinal de igual");
    break;

    default: printf("Outro símbolo");
    break; 
  }
}
