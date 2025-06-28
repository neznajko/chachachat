////////////////////////////////////////////////////////////////
console.log( "scrip4ing .." );
////////////////////////////////////////////////////////////////
/////////////////////////////////// Base class for a DOM element
class Dom {
    static cons( localName, textContent = null ){
        const elem = document.createElement( localName );
        if( textContent != null ){
            elem.textContent = textContent;
        }
        return elem;
    }
    constructor( selector ){
        this.elem = document.querySelector( selector );
    }
    subscribe( event, callback ){
        this.elem.addEventListener( event, callback );
    }
}
/////////////////////////////////////////////////////////// Form
class Form extends Dom {
    subscribe( callback ){
        super.subscribe( "submit", e => {
            e.preventDefault();
            callback( e );
        });
    }
}
////////////////////////////////////////////////////////// Input
class Input extends Dom {
    value() {
        return this.elem.value;
    }
    clear() {
        this.elem.value = "";
    }
}
/////////////////////////////////////////////////////////// Chat
class Chat extends Dom {
    insert( usr, msg ){
        var strong = Dom.cons( "strong", usr + ": " );
        var span = Dom.cons( "span", msg );
        var div = Dom.cons( "div" );
        div.appendChild( strong );
        div.appendChild( span );
        this.elem.prepend( div );
    }
}
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
const data = document.getElementById( "data" );
const username = data.dataset.username;
const chatname = data.dataset.chatname;
console.log( username );
console.log( chatname );
////////////////////////////////////////////////////////////////
const client = new StompJs.Client({
    brokerURL: "ws://localhost:8083/websocket",
});
////////////////////////////////////////////////////////////////
const form = new Form( ".form-con > form" );
const input = new Input( ".form-con > form > input" );
const chat = new Chat( ".messages" );
form.subscribe( e => {
    const msg = input.value();
    if( msg ){
        const dest = "/app/chat/" + chatname;
        const body = JSON.stringify({
            "user": username,
            "text": msg
        });
        console.log( dest );
        console.log( body );
        client.publish({
            "destination": dest,
            "body": body,
        });
        input.clear();
    }
});
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
client.onConnect = function( frame ){
    const topic = "/topic/chat/" + chatname;
    console.log( topic )
    client.subscribe( topic, function( msg ){
        const stomp = JSON.parse( msg.body );
        chat.insert( stomp.user, stomp.text );
    });
}
////////////////////////////////////////////////////////////////
client.activate();
////////////////////////////////////////////////////////////////
// 24. A certain family has 6 children, consisting of 3 boys and
// 3 girls. Assuming  that  all birth orders are equally likely,
// what is the  probability that the 3 eldest children are the 3
// girls?
////////////////////////////////////////////////////////////////
// isn't that 1/C(6,3) = 1/6!/3!3! = 3!/4*5*6 = 1/20, be coz
// we can order the birth dates as 1 2 3 4 5 6, and then pick
// three of them for the girls, that will give us the total
// cases C(6,3), here there is only one scenario vhere the girls
// are fyorst: g g g b b b
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
