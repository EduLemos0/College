#include <stdio.h>


//Declarar abaixo as variáveis globais(sum).


//declarar função que faz a operacao.
float func1(int N){
  float soma=0,resultado=0;
  
  for(int j = 1; j <= N; j++){
    
    soma = ((j*j)+1) / ((j + 3)); 
    
    resultado +=soma;
  }
  
  return(resultado);
}




//funcao que lê o número de repeticoes e encaminha para sum();
int main(void) {
  int input;
  printf("\n Digite o numero: ");
  scanf("%d",&input);

  printf("%f", func1(input));

  return 0;
}
