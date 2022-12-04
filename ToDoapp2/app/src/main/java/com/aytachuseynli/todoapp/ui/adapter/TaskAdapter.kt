package com.aytachuseynli.todoapp.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.aytachuseynli.todoapp.R
import com.aytachuseynli.todoapp.data.entity.Tasks
import com.aytachuseynli.todoapp.databinding.CardDesignBinding
import com.aytachuseynli.todoapp.databinding.FragmentSaveBinding
import com.aytachuseynli.todoapp.ui.fragments.MainFragmentDirections
import com.google.android.material.snackbar.Snackbar

class TaskAdapter(var mContext: Context, var tasksList:List<Tasks>)
    : RecyclerView.Adapter<TaskAdapter.CardDesignHolder>() {

    inner class  CardDesignHolder(var binding: CardDesignBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
       val binding:CardDesignBinding =
           DataBindingUtil.inflate(LayoutInflater.from(mContext),
           R.layout.card_design,parent,false)
        return  CardDesignHolder(binding)

    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
       val task = tasksList.get(position)
        val b = holder.binding
        b.task = task

        b.cardViewTask.setOnClickListener{
            val transition = MainFragmentDirections.toDetail(task = task)
            Navigation.findNavController(it).navigate(transition)
        }

        b.imageViewDelete.setOnClickListener{
        Snackbar.make(it,"Do you want to delete ${task.name}?",Snackbar.LENGTH_LONG)
            .setAction("YES") {
                delete(task.id)
            }.show()
        }
    }

    override fun getItemCount(): Int {
        return tasksList.size
    }

    fun delete(id:Int){
        Log.e("Task Delete",id.toString())
    }


}