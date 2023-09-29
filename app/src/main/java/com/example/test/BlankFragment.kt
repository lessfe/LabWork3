package com.example.test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.test.MainActivity
import com.example.test.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.google.android.material.button.MaterialButton


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment : Fragment() {
    private val viewModel: DataModel by activityViewModels()
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.fragment_blank, container, false)
        val el:Button = rootView.findViewById(R.id.fold)
        val el1:Button = rootView.findViewById(R.id.subtract)
        val el2:Button = rootView.findViewById(R.id.goNext)

        el.setOnClickListener(){
            val valTxt:EditText = rootView.findViewById<EditText?>(R.id.valField)
            val valTxt1:EditText = rootView.findViewById<EditText?>(R.id.edValfield)
            val ele = valTxt.text.toString().toFloat() + valTxt1.text.toString().toFloat()
            Thread.sleep(3_000)  // wait for 1 second
            viewModel.selectItem(ele.toInt())
            valTxt1.setText(ele.toString())
        }
        el1.setOnClickListener(){
            val valTxt:EditText = rootView.findViewById<EditText?>(R.id.valField)
            val valTxt1:EditText = rootView.findViewById<EditText?>(R.id.edValfield)
            val ell = valTxt1.text.toString().toFloat() - valTxt.text.toString().toFloat()
            Thread.sleep(3_000)
            viewModel.selectItem(ell.toInt())
            valTxt1.setText(ell.toString())
        }
        el2.setOnClickListener(){
            val valTxt1 = rootView.findViewById<EditText?>(R.id.edValfield).text.toString()
            val bnd = Bundle()
            bnd.putString("tag", valTxt1)
            Navigation.findNavController(rootView).navigate(R.id.action_blankFragment_to_blankFragment2, bnd)
        }
        return rootView
    }

    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BlankFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }

    }
}

