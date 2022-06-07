package com.irfanrizqulloh.capstone.mentalfitness

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class ListQuestionAdapter(private val listQuestion: ArrayList<Question>) :
    RecyclerView.Adapter<ListQuestionAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvQuestion: TextView = itemView.findViewById(R.id.tv_question)
        var rbquestion1: RadioButton = itemView.findViewById(R.id.rb_question1)
        var rbquestion2: RadioButton = itemView.findViewById(R.id.rb_question2)
        var rbquestion3: RadioButton = itemView.findViewById(R.id.rb_question3)
        var rbquestion4: RadioButton = itemView.findViewById(R.id.rb_question4)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_question, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (questions) = listQuestion[position]
        holder.tvQuestion.text = questions
        holder.itemView.setOnClickListener {

            Toast.makeText(
                holder.itemView.context,
                "Kamu memilih " + listQuestion[holder.adapterPosition].questions,
                Toast.LENGTH_SHORT
            ).show()

        }
        holder.rbquestion1.setOnClickListener()

    }

    override fun getItemCount(): Int = listQuestion.size
}