package com.developersbreach.androidbeginners.view.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.developersbreach.androidbeginners.R
import com.developersbreach.androidbeginners.model.Student
import com.developersbreach.androidbeginners.utils.getSportImage

class DetailFragment : Fragment() {

    private lateinit var student: Student

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        student = DetailFragmentArgs.fromBundle(requireArguments()).studentDetailArgs
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val detailTitleTextView = view.findViewById<TextView>(R.id.detail_student_name_text_view)
        val detailSportImageView = view.findViewById<ImageView>(R.id.detail_student_sport_image_view)
        detailTitleTextView.text = student.name
        val sportImage: Int = getSportImage(student.favoriteSport)
        Glide.with(requireContext()).load(sportImage).into(detailSportImageView)
    }
}
