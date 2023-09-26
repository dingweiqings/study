%{
#include <stdio.h>
#include <string.h>
extern int yydebug = 1;
void yywrap()
{
    return  1;
}
void yyerror(char * errmsg){
    printf("%s\n",errmsg);
}

int main()
{
    yyparse();
}
%}

%token  NUMBER TOKHEAT STATE TOKTARGET TOKTEMPERATURE
%%
commands: /* empty */
    | commands command
;

command: heat_switch
    | target_set
;

heat_switch:
    TOKHEAT STATE
    {
         if ($2)
            printf("\tHeat turned on\n");
         else
            printf("\tHeat turned off\n");
    }
;

target_set:
    TOKTARGET TOKTEMPERATURE NUMBER
    {
        //展示区别,这里给输入参数+5
        printf("\tTemperature set %d\n",$3 + 5);
    }
;
%%