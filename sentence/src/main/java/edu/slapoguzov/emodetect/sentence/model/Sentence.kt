package edu.slapoguzov.emodetect.sentence.model

data class Sentence(
        val clauses: List<Clause>,
        override val valence: Double
) : Valenced {
    val allWords = clauses.flatMap { it.words + it.relatedClauses.flatMap { it.clause.words } }.toSet()

    override fun toString(): String {
        return "\nSentence(\n\tclauses=\n\t\t${clauses.joinToString("\n\t\t")}, \n\tvalence=$valence)"
    }
}