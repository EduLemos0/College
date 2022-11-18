#include <stdio.h>

//filtra se o número é positivo(true) ou negativo(false)
int posNeg(int input){
  if(input >= 0){
      return 1;
    }else{
      return 0;
  }
}


// digita quantos números quiser e os coloca em ordem
int main(void) {
  int input,i=1;
  while(1 ==1) {
    printf("\nDigite o numero %d: ",i);
    scanf("%d",&input);
    posNeg(input);
    if(posNeg(input) == 1){
      printf("Positivo");
    } else {
      printf("Negativo!");
    }
    i++;   
  }
}
