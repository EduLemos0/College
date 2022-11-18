#include <stdio.h>


//Função que compara os dois valores
void size(int *p1, int *p2){
  int temp = 0;
  if(*p1 < *p2){
    temp = *p1;
    *p1 = *p2;
    *p2 = temp;
  }
}




//Função principal, que chama a função size e imprime os valores alterados.
int main(void) {
  int num1,num2;

  printf("Digite dois números:\n");
  scanf("%d %d",&num1,&num2);

  size(&num1,&num2);
  printf("%d %d \n",num1,num2);
  return 0;
}
