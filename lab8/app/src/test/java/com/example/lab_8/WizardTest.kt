package com.example.lab_8


import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class WizardTest {
    private lateinit var evilWizard: Wizard

    // Set up a new wizard before every single test
    @Before
    fun setUp() {
        evilWizard = Wizard("Evil Wizard", 30, 10)
    }

    @Test
    fun castSpell_explosion_successful() {
        val damageDealt = evilWizard.castSpell("Explosion")

        assertEquals(30, damageDealt) // spellPower of 10 * 3 = 30

        assertEquals(20, evilWizard.mana) // mana of 30 - 10 = 20
    }

    @Test
    fun castSpell_explosion_unsuccessful() {
        evilWizard.mana = 5 // Evil Wizard does not have enough mana to cast "Explosion"
        val damageDealt = evilWizard.castSpell("Explosion")

        assertEquals(0, damageDealt)

        assertEquals(5, evilWizard.mana) // mana still is 5
    }
    @Test
    fun restoreMana_capsAt100() {
        evilWizard.restoreMana(75)

        assertEquals(100, evilWizard.mana)
    }

    @Test
    fun restoreMana_addsManaNormally() {
        evilWizard.restoreMana(25)

        assertEquals(55, evilWizard.mana)
    }
    @Test
    fun train_withEnoughMana() {
        evilWizard.train()

        assertEquals(25, evilWizard.mana)
        assertEquals(11, evilWizard.spellPower)
    }

    @Test
    fun train_withLowMana() {
        evilWizard.mana = 4

        evilWizard.train()

        assertEquals(4, evilWizard.mana)
        assertEquals(10, evilWizard.spellPower)
    }
}