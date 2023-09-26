%{
#include <stdio.h>
%}

%%
[0-9]+ printf("Num\n");
[a-zA-Z][a-zA-Z0-9]* printf("Word\n");
%%