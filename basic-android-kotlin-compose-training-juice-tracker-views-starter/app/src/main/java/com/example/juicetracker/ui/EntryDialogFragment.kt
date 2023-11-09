package com.example.juicetracker.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.juicetracker.data.Juice
import com.example.juicetracker.data.JuiceColor
import com.example.juicetracker.databinding.FragmentEntryDialogBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class EntryDialogFragment : BottomSheetDialogFragment() {

    var selectedColor: JuiceColor = JuiceColor.Red
    private val entryViewModel by viewModels<EntryViewModel> { AppViewModelProvider.Factory }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentEntryDialogBinding.inflate(inflater, container, false).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val binding = FragmentEntryDialogBinding.bind(view)
        val args: EntryDialogFragmentArgs by navArgs()
        val juiceId = args.itemId

        binding.name.setText("Apple Juice")
        binding.saveButton.setOnClickListener {
            entryViewModel.saveJuice(
                id = juiceId,
                name = binding.name.text.toString(),
                description = binding.description.text.toString(),
                color = selectedColor.name,
                rating = binding.ratingBar.rating.toInt()
            )
            dismiss()
        }
    }

}