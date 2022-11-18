#include <stdio.h>



  int num1,num2;
  int *p1; 
  int *p2;
  printf("Digite o número 1 e 2 : \n");
  scanf("%d %d",&num1,&num2);

  printf("o endereco de num1 é %p\n",&num1);
  printf("o endereco de num2 é %p\n",&num2);
  

  p1 = &num1;
  p2 = &num2;

  if(p1 > p2){
    printf("%p é o maior endereço\n",p1);
  }else{
    printf("%p é o maior endereço\n",p2);
  }

  return 0;
}
