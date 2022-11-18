#include <stdio.h>

int main(void) {
  int valor = 5;
  int *valorPtr;

  valorPtr = &valor;
  printf("%d \n",valor);
  printf("%d \n",*valorPtr);
  printf("%p \n",&valor);
  printf("%p \n",valorPtr);
}


//à partir disso, vemos que as alternativas corretas são B e C.
