#include <stdio.h>

float formula (int N){
  float S = 0, fat = 1;

  for(int i = 1; i <= N; i++){
    S += 1/fat;
    fat *= i;
  }
  return S;
}


//digitar N elementos, mandar para a função e retornar.
int main(void) {
 int n;
  printf("Digite um número: \n");
  scanf("%d",&n);
  
  printf("O resultado é: %f\n",formula(n));
}
