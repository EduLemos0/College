#include <stdio.h>

//Função que calcula a área e  o comprimento

void calcCircunferencia (float R, float *comprimento, float *area) {

  *comprimento=2*3.14*R;
  *area=3.14*(R*R);
}


int main(void) {
  float raio, comp, a;
  printf("Digite o valor do raio:\n");
  scanf("%f", &raio);

  calcCircunferencia(raio, &comp, &a);
  printf("Comprimento: %f\n", comp);
  printf("Area: %f\n", a);
  
  return 0;
}
