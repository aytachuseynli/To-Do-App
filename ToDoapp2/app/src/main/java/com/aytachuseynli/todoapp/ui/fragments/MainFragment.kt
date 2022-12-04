package com.aytachuseynli.todoapp.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.aytachuseynli.todoapp.R
import com.aytachuseynli.todoapp.data.entity.Tasks
import com.aytachuseynli.todoapp.databinding.FragmentDetailBinding
import com.aytachuseynli.todoapp.databinding.FragmentMainBinding
import com.aytachuseynli.todoapp.ui.adapter.TaskAdapter
import kotlinx.coroutines.processNextEventInCurrentThread

class MainFragment : Fragment(), SearchView.OnQueryTextListener{
    private lateinit var binding: FragmentMainBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       binding = DataBindingUtil.inflate(inflater,R.layout.fragment_main,container, false)
        binding.mainFragment = this
        binding.toolbarMainTitle = "Tasks"

        (activity as  AppCompatActivity).setSupportActionBar(binding.toolbarMain)


        val taskList = ArrayList<Tasks>()
        val t1 = Tasks(1,"A")
        val t2 = Tasks(2,"B")
        val t3 = Tasks(3,"C")
        taskList.add(t1)
        taskList.add(t2)
        taskList.add(t3)

        val adapter = TaskAdapter(requireContext(),taskList)
        binding.adapter = adapter

        requireActivity().addMenuProvider(object : MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu,menu)

                val item = menu.findItem(R.id.action_search)
                val searchView = item.actionView as SearchView
                searchView.setOnQueryTextListener(this@MainFragment)

            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
               return false
            }
        },viewLifecycleOwner,Lifecycle.State.RESUMED)

        return binding.root
    }


    fun fabClick(it:View){
        Navigation.findNavController(it).navigate(R.id.toSave)
    }
    override fun onQueryTextSubmit(query: String): Boolean {
        search(query)
        return true

    }

    override fun onQueryTextChange(newText: String): Boolean {
        search(newText)
        return true
    }

    fun search(searchKeyword:String){
        Log.e("Task Search",searchKeyword)
    }


}