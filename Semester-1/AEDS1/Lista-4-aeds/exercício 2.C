#include <stdio.h>

int sum(int num){ 
 int q = num/10; //quociente
 int r = num%10; //resto

  if(num > 10){
    return (r+ sum(q)); //soma ao resto.
  }else{
    return num;
  }
}

int main(void) {
  int n;
  printf("digite um numero:\n");
  scanf("%d",&n);

  printf("a soma dos dígitos do número %d é %d",n,sum(n));
  
  return 0;
}
