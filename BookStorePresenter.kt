import org.w3c.xhr.XMLHttpRequest

// 1
class BookStorePresenter : BookStoreContract.Presenter {
    // 2
    private lateinit var view: BookStoreContract.View
    // 3
    override fun attach(view: BookStoreContract.View) {
        this.view = view
    }
    // 4
    override fun loadBooks() {
        //1
        view.showLoader()
        //2
        getAsync(API_URL) { response ->
            //3
            val books = JSON.parse<Array<Book>>(response)
            //4
            view.hideLoader()
            //5
            view.showBooks(books.toList())
        }


    }
}

// 1
private fun getAsync(url: String, callback: (String) -> Unit) {
    // 2
    val xmlHttp = XMLHttpRequest()
    // 3
    xmlHttp.open("GET", url)
    // 4
    xmlHttp.onload = {
        // 5
        if (xmlHttp.readyState == 4.toShort() && xmlHttp.status == 200.toShort()) {
            // 6
            callback.invoke(xmlHttp.responseText)
        }
    }
    // 7
    xmlHttp.send()
}

