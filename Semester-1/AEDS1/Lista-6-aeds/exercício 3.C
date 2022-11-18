#include <stdio.h>
#include  <stdlib.h>

/*Faça um procedimento que preencha 2 vetores X e Y com 10 elementos cada um (ocupando 
as posições de 0 a 9 em cada vetor). Faça um outro procedimento que receba dois vetores 
preenchidos  e  gera  um  novo  vetor  com  os  elementos  desses  2  vetores  intercalados  de  tal 
forma que nas posições ímpares do novo vetor estejam os elementos do primeiro vetor e nas 
posições pares os elementos do segundo vetor recebido por parâmetro. Faça um 
procedimento  que  receba  e  exiba  o  conteúdo  de  um  vetor.  Faça  um  programa  que  faça  as 
devidas declarações e acione os módulos para exemplificar o seu uso. */

void fill(int x[],int y[]){
  int b = 10;

  printf("Conteudo do array x:\n");
   for(int i = 0; i < b; i++){
     x[i] = rand() % 51;
     printf("%d ",x[i]);
   } 
  printf("\n\n");
  printf("Conteudo do array y:\n");

  for(int j = 0; j < b; j++){
     y[j] = rand() % 51;
    printf("%d ",y[j]);
   } 

}

void newArray(int x[10],int y[10]){
  int alternado [20];
  int c = 20,px=0,py=0;

  for(int i = 0; i <= c; i++){
    if(i%2 == 0){
      alternado[i] = x[px++];
    }else{
      alternado[i] = y[py++];
    }
  }
  printf("\n\nO novo array alternado terá os elementos abaixo:\n");
  for(int  k = 0; k < c; k++){
    printf("%d ",alternado[k]);
  }
  
}





int main(void) {
int n = 10;
int x[n], y[n];

fill(x,y);
newArray(x,y);
  
}
