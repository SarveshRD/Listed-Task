package com.wss.eat_space_iz.ui.viewModel.blogsTab

import com.wss.eat_space_iz.repository.blogsTab.BlogTabRepository
import com.wss.eat_space_iz.ui.viewModel.base.BaseVM
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class BlogsTabViewModel
@Inject constructor(private val repo: BlogTabRepository) :BaseVM() {




}