package com.developersbreach.androidbeginners

import android.content.Context

object MovieRepo {

    fun data(
        context: Context
    ) = listOf(
        Movie(
            1,
            "Frozen",
            R.drawable.frozen,
            context.getString(R.string.overview_frozen)
        ),
        Movie(
            2,
            "Moana",
            R.drawable.moana,
            context.getString(R.string.overview_moana)
        ),
        Movie(
            3,
            "The Baby Boss",
            R.drawable.baby_boss,
            context.getString(R.string.overview_the_boss_baby)
        ),
        Movie(
            4,
            "Tangled",
            R.drawable.tangled,
            context.getString(R.string.overview_tangled)
        ),
        Movie(
            5,
            "Despicable Me",
            R.drawable.despicable_me,
            context.getString(R.string.overview_despicable_me)
        ),
        Movie(
            6,
            "Kung Fu Panda",
            R.drawable.kung_fu_panda,
            context.getString(R.string.overview_kung_fu_panda)
        ),
        Movie(
            7,
            "Toy Story",
            R.drawable.toy_story,
            context.getString(R.string.overview_toy_story)
        ),
        Movie(
            8,
            "Wall-E",
            R.drawable.wall_e,
            context.getString(R.string.overview_wall_e)
        ),
        Movie(
            9,
            "Up",
            R.drawable.up,
            context.getString(R.string.overview_up)
        ),
        Movie(
            10,
            "The Incredibles",
            R.drawable.the_incredibles,
            context.getString(R.string.overview_the_incredibles)
        ),
        Movie(
            11,
            "Ice Age",
            R.drawable.ice_age,
            context.getString(R.string.overview_ice_age)
        ),
        Movie(
            12, "Finding Nemo", R.drawable.finding_nemo,
            context.getString(R.string.overview_finding_nemo)
        ),
    )
}