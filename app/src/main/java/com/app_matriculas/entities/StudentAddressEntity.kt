package com.app_matriculas.entities

import androidx.room.Embedded
import androidx.room.Relation

data class StudentAddressEntity(
    @Embedded val studentEntity: StudentEntity,
    @Relation(
        parentColumn = "",
        entityColumn = ""
    )
    val addressEntity: AddressEntity
)