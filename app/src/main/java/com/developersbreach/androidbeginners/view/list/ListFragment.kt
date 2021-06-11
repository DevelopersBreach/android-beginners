package com.developersbreach.androidbeginners.view.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.developersbreach.androidbeginners.MovieAdapter
import com.developersbreach.androidbeginners.MovieRepo
import com.developersbreach.androidbeginners.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tabLayout: TabLayout = view.findViewById(R.id.movie_tab_layout)
        val viewPager: ViewPager2 = view.findViewById(R.id.movie_view_pager)

        val listData = MovieRepo.data(requireContext())
        val adapter = MovieAdapter(listData, movieItemClickListener)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            for (item in listData) {
                // To start from 0
                // We are starting at 1
                // Diff is +1
                when (position + 1) {
                    item.movieId -> {
                        // Executes only when position == item.movieId
                        tab.text = item.title
                    }
                }
            }
        }.attach()
    }

    private val movieItemClickListener = MovieAdapter.OnClickListener { movie ->
        findNavController().navigate(
            ListFragmentDirections.listToDetailFragment(movie)
        )
    }
}