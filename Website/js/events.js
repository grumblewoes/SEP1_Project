const eventsContainer = $('.events')[0]

const convertEventToObject = (event) => {
    let obj = {
        title: $($(event).find("title")[0]).text(),
        description: $($(event).find("description")[0]).text(),
        date: $($(event).find("date")[0]).text(),
        location: $($(event).find("location")[0]).text(),
        participants: $($(event).find("participants")[0]).text(),
    }
    return obj
}




// change this to style the event element
//just write the html code in the string below
const createEventElement = (title, description, date, location, participants) => `
    <div class="event col-11 border border-dark bg-white p-3 my-3" data-tilt data-tilt-scale="1.02">
        <h4 class="d-flex justify-content-between">
            <span>${title}</span>
            <span>${location} | ${date}</span>
        </h4>
        <h5><span>Number of participants: ${participants}</span></h5>
        <p class="mt-3"> ${description} </p>
    </div>
`









//maybe sort the events by votes?? => in version 2.0

$.get("../../xml.xml", function (xml, status) {
    const events = $(xml).find("event")
    if (events.length != 0) {
        $(".event_empty").remove()
    }
    for (let event of events) {
        const { title, description, date, location, participants } = convertEventToObject(event)
        $(eventsContainer).append(createEventElement(title, description, date, location, participants))
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
})

