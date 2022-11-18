#include <stdio.h>

/*
Procedimento  recebe  3  valores  reais  e  que  verifique 

o comprimento de cada lado de um triângulo é menor do  que  a  soma  do  comprimento  dos  outros  dois  lados.
 
- Triângulo Equilátero: os comprimentos dos 3 lados são iguais; 
- Triângulo Isósceles: os comprimentos de pelo menos 2 lados são iguais.  
- Triângulo Escaleno: os comprimentos dos 3 lados são diferentes. 
 
      Faça um programa que leia um número indeterminado de triângulos (valores dos 3 lados) e  
      para cada triângulo, acione o procedimento.
*/


//Declaramos as variáveis globais XYZ.

void triangle(int x,int y,int z){


  if((z+y > x) && (x+z > y) && (x+y > z)){
     if((x == y) && (y == z)){
      printf("Triângulo Equilátero.\n\n");
    }else if((x!= y) && (x != z) && (y!=z)){
      printf("Triângulo Escaleno.\n\n");
    }else{
       printf("Triângulo Isósceles.\n\n");
    }
  }else{
    printf("Não é triângulo.\n\n");
  }
  
}
  



int main(void) {
  int l1,l2,l3;

  while(1){
    printf("Digite os 3 lados do triângulo: \n");
    scanf("%d %d %d", &l1, &l2, &l3);
    triangle(l1, l2, l3);
    
  }
  
}
