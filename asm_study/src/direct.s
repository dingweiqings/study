.section .rodata
msg:
    .ascii  "Hello, world\n"

    .text
    .global _start
_start:
    # 相当于执行 write(1, msg, 13)
    mov $1, %rax    # 在 x86-64 下，write 的系统调用号是 1
    mov $1, %rdx    # 第一个参数：1 是标准输出（stdout）的文件描述符
    mov $msg, %rsi  # 第二个参数：Hello, world 字符串的首地址（msg 标签处）
    mov $13, %rdx   # 第三个参数：要输出数据的字节数
    syscall         # 发起系统调用
    # 相当于调用 exit(0)
    mov $60, %rax   # 在 x86-64 下，exit 的系统调用号是 60
    mov $0, %rdx    # 唯一的一个参数：0
    syscall         # 发起系统调用