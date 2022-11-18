 #include <stdio.h>

int main(void) {
  int in = 5;
  float real = 1.8;
  char (texto)='a';

  int *Pin = &in;
  float *Pr = &real;
  char *Pt = &texto;

  //Imprime os valores pré determinados.
  printf("Valor de in: %d\n",in);
  printf("Endereço de in: %p\n",&in);
  printf("Valor de Pin: %d\n",*Pin);
  printf("Endereço de Pin: %p\n\n",&Pin);

  printf("Valor de real: %f\n",real);
  printf("Endereço de real: %p\n",&real);
  printf("Valor de Pr: %f\n",*Pr);
  printf("Endereço de Pr: %p\n\n",&Pr);

  printf("Valor de texto: %c\n",texto);
  printf("Endereço de texto: %p\n",&texto);
  printf("Valor de Pt: %c\n",*Pt);
  printf("Endereço de Pt: %p\n\n",&Pt);
  //Fim de impressão pré determinada


  //Aplicação de novos valores 
  printf("Digite um novo valor para in:\n");
  scanf("%d",&in);
  printf("Digite um novo valor real:\n");
  scanf("%f",&real);
  printf("Digite um novo caractere:\n");
  scanf(" %c",&texto);
  //Fim de aplicação

  
  //Impressão de novos valores
  printf("Valor de in: %d\n",in);
  printf("Endereço de in: %p\n",&in);
  printf("Valor de Pin: %d\n",*Pin);
  printf("Endereço de Pin: %p\n\n",&Pin);

  printf("Valor de real: %f\n",real);
  printf("Endereço de real: %p\n",&real);
  printf("Valor de Pr: %f\n",*Pr);
  printf("Endereço de Pr: %p\n\n",&Pr);

  printf("Valor de texto: %c\n",texto);
  printf("Endereço de texto: %p\n",&texto);
  printf("Valor de Pt: %c\n",*Pt);
  printf("Endereço de Pt: %p\n\n",&Pt);
  //Fim de impressão
}
