#include <stdio.h>
//Função que recebe o valor do salário de cada participante e soma ao total,no final, o programa calcula a média dos salários e joga para a função main.
void mSalario(int n){
  float soma=0, media=0,salario=0;
  int child = 0;
  for(int x = 1; x <= n; x++){
    printf("CIDADÃO N°%d\n",x);
    printf("Digite o valor do seu salário: \n");
    scanf("%f",&salario);
    printf("Digite o número de filhos:\n");
    scanf("%d",&child);
    soma += salario;
    media = soma / x;
  printf("A média dos salários é: R$%0.2f\n\n",media);
  }
  
}


//Função main, que recebe a entrada do numero de participantes e retorna a média de salários.
int main(void) {
  int n;
  printf("Digite o número de cidadãos participantes da pesquisa: \n");
  scanf("%d",&n);
mSalario(n);
  
}
