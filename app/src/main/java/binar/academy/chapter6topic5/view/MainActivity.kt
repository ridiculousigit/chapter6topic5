package binar.academy.chapter6topic5.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import binar.academy.chapter6topic5.databinding.ActivityMainBinding
import binar.academy.chapter6topic5.viewmodel.ViewModelMakeup
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MakeUpAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setVmtoAdapter()
    }

    private fun setVmtoAdapter(){

        val viewModel = ViewModelProvider(this).get(ViewModelMakeup::class.java)
        viewModel.callApi()
        viewModel.getliveDataMakeup().observe(this, Observer {

            adapter = MakeUpAdapter(it)

            if ( it != null){

                binding.rvMakeup.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                binding.rvMakeup.adapter = MakeUpAdapter(it)

            }
        })
    }
}