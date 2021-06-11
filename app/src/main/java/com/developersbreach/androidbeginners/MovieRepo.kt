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
            context.getString(R.string.overview_frozen),
            R.color.candy
        ),
        Movie(
            2,
            "Moana",
            R.drawable.moana,
            context.getString(R.string.overview_moana),
            R.color.mauve
        ),
        Movie(
            3,
            "The Baby Boss",
            R.drawable.baby_boss,
            context.getString(R.string.overview_the_boss_baby),
            R.color.cherry
        ),
        Movie(
            4,
            "Tangled",
            R.drawable.tangled,
            context.getString(R.string.overview_tangled),
            R.color.teal
        ),
        Movie(
            5,
            "Despicable Me",
            R.drawable.despicable_me,
            context.getString(R.string.overview_despicable_me),
            R.color.candy
        ),
        Movie(
            6,
            "Kung Fu Panda",
            R.drawable.kung_fu_panda,
            context.getString(R.string.overview_kung_fu_panda),
            R.color.mauve
        ),
        Movie(
            7,
            "Toy Story",
            R.drawable.toy_story,
            context.getString(R.string.overview_toy_story),
            R.color.cherry
        ),
        Movie(
            8,
            "Wall-E",
            R.drawable.wall_e,
            context.getString(R.string.overview_wall_e),
            R.color.teal
        ),
        Movie(
            9,
            "Up",
            R.drawable.up,
            context.getString(R.string.overview_up),
            R.color.candy
        ),
        Movie(
            10,
            "The Incredibles",
            R.drawable.the_incredibles,
            context.getString(R.string.overview_the_incredibles),
            R.color.candy
        ),
        Movie(
            11,
            "Ice Age",
            R.drawable.ice_age,
            context.getString(R.string.overview_ice_age),
            R.color.candy
        ),
        Movie(
            12, "Finding Nemo", R.drawable.finding_nemo,
            context.getString(R.string.overview_finding_nemo),
            R.color.candy
        ),
    )
}