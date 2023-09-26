%{
#include <stdio.h>
#include <string.h>
extern int yydebug = 1;
char * heater=NULL;
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

%token  TOKHEAT TOKTARGET TOKTEMPERATURE  TOKHEATER 
%union
{

    int number;

    char *string;
}

%token <number> STATE

%token <number> NUMBER

%token <string> WORD

%%
commands: /* empty */
    | commands command
;

command: heat_switch
    | target_set | heater_select
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
        printf("\tHeater '%s' temperature set to %d\n", heater, $3+5);
    }
;
heater_select :

    TOKHEATER WORD

    {

       printf("\tSelected heater ‘%s’\n", $2);

       heater = $2;

}

    ;
%%