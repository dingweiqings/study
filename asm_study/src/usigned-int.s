	.file	"usigned-int.cc"
# GNU C++14 (Uos 8.3.0.3-3+rebuild) version 8.3.0 (x86_64-linux-gnu)
#	compiled by GNU C version 8.3.0, GMP version 6.1.2, MPFR version 4.0.2, MPC version 1.1.0, isl version isl-0.20-GMP

# GGC heuristics: --param ggc-min-expand=100 --param ggc-min-heapsize=131072
# options passed:  -imultiarch x86_64-linux-gnu -D_GNU_SOURCE
# usigned-int.cc -mtune=generic -march=x86-64 -fverbose-asm
# options enabled:  -faggressive-loop-optimizations
# -fasynchronous-unwind-tables -fauto-inc-dec -fchkp-check-incomplete-type
# -fchkp-check-read -fchkp-check-write -fchkp-instrument-calls
# -fchkp-narrow-bounds -fchkp-optimize -fchkp-store-bounds
# -fchkp-use-static-bounds -fchkp-use-static-const-bounds
# -fchkp-use-wrappers -fcommon -fdelete-null-pointer-checks
# -fdwarf2-cfi-asm -fearly-inlining -feliminate-unused-debug-types
# -fexceptions -ffp-int-builtin-inexact -ffunction-cse -fgcse-lm
# -fgnu-runtime -fgnu-unique -fident -finline-atomics -fira-hoist-pressure
# -fira-share-save-slots -fira-share-spill-slots -fivopts
# -fkeep-static-consts -fleading-underscore -flifetime-dse
# -flto-odr-type-merging -fmath-errno -fmerge-debug-strings -fpeephole
# -fplt -fprefetch-loop-arrays -freg-struct-return
# -fsched-critical-path-heuristic -fsched-dep-count-heuristic
# -fsched-group-heuristic -fsched-interblock -fsched-last-insn-heuristic
# -fsched-rank-heuristic -fsched-spec -fsched-spec-insn-heuristic
# -fsched-stalled-insns-dep -fschedule-fusion -fsemantic-interposition
# -fshow-column -fshrink-wrap-separate -fsigned-zeros
# -fsplit-ivs-in-unroller -fssa-backprop -fstdarg-opt
# -fstrict-volatile-bitfields -fsync-libcalls -ftrapping-math -ftree-cselim
# -ftree-forwprop -ftree-loop-if-convert -ftree-loop-im -ftree-loop-ivcanon
# -ftree-loop-optimize -ftree-parallelize-loops= -ftree-phiprop
# -ftree-reassoc -ftree-scev-cprop -funit-at-a-time -funwind-tables
# -fverbose-asm -fzero-initialized-in-bss -m128bit-long-double -m64 -m80387
# -malign-stringops -mavx256-split-unaligned-load
# -mavx256-split-unaligned-store -mfancy-math-387 -mfp-ret-in-387 -mfxsr
# -mglibc -mieee-fp -mlong-double-80 -mmmx -mno-sse4 -mpush-args -mred-zone
# -msse -msse2 -mstv -mtls-direct-seg-refs -mvzeroupper

	.text
	.section	.rodata
	.type	_ZStL19piecewise_construct, @object
	.size	_ZStL19piecewise_construct, 1
_ZStL19piecewise_construct:
	.zero	1
	.local	_ZStL8__ioinit
	.comm	_ZStL8__ioinit,1,1
	.type	_ZStL13allocator_arg, @object
	.size	_ZStL13allocator_arg, 1
_ZStL13allocator_arg:
	.zero	1
	.type	_ZStL6ignore, @object
	.size	_ZStL6ignore, 1
_ZStL6ignore:
	.zero	1
	.type	_ZStL10defer_lock, @object
	.size	_ZStL10defer_lock, 1
_ZStL10defer_lock:
	.zero	1
	.type	_ZStL11try_to_lock, @object
	.size	_ZStL11try_to_lock, 1
_ZStL11try_to_lock:
	.zero	1
	.type	_ZStL10adopt_lock, @object
	.size	_ZStL10adopt_lock, 1
_ZStL10adopt_lock:
	.zero	1
	.globl	result
	.bss
	.align 16
	.type	result, @object
	.size	result, 24
result:
	.zero	24
	.globl	total
	.align 4
	.type	total, @object
	.size	total, 4
total:
	.zero	4
	.section	.rodata
.LC0:
	.string	"%d"
	.text
	.globl	_Z6pailiePiii
	.type	_Z6pailiePiii, @function
_Z6pailiePiii:
.LFB2103:
	.cfi_startproc
	pushq	%rbp	#
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	movq	%rsp, %rbp	#,
	.cfi_def_cfa_register 6
	subq	$32, %rsp	#,
	movq	%rdi, -24(%rbp)	# arr, arr
	movl	%esi, -28(%rbp)	# start, start
	movl	%edx, -32(%rbp)	# end, end
# usigned-int.cc:8: 	if(start == end){
	movl	-28(%rbp), %eax	# start, tmp108
	cmpl	-32(%rbp), %eax	# end, tmp108
	jne	.L2	#,
# usigned-int.cc:9: 		for(int i=0;i<N;i++){
	movl	$0, -4(%rbp)	#, i
.L4:
# usigned-int.cc:9: 		for(int i=0;i<N;i++){
	cmpl	$5, -4(%rbp)	#, i
	jg	.L3	#,
# usigned-int.cc:10: 			printf("%d",result[i]);
	movl	-4(%rbp), %eax	# i, tmp110
	cltq
	movl	result(,%rax,4), %eax	# result, _1
	movl	%eax, %esi	# _1,
	movl	$.LC0, %edi	#,
	movl	$0, %eax	#,
	call	printf	#
# usigned-int.cc:9: 		for(int i=0;i<N;i++){
	addl	$1, -4(%rbp)	#, i
	jmp	.L4	#
.L3:
# usigned-int.cc:12: 		printf("\n");
	movl	$10, %edi	#,
	call	putchar	#
# usigned-int.cc:13: 		total+=1;
	movl	total(%rip), %eax	# total, total.0_2
	addl	$1, %eax	#, _3
	movl	%eax, total(%rip)	# _3, total
.L2:
# usigned-int.cc:15: 	int tmp=0;
	movl	$0, -12(%rbp)	#, tmp
# usigned-int.cc:16: 	for(int i=start;i<end;i++){
	movl	-28(%rbp), %eax	# start, tmp111
	movl	%eax, -8(%rbp)	# tmp111, i
.L6:
# usigned-int.cc:16: 	for(int i=start;i<end;i++){
	movl	-8(%rbp), %eax	# i, tmp112
	cmpl	-32(%rbp), %eax	# end, tmp112
	jge	.L7	#,
# usigned-int.cc:17: 		tmp=arr[i];
	movl	-8(%rbp), %eax	# i, tmp113
	cltq
	leaq	0(,%rax,4), %rdx	#, _5
	movq	-24(%rbp), %rax	# arr, tmp114
	addq	%rdx, %rax	# _5, _6
# usigned-int.cc:17: 		tmp=arr[i];
	movl	(%rax), %eax	# *_6, tmp115
	movl	%eax, -12(%rbp)	# tmp115, tmp
# usigned-int.cc:18: 		arr[i]=arr[start];
	movl	-28(%rbp), %eax	# start, tmp116
	cltq
	leaq	0(,%rax,4), %rdx	#, _8
	movq	-24(%rbp), %rax	# arr, tmp117
	addq	%rdx, %rax	# _8, _9
# usigned-int.cc:18: 		arr[i]=arr[start];
	movl	-8(%rbp), %edx	# i, tmp118
	movslq	%edx, %rdx	# tmp118, _10
	leaq	0(,%rdx,4), %rcx	#, _11
	movq	-24(%rbp), %rdx	# arr, tmp119
	addq	%rcx, %rdx	# _11, _12
# usigned-int.cc:18: 		arr[i]=arr[start];
	movl	(%rax), %eax	# *_9, _13
# usigned-int.cc:18: 		arr[i]=arr[start];
	movl	%eax, (%rdx)	# _13, *_12
# usigned-int.cc:19: 		arr[start]=tmp;
	movl	-28(%rbp), %eax	# start, tmp120
	cltq
	leaq	0(,%rax,4), %rdx	#, _15
	movq	-24(%rbp), %rax	# arr, tmp121
	addq	%rax, %rdx	# tmp121, _16
# usigned-int.cc:19: 		arr[start]=tmp;
	movl	-12(%rbp), %eax	# tmp, tmp122
	movl	%eax, (%rdx)	# tmp122, *_16
# usigned-int.cc:21: 		result[start]=arr[start];
	movl	-28(%rbp), %eax	# start, tmp123
	cltq
	leaq	0(,%rax,4), %rdx	#, _18
	movq	-24(%rbp), %rax	# arr, tmp124
	addq	%rdx, %rax	# _18, _19
	movl	(%rax), %edx	# *_19, _20
# usigned-int.cc:21: 		result[start]=arr[start];
	movl	-28(%rbp), %eax	# start, tmp126
	cltq
	movl	%edx, result(,%rax,4)	# _20, result
# usigned-int.cc:22: 		pailie(arr,start+1,end);
	movl	-28(%rbp), %eax	# start, tmp127
	leal	1(%rax), %ecx	#, _21
	movl	-32(%rbp), %edx	# end, tmp128
	movq	-24(%rbp), %rax	# arr, tmp129
	movl	%ecx, %esi	# _21,
	movq	%rax, %rdi	# tmp129,
	call	_Z6pailiePiii	#
# usigned-int.cc:16: 	for(int i=start;i<end;i++){
	addl	$1, -8(%rbp)	#, i
	jmp	.L6	#
.L7:
# usigned-int.cc:28: }
	nop	
	leave	
	.cfi_def_cfa 7, 8
	ret	
	.cfi_endproc
.LFE2103:
	.size	_Z6pailiePiii, .-_Z6pailiePiii
	.globl	main
	.type	main, @function
main:
.LFB2104:
	.cfi_startproc
	pushq	%rbp	#
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	movq	%rsp, %rbp	#,
	.cfi_def_cfa_register 6
	subq	$32, %rsp	#,
	movl	%edi, -20(%rbp)	# argc, argc
	movq	%rsi, -32(%rbp)	# argv, argv
# usigned-int.cc:42: 	int len =24;
	movl	$24, -4(%rbp)	#, len
.L10:
# usigned-int.cc:43: 	  while ( len-- )
	movl	-4(%rbp), %eax	# len, len.2_1
	leal	-1(%rax), %edx	#, tmp92
	movl	%edx, -4(%rbp)	# tmp92, len
	testl	%eax, %eax	# len.2_1
	setne	%al	#, retval.1_8
	testb	%al, %al	# retval.1_8
	je	.L9	#,
# usigned-int.cc:45:     std::cout<< len<<std::endl;
	movl	-4(%rbp), %eax	# len, tmp93
	movl	%eax, %esi	# tmp93,
	movl	$_ZSt4cout, %edi	#,
	call	_ZNSolsEi	#
# usigned-int.cc:45:     std::cout<< len<<std::endl;
	movl	$_ZSt4endlIcSt11char_traitsIcEERSt13basic_ostreamIT_T0_ES6_, %esi	#,
	movq	%rax, %rdi	# _2,
	call	_ZNSolsEPFRSoS_E	#
# usigned-int.cc:43: 	  while ( len-- )
	jmp	.L10	#
.L9:
# usigned-int.cc:47: 	return 0;
	movl	$0, %eax	#, _12
# usigned-int.cc:49: }
	leave	
	.cfi_def_cfa 7, 8
	ret	
	.cfi_endproc
.LFE2104:
	.size	main, .-main
	.type	_Z41__static_initialization_and_destruction_0ii, @function
_Z41__static_initialization_and_destruction_0ii:
.LFB2625:
	.cfi_startproc
	pushq	%rbp	#
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	movq	%rsp, %rbp	#,
	.cfi_def_cfa_register 6
	subq	$16, %rsp	#,
	movl	%edi, -4(%rbp)	# __initialize_p, __initialize_p
	movl	%esi, -8(%rbp)	# __priority, __priority
# usigned-int.cc:49: }
	cmpl	$1, -4(%rbp)	#, __initialize_p
	jne	.L14	#,
# usigned-int.cc:49: }
	cmpl	$65535, -8(%rbp)	#, __priority
	jne	.L14	#,
# /usr/include/c++/8/iostream:74:   static ios_base::Init __ioinit;
	movl	$_ZStL8__ioinit, %edi	#,
	call	_ZNSt8ios_base4InitC1Ev	#
	movl	$__dso_handle, %edx	#,
	movl	$_ZStL8__ioinit, %esi	#,
	movl	$_ZNSt8ios_base4InitD1Ev, %edi	#,
	call	__cxa_atexit	#
.L14:
# usigned-int.cc:49: }
	nop	
	leave	
	.cfi_def_cfa 7, 8
	ret	
	.cfi_endproc
.LFE2625:
	.size	_Z41__static_initialization_and_destruction_0ii, .-_Z41__static_initialization_and_destruction_0ii
	.type	_GLOBAL__sub_I_result, @function
_GLOBAL__sub_I_result:
.LFB2626:
	.cfi_startproc
	pushq	%rbp	#
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	movq	%rsp, %rbp	#,
	.cfi_def_cfa_register 6
# usigned-int.cc:49: }
	movl	$65535, %esi	#,
	movl	$1, %edi	#,
	call	_Z41__static_initialization_and_destruction_0ii	#
	popq	%rbp	#
	.cfi_def_cfa 7, 8
	ret	
	.cfi_endproc
.LFE2626:
	.size	_GLOBAL__sub_I_result, .-_GLOBAL__sub_I_result
	.section	.init_array,"aw"
	.align 8
	.quad	_GLOBAL__sub_I_result
	.hidden	__dso_handle
	.ident	"GCC: (Uos 8.3.0.3-3+rebuild) 8.3.0"
	.section	.note.GNU-stack,"",@progbits
