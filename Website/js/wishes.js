const wishesContainer = $('.wishes')[0]

const convertWishToObject = (wish) => {
    let obj = {
        title: $($(wish).find("title")[0]).text(),
        votes: $($(wish).find("votes")[0]).text(),
    }
    return obj
}




// change this to style the wish element
//just write the html code in the string below
const createWishElement = (title, votes) => `
    <div class="wish">
        <h3>${title}</h3>
        <p>Number of votes: ${votes}</p>
    </div>
`









//maybe sort the wishes by votes?? => in version 2.0
$.get("../../xml.xml", function (xml, status) {
    try {
        const wishes = $(xml).find("wish")
        for (let wish of wishes) {
            const { title, votes } = convertWishToObject(wish)
            $(wishesContainer).append(createWishElement(title, votes))
        }
    } catch (e) {
        console.warn("...Unable to read xml or load wishes...")
    }
})

