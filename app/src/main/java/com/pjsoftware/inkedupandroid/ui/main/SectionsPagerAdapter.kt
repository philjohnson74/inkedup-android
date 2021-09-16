package com.pjsoftware.inkedupandroid.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.pjsoftware.inkedupandroid.R

private val TAB_TITLES = arrayOf(
    R.string.tab_text_pens,
    R.string.tab_text_ink
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        if(isTabClickedPens(position))
            return PensFragment.newInstance(position + 1)

        return InkFragment.newInstance(position + 1)
    }

    private fun isTabClickedPens(position: Int) = position == 0

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        // Show 2 total pages.
        return 2
    }
}