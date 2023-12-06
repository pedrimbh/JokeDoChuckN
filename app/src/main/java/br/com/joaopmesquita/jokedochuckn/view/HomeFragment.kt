package br.com.joaopmesquita.jokedochuckn.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.joaopmesquita.jokedochuckn.R
import br.com.joaopmesquita.jokedochuckn.data.CategoryRemoteDataSource
import br.com.joaopmesquita.jokedochuckn.model.Category
import br.com.joaopmesquita.jokedochuckn.presentation.HomePresenter
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieAdapter

class HomeFragment : Fragment() {
    private lateinit var presenter: HomePresenter
    private val adapter = GroupieAdapter()
    private lateinit var progressBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = HomePresenter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        progressBar = view.findViewById(R.id.progress_bar)
        val recycleView = view.findViewById<RecyclerView>(R.id.rv_main)
        recycleView.layoutManager = LinearLayoutManager(requireContext())
        presenter.findAllCategories()
        recycleView.adapter = adapter
    }

    fun showCategories(categories: List<Category>) {
        val catagoryList = categories.map { CategoryItem(it) }
        adapter.addAll(catagoryList)
        adapter.notifyDataSetChanged()

    }

    fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    fun endProgress() {
        progressBar.visibility = View.GONE
    }

    fun showFaliure(msg: String) {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_LONG).show()
    }
}