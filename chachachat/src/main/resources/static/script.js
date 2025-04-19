////////////////////////////////////////////////////////////////
console.log( "scrip4ing .." );
////////////////////////////////////////////////////////////////
/////////////////////////////////// Base class for a DOM element
class Dom {
    constructor( selector ){
        this.elem = document.querySelector( selector );
    }
    subscribe( event, callback ){
        this.elem.addEventListener( event, callback );
    }
}
//////////////////////////////////////////////////// Select User 
class Select extends Dom {
    subscribe( callback ){
        super.subscribe( "change", callback );
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
////////////////////////////////////////////////////////////////
class Chat extends Dom {
    insert( msg ){
        const p = document.createElement( "p" );
        p.textContent = msg;
        this.elem.prepend( p );
    }
}
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
const client = new StompJs.Client({
    brokerURL: "ws://localhost:8083/websocket",
});
client.name = "";
client.setName = function( name ){
    this.name = name;
};
////////////////////////////////////////////////////////////////
const select = new Select( "#select-user" );
select.subscribe( e => {
    const name = e.target.value;
    if( name ){
        client.setName( name );
    }
});
const form = new Form( ".form-con > form" );
const input = new Input( ".form-con > form > input" );
const chat = new Chat( ".chat-con" );
form.subscribe( e => {
    const msg = input.value();
    if( msg ){
        client.publish({
            destination: "/app/chat/java",
            body: JSON.stringify({
                "user": client.name,
                "text": msg
            }),
        });
        input.clear();
    }
});
////////////////////////////////////////////////////////////////
client.onConnect = function( frame ){
    client.subscribe( "/topic/chat/java", function( msg ){
        const stomp = JSON.parse( msg.body );
        chat.insert( stomp.user + ": " + stomp.text );
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
