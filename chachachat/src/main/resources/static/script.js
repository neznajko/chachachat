////////////////////////////////////////////////////////////////
console.log( "scrip4ing .." );
////////////////////////////////////////////////////////////////
const client = new StompJs.Client({
    brokerURL: "ws://localhost:8080/websocket",
});
////////////////////////////////////////////////////////////////
const messagesCon = document.querySelector( ".messages-con" );
////////////////////////////////////////////////////////////////
client.onConnect = function( frame ){
    client.subscribe( "/topic/chat", function( msg ){
        console.log( "> ", msg.body );
        const p = document.createElement( "p" );
        p.textContent = msg.body;
        messagesCon.appendChild( p );
    });
}
////////////////////////////////////////////////////////////////
const inputText = document.getElementById( "example" );
const sendButton = document.getElementById( "sendButton" );
sendButton.addEventListener( "click", e => {
    client.publish({
        destination: "/app/chat",
        body: JSON.stringify({"text":inputText.value}),
    });
});
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
