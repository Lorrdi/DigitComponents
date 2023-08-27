package com.lorrdi.digitcomponents.domain.repository

import com.lorrdi.digitcomponents.domain.entity.GameSettings
import com.lorrdi.digitcomponents.domain.entity.Level
import com.lorrdi.digitcomponents.domain.entity.Question

interface GameRepository {
    fun generateQuestion(maxSumValue: Int, countOfOptions: Int): Question
    fun getGameSettings(level: Level): GameSettings
}