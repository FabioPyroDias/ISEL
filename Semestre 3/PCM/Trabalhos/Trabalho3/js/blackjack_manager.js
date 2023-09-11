// pcm 20172018a Blackjack oop

let game = null;

function debug(an_object) {
    document.getElementById("debug").innerHTML = JSON.stringify(an_object);
}

function buttons_initialization(){
    document.getElementById("card").disabled     = false;
    document.getElementById("stand").disabled     = false;
    document.getElementById("new_game").disabled = true;

    document.getElementById("new_game").classList.remove("btn-light");
    document.getElementById("new_game").classList.add("btn-dark");

    document.getElementById("card").classList.add("btn-light");
    document.getElementById("card").classList.remove("btn-dark");

    document.getElementById("stand").classList.add("btn-light");
    document.getElementById("stand").classList.remove("btn-dark");
}

function finalize_buttons(){
    document.getElementById("card").disabled     = true;
    document.getElementById("stand").disabled     = true;
    document.getElementById("new_game").disabled = false;

    document.getElementById("new_game").classList.remove("btn-dark");
    document.getElementById("new_game").classList.add("btn-light");

    document.getElementById("card").classList.add("btn-dark");
    document.getElementById("card").classList.remove("btn-light");

    document.getElementById("stand").classList.add("btn-dark");
    document.getElementById("stand").classList.remove("btn-light");
}

function display_debug() {
    let debug = document.getElementById("sec_debug");
    let button = document.getElementById("debug-display");

    if(debug.style.display == "block")
    {   
        button.innerHTML = "Show";
        debug.style.display = "none";
    }
    else
    {
        button.innerHTML = "Hide";
        debug.style.display = "block";
    }
}

//FUNÇÕES QUE DEVEM SER IMPLEMENTADOS PELOS ALUNOS
function new_game(){

    game = new BlackJack();

    dealer_new_card();
    dealer_new_card();
    
    document.getElementById("cards-dealer-display").lastChild.src = './imgs/cards/BLUE_BACK.svg'

    player_new_card();

    //Falta substituir a carta por um caracter (mudar isto para a face de trás de uma carta)

    //Adicionado por mim. Creio que falta isto
    buttons_initialization();

    debug(game);
}

function update_dealer(state){

    let dealerCards = "";

    let cards = game.get_dealer_cards();
    
    for(let card in cards)
    {
        dealerCards += cards[card][0] + " ";
    }

    if(state.gameEnded)
    {
        if(state.dealerWon)
        {
            dealerCards += "Won";
        }
        else
        {
            dealerCards += "Lost";
        }
    }

    //Posso fazer isto no for de cima, evitando dois fors.
    let dealerCardsDisplay = document.getElementById("cards-dealer-display");
    dealerCardsDisplay.innerHTML = "";

    for(let card in cards)
    {
        let image = document.createElement('img');
        image.src = './imgs/cards/' + cards[card][0][1] + '_' + cards[card][0][0] + '.svg';
        image.classList.add("card");
        dealerCardsDisplay.appendChild(image);
    }

    console.log("Dealer Cards: " + dealerCards);

    finalize_buttons();
}

function update_player(state){

    let playerCards = "";

    let cards = game.get_player_cards();

    for(let card in cards)
    {
        playerCards += cards[card][0] + " ";
    }
    
    if(state.gameEnded) 
    {
        if(!state.dealerWon){
            playerCards += "Won";
        }
        else
        {
            playerCards += "Lost";
        }

        finalize_buttons();
    }

    //Posso fazer isto no for de cima, evitando dois fors.
    let playerCardsDisplay = document.getElementById("cards-player-display");
    console.log(playerCardsDisplay);
    playerCardsDisplay.innerHTML = "";

    for(let card in cards)
    {
        let image = document.createElement('img');
        image.src = './imgs/cards/' + cards[card][0][1] + '_' + cards[card][0][0] + '.svg';
        image.classList.add("card");
        playerCardsDisplay.appendChild(image);
    }

    console.log("Player Cards: " + playerCards);
}

function dealer_new_card(){

    update_dealer(game.dealer_move());

}

function player_new_card(){

    update_player(game.player_move());

    debug(game);
}

function dealer_finish(){

    finalize_buttons();

    game.setDealerTurn(true);
    
    while(!game.get_game_state().gameEnded)
    {
        dealer_new_card();
    }

    update_dealer(game.get_game_state());

    debug(game);
}

