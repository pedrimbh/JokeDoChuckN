package br.com.joaopmesquita.jokedochuckn.data

interface ListCategoryCallback {

    fun onSuccess(response: List<String>)

    fun onError(response: String)

    fun onComplete()
}