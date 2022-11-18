#include <stdio.h>

int resto(int num,int den){
  int subt = 0;
 if(den > num){
   return num;
 }else if (num >= den){
   subt = num - den;
   return resto(subt,den);
 }
} 

int main(void) {
  int a, b;
  printf("digite o numerador e o denominador respectivamente:\n");
  scanf("%d %d",&a,&b);
  
  printf("O resto da divisão é igual a %d", resto(a, b));
  return 0;
  
}
