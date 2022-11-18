#include <stdio.h>

int main (void){
  double salario, novoSalario;
  char op;
  printf("Digite o valor de seu salário: ");
  scanf("%lf", &salario);

  printf("escolha a opção A, B ou C: ");
    scanf(" %c",&op);

  switch(op){
    case 'A': novoSalario = salario + (salario * 0.08);
    break;

    case 'B': novoSalario = salario + (salario * 0.11);
    break;

    case 'C': if (salario > 1000) {
      novoSalario = salario + 200;
    } else if (salario <= 1000) {
      novoSalario = salario + 350;
    } 
    break;
  }
  printf("\nO seu novo salário é de R$ %.0lf,00",novoSalario);
}
