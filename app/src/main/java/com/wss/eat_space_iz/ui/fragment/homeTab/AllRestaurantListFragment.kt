package com.wss.eat_space_iz.ui.fragment.homeTab


import android.view.View
import androidx.fragment.app.viewModels
import com.wss.eat_space_iz.databinding.FragmentAllRestaurantListBinding
import com.wss.eat_space_iz.ui.common.ApiRenderState
import com.wss.eat_space_iz.ui.fragment.base.BaseFrag
import com.wss.eat_space_iz.ui.viewModel.homeTab.AllRestaurantListViewModel
import com.wss.eat_space_iz.utils.Layouts
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AllRestaurantListFragment :
    BaseFrag<FragmentAllRestaurantListBinding, AllRestaurantListViewModel>(Layouts.fragment_all_restaurant_list) {

    override val hasProgress: Boolean = false

    override fun getViewBinding() = FragmentAllRestaurantListBinding.inflate(layoutInflater)

    override val vm: AllRestaurantListViewModel by viewModels()

    override fun init() {
        setUpListener()
    }

    private fun setUpListener() {
        with(binding) {

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
            when (v) {

            }
        }
    }
}