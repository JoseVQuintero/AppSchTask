package com.joe.appschtask.fragment.tabs.task

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.graphics.BlendModeColorFilterCompat
import androidx.core.graphics.BlendModeCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.joe.appschtask.R
import com.joe.appschtask.adapter.TaskAdapter
import com.joe.appschtask.adapter.listener.ListenerTask
import com.joe.appschtask.adapter.pager.TabsTask
import com.joe.appschtask.domain.Task
import kotlinx.android.synthetic.main.fragment_task.*
import kotlinx.android.synthetic.main.fragment_task.view.*

class TaskFragment: Fragment(), ListenerTask, View.OnClickListener, TaskInteractor.View, TabLayout.OnTabSelectedListener {
    private val tasks = listOf<Task>()
    private var adapter: TaskAdapter? = null
    private var presenter: TaskPresenter? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_task, container, false)

        // Tabs Customization
        view.tab_layout.setSelectedTabIndicatorColor(Color.WHITE)
        view.tab_layout.setBackgroundColor(ContextCompat.getColor(view.context, R.color.colorPrimaryDark))
        view.tab_layout.tabTextColors = ContextCompat.getColorStateList(view.context, android.R.color.white)

        // Set different Text Color for Tabs for when are selected or not
        //tab_layout.setTabTextColors(R.color.normalTabTextColor, R.color.selectedTabTextColor)

        // Number Of Tabs
        val numberOfTabs = 3

        // Set Tabs in the center
        //tab_layout.tabGravity = TabLayout.GRAVITY_CENTER

        // Show all Tabs in screen
        view.tab_layout.tabMode = TabLayout.MODE_FIXED

        // Scroll to see all Tabs
        //tab_layout.tabMode = TabLayout.MODE_SCROLLABLE

        // Set Tab icons next to the text, instead above the text
        view.tab_layout.isInlineLabel = true

        // Set the ViewPager Adapter
        val adapter = TabsTask(childFragmentManager, lifecycle, numberOfTabs)
        view.tabs_viewpager.adapter = adapter

        // Enable Swipe
        view.tabs_viewpager.isUserInputEnabled = true

        // Link the TabLayout and the ViewPager2 together and Set Text & Icons
        TabLayoutMediator(view.tab_layout, view.tabs_viewpager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Today"
                    tab.setIcon(R.drawable.ic_music)
                }
                1 -> {
                    tab.text = "Attend"
                    tab.setIcon(R.drawable.ic_movie)

                }
                2 -> {
                    tab.text = "Justify"
                    tab.setIcon(R.drawable.ic_book)
                }

            }
            // Change color of the icons
            tab.icon?.colorFilter =
                BlendModeColorFilterCompat.createBlendModeColorFilterCompat(
                    Color.WHITE,
                    BlendModeCompat.SRC_ATOP
                )
        }.attach()

        return view
    }

    override fun onTabReselected(tab: TabLayout.Tab?) {
        TODO("Not yet implemented")
    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {
        TODO("Not yet implemented")
    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
        TODO("Not yet implemented")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = TaskPresenter(requireContext(),this)

        setupAdapter()
        setupAction()
    }

    private fun setupAction(){

    }

    private fun setupAdapter(){
        adapter = TaskAdapter(requireContext(), tasks, this)

        rvTasks.setHasFixedSize(true)
        rvTasks.layoutManager = LinearLayoutManager(requireContext())
        rvTasks.adapter = this.adapter
    }

    override fun onResume() {
        super.onResume()
        presenter?.getTask()
    }

    override fun onSuccess() {
        Toast.makeText(requireContext(),"Create note success", Toast.LENGTH_SHORT).show()
    }

    override fun setTasks(tasks: List<Task>) {
        adapter?.updateData(tasks)
    }

    override fun onClickTask(task: Task) {
        val bundle = Bundle()

    }

    override fun onClick(v: View?) {

    }
}