package programmerzamannow.android_basic

import org.junit.Assert
import org.junit.Test

class HelloTest {
//    make unit test
    @Test
    fun testHello() {
        val hasil = Hello.sayHello("Reihan")
        Assert.assertEquals("Hello Reihan", hasil)
    }
}