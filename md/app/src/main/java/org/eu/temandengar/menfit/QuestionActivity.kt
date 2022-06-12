package org.eu.temandengar.menfit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.eu.temandengar.menfit.R
import org.eu.temandengar.menfit.databinding.ActivityQuestionBinding
import java.util.*

class QuestionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuestionBinding
    private lateinit var rvQuestions: RecyclerView
    private val list = ArrayList<Question>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_question)

        rvQuestions = findViewById(R.id.rv_questions)
        rvQuestions.setHasFixedSize(true)

        list.addAll(listQuestions)
        showRecyclerList()
    }

    private val listQuestions: ArrayList<Question>
        get() {
            val dataQuestion = resources.getStringArray(R.array.data_question)
            val listQuestion = ArrayList<Question>()

            for (i in 0..(dataQuestion.size-1)) {
                val question = Question(dataQuestion[i])
                listQuestion.add(question)
            }
            return listQuestion
        }

    private fun showRecyclerList() {
        rvQuestions.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListQuestionAdapter(list)
        rvQuestions.adapter = listHeroAdapter
    }

}