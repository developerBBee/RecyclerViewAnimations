package com.example.recyclerviewanimations.list

import java.util.UUID

data class MyItem(
    val uuid: UUID = UUID.randomUUID(),
    val title: String,
    val description: String
)
