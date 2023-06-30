# file movstest1.s --an example of MOVS指令使用例子

    .section .data
        srcStr:
            .string "abcdefghigklmn"

    .section .bss
        .lcomm destStr,14

    .section .text

    .global _start

_start:

    nop;

    leal srcStr,%esi # 标签前不需要加$符号。

    leal destStr,%edi

    movsb

    movsw

    movsl   

    movl $1,%eax

    ret

