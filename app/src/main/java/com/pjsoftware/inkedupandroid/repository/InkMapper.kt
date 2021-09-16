package com.pjsoftware.inkedupandroid.repository

import com.pjsoftware.inkedupandroid.api.Ink
import com.pjsoftware.inkedupandroid.db.InkEntity

class InkMapper {
    fun serviceToEntity(ink: Ink): InkEntity {
        return InkEntity(ink.manufacturer, ink.color)
    }
}