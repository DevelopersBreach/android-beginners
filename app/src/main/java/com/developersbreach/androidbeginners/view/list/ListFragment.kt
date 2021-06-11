package com.developersbreach.androidbeginners.view.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.developersbreach.androidbeginners.Movie
import com.developersbreach.androidbeginners.MovieAdapter
import com.developersbreach.androidbeginners.MovieRepo
import com.developersbreach.androidbeginners.R


class ListFragment : Fragment() {

    private lateinit var viewPager: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewPager = view.findViewById(R.id.movie_view_pager)
        val listData = MovieRepo.data(requireContext())
        val adapter = MovieAdapter(listData, movieItemClickListener)
        viewPager.adapter = adapter
    }

    private val movieItemClickListener = MovieAdapter.OnClickListener { movie ->
        findNavController().navigate(
            ListFragmentDirections.listToDetailFragment(movie)
        )
    }
}