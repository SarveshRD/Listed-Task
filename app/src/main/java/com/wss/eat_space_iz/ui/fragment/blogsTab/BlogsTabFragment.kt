package com.wss.eat_space_iz.ui.fragment.blogsTab

import android.view.View
import com.wss.eat_space_iz.databinding.FragmentBlogsTabBinding
import com.wss.eat_space_iz.utils.Layouts
import com.wss.eat_space_iz.ui.common.ApiRenderState
import com.wss.eat_space_iz.ui.fragment.base.BaseFrag
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.wss.eat_space_iz.ui.viewModel.blogsTab.BlogsTabViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BlogsTabFragment : BaseFrag<FragmentBlogsTabBinding, BlogsTabViewModel>(Layouts.fragment_blogs_tab) {

    override val hasProgress: Boolean = false
    override fun getViewBinding() =  FragmentBlogsTabBinding.inflate(layoutInflater)
    override val vm: BlogsTabViewModel by viewModels()

    override fun init() {
        setUpListener()
    }

    private fun setUpListener() {
        with(binding) {
            tvFollowers.setOnClickListener(this@BlogsTabFragment)
            tvFollowing.setOnClickListener(this@BlogsTabFragment)
            tvFollowersCount.setOnClickListener(this@BlogsTabFragment)
            tvFollowingCount.setOnClickListener(this@BlogsTabFragment)
        }
    }

    override fun renderState(apiRenderState: ApiRenderState) {
        when (apiRenderState) {
            is ApiRenderState.Loading -> {
                showProgress()
            }
            is ApiRenderState.ApiSuccess<*> -> {

            }
            is ApiRenderState.ValidationError -> {
                apiRenderState.message?.let {
                    errorToast(getString(it))
                }
            }
            is ApiRenderState.ApiError<*> -> {
                errorToast(apiRenderState.error.toString())
            }
            else -> {}
        }
    }

    override fun onClick(v: View) {
        super.onClick(v)
        with(binding)
        {
            when (v)
            {
                tvFollowers -> {
                    val action = BlogsTabFragmentDirections.actionBlogsTabFragmentToFollowerAndFollowingFragment(isFollower = true)
                    findNavController().navigate(action)
                }
                tvFollowing -> {
                    val action = BlogsTabFragmentDirections.actionBlogsTabFragmentToFollowerAndFollowingFragment(isFollower = false)
                    findNavController().navigate(action)
                }
                tvFollowersCount -> {
                    val action = BlogsTabFragmentDirections.actionBlogsTabFragmentToFollowerAndFollowingFragment(isFollower = true)
                    findNavController().navigate(action)
                }
                tvFollowingCount -> {
                    val action = BlogsTabFragmentDirections.actionBlogsTabFragmentToFollowerAndFollowingFragment(isFollower = false)
                    findNavController().navigate(action)
                }

                else -> {}
            }
        }
    }
}