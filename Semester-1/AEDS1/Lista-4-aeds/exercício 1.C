#include <stdio.h>

int dig(int num){ 

  if(num > 10){
    return (1+ dig(num/10)); //chama a função até que num/10 possua apenas 1 dígito. 
  }else{
    return 1; //caso o número tenha 1 digito.
  }
}

int main(void) {
  int n;
  printf("digite um numero:\n");
  scanf("%d",&n);

  printf("o numero de dígitos do número %d é %d",n,dig(n));
  
  return 0;
}
