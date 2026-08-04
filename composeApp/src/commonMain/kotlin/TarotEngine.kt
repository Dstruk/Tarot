import kotlin.math.abs

data class TarotCard(
    val id: Int,
    val name: String,
    val arcana: String,
    val meaningGeneral: String,
    val energy: String
)

object TarotEngine {
    val majorArcana = listOf(
        TarotCard(0, "El Loco", "Mayor", "Nuevos comienzos, espontaneidad, fe en el futuro.", "Positiva"),
        TarotCard(1, "El Mago", "Mayor", "Manifestación, poder personal, acción inspirada.", "Positiva"),
        TarotCard(2, "La Sacerdotisa", "Mayor", "Intuición, misterio, subconsciente.", "Neutral"),
        TarotCard(3, "La Emperatriz", "Mayor", "Fertilidad, creatividad, abundancia.", "Positiva"),
        TarotCard(4, "El Emperador", "Mayor", "Autoridad, estructura, estabilidad.", "Positiva"),
        TarotCard(5, "El Hierofante", "Mayor", "Tradición, conformidad, guía espiritual.", "Neutral"),
        TarotCard(6, "Los Enamorados", "Mayor", "Amor, armonía, relaciones, elecciones.", "Positiva"),
        TarotCard(7, "El Carro", "Mayor", "Control, voluntad, victoria, éxito.", "Positiva"),
        TarotCard(8, "La Fuerza", "Mayor", "Fuerza interior, coraje, compasión.", "Positiva"),
        TarotCard(9, "El Ermitaño", "Mayor", "Introspección, soledad, búsqueda de la verdad.", "Neutral"),
        TarotCard(10, "La Rueda de la Fortuna", "Mayor", "Cambio, ciclos, destino, suerte.", "Neutral"),
        TarotCard(11, "La Justicia", "Mayor", "Equilibrio, verdad, ley, causa y efecto.", "Neutral"),
        TarotCard(12, "El Colgado", "Mayor", "Pausa, rendición, nueva perspectiva.", "Neutral"),
        TarotCard(13, "La Muerte", "Mayor", "Finales, transformación, transición.", "Neutral"),
        TarotCard(14, "La Templanza", "Mayor", "Paciencia, moderación, equilibrio.", "Positiva"),
        TarotCard(15, "El Diablo", "Mayor", "Adicción, apego, sombras.", "Negativa"),
        TarotCard(16, "La Torre", "Mayor", "Cambio repentino, caos, revelación.", "Negativa"),
        TarotCard(17, "La Estrella", "Mayor", "Esperanza, renovación, espiritualidad.", "Positiva"),
        TarotCard(18, "La Luna", "Mayor", "Miedo, ilusión, ansiedad, subconsciente.", "Negativa"),
        TarotCard(19, "El Sol", "Mayor", "Éxito, felicidad, vitalidad.", "Positiva"),
        TarotCard(20, "El Juicio", "Mayor", "Reflexión, despertar, propósito.", "Neutral"),
        TarotCard(21, "El Mundo", "Mayor", "Finalización, integración, viaje.", "Positiva")
    )

    /**
     * Selecciona una carta basada en el nombre de usuario y el tiempo.
     * Esto crea una "huella digital" para la lectura.
     */
    fun getCardForUser(username: String): TarotCard {
        val timeSeed = getEpochMillis() / (1000 * 60) // Cambia cada minuto para el mismo usuario
        val seed = username.hashCode().toLong() + timeSeed
        val index = abs(seed.toInt()) % majorArcana.size
        return majorArcana[index]
    }
}
