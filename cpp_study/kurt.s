assume cs:codesg
codesg segment
        mov %rax,$0123
        mov %rbx,$0456
        add %rax,%rbx
        mov %rax,$4c00
        int 21
codesg ends