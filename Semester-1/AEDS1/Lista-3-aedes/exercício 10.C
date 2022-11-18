#include <stdio.h>

//função que analisa a categoria do nadador
char category(int N){
  int age;
  printf("digite a idade do nadador:\n");
  scanf("%d",&age);

  if((age >= 5) && (age <=7)){
    return('F');
  }else if((age > 7) && (age <= 10)){
    return('E');
  }else if((age > 10) && (age <=13)){
    return('D');
  }else if((age > 13) && (age <= 15)){
    return('C');
  }else if((age > 15) && (age <= 17)){
    return('B');
  }else if (age >= 18){
    return('A');
  }
}


//tem um for para que o código se repita até o número de nadadores dado.
int main(void) {
  int n;
  printf("digite o número de nadadores participantes:\n");
  scanf("%d",&n);

  for(int i = 1; i <= n;i++){
    printf("calculando a categoria do nadador n°%d\n",i);
    printf("Categoria %c", category(n));
  }
}
