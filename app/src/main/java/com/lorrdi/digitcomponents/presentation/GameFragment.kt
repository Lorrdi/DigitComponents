package com.lorrdi.digitcomponents.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.lorrdi.digitcomponents.R
import com.lorrdi.digitcomponents.databinding.FragmentGameBinding
import com.lorrdi.digitcomponents.domain.entity.GameResult
import com.lorrdi.digitcomponents.domain.entity.GameSettings
import com.lorrdi.digitcomponents.domain.entity.Level

class GameFragment : Fragment() {
    private lateinit var level: Level
    private var _binding: FragmentGameBinding? = null
    private val binding: FragmentGameBinding
        get() = _binding ?: throw RuntimeException("FragmentGameBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseArgs()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvOption1.setOnClickListener {
            launchGameFinishedFragment(
                GameResult(
                    true,
                    10,
                    10,
                    GameSettings(0, 0, 0, 0)
                )
            )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun parseArgs() {
        level = requireArguments().getSerializable(KEY_LEVEL, Level::class.java) as Level
    }

    private fun launchGameFinishedFragment(gameResult: GameResult) {
        requireActivity().supportFragmentManager.beginTransaction().addToBackStack(null).replace(
            R.id.main_container, GameFinishedFragment.newInstance(gameResult)
        ).commit()
    }

    companion object {
        const val NAME = "GameFragment"
        private const val KEY_LEVEL = "level"
        fun newInstance(level: Level): GameFragment {
            val fragment = GameFragment().apply {
                this.arguments = Bundle().apply {
                    putSerializable(KEY_LEVEL, level)
                }
            }
            return fragment
        }
    }
}