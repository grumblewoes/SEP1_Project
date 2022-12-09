const eventsContainer = $('.events')[0]

const convertEventToObject = (event) => {
    let obj = {
        title: $($(event).find("title")[0]).text(),
        description: $($(event).find("description")[0]).text(),
        date: $($(event).find("date")[0]).text(),
    }
    return obj
}




// change this to style the event element
//just write the html code in the string below
const createEventElement = (title, description, date) => `
    <div class="event col-12 border border-dark bg-white p-3 my-3" data-tilt data-tilt-scale="1.02">
        <h5 class="d-flex justify-content-between">
            <span>${title}</span>
            <span>${date}</span>
        </h5>
        <p class="mt-3"> ${description} </p>
    </div>
`

const emptyEventElement = () => `
<div class="row event my-3">
        <div class="col-12 info text-center">
          <h3 class="game-name">No events in the system!</h3>
          <p class="description">
            No events are apparently happening. If you have any suggestion for an event, Contact Bob!
          </p>
        </div>
      </div>
`







//maybe sort the events by votes?? => in version 2.0
$.get("../../xml.xml", function (xml, status) {
    try {
        const events = $(xml).find("event")
                if(events.length==0){
                $(eventsContainer).append(emptyEventElement())
                }
        for (let event of events) {
            const { title, description, date } = convertEventToObject(event)
            $(eventsContainer).append(createEventElement(title, description, date))
        }
        VanillaTilt.init(
            document.querySelectorAll(".events .event"),
            {
                max: 2,
                speed: 200,
                glare: true,
                "max-glare": 0.5
            }
        );
    } catch (e) {
        console.warn("...Unable to read xml or load events...")
    }
})

