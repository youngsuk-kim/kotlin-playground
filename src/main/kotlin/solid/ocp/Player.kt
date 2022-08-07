package solid.ocp

import kotlin.random.Random

class Player {

    var health: Int = 100

    fun getPowerUp(powerUp: PowerUp) {

        when(powerUp) {
            is Potion -> {
                health += powerUp.basePower - powerUp.fat
            }
            is EnergyDrink -> {
                health += powerUp.basePower
                if(Random.nextInt(100) > powerUp.poisoningProbability)
                    health = 5
            }
            is MedicalKit -> {
                health += powerUp.basePower * powerUp.protein + powerUp.iron
            }
        }
    }

    ///////////////////////////

    fun getPowerUpOcpVersion(powerUp: PowerUpOcpVersion) {
        health = powerUp.consume(health)
    }
}
