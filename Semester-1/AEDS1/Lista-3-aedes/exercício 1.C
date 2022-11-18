
#include <stdio.h>

float nota1,nota2,nota3; //Declarando variáveis globais.
char op;

//Abaixo, declarar function que calcula ambas as médias á partir do número de alunos.
void media(int n){
  char op;
  float result, add;

  printf("Nota 1: \n");
  scanf("%f",&nota1);
  printf("Nota 2: \n");
  scanf("%f",&nota2);
  printf("Nota 3: \n");
  scanf("%f",&nota3);

  printf("Digite uma opção(A ou P): \n");
  scanf(" %c",&op);

  
  if(op == 'A'){
    add = nota1 + nota2 + nota3;
    result = add / 3.0;
  } else if(op == 'P'){
    result = (nota1*5 + nota2*3 + nota3*2)/10.0;
  }else{
    printf("Operação inexistente");
  }
  printf("A média do aluno foi: %0.2f\n\n",result);
}


//Abaixo, declarar function que recolhe os dados, como quantidade de alunos, tipo de média(A ou P), e o valor da nota.
int main(void){
  int N;
  printf("Digite o número de alunos: \n");
  scanf("%d",&N);

  for(int i = 1; i <= N; i++){
    printf("Calculando média do %d° aluno...\n",i);
    media(N);
  }
}
