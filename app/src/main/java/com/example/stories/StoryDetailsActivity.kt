package com.example.stories

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar


class StoryDetailsActivity : AppCompatActivity() {

    lateinit var toolbar: Toolbar
    lateinit var titleTextView: TextView
    lateinit var detailsTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story_details)

        connectViews()

        setData()
    }

    private fun connectViews() {
        toolbar=findViewById(R.id.details_tool_bar)
        titleTextView = findViewById(R.id.title_text_view)
        detailsTextView = findViewById(R.id.details_text_view)
    }

    private fun setData(){

        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        supportActionBar?.title=intent.getStringExtra("Title")


        titleTextView.text =intent.getStringExtra("Title")
        detailsTextView.text =intent.getStringExtra("SubTitle")

        detailsTextView.movementMethod = ScrollingMovementMethod()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }


}