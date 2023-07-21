; jmp init; BS_jmpBoot短跳转指令（加上nop填充后为3个字节）
; nop
; Bs_OEMName db "Jiaxgong";Bs_OEMName 厂商名称 8字节
; BPB_BytsPerSec dw 512;每扇区字节数
; BPB_SecPerClus db 1;每簇扇区数
; BPB_RsvdSecCnt dw 1;保留区中的保留扇区数FAT12必须为1,(引导记录占用的扇区数)
; BPB_NumFATs db 2;此卷中FAT表的份数，建议为2
; BPB_RootEntCnt dw 512;根目录中的目录项数 FAT12中建议取值512
; BPB_TotSec16 dw 2880;扇区总数
; BPB_Media db 0xf0;BPB_Media 存储介质f0表示可移动介质，f8表示固定介质
; BPB_FATSz16 dw 9;一个FAT表所占的扇区数
; BPB_SecPerTrk dw 18;每磁道扇区数
; BPB_NumHeaders dw 2;磁头数
; BPB_HiddSec dd 0;FAT分区之前的隐藏扇区数，对于未分区介质必须为0
; BPB_TotSec32 dd 0
; BS_drveNum db 0;int13得到的驱动器号
; BS_Reserved1 db 0;保留（供NT使用）
; BS_BootSig db 0x29;扩展引导标记，指明此后的3个域可用
; BS_VolID dd 0;卷标序列号
; BS_VolLab db "VirtualBoot";磁盘卷标，此域必须与根目录中11字节长的卷标一致
; BS_FilSysType db "FAT12   ";文件系统类型

; init:
;     mov    ax, 7c00h
;     mov    ds, ax
;     mov    es, ax
;     mov    ss, ax
;     mov    sp, 180h
;     call    DispStr

; loop:
;     jmp     loop

; DispStr:
;     mov    ax, BootMsg
;     mov    bp, ax
;     mov    cx, 16
;     mov    ax, 01301h
;     mov    bx, 000ch
;     mov    dl, 0
;     int     10h
;     ret

; BootMsg: db  "Hello, OS World!"

; times 510-($-$$) db 0

; dw 0xaa55
; org 0x7C00                      ; BIOS loads our programm at this address
    bits 16                         ; We're working at 16-bit mode here
    global  _start
    section .text
_start:
;;	cli                     ; Disable the interrupts
	mov si, msg             ; SI now points to our message
	mov ah, 0x0E            ; Indicate BIOS we're going to print chars
.loop	lodsb                   ; Loads SI into AL and increments SI [next char]
	or al, al               ; Checks if the end of the string,i.e. '\0'
	jz halt                 ; Jump to halt if the end
	int 0x10                ; Otherwise, call interrupt for printing the char
	jmp .loop               ; Next iteration of the loop

halt:	hlt                     ; CPU command to halt the execution
        cli
        jmp  halt
msg:	db "Hello, World!", 0   ; Our actual message to print

;; Magic numbers
times 510 - ($ - $$) db 0
dw 0xAA55
