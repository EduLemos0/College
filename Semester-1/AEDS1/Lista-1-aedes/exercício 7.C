#include <stdio.h>

int main (void){
float y, x;
  printf("Escreva um valor para x: ");
  scanf("%f", &x);

  if (x <= 1){
    y = 1;
    printf("y = %.0f",y);
  } else if((x > 1)&&(x <= 2)){
    y = 2;
    printf("y = %.0f",y);
  } else if((x > 2)&&(x <= 3)){
    y = x*x;
    printf("y = %.0f",y);
  } else if(x > 3) {
    y = x*x*x;
    printf("y = %.0f",y);
  }
  return 0;
}
