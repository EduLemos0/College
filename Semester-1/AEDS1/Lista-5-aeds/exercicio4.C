#include <stdio.h> 
int main() 
{ 
    int x, *p, **q; 
    p = &x; 
    q = &p; 
    x = 10; 
    printf("\n%d\n", **q); 
    return(0);  
} 

//Devemos trocar o "&q", que mostra o endereço de "q", para "**q", que aponta para "p", que aponta para o conteúdo de x.
