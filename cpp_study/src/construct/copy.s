	.file	"copy.cc"
	.text
	.section	.rodata
	.type	_ZStL19piecewise_construct, @object
	.size	_ZStL19piecewise_construct, 1
_ZStL19piecewise_construct:
	.zero	1
	.local	_ZStL8__ioinit
	.comm	_ZStL8__ioinit,1,1
	.section	.text._ZN6PersonC2Ev,"axG",@progbits,_ZN6PersonC5Ev,comdat
	.align 2
	.weak	_ZN6PersonC2Ev
	.type	_ZN6PersonC2Ev, @function
_ZN6PersonC2Ev:
.LFB1519:
	.cfi_startproc
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register 6
	subq	$16, %rsp
	movq	%rdi, -8(%rbp)
	movq	-8(%rbp), %rax
	addq	$8, %rax
	movq	%rax, %rdi
	call	_ZNSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEC1Ev
	nop
	leave
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE1519:
	.size	_ZN6PersonC2Ev, .-_ZN6PersonC2Ev
	.weak	_ZN6PersonC1Ev
	.set	_ZN6PersonC1Ev,_ZN6PersonC2Ev
	.section	.rodata
.LC0:
	.string	"Copy Constructor"
	.section	.text._ZN6PersonC2ERKS_,"axG",@progbits,_ZN6PersonC5ERKS_,comdat
	.align 2
	.weak	_ZN6PersonC2ERKS_
	.type	_ZN6PersonC2ERKS_, @function
_ZN6PersonC2ERKS_:
.LFB1522:
	.cfi_startproc
	.cfi_personality 0x3,__gxx_personality_v0
	.cfi_lsda 0x3,.LLSDA1522
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register 6
	pushq	%rbx
	subq	$24, %rsp
	.cfi_offset 3, -24
	movq	%rdi, -24(%rbp)
	movq	%rsi, -32(%rbp)
	movq	-24(%rbp), %rax
	addq	$8, %rax
	movq	%rax, %rdi
	call	_ZNSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEC1Ev
	movl	$.LC0, %esi
	movl	$_ZSt4cout, %edi
.LEHB0:
	call	_ZStlsISt11char_traitsIcEERSt13basic_ostreamIcT_ES5_PKc
	movl	$_ZSt4endlIcSt11char_traitsIcEERSt13basic_ostreamIT_T0_ES6_, %esi
	movq	%rax, %rdi
	call	_ZNSolsEPFRSoS_E
.LEHE0:
	jmp	.L5
.L4:
	movq	%rax, %rbx
	movq	-24(%rbp), %rax
	addq	$8, %rax
	movq	%rax, %rdi
	call	_ZNSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEED1Ev
	movq	%rbx, %rax
	movq	%rax, %rdi
.LEHB1:
	call	_Unwind_Resume
.LEHE1:
.L5:
	addq	$24, %rsp
	popq	%rbx
	popq	%rbp
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE1522:
	.globl	__gxx_personality_v0
	.section	.gcc_except_table._ZN6PersonC2ERKS_,"aG",@progbits,_ZN6PersonC5ERKS_,comdat
.LLSDA1522:
	.byte	0xff
	.byte	0xff
	.byte	0x1
	.uleb128 .LLSDACSE1522-.LLSDACSB1522
.LLSDACSB1522:
	.uleb128 .LEHB0-.LFB1522
	.uleb128 .LEHE0-.LEHB0
	.uleb128 .L4-.LFB1522
	.uleb128 0
	.uleb128 .LEHB1-.LFB1522
	.uleb128 .LEHE1-.LEHB1
	.uleb128 0
	.uleb128 0
.LLSDACSE1522:
	.section	.text._ZN6PersonC2ERKS_,"axG",@progbits,_ZN6PersonC5ERKS_,comdat
	.size	_ZN6PersonC2ERKS_, .-_ZN6PersonC2ERKS_
	.weak	_ZN6PersonC1ERKS_
	.set	_ZN6PersonC1ERKS_,_ZN6PersonC2ERKS_
	.section	.rodata
.LC1:
	.string	"Assign"
	.section	.text._ZN6PersonaSERKS_,"axG",@progbits,_ZN6PersonaSERKS_,comdat
	.align 2
	.weak	_ZN6PersonaSERKS_
	.type	_ZN6PersonaSERKS_, @function
_ZN6PersonaSERKS_:
.LFB1524:
	.cfi_startproc
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register 6
	subq	$16, %rsp
	movq	%rdi, -8(%rbp)
	movq	%rsi, -16(%rbp)
	movl	$.LC1, %esi
	movl	$_ZSt4cout, %edi
	call	_ZStlsISt11char_traitsIcEERSt13basic_ostreamIcT_ES5_PKc
	movl	$_ZSt4endlIcSt11char_traitsIcEERSt13basic_ostreamIT_T0_ES6_, %esi
	movq	%rax, %rdi
	call	_ZNSolsEPFRSoS_E
	movq	-8(%rbp), %rax
	leave
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE1524:
	.size	_ZN6PersonaSERKS_, .-_ZN6PersonaSERKS_
	.text
	.globl	_Z1f6Person
	.type	_Z1f6Person, @function
_Z1f6Person:
.LFB1525:
	.cfi_startproc
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register 6
	movq	%rdi, -8(%rbp)
	nop
	popq	%rbp
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE1525:
	.size	_Z1f6Person, .-_Z1f6Person
	.section	.text._ZN6PersonD2Ev,"axG",@progbits,_ZN6PersonD5Ev,comdat
	.align 2
	.weak	_ZN6PersonD2Ev
	.type	_ZN6PersonD2Ev, @function
_ZN6PersonD2Ev:
.LFB1528:
	.cfi_startproc
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register 6
	subq	$16, %rsp
	movq	%rdi, -8(%rbp)
	movq	-8(%rbp), %rax
	addq	$8, %rax
	movq	%rax, %rdi
	call	_ZNSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEED1Ev
	nop
	leave
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE1528:
	.size	_ZN6PersonD2Ev, .-_ZN6PersonD2Ev
	.weak	_ZN6PersonD1Ev
	.set	_ZN6PersonD1Ev,_ZN6PersonD2Ev
	.text
	.globl	_Z2f1v
	.type	_Z2f1v, @function
_Z2f1v:
.LFB1526:
	.cfi_startproc
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register 6
	subq	$16, %rsp
	movq	%rdi, -8(%rbp)
	movq	-8(%rbp), %rax
	movq	%rax, %rdi
	call	_ZN6PersonC1Ev
	nop
	movq	-8(%rbp), %rax
	leave
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE1526:
	.size	_Z2f1v, .-_Z2f1v
	.globl	main
	.type	main, @function
main:
.LFB1530:
	.cfi_startproc
	.cfi_personality 0x3,__gxx_personality_v0
	.cfi_lsda 0x3,.LLSDA1530
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register 6
	pushq	%rbx
	subq	$296, %rsp
	.cfi_offset 3, -24
	leaq	-160(%rbp), %rax
	movq	%rax, %rdi
	call	_ZN6PersonC1Ev
	leaq	-160(%rbp), %rdx
	leaq	-208(%rbp), %rax
	movq	%rdx, %rsi
	movq	%rax, %rdi
.LEHB2:
	call	_ZN6PersonC1ERKS_
.LEHE2:
	leaq	-256(%rbp), %rax
	movq	%rax, %rdi
	call	_ZN6PersonC1Ev
	leaq	-160(%rbp), %rdx
	leaq	-256(%rbp), %rax
	movq	%rdx, %rsi
	movq	%rax, %rdi
.LEHB3:
	call	_ZN6PersonaSERKS_
	leaq	-256(%rbp), %rdx
	leaq	-112(%rbp), %rax
	movq	%rdx, %rsi
	movq	%rax, %rdi
	call	_ZN6PersonC1ERKS_
.LEHE3:
	leaq	-112(%rbp), %rax
	movq	%rax, %rdi
	call	_Z1f6Person
	leaq	-112(%rbp), %rax
	movq	%rax, %rdi
	call	_ZN6PersonD1Ev
	leaq	-64(%rbp), %rax
	movq	%rax, %rdi
	call	_Z2f1v
	leaq	-64(%rbp), %rdx
	leaq	-256(%rbp), %rax
	movq	%rdx, %rsi
	movq	%rax, %rdi
.LEHB4:
	call	_ZN6PersonaSERKS_
.LEHE4:
	leaq	-64(%rbp), %rax
	movq	%rax, %rdi
	call	_ZN6PersonD1Ev
	leaq	-304(%rbp), %rax
	movq	%rax, %rdi
	call	_Z2f1v
.LEHB5:
	call	getchar
.LEHE5:
	movl	$0, %ebx
	leaq	-304(%rbp), %rax
	movq	%rax, %rdi
	call	_ZN6PersonD1Ev
	leaq	-256(%rbp), %rax
	movq	%rax, %rdi
	call	_ZN6PersonD1Ev
	leaq	-208(%rbp), %rax
	movq	%rax, %rdi
	call	_ZN6PersonD1Ev
	leaq	-160(%rbp), %rax
	movq	%rax, %rdi
	call	_ZN6PersonD1Ev
	movl	%ebx, %eax
	jmp	.L23
.L21:
	movq	%rax, %rbx
	leaq	-64(%rbp), %rax
	movq	%rax, %rdi
	call	_ZN6PersonD1Ev
	jmp	.L16
.L22:
	movq	%rax, %rbx
	leaq	-304(%rbp), %rax
	movq	%rax, %rdi
	call	_ZN6PersonD1Ev
	jmp	.L16
.L20:
	movq	%rax, %rbx
.L16:
	leaq	-256(%rbp), %rax
	movq	%rax, %rdi
	call	_ZN6PersonD1Ev
	leaq	-208(%rbp), %rax
	movq	%rax, %rdi
	call	_ZN6PersonD1Ev
	jmp	.L18
.L19:
	movq	%rax, %rbx
.L18:
	leaq	-160(%rbp), %rax
	movq	%rax, %rdi
	call	_ZN6PersonD1Ev
	movq	%rbx, %rax
	movq	%rax, %rdi
.LEHB6:
	call	_Unwind_Resume
.LEHE6:
.L23:
	addq	$296, %rsp
	popq	%rbx
	popq	%rbp
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE1530:
	.section	.gcc_except_table,"a",@progbits
.LLSDA1530:
	.byte	0xff
	.byte	0xff
	.byte	0x1
	.uleb128 .LLSDACSE1530-.LLSDACSB1530
.LLSDACSB1530:
	.uleb128 .LEHB2-.LFB1530
	.uleb128 .LEHE2-.LEHB2
	.uleb128 .L19-.LFB1530
	.uleb128 0
	.uleb128 .LEHB3-.LFB1530
	.uleb128 .LEHE3-.LEHB3
	.uleb128 .L20-.LFB1530
	.uleb128 0
	.uleb128 .LEHB4-.LFB1530
	.uleb128 .LEHE4-.LEHB4
	.uleb128 .L21-.LFB1530
	.uleb128 0
	.uleb128 .LEHB5-.LFB1530
	.uleb128 .LEHE5-.LEHB5
	.uleb128 .L22-.LFB1530
	.uleb128 0
	.uleb128 .LEHB6-.LFB1530
	.uleb128 .LEHE6-.LEHB6
	.uleb128 0
	.uleb128 0
.LLSDACSE1530:
	.text
	.size	main, .-main
	.type	_Z41__static_initialization_and_destruction_0ii, @function
_Z41__static_initialization_and_destruction_0ii:
.LFB2022:
	.cfi_startproc
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register 6
	subq	$16, %rsp
	movl	%edi, -4(%rbp)
	movl	%esi, -8(%rbp)
	cmpl	$1, -4(%rbp)
	jne	.L26
	cmpl	$65535, -8(%rbp)
	jne	.L26
	movl	$_ZStL8__ioinit, %edi
	call	_ZNSt8ios_base4InitC1Ev
	movl	$__dso_handle, %edx
	movl	$_ZStL8__ioinit, %esi
	movl	$_ZNSt8ios_base4InitD1Ev, %edi
	call	__cxa_atexit
.L26:
	nop
	leave
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE2022:
	.size	_Z41__static_initialization_and_destruction_0ii, .-_Z41__static_initialization_and_destruction_0ii
	.type	_GLOBAL__sub_I__Z1f6Person, @function
_GLOBAL__sub_I__Z1f6Person:
.LFB2023:
	.cfi_startproc
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register 6
	movl	$65535, %esi
	movl	$1, %edi
	call	_Z41__static_initialization_and_destruction_0ii
	popq	%rbp
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE2023:
	.size	_GLOBAL__sub_I__Z1f6Person, .-_GLOBAL__sub_I__Z1f6Person
	.section	.init_array,"aw"
	.align 8
	.quad	_GLOBAL__sub_I__Z1f6Person
	.hidden	__dso_handle
	.ident	"GCC: (Uos 8.3.0.3-3+rebuild) 8.3.0"
	.section	.note.GNU-stack,"",@progbits
