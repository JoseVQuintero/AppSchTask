package com.joe.appschtask.presentation.container

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import com.joe.appschtask.R
import com.joe.appschtask.fragment.tabs.settings.SettingsFragment
import com.joe.appschtask.fragment.tabs.task.TaskFragment
import com.joe.appschtask.fragment.tabs.taskuser.TaskUserFragment
import com.joe.appschtask.presentation.main.MainActivity
import kotlinx.android.synthetic.main.activity_container.*

class ContainerActivity : AppCompatActivity(),
    TabLayout.OnTabSelectedListener,
    BottomNavigationView.OnNavigationItemSelectedListener,
    ContainerContract.View {
    private var presenter: ContainerPresenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_container)

        replaceFragment(TaskFragment(),"",this)
        bottomNavigation.setOnNavigationItemSelectedListener(this)
        presenter = ContainerPresenter(this, this)
        // Set the toolbar as support action bar
        setSupportActionBar(toolbar)

        supportActionBar?.apply {
            // Set toolbar title/app title
            //title = "Toolbar Title"

            // Set action bar/toolbar sub title
            //subtitle = "Toolbar sub title"

            // Display the app icon in action bar/toolbar
            setDisplayShowHomeEnabled(false)
            //setLogo(R.mipmap.ic_launcher)
            //setDisplayUseLogoEnabled(true)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu to use in the action bar
        val inflater = menuInflater
        inflater.inflate(R.menu.toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle presses on the action bar menu items
        when (item.itemId) {
            /*R.id.action_cut -> {
                //textView.text = "Cut Clicked."
                return true
            }
            R.id.action_copy -> {
                //textView.text = "Copy Clicked."
                return true
            }
            R.id.action_paste -> {
                //textView.text = "Paste Clicked."
                return true
            }
            R.id.action_new -> {
                //textView.text = "New Clicked."
                return true
            }*/
            R.id.action_logout -> {
                presenter!!.logoutUser()
                startActivity(Intent(this, MainActivity::class.java))
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_task -> replaceFragment(TaskFragment(),"This value Fragment Home",this)
            R.id.menu_task_user -> replaceFragment(TaskUserFragment(),"This value Fragment News",this)
            R.id.menu_settings -> replaceFragment(SettingsFragment(),"This value Fragment Settings",this)
        }
        return false
    }



    private fun replaceFragment(fragment: Fragment, message: String, context: Context){
        val sm = supportFragmentManager.beginTransaction()
        sm.apply {
            setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)

            /*val bundle = Bundle()
            bundle.putString("message", message)
            fragment.arguments = bundle*/

            /*fragment.tabLayout.addTab(fragment.tabLayout.newTab().setText("One"))
            fragment.tabLayout.addTab(fragment.tabLayout.newTab().setText("Two"))
            fragment.tabLayout.addTab(fragment.tabLayout.newTab().setText("Three"))
            fragment.tabLayout.tabGravity = TabLayout.GRAVITY_FILL
            val adapter = ViewPageAdapter(context, supportFragmentManager, fragment.tabLayout.tabCount)
            fragment.container.adapter = adapter

            fragment.tabLayout.addOnTabSelectedListener( context)
            fragment.tabLayout.setupWithViewPager(fragment.container)*/

            replace(R.id.container, fragment)
            addToBackStack(null)
            commit()
        }


    }

    override fun onTabReselected(tab: TabLayout.Tab?) {
        TODO("Not yet implemented")
    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {
        TODO("Not yet implemented")
    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
        //viewPager.currentItem = tab!!.position
    }

}