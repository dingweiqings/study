# boot代码
ld的时候需要将代码放入到0x7c00的位置，cpu会执行这段boot代码，位于磁盘的第一个扇区
查看kos.ld的脚本
ld -T $kernel_name.ld $out_dir/$kernel_name.o -o $out_dir/$kernel_name.elf
# 启动和调试
qemu-system-i386 -fda ../out/kos.img -S -s
-S 是调试boot代码，-s 指定gdb端口
gdb ../out/kos.img，target remote :1234
然后b _start。执行continue就可以一步一步向下调试
# initrd

# main.c
操作系统内核