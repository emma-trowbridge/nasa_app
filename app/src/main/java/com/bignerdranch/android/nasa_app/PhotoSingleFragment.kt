package com.bignerdranch.android.nasa_app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import coil.load
import com.bignerdranch.android.nasa_app.databinding.FragmentPhotoSingleBinding

class PhotoSingleFragment : Fragment() {
    private var _binding: FragmentPhotoSingleBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPhotoSingleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Retrieve image URL and title from arguments
        val imageUrl = arguments?.getString("image_url") ?: ""
        val imageTitle = arguments?.getString("image_title") ?: ""

        // Load image using Coil and set the title
        binding.imageView.load(imageUrl)
        binding.titleTextView.text = imageTitle
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
