#!/bin/bash
set -ex
dd if=source/topic03/myboot of=demo.img seek=0 count=1 oflag=append 
dd if=source/topic03/ex3-2/setup of=demo.img seek=20 count=2 oflag=append
# dd if=source/lib/lib16 of=demo.img seek=20  oflag=append
# dd if=source/common/protected_mp of=demo.img seek=64  oflag=append
# dd if=source/common/long of=demo.img seek=128  oflag=append
# dd if=source/lib/lib32 of=demo.img seek=192  oflag=append
# dd if=source/topic03/ex1-1/setup of=demo.img seek=1 count=4 oflag=append
# dd if=source/lib/lib16 of=demo.img seek=20 count=2 oflag=append

# ######## 下面是写入 floppy 盘映像 ######
# ..\..\common\boot,0,demo.img,0,1		
# setup,0,demo.img,1,4
# ..\..\lib\lib16,0,demo.img,20,2
