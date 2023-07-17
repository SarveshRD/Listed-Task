package com.wss.eat_space_iz.ui.fragment.cartTab

import android.view.View
import androidx.fragment.app.viewModels
import com.wss.eat_space_iz.databinding.FragmentCartTabBinding
import com.wss.eat_space_iz.ui.common.ApiRenderState
import com.wss.eat_space_iz.ui.fragment.base.BaseFrag
import com.wss.eat_space_iz.ui.viewModel.cartTab.CartTabViewModel
import com.wss.eat_space_iz.utils.Layouts
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CartTabFragment : BaseFrag<FragmentCartTabBinding, CartTabViewModel>(Layouts.fragment_cart_tab) {

    override val hasProgress: Boolean = false

    override fun getViewBinding() =  FragmentCartTabBinding.inflate(layoutInflater)

    override val vm: CartTabViewModel by viewModels()

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
            when (v)
            {

            }
        }
    }
}