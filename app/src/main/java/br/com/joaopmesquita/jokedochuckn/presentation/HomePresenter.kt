package br.com.joaopmesquita.jokedochuckn.presentation

import android.os.Handler
import android.os.Looper
import android.widget.Toast
import br.com.joaopmesquita.jokedochuckn.data.CategoryRemoteDataSource
import br.com.joaopmesquita.jokedochuckn.data.ListCategoryCallback
import br.com.joaopmesquita.jokedochuckn.model.Category
import br.com.joaopmesquita.jokedochuckn.view.CategoryItem
import br.com.joaopmesquita.jokedochuckn.view.HomeFragment

class HomePresenter(
    private val view: HomeFragment,
    private val dataSource: CategoryRemoteDataSource = CategoryRemoteDataSource()
) : ListCategoryCallback{
    fun findAllCategories() {
        view.showProgress()
        dataSource.findAllCategories(this)
    }

    override fun onSuccess(response: List<String>) {
//        val categories = mutableListOf<CategoryItem>()
//
//        for (category in response) {
//            categories.add(CategoryItem(category))
//        }
        val categories = response.map {
            Category(it, 0xFFFF0000)
        }
        onComplete()
        view.showCategories(categories)
    }

    override fun onError(response: String) {
        view.showFaliure(response)
    }

    override fun onComplete() {
        view.endProgress()
    }

}