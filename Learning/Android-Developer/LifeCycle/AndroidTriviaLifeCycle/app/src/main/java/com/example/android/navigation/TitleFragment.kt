package com.example.android.navigation

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.databinding.FragmentTitleBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TitleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TitleFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
//        make object binding and define fragmen title binding
        val binding = DataBindingUtil.inflate<FragmentTitleBinding>(inflater,
            R.layout.fragment_title,container,false)

        binding.playButton.setOnClickListener { view : View ->
            view.findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToGameFragment())
        }
        binding.rulesButton.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_titleFragment_to_rulesFragment)
        }
        binding.aboutButton.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_titleFragment_to_aboutFragment)
        }
        setHasOptionsMenu(true)
//         add log
        Log.i("TitleFragment", "onCreateView called")
        return binding.root
    }

//    Logging onAttach
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i("TitleFragment", "onAttach called")
    }
//    Logging onCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("TitleFragment", "onCreate called")
    }
//    Logging onCreateView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i("TitleFragment", "onViewCreated called")
    }
//    Logging onStart
    override fun onStart() {
        super.onStart()
        Log.i("TitleFragment", "onStart called")
    }
//    Logging onResume
    override fun onResume() {
        super.onResume()
        Log.i("TitleFragment", "onResume called")
    }
//    Logging onPause
    override fun onPause() {
        super.onPause()
        Log.i("TitleFragment", "onPause called")
    }
//    Logging onStop
    override fun onStop() {
        super.onStop()
        Log.i("TitleFragment", "onStop called")
    }
//    Logging onDestroyView
    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("TitleFragment", "onDestroyView called")
    }
//    Logging onDetach
    override fun onDetach() {
        super.onDetach()
        Log.i("TitleFragment", "onDetach called")
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI
            .onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

}