package com.example.stories

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var drawerLayout : DrawerLayout
    lateinit var toolbar:Toolbar
    lateinit var navigationView: NavigationView
    lateinit var emailTextView: TextView
    lateinit var recyclerView: RecyclerView
    lateinit var floatingActionButton: FloatingActionButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        connectViews()

        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setupDrawer()

        setData()

        drawerClicks()

        navigateToAddStory()

        displayStory()

    }




    private fun connectViews(){

        drawerLayout=findViewById(R.id.drawer)
        toolbar=findViewById(R.id.tool_bar)
        navigationView = findViewById(R.id.nav_view)
        recyclerView = findViewById(R.id.stories_recycle_view)
        floatingActionButton = findViewById(R.id.home_floating_Action_Button)
    }

    private fun setData(){

        val headerView = navigationView.getHeaderView(0)

        emailTextView= headerView.findViewById<TextView>(R.id.email_text_view)

        emailTextView.text =intent.getStringExtra("Email")


    }

    private fun setupDrawer() {
     val toggleView = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)

        drawerLayout.addDrawerListener(toggleView)

        toggleView.syncState()
    }

    private fun drawerClicks(){

        navigationView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home->{
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.logout->{
                    finish()
                    val intent = Intent(this,LoginActivity::class.java)
                    startActivity(intent)
                    true
                }else ->true
            }
        }
    }


    private fun navigateToAddStory(){
        floatingActionButton.setOnClickListener{
            val i = Intent(this,AddStoryActivity::class.java)
            startActivity(i)
        }
    }

    private fun displayStory() {
        val storyList = ArrayList<Story>()

        storyList.add(Story("First Story","on"))


        val customRecycleAdapter = CustomRecycleAdapter(storyList,this)

        recyclerView.adapter =customRecycleAdapter


        if(intent.getStringExtra("Title") !=null) {

            val title = intent.getStringExtra("Title")
            val subtitle = intent.getStringExtra("SubTitle")
            storyList.add(Story(title!!,subtitle!!))

            customRecycleAdapter.notifyDataSetChanged()

        }
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home->{
                drawerLayout.openDrawer(GravityCompat.START)
                true
            }else->true
        }
    }
}