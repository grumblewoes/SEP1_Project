const gamesContainer = $('.games')[0]

const convertGameToObject = (game) => {
    let obj = {
        title: $($(game).find("title")[0]).text(),
        numberOfPlayers: $($(game).find("numberOfPlayers")[0]).text(),
        type: $($(game).find("type")[0]).text(),
        description: $($(game).find("description")[0]).text(),
        borrowedTo: $($(game).find("borrowedTo")[0]).text(),
        owner: $($(game).find("owner")[0]).text(),
    }
    return obj
}

// change this to style the game element
// just write the html code in the string below
const createGameElement = (title, description, type,numberOfPlayers,borrowedTo,owner) => `
<div class="row game my-3">
        <img class="col-12 col-md-4 mb-3 mb-md-0 rounded" src="images/gamesImage.jpg" alt="game picture">
        <div class="col-12 col-md-8 info">
          <h3 class="game-name">${title}</h3>
          <div class="d-flex flex-row">
            <p class="flex-grow-1 text-center">Players: ${numberOfPlayers}</p>
            <p class="flex-grow-1 text-center">Type: ${type}</p>
            <p class="flex-grow-1 text-center">Game Owner: ${owner}</p>
            <p class="flex-grow-1 text-center">Status: ${borrowedTo}</p>
          </div>
          <p class="description">
            ${description}
          </p>
        </div>
      </div>
`
const emptyGameElement = () => `
<div class="row game_empty my-3">
        <div class="col-12 info text-center">
          <h3 class="game-name">No games in the system!</h3>
          <p class="description">
            There are no games in the association so far. Contact Bob if you have any games you would like to share with others.
          </p>
        </div>
      </div>
`
$.get("../../xml.xml", function (xml, status) {
    try {
        const games = $(xml).find("game")
        if(games.length==0){
        $(gamesContainer).append(emptyGameElement())
        }
        for (let game of games) {
            const { title, description, type,numberOfPlayers,borrowedTo,owner } = convertGameToObject(game)
            $(gamesContainer).append(createGameElement(title, description, type,numberOfPlayers,borrowedTo,owner))
        }
    } catch (e) {
        console.warn("...Unable to read xml or load events...")
    }
})

