#include <stdio.h>


double fat(int n){
  if((n == 0) || (n ==1)){
    return 1; //caso o número seja 1 ou 0, o fatorial sempre será 1.
  }else{
    return (n * fat(n-1));
  }
}


double series (int n){
  double total = 1;
  

  
  return total;
}


int main(void) {
  int n;
  printf("digite um número: \n");
  scanf("%d",&n);
  if(n < 0){
    printf("equação inválida\n");
  }

  printf("resultado: %lf",series(n));
  
  return 0;
}
