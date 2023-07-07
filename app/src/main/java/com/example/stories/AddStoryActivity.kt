package com.example.stories

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.widget.Toolbar

class AddStoryActivity : AppCompatActivity() {


    lateinit var toolbar: Toolbar
    lateinit var titleEditText: EditText
    lateinit var subTitleEditText: EditText
    lateinit var addStroyButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_story)

        connectViews()


        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        supportActionBar?.title="Add Story"

        addStory()
    }

    private fun addStory() {

        addStroyButton.setOnClickListener {

            when{
                titleEditText.text.isEmpty()->{
                    titleEditText.error = "Please Enter Story Title"
                }
                subTitleEditText.text.isEmpty()->{
                    subTitleEditText.error = "Please Enter Story Sub Title"
                }
                else ->{
                    this.finish()
                    val i = Intent(this,MainActivity::class.java)
                    i.putExtra("Title",titleEditText.text.toString())
                    i.putExtra("SubTitle",subTitleEditText.text.toString())
                    startActivity(i)
                }
            }
        }
    }

    private fun connectViews() {
        toolbar=findViewById(R.id.add_story_tool_bar)
        titleEditText = findViewById(R.id.title_Edit_text)
        subTitleEditText = findViewById(R.id.sub_title_Edit_text)
        addStroyButton = findViewById(R.id.add_story_button)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}