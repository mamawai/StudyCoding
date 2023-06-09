package com.mashibing.dp.ASM;

/**
 * 光标必须位于类体内，View-Show ByteCode
 */

public class T1 {
    int i = 0;
    public void m() {
        int j=1;
        int k =0;
        k++;
        System.out.println(k);
    }

}
