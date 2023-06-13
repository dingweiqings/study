#  输出HelloWorld
.section .data
hello: .string "HelloWorld\n"
.section .text
.globl syscall
.global add
syscall:
    mov	$12,%edx		# message length
    mov	$hello,%ecx		# message to write
    mov	$1,%ebx	# file descriptor (stdout)
    mov	$4,%eax		# system call number (sys_write
    int $0x80
    mov $1,%eax
    mov $0,%ebx
    int $0x80
add:
    # 备份rbp
    push %rbp
    # 让rbp指向当前栈帧
    mov %rsp,%rbp
    # 备份寄存器
    push %rdx
    mov %rdi,%rax
    mov %rsi,%rdx
    add %rdx,%rax
    # 恢复寄存器
    pop %rdx
    # 恢复到以前的rsp
    mov %rbp,%rsp
    pop %rbp
    ret