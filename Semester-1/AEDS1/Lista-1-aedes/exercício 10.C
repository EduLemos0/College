#include <stdio.h>

int main(void) {
 double velocidade,velocidadeMax, deltaVelocidade, multa=0,speed;
  printf("Digite a velocidade máxima permitida: ");
  scanf("%lf",&velocidadeMax);
  printf("\n Digite a velocidade do motorista: ");
  scanf("%lf",&velocidade);

  deltaVelocidade = velocidade - velocidadeMax;

  if(deltaVelocidade <= 0) {
    printf("\nMotorista respeitou a lei");
  } else if((deltaVelocidade > 0)&&(deltaVelocidade <= 10)) {
    multa = 50;
    printf("Motorista em até 10km acima da velocidade, recebendo assim uma multa de R$ %.0lf", multa);
  } else if((deltaVelocidade > 10)&&(deltaVelocidade <= 30)){
    multa = 100;
    printf("Motorista em até 30km acima da velocidade, recebendo assim uma multa de R$ %.0lf", multa);
  } else if(deltaVelocidade > 30){
    multa = 30;
    printf("Motorista em mais de 30km acima da velocidade, recebendo assim uma multa de R$ %.0lf", multa);
  }
}
