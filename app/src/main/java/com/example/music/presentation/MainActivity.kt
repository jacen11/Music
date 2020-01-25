package com.example.music.presentation

import android.os.Bundle
import android.os.Parcelable
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.music.App
import com.example.music.R
import com.example.music.adapter.LastFmAdapter
import com.example.music.model.lastfm.Track
import com.example.music.viewpager.ITunesFragment
import com.example.music.viewpager.LastFmFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.last_fm_item_fragment.*
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var presenter: Presenter

    val adapter = ViewPagerAdapter(supportFragmentManager)

    override fun onCreate(savedInstanceState: Bundle?) {

        App.appComponent?.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.attachView(this)

        setupViewPager(viewpager)
        tablayout.setupWithViewPager(viewpager)




        btnStartSearch.setOnClickListener {
            if (etNameTrack.text.toString().isNotBlank()) {
                presenter.searchTrack(etNameTrack.text.toString())
            } else {
                Toast.makeText(this, "Пустой запрос", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun setTrackList(list: List<Track>?) {

        if (list.isNullOrEmpty()) {
            Toast.makeText(this, "Результатов нет", Toast.LENGTH_LONG).show()
        } else {
            // val adapter = LastFmAdapter(list)
            val findFragmentById: LastFmFragment = adapter.getItem(0) as LastFmFragment
            // val findFragmentById: LastFmFragment = supportFragmentManager.findFragmentById(R.id.last_fm_list_fragment) as LastFmFragment
            val bundle = Bundle()
            //bundle.putParcelableArrayList("data", list as ArrayList<Track>)
            // findFragmentById.arguments = bundle

            findFragmentById.show(LastFmAdapter(list))

            //  rl.adap //. .setAdapter(adapter)

        }


    }

    fun showError() {
        Toast.makeText(this, "Произошла ошибка", Toast.LENGTH_LONG).show()
    }


    override fun onDestroy() {
        super.onDestroy()

        if (isFinishing) {
            App.appComponent = null
        }
    }

    private fun setupViewPager(viewPager: ViewPager) {
        adapter.addFragment(LastFmFragment(), resources.getString(R.string.last_fm))
        adapter.addFragment(ITunesFragment(), resources.getString(R.string.itunes))
        viewPager.adapter = adapter
    }

    class ViewPagerAdapter(manager: FragmentManager?) :
        FragmentPagerAdapter(manager) {

        private val mFragmentList: MutableList<Fragment> = ArrayList()
        private val mFragmentTitleList: MutableList<String> = ArrayList()

        override fun getItem(position: Int): Fragment = mFragmentList[position]

        override fun getCount(): Int = mFragmentList.size

        override fun getPageTitle(position: Int): CharSequence? = mFragmentTitleList[position]

        fun addFragment(fragment: Fragment, title: String) {
            mFragmentList.add(fragment)
            mFragmentTitleList.add(title)
        }

    }
}
