package programmerzamannow.android_basic

import org.junit.Assert
import org.junit.Test
// Test Buisness Logic
class GameTest {
//    make test pickRandomOption
    @Test
    fun testPickRandomOption(){
        val options = listOf("ROCK", "PAPER", "SCISSORS")
        Assert.assertTrue(options.contains(Game.pickRandomOption()))
        Assert.assertTrue(options.contains(Game.pickRandomOption()))
        Assert.assertTrue(options.contains(Game.pickRandomOption()))
        Assert.assertTrue(options.contains(Game.pickRandomOption()))
        Assert.assertTrue(options.contains(Game.pickRandomOption()))
    }

//     make test pickRandomDrawable
    @Test
    fun testPickDrawable(){
        Assert.assertEquals(R.drawable.rock, Game.pickDrawable("ROCK"))
        Assert.assertEquals(R.drawable.paper, Game.pickDrawable("PAPER"))
        Assert.assertEquals(R.drawable.scissors, Game.pickDrawable("SCISSORS"))
    }

//     make test isDraw
    @Test
    fun testIsDraw(){
//     if True
        Assert.assertTrue(Game.isDraw("ROCK", "ROCK"))
        Assert.assertTrue(Game.isDraw("PAPER", "PAPER"))
        Assert.assertTrue(Game.isDraw("SCISSORS", "SCISSORS"))

//     if False
        Assert.assertFalse(Game.isDraw("ROCK", "PAPER"))
        Assert.assertFalse(Game.isDraw("PAPER", "SCISSORS"))
        Assert.assertFalse(Game.isDraw("SCISSORS", "ROCK"))
    }

//    make test isWin
    @Test
    fun testIsWin(){
//     if True
        Assert.assertTrue(Game.isWin("ROCK", "SCISSORS"))
        Assert.assertTrue(Game.isWin("PAPER", "ROCK"))
        Assert.assertTrue(Game.isWin("SCISSORS", "PAPER"))

//     if False
        Assert.assertFalse(Game.isWin("ROCK", "PAPER"))
        Assert.assertFalse(Game.isWin("PAPER", "SCISSORS"))
        Assert.assertFalse(Game.isWin("SCISSORS", "ROCK"))
    }

}