package com.wss.eat_space_iz.ui.viewModel.cartTab


import com.wss.eat_space_iz.repository.cartTab.CartTabRepository
import com.wss.eat_space_iz.ui.viewModel.base.BaseVM
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CartTabViewModel
@Inject constructor(private val repo: CartTabRepository) : BaseVM(){
}