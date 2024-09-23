package com.example.recyclerviewanimations

import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.recyclerviewanimations.databinding.ActivityMainBinding
import com.example.recyclerviewanimations.list.MyAnimator
import com.example.recyclerviewanimations.list.MyItem
import com.example.recyclerviewanimations.list.MyListAdapter

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val myAdapter = MyListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.recyclerView.apply {
            adapter = myAdapter
            itemAnimator = MyAnimator()
        }

        binding.add.setOnClickListener {
            val title = binding.titleEdit.text.toString()
            val description = binding.descriptionEdit.text.toString()
            if (title.isNotEmpty() && description.isNotEmpty()) {
                myAdapter.addItem(MyItem(title = title, description = description))
            }
        }
    }
}