#!/bin/sh
set -ex
out_dir=../out
kernel_name=kos
gcc -g -c -m32 $kernel_name.s -o $out_dir/$kernel_name.o
ld -T $kernel_name.ld $out_dir/$kernel_name.o -o $out_dir/$kernel_name.elf # -T for <filename>.ld
objcopy -O binary $out_dir/$kernel_name.elf $out_dir/$kernel_name.bin # or anything else will do
dd if=/dev/zero of=$out_dir/$kernel_name.img bs=512 count=2880 # start making booting floppy
./flush.sh