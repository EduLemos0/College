#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <stdlib.h>

#define nDeStrings 1000
#define tam 100

bool end(char *a);
bool palindrome(char *a);
void print (char *a);


int main (void) {

char str[nDeStrings][tam + 1];
int y = 0; // tamanho string
char test[tam + 1];
    // pegar strings


    do {
        fgets(test, tam, stdin);
        test[strcspn(test, "\r\n")] = 0;
        strcpy(str[y], test);
    } while (end(str[y++]));
    y--; //desnconsiderar fim

      for (int i = 0; i < y; i++) {
        print(str[i]);
    } 

}

bool end(char *a) {
    if (a[0] == 'F' && a[1] == 'I' && a[2] == 'M'){
    return false;
    }
    return true;
}

void print (char *a) {
    if (palindrome(a) == true) {
    printf("SIM\n");
    } else {
    printf("NAO\n");
    }
}

bool palindrome(char *a) {
    for (int i = 0; i < (strlen(a) / 2); i++) {
        if (a[i] != a[strlen(a) - i - 1]) {
            return false;
        }
    } 
    return true;
}