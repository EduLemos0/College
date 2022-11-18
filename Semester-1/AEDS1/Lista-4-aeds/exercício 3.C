#include <stdio.h>

/*a function division funciona de modo que enquanto a subtração não for 0, somará 1 ao quociente, até que a operação esteja zerada,
retornando assim, o valor final do quociente.
*/

int division(int num,int den){
  int sub = num - den;

  if(sub != 0){
    return (1 + division(sub,den));
  }else{
    return (1);
  }
}





int main(void) {
  int a, b;
  printf("digite o numerador e o denominador:\n");
  scanf("%d %d",&a,&b);
  printf("%d dividido por %d é igual a: %d \n\n",a,b,division(a,b));
  
  return 0;
}
