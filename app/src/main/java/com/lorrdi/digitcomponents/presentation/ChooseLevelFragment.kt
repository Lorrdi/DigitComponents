package com.lorrdi.digitcomponents.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.lorrdi.digitcomponents.databinding.FragmentChooseLevelBinding
import com.lorrdi.digitcomponents.domain.entity.Level

class ChooseLevelFragment : Fragment() {


    private var _binding: FragmentChooseLevelBinding? = null
    private val binding: FragmentChooseLevelBinding
        get() = _binding ?: throw RuntimeException("FragmentChooseLevelBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChooseLevelBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonTestLevel.setOnClickListener { launchGameFragment(Level.TEST) }
        binding.buttonEasyLevel.setOnClickListener { launchGameFragment(Level.EASY) }
        binding.buttonNormalLevel.setOnClickListener { launchGameFragment(Level.NORMAL) }
        binding.buttonHardLevel.setOnClickListener { launchGameFragment(Level.HARD) }

    }

    private fun launchGameFragment(level: Level) {
        findNavController().navigate(
            ChooseLevelFragmentDirections.actionChooseLevelFragment2ToGameFragment2(
                level
            )
        )
    }
}
