package com.sopian.recyclerviewsample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listUser = listOf(
            User("Ahmad Sopian", +628972774965),
            User("Rifaldi Febrianto", +628972774965),
            User("Iqbal Fadillah", +628972774965),
            User("Ahmad Sopian", +628972774965),
            User("Ahmad Sopian", +628972774965),
        )

        val adapter = UserAdapter(listUser, onItemClick = {
            val action = ListFragmentDirections.actionListFragmentToDetailFragment(it)
            findNavController().navigate(action)
        })

        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recylcer_view)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }

}