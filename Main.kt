fun main(args: Array<String>) {
    val bookStorePresenter = BookStorePresenter()
    val bookStorePage = BookStorePage(bookStorePresenter)
    bookStorePage.show()
}

val API_URL = js("getApiUrl()") as String