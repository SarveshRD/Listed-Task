package com.wss.eat_space_iz.ui.fragment.homeTab

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.wss.eat_space_iz.data.networkModels.listed.ListedResponse
import com.wss.eat_space_iz.data.networkModels.listed.RecentLink
import com.wss.eat_space_iz.data.networkModels.listed.TopLink
import com.wss.eat_space_iz.databinding.FragmentHomeTabBinding
import com.wss.eat_space_iz.ui.adapter.profileTab.CategoriesAdapter
import com.wss.eat_space_iz.ui.adapter.profileTab.HistoryAdapter
import com.wss.eat_space_iz.ui.adapter.profileTab.PopularNearYouAdapter
import com.wss.eat_space_iz.ui.common.ApiRenderState
import com.wss.eat_space_iz.ui.fragment.base.BaseFrag
import com.wss.eat_space_iz.ui.viewModel.homeTab.HomeTabViewModel
import com.wss.eat_space_iz.utils.Drawables
import com.wss.eat_space_iz.utils.Layouts
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeTabFragment :
    BaseFrag<FragmentHomeTabBinding, HomeTabViewModel>(Layouts.fragment_home_tab) {


    private lateinit var mPopularNearYouAdapter: PopularNearYouAdapter
    private lateinit var mPopularNearYouDataList: List<Any>

    private var mCategoriesAdapter: CategoriesAdapter? = null
    private var mCategoriesDataList= ArrayList<TopLink>()

    private var mHistoryAdapter: HistoryAdapter? = null
    private var mHistoryDataList= ArrayList<RecentLink>()


    private val itemList = listOf(
        Item("", "123","Today Click"),
        Item("", "Ahmedabad","Tap Location"),
        Item("", "Instagram","Top source")
    )

    companion object {
        private val lineSet = listOf(
            "label1" to 20f,
            "label2" to 5f,
            "label3" to 4f,
            "label4" to 16f,
            "label5" to 11f,
            "label6" to 29f,
            "label7" to 6f,
            "label8" to 3f,
            "label9" to 8f,
            "label10" to 7f,
            "label11" to 5f,
            "label12" to 2f
        )

        private const val animationDuration = 1000L
    }



    override val hasProgress: Boolean = false
    override fun getViewBinding() = FragmentHomeTabBinding.inflate(layoutInflater)
    override val vm: HomeTabViewModel by viewModels()

    override fun init() {
        setUpListener()
        setupPopularNearYouRecyclerView(itemList)
        listed()
        lineGraph()
    }

    private fun listed() {
        vm.topLink()
    }

    private fun lineGraph() {

        binding.homeCategories.lineChart.gradientFillColors =
            intArrayOf(
                Color.parseColor("#81FFFFFF"),
                Color.TRANSPARENT
            )
        binding.homeCategories.lineChart.animation.duration = animationDuration
        binding.homeCategories.lineChart.onDataPointTouchListener = { index, _, _ ->

        }
        binding.homeCategories.lineChart.animate(lineSet)


    }
    private fun setUpListener() {
        with(binding) {
            homeDealOfTheDay.tvOngoing.setOnClickListener(this@HomeTabFragment)
            homeDealOfTheDay.tvHistory.setOnClickListener(this@HomeTabFragment)
            homeAllRestaurents.tvAllRestaurants.setOnClickListener(this@HomeTabFragment )
        }
    }

    override fun renderState(apiRenderState: ApiRenderState) {
        when (apiRenderState) {
            is ApiRenderState.Loading -> {
                showProgress()
            }
            is ApiRenderState.ApiSuccess<*> -> {
                when (apiRenderState.result) {
                    is ListedResponse -> {
                        val model = apiRenderState.result
                        model.status.let {
                            //when (it) {
                             //   getString(Strings.api_success_status) -> {
                                    mCategoriesDataList = model.data.topLinks as ArrayList<TopLink>
                                    setupCategoriesRecyclerView(mCategoriesDataList)

                            mHistoryDataList = model.data.recentLinks as ArrayList<RecentLink>
                         //   setupHistoryRecyclerView(mHistoryDataList)


                            //   }
                           //     else -> {}
                           // }
                        }
                    }
                }
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
              /*  homeDealOfTheDay.tvOngoing -> {
                    setupCategoriesRecyclerView(mCategoriesDataList, ONGOING_ORDERS)
                }*/
                homeDealOfTheDay.tvHistory -> {
                    homeDealOfTheDay.tvHistory.background = ContextCompat.getDrawable(
                        requireContext(), Drawables.tv_order_type_bg
                    )
                    homeDealOfTheDay.tvOngoing.background = null
                    setupHistoryRecyclerView(mHistoryDataList)
                }


                homeAllRestaurents.tvAllRestaurants -> {

                    val text = "This is a test"
                    val toNumber = "8297368106"
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data =
                        Uri.parse("http://api.whatsapp.com/send?phone=$toNumber&text=$text")
                    startActivity(intent)

                }
            }
        }
    }

    private fun setupPopularNearYouRecyclerView(data: List<Item>) {

        mPopularNearYouDataList = data
        if (mPopularNearYouDataList.isNotEmpty()) {
            mPopularNearYouAdapter = PopularNearYouAdapter(data)
            binding.homePopularNearYou.rvPopularNearYou.adapter = mPopularNearYouAdapter
        }
         /*   mPopularNearYouAdapter.setOnItemClickListener(object :
                PopularNearYouAdapter.OnItemClickListener {
                override fun onItemClick(position: Int, v: View) {
                    openRestaurantDetails(position)
                }
            })*/

    }
    private fun openRestaurantDetails(position: Int) {
        val restaurantId = mPopularNearYouDataList?.get(position)
        val action = restaurantId?.let { HomeTabFragmentDirections.actionHomeTabFragmentToScheduleTripFragment() }
        if (action != null) {
            findNavController().navigate(action)
        }
    }
    private fun setupCategoriesRecyclerView(data: ArrayList<TopLink>) {
        mCategoriesDataList = data
        if (mCategoriesDataList.isNotEmpty()) {
            mCategoriesAdapter = CategoriesAdapter(data)
            binding.homeRecommended.rvCategories.adapter = mCategoriesAdapter
        }
    }

    private fun setupHistoryRecyclerView(data: ArrayList<RecentLink>) {
        mHistoryDataList = data
        if (mHistoryDataList.isNotEmpty()) {
            mHistoryAdapter = HistoryAdapter(data)
            binding.homeRecommended.rvCategories.adapter = mHistoryAdapter
        }
    }
}