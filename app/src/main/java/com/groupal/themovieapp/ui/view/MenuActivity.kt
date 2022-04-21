package com.groupal.themovieapp.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.groupal.themovieapp.data.model.Menu
import com.groupal.themovieapp.databinding.ActivityMenuBinding
import com.groupal.themovieapp.ui.viewmodel.MenuViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MenuActivity : AppCompatActivity(), MenuAdapter.OnItemClickListener {

    private lateinit var binding: ActivityMenuBinding
    private val menuViewModel: MenuViewModel by viewModels()

    private lateinit var mRecyclerView : RecyclerView
    private val mAdapter : MenuAdapter = MenuAdapter(this)

    lateinit var clickListener: MenuAdapter.OnItemClickListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        menuViewModel.onCreate()

        mRecyclerView = binding.menuList;
        mRecyclerView.setHasFixedSize(true)

//        mAdapter.setMenus(it)

        mRecyclerView.layoutManager = GridLayoutManager(this, 2)
        mRecyclerView.adapter = mAdapter

        menuViewModel.menus.observe(this, Observer {
            //setear datos en recyleView

            mAdapter.setMenus(it)

        })
        menuViewModel.isLoading.observe(this, Observer {
            binding.loading.isVisible = it
        })

    }

    private fun launchMoviesActivity(characterId: String) {
        val intent: Intent = Intent(this, MovieActivity::class.java)
//        intent.putExtra("key_id", characterId)
        startActivity(intent)
    }

    override fun onItemClick(menu: Menu) {
//        Toast.makeText(this, "Item $position clicked", Toast.LENGTH_SHORT).show()
        val intent: Intent = Intent(this, MovieActivity::class.java)
//        intent.putExtra("key_id", characterId)
        startActivity(intent)
    }

}
