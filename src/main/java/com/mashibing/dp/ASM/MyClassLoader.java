package com.mashibing.dp.ASM;

class MyClassLoader extends ClassLoader {
    public Class<?> defineClassFromBytes(byte[] b) {
        return defineClass(null, b, 0, b.length);
    }
}
