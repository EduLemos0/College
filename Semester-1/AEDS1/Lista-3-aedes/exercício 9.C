#include <stdio.h>

//verifica se determinado aluno passou ou não.
int score(float grade){
  if(grade >= 6){
    return 1;
  } else {
    return 0;
  }
}

//função que calcula a média das notas.
float average(int alunos, float nota){
  float avg = nota/alunos;

  return media;
  
}


int main(void) {
  float input = 1;
  int total = 0;
  int totalNotas =0;
  while(input > 0){
    printf("\n Digite a nota do aluno \n(-1 para sair): ");
    scanf("%f",&input);
    if(input >0){
      if(score(input) == 1){
        total ++;
        totalNotas += input;
      }
    }
    
  }

  printf("Media dos alunos aprovados: %.2f", average(total, totalNotas));
  
  return 0;
}
