#include <stdio.h>

int main(void) {
  float n;
  printf("informe sua nota:\n");
  scanf("%f", &n);
  if ((n>=8)&&(n<=10)) {
    printf("Ótimo\n");
  } else if ((n>=7)&&(n<8)) {
    printf("Bom\n");
  } else if ((n>=5)&&(n<7)) {
    printf("Regular\n");
  } else if (n<5) {
    printf("Insatisfatório\n");
  }
  return 0;
}
