1. 直接汇编

1. c语言调汇编
call-asm.s
call-asm.c
2. 汇编输出你好
```
gcc src/helloworld.s -o out/helloworld
```
3. c语言调用汇编，调用syscall打印你好
```
gcc src/helloworld.c src/syscall.s -o out/helloworld
```
3. 汇编调用cpuid
```
gcc src/cpuid.s -o out/cpuid
```