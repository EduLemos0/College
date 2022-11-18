#include <stdio.h>

/*
  4 candidatos
  1,2,3,4 para cada candidato
  5 = voto nulo
  6 = voto em branco

  finaliza o contador de votos, quando escreve 0

*/

int main(void) {
  int cand1=0,cand2=0,cand3=0,cand4=0,nulo=0,branco=0, input = 0;
  int rep =1; // repeticao ligada ou desligada

  while(rep == 1){
    printf("Digite um número de 1 a 6: \n");
    scanf("%d",&input);

    switch(input){
      case 0: rep =0;
      break;
      case 1: cand1++;
      break;
      case 2: cand2++;
      break;
      case 3: cand3++;
      break;
      case 4: cand4++;
      break;
      case 5: nulo++;
      break;
      case 6: branco++;
      break;
      default: printf("Número inválido");
      break; 
    }
  }
  printf("Votos para candidato 1: %d\nVotos para candidato 2: %d\nVotos para candidato 3: %d\nVotos para candidato 4: %d\nVotos nulos: %d\nVotos em branco: %d\n",cand1,cand2,cand3,cand4,nulo,branco);
  
  return 0;
}
