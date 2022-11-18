#include <stdio.h>

int main(void) {
  int N = 0;
  double fat = 1, E = 1;

  printf("Digite quantos números terá a sequência: "); //N limita o número de repetições dentro do for.
  scanf("%d",&N);
  
  for(int x=1;x <= N; x++){
    fat *= x;
    E += 1/fat; 
    printf("%d %lf %lf \n", x, fat,E);
  }

} 
