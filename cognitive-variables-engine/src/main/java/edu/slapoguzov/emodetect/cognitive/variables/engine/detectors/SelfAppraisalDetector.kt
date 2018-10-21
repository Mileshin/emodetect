package edu.slapoguzov.emodetect.cognitive.variables.engine.detectors

import edu.slapoguzov.emodetect.occ.model.variables.SelfAppraisal
import edu.slapoguzov.emodetect.sentence.model.Characteristic
import edu.slapoguzov.emodetect.sentence.model.Sentence

class SelfAppraisalDetector : VariableDetector<SelfAppraisal> {
    override fun detect(sentence: Sentence): SelfAppraisal? {
        val action = sentence.allWords.find { it.characteristics.contains(Characteristic.IS_ACTION) }
                ?: return SelfAppraisal.NEUTRAL
        if (action.valence > 0.5) return SelfAppraisal.PRAISEWORTHY
        if (action.valence < -0.5) return SelfAppraisal.BLAMEWORTHY
        return SelfAppraisal.NEUTRAL
    }
}