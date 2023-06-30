## 直接使用汇编
遵循汇编器的语法，要以_start开头, as + ld 来处理， 先as src/direct.s -o out/direct.o  再ld out/direct.o -o out/direct
以main 开头，需要增加.text,.data段，gcc编译
## c调用汇编，链接时找到汇编提供的符号
## c内嵌汇编