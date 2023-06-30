# cpuid2.s View the CPUID Vendor ID string using C library calls
.section .data
.balign 16
output:
    .asciz "The processor Vendor ID is '%s'\n" 
.balign 16
    align_var: .long 1
.section .bss
    .balign 16
    .comm buffer, 16
.section .text
.globl main
main:
# 第一个参数是edi,第二个参数是esi
    movl $0, %eax
    cpuid
    # 放入buffer的参数中
    movl $buffer, %edi
    movl %ebx, (%edi)
    movl %edx, 4(%edi)
    movl %ecx, 8(%edi)
    
    movl %edi,%esi
    movl $output,%edi
    # 这里做了栈的16字节对齐
    push $buffer
    push $buffer
    push $output
    call printf
    # 还原栈
    addq $0x18, %rsp
    push $0
    call exit