#include <stdio.h>

int main(void) {
int total = 0, negativo = 0, positivo = 0, zero = 0, num, P;
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
  }while(num != 123); //interromperá o processo assim que o usuário digitar 123
  total = positivo + negativo + zero; //calcular o total, para obter a porcentagem

  printf("Porcentagem de números positivos: %d %% \n",positivo*100 / total);
  printf("Porcentagem de zeros: %d %% \n",zero*100 / total);
  printf("Porcentagem de números negativos: %d %% \n",negativo*100 / total);
  
}
