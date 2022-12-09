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
function createWishElement(title, votes) {

    let stringEl = `
        <div class="wish">
            <h3>${title}</h3>
            <p>Number of votes: ${votes}</p>
        </div>
        `

    return stringEl;
}

const emptyWishElement = () => `
<div class="row wish my-3">
        <div class="col-12 info text-center">
          <h3 class="game-name">No wishes in the system!</h3>
          <p class="description">
            There are no wishes for a games so far. Contact Bob if you have any games you would like to suggest.
          </p>
        </div>
      </div>
`






//maybe sort the wishes by votes?? => in version 2.0
$.get("../../xml.xml", function (xml, status) {
    try {
        const wishes = $(xml).find("wish")
                if(wishes.length==0){
                $(wishesContainer).append(emptyWishElement())
                }
        for (let wish of wishes) {
            const { title, votes } = convertWishToObject(wish)
            $(wishesContainer).append(createWishElement(title, votes))
        }
    } catch (e) {
        console.warn("...Unable to read xml or load wishes...")
    }
})

