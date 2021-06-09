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
import com.developersbreach.androidbeginners.Movie
import com.developersbreach.androidbeginners.MovieAdapter
import com.developersbreach.androidbeginners.MovieRepo
import com.developersbreach.androidbeginners.R


class ListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.movie_recycler_view)
        val editText: EditText = view.findViewById(R.id.movie_edit_text)
        val clearQueryImageView: ImageView = view.findViewById(R.id.clear_query_icon)

        val movieList: List<Movie> = MovieRepo.data(requireContext())
        showData(movieList)

        editText.doOnTextChanged { userQuery, _, _, _ ->

            val filterList = ArrayList<Movie>()

            if (!userQuery.isNullOrEmpty()) {
                for (currentTitle in movieList) {
                    if (currentTitle.title!!.lowercase().contains(userQuery)) {
                        filterList.add(currentTitle)
                    }
                    showData(filterList)
                }

                clearQueryImageView.visibility = View.VISIBLE

            } else {
                showData(movieList)
                clearQueryImageView.visibility = View.INVISIBLE
            }
        }

        clearQueryImageView.setOnClickListener {
            editText.setText("")
        }
    }

    private fun showData(listData: List<Movie>) {
        val adapter = MovieAdapter(listData, movieItemClickListener)
        recyclerView.adapter = adapter
    }

    val movieItemClickListener = MovieAdapter.OnClickListener { movie ->
        findNavController().navigate(
            ListFragmentDirections.listToDetailFragment(movie)
        )
    }
}