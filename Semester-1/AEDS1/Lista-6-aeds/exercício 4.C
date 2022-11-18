#include <stdio.h>
#include <stdlib.h>>
/*Em uma cidade, sabe-se hipoteticamente que, em janeiro de 2021, não ocorreu temperatura 
inferior a 15°C, nem superior a 40°C. Faça um programa que armazene as temperaturas de 
cada dia de janeiro em um vetor (de 31 posições), calcule e imprima: 
 A menor e a maior temperatura ocorrida; 
 A temperatura média; 
 O número de dias nos quais a temperatura foi inferior a temperatura média. 
 */



int main(void) {
  int n = 31;
  int arr[n];
  int low = 41, big = 0,sum = 0,count = 0;

  for(int i=0; i < n; i++){
    arr[i] = rand()% 26 + 15; 
    sum += arr[i];
    if(arr[i] < 41){
      low = arr [i];
    }
    if(arr[i] > big){
      big = arr[i];
    }
  }

  float average = sum/31;

  for(int k = 0; k < 31;k++){
    if(arr[k] < average){
      count++;
    }
  }
    
  printf("\n\nA maior temperatura foi igual a %d", big);
  printf("\nA menor temperatura foi igual a %d", low);
  printf("\nA temperatura média é igual a %.2f", average);
  printf("\n%d dias tiveram temperatura abaixo da temperatura média",count);
  
  
}
