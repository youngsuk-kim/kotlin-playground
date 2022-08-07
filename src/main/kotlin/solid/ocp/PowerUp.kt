package solid.ocp

import kotlin.random.Random

abstract class PowerUp {
    abstract val basePower: Int
}

class Potion : PowerUp() {
    override val basePower: Int
        get() = 15

    val fat = 2
}

class EnergyDrink : PowerUp() {
    override val basePower: Int
        get() = 20

    val poisoningProbability = 30
}

class MedicalKit : PowerUp() {
    override val basePower: Int
        get() = 10

    val iron = 4
    val protein = 6
}

///////////////////

abstract class PowerUpOcpVersion {
    abstract val basePower: Int

    abstract fun consume(initialHealth: Int): Int
}

class PotionOcp : PowerUpOcpVersion() {
    private val fat = 2

    override val basePower: Int
        get() = 15

    override fun consume(initialHealth: Int) = initialHealth + basePower - fat
}

class EnergyDrinkOcp : PowerUpOcpVersion() {
    private val poisoningProbability = 30

    override val basePower: Int
        get() = 20

    override fun consume(initialHealth: Int): Int {
        var healthToReturn =
            initialHealth + basePower

        if (Random.nextInt(100) < poisoningProbability)
            healthToReturn = 5

        return healthToReturn
    }
}

class MedicalKitOcp : PowerUpOcpVersion() {
    private val iron = 4
    private val protein = 6

    override val basePower: Int
        get() = 10

    override fun consume(initialHealth: Int) = initialHealth + basePower * protein + iron
}

class Pills : PowerUpOcpVersion() {
    override val basePower: Int
        get() = 50

    override fun consume(initialHealth: Int) = initialHealth + basePower
}

