#include <stdio.h>
#include <stdlib.h>  //Possibilita o uso de "rand()".

//Procedimento que cria novo array á partir dos números negativos
void newArray(int negative,int x[10]){
  int y[negative],j=0;

  
  for(int c = 0; c < 10;c++){
    if(x[c] < 0){
      y[j++] = x[c];
    }
  }

  printf("\nVetor Y:\n");
  for(int k = 0; k < negative; k++){
    printf("%d ",y[k]);
  }
  printf("\n");
}




int main(void) {
    //Declarar vetor X
  int n = 10, negative = 0;
  int x[n];

  //randomizar números entre -10 e 10 e colocar como objects do array.
  for(int i=0; i < n; i++){
    x[i] = rand() % 21 - 10;

    //caso seja negativo, "negative" aumentará.
    if(x[i] < 0){
      negative++;
    }
  }

  //Imprimir valores de vetor X
  printf("Vetor X:\n");
  for(int h=0; h<n;h++){
    printf("%d ",x[h]);
  }
  printf("\n");

  newArray(negative,x); /* Para passagem do array"X", é apenas necessario                           o seu nome */
return 0;                
}
