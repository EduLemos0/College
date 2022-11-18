#include <stdio.h>

int main(void) {
int total = 0, negativo = 0, positivo = 0, zero = 0, num;
  do{
    printf("Digite um número ");
    scanf("%d",&num);

    if(num > 0){
      positivo++;
    }
    if(num == 0){
      zero++;
    }
    if(num < 0){
      negativo++;
    }
  }while(num != 123);
  printf("Quantidade de números positivos: %d \n",positivo);
  printf("Quantidade de zeros: %d \n",zero);
  printf("Quantidade de números negativos: %d \n",negativo);
}
