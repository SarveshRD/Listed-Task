package com.wss.eat_space_iz.ui.viewModel.searchTab


import com.wss.eat_space_iz.repository.searchTab.SearchTabRepository
import com.wss.eat_space_iz.ui.viewModel.base.BaseVM
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchTabViewModel
@Inject constructor(private val repo: SearchTabRepository) : BaseVM(){
}