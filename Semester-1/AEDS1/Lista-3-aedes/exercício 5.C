#include <stdio.h>


//Usa o método if, para que calcule o conceito de cada aluno.
void concept(int N){
  int grade; //variável nota.
  printf("Digite a nota do aluno: \n");
  scanf("%d",&grade);
if(grade <= 39){
    printf("Conceito F.\n\n");
  }else if((grade > 40) && (grade <= 59)){
    printf("Conceito E.\n\n");
  }else if((grade > 60) && (grade <= 69)){
    printf("Conceito D.\n\n");
  }else if((grade > 70) && (grade <= 79)){
    printf("Conceito C.\n\n");
  }else if((grade > 80) && (grade <= 89)){
    printf("Conceito B.\n\n");
  }else if(grade > 90){
    printf("Conceito A.\n\n");
    }
 
}




// le o numero de participantes e chama a função para calcular o conceito de cada aluno.
int main(void) {
  int n;
  printf("digite o número de alunos participantes:\n");
  scanf("%d",&n);

  for(int i = 1; i <= n; i++){
    printf("Gerando resultado do aluno n°%d...\n",i);
    concept(n);
  }
  
  return 0;
}
