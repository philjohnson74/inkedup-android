package com.pjsoftware.inkedupandroid.repository

import com.pjsoftware.inkedupandroid.api.Pen
import com.pjsoftware.inkedupandroid.db.PenEntity

class PenMapper {
    fun serviceToEntity(pen: Pen): PenEntity {
        return PenEntity(pen.manufacturer, pen.model, pen.ink)
    }
}