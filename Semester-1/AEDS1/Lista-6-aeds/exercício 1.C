#include <stdio.h>
//Variável global de soma, dos aprovados e reprovados
float sum = 0;
int pass = 0,rep = 0;

//Função que preenche os valores do vetor
void fillScore(int n, float vetor[]){
  for (int i=0; i < n; i++){
    printf("Digite a nota do aluno %d:\n",i+1);
    scanf("%f",&vetor[i]);
    sum += vetor[i];
  }
}
  //Função que calcula a média das notas
  void avg(int n, float vetor[]){
    float average = 0;
    average = sum/n;
    printf("\nA média das notas é %.1f\n",average);

    for(int i = 0; i < n; i++){
      if(vetor[i] < average){
        rep++;
      }else{
        pass++;
      }
    }
  }

  

int main(void) {
  int n = 10;
  float vscore[n];

  fillScore(n,vscore);
  avg(n,vscore);
  printf("%d Alunos aprovados\n",pass);
  printf("%d Alunos reprovados\n",rep);
return 0;
}
