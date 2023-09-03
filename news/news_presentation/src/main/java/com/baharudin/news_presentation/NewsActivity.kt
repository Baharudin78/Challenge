package com.baharudin.news_presentation

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.baharudin.common_utils.Navigator
import com.baharudin.common_utils.view.gone
import com.baharudin.common_utils.view.visible
import com.baharudin.news_presentation.R
import com.baharudin.news_presentation.databinding.ActivityNewsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class NewsActivity : AppCompatActivity() {

    companion object{
        fun launchActivity(activity: Activity){
            val intent = Intent(activity, NewsActivity::class.java)
            activity.startActivity(intent)
        }
    }

    private lateinit var binding : ActivityNewsBinding
    private val viewModel : NewsViewModel by viewModels()
    private val newsAdapter = NewsAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setObserver()
        initView()
    }

    private fun initView(){
        binding.rvArticles.adapter = newsAdapter
    }
    private fun setObserver() {
        lifecycleScope.launch {
            viewModel.newsArticle.collectLatest {
                if (it.isLoading){
                    binding.progressBar.visible()
                }
                if (it.errorMessage?.isNotBlank() == true){
                    binding.progressBar.gone()
                    Toast.makeText(this@NewsActivity, it.errorMessage, Toast.LENGTH_SHORT).show()
                }
                it.data?.let {
                    binding.progressBar.gone()
                    newsAdapter.setData(it)
                }
            }
        }
    }
}

object GoToNewsActivity : Navigator {
    override fun navigate(activity: Activity) {
        NewsActivity.launchActivity(activity)
    }
}