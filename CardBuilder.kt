import org.w3c.dom.*
import kotlin.browser.document
import kotlin.browser.window
import kotlin.dom.addClass

class CardBuilder {

    fun build(book: Book): HTMLElement {
        // 1
        val containerElement = document.createElement("div") as HTMLDivElement
        val imageElement = document.createElement("img") as HTMLImageElement
        val titleElement = document.createElement("div") as HTMLDivElement
        val priceElement = document.createElement("div") as HTMLDivElement
        val descriptionElement = document.createElement("div") as HTMLDivElement
        val viewDetailsButtonElement = document.createElement("button") as HTMLButtonElement

        // 2
        bind(book = book,
                imageElement = imageElement,
                titleElement = titleElement,
                priceElement = priceElement,
                descriptionElement = descriptionElement,
                viewDetailsButtonElement = viewDetailsButtonElement)

        // 3
        applyStyle(containerElement,
                imageElement = imageElement,
                titleElement = titleElement,
                priceElement = priceElement,
                descriptionElement = descriptionElement,
                viewDetailsButtonElement = viewDetailsButtonElement)

        // 4
        containerElement
                .appendChild(
                        imageElement,
                        titleElement,
                        descriptionElement,
                        priceElement,
                        viewDetailsButtonElement
                )
        // 5
        return containerElement
    }

    // 6
    private fun Element.appendChild(vararg elements: Element) {
        elements.forEach {
            this.appendChild(it)
        }
    }

    private fun bind(book: Book,
                     imageElement: HTMLImageElement,
                     titleElement: HTMLDivElement,
                     priceElement: HTMLDivElement,
                     descriptionElement: HTMLDivElement,
                     viewDetailsButtonElement: HTMLButtonElement) {

        // 1
        imageElement.src = book.coverUrl

        // 2
        titleElement.innerHTML = book.title
        priceElement.innerHTML = book.price
        descriptionElement.innerHTML = book.description
        viewDetailsButtonElement.innerHTML = "view details"

        // 3
        viewDetailsButtonElement.addEventListener("click", {
            window.open(book.url)
        })
    }

    private fun applyStyle(containerElement: HTMLDivElement,
                           imageElement: HTMLImageElement,
                           titleElement: HTMLDivElement,
                           priceElement: HTMLDivElement,
                           descriptionElement: HTMLDivElement,
                           viewDetailsButtonElement: HTMLButtonElement) {
        containerElement.addClass("card", "card-shadow")
        imageElement.addClass("cover-image")
        titleElement.addClass("text-title", "float-left")
        descriptionElement.addClass("text-description", "float-left")
        priceElement.addClass("text-price", "float-left")
        viewDetailsButtonElement.addClass("view-details", "ripple", "float-right")
    }
}