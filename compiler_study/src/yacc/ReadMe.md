# 编译lex
flex helloworld.lex
# 编译parse,最后的-ll需要加上
gcc lex.yy.c -o regex -ll

# lex和yacc
我们希望实现下面的功能,如果用户输入heat on 就打开温度控制器,输入heat off就关闭温度控制器,用户还可以通过target temperature set xxx来设定温度值

flex heat.lex
生成语法,--file-prefix是文件名的前缀
bison -d heat-grammer.y  --file-prefix y
gcc y.tab.c lex.yy.c -o heat

调试
bison -t -v -d heat-grammer.y -b y 

# union 参数
用下面方式控制，先选择heater，再设置温度
heater mainbuilding

    Selected ‘mainbuilding’ heater

Target temperature 23

    ‘mainbuilding’ heater target temperature now 23