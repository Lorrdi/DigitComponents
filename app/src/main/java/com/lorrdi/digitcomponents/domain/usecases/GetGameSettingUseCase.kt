package com.lorrdi.digitcomponents.domain.usecases

import com.lorrdi.digitcomponents.domain.entity.GameSettings
import com.lorrdi.digitcomponents.domain.entity.Level
import com.lorrdi.digitcomponents.domain.repository.GameRepository

class GetGameSettingUseCase(private val repository: GameRepository) {

    operator fun invoke(level: Level): GameSettings {
        return repository.getGameSettings(level)
    }
}