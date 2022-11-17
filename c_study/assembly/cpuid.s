.section .data

output:
    .ascii "The processor Vender ID is 'xxxxxxxxxxxx'\n"

.section .text
.globl main

; _start:

;     // 获取 CPU ID
;     movl $0, %eax
;     cpuid
    
;     // 将 CPU ID 填充到 output 的占位符部分
;     movl $output, %edi
;     movl %ebx, 28(%edi)
;     movl %edx, 32(%edi)
;     movl %ecx, 36(%edi)

;     // 系统调用, 显示 CPUID
;     movl $4, %eax
;     movl $1, %ebx
;     movl $output, %ecx
;     movl $42, %edx
;     int $0x80
;     movl $1, %eax
;     movl $0, %ebx
;     int $0x80

;     // 系统调用, 返回程序执行结果
;     movl $1, %eax
;     movl $0, %ebx
;     int $0x80
;     ret