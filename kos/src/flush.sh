#!/bin/sh
set -ex
out_dir=../out
kernel_name=kos
sudo losetup /dev/loop11 $out_dir/$kernel_name.img
sudo dd if=$out_dir/$kernel_name.bin of=/dev/loop11 bs=512 count=1
sudo losetup -d /dev/loop11