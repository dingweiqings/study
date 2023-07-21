vga_sec = 0Xb800		# 1*
clear = 4000
.code16					# assembler directive to start 16-bit real mode 
.text
.org 0x00				# the starting address of MBR

.global _start  
.section "text","ax"        
_start:
	cli					# clear interupt
	mov %cs,%ax			# real-mode register
	mov %ax,%ds
	mov 0x4000, %ax		# the physical address loaded by the bootloader
	mov %ax, %ss
	xor %sp,%sp			# clear screen
	call _boot
	ret
_boot:
	cld					# clear direction flag
	mov $vga_sec,%bx
	mov %bx,%es
	xor %di,%di
	mov $0000,%ax
	mov $clear,%cx		# clear screen
	rep stosb

	mov $msg,%si		# move the address of the string to the reg
	mov $0x7,%ah		# COLOR
	mov $vga_sec,%bx
	mov %bx,%es
	mov $986,%edx		# 2*
	call _disp			# output
	ret
_disp:                  # 显示
	lodsb
	or %al,%al			# check if the string has been completely outputed
	jz _endprint
	mov %ax,%es:0(,%edx,2)
	incl %edx
	jmp _disp
	ret
_endprint:
	hlt
.section ".data","a"
msg:
    .asciz "Hello, World111!"
.section ".signature", "a"	
.globl	sig
sig:	.word 0xaa55