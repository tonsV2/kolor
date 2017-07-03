package com.andreapivetta.kolor

import com.winterbe.expekt.should
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

object KolorTest : Spek({
    describe("foreground/background") {
        it("should create a string that starts with an ANSI code and ends with the reset code") {
            for (color in Color.values()) {
                Kolor.foreground("foo", color).should.equal("${color.ANSI()}foo\u001B[0m")
                Kolor.background("foo", color).should.equal("${color.ANSIBackground()}foo\u001B[0m")
            }
        }
    }
})
