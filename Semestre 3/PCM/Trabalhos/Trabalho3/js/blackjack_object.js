// pcm 20172018a Blackjack object

//constante com o número máximo de pontos para blackJack
const MAX_POINTS = 21;


// Classe BlackJack - construtor
class BlackJack {
    constructor() {
        // array com as cartas do dealer
        this.dealer_cards = [];
        // array com as cartas do player
        this.player_cards = [];
        // variável booleana que indica a vez do dealer jogar até ao fim
        this.dealerTurn = false;

        // objeto na forma literal com o estado do jogo
        this.state = {
            'gameEnded': false,
            'dealerWon': false,
            'playerBusted': false
        };

        //métodos utilizados no construtor (DEVEM SER IMPLEMENTADOS PELOS ALUNOS)
        this.new_deck = function () {
            
            let cards = [];
            let cardsIndex = 0;

            for(let suit = 1; suit < 5; suit++)
            {
                for(let cardNumber = 1; cardNumber <= 13; cardNumber++)
                {
                    switch(suit)
                    {
                        case 1:
                            cards[cardsIndex] = ["clubs", cardNumber];
                            break;
                        case 2:
                            cards[cardsIndex] = ["diamonds", cardNumber];
                            break;
                        case 3:
                            cards[cardsIndex] = ["hearts", cardNumber];
                            break;
                        case 4:
                            cards[cardsIndex] = ["spades", cardNumber];
                            break;
                        default:
                            break;
                    }
                    cardsIndex++;
                }
            }
            console.log(cards);
            return cards;
        };

        this.shuffle = function (deck) {
            
            let shuffled = [];
            let IndexArray = [];
            
            for(let index = 0; index < deck.length; index++)
            {
                IndexArray[index] = index;
            }

            for(let index = 0; index < deck.length; index++)
            {
                shuffled.push(deck[IndexArray.splice(Math.floor(Math.random() * IndexArray.length), 1)]);
            }

            console.log(shuffled);
            return shuffled;
        };

        // baralho de cartas baralhado
        this.deck = this.shuffle(this.new_deck());
    }

    // métodos
    // devolve as cartas do dealer num novo array (splice)
    get_dealer_cards() {
        return this.dealer_cards.slice();
    }

    // devolve as cartas do player num novo array (splice)
    get_player_cards() {
        return this.player_cards.slice();
    }

    // Ativa a variável booleana "dealerTurn"
    setDealerTurn (val) {
        this.dealerTurn = true;
    }

    //MÉTODOS QUE DEVEM SER IMPLEMENTADOS PELOS ALUNOS
    get_cards_value(cards) {
        
        let valor = 0;

        console.log("get_cards_value -> cartas:");
        console.log(cards);
        console.log("get_cards_value -> tamanho das cartas: " + cards.length);

        for(let card in cards)
        {
            console.log("get_cards_value -> card: " + card);

            if(cards[card][0][1] > 1 && cards[card][0][1] < 10)
            {
                valor += cards[card][0][1];
            }
            else if(cards[card][0][1] >= 10)
            {
                valor += 10;
            }
            else
            {
                //Falta fazer com que o jogador decida se quer 1 ou 11
                if(valor + 11 <= 21)
                {
                    valor += 11;
                }
                else
                {
                    valor += 1;
                }
            }
        }

        console.log("get_cards_value -> " + valor);
        console.log("get_cards_value -> FIM!");
        console.log("");
        return valor;
    }

    dealer_move() {
        this.dealer_cards.push(this.deck.splice(this.deck.length - 1, 1));

        return this.get_game_state();
    }

    player_move() {
        
        this.player_cards.push(this.deck.splice(this.deck.length - 1, 1));

        return this.get_game_state(); 
    }

    get_game_state() {
        
        let dealerPoints = this.get_cards_value(this.dealer_cards);
        let playerPoints = this.get_cards_value(this.player_cards);

        console.log("Player points: " + playerPoints);
        console.log("Dealer points: " + dealerPoints);
        console.log("ISGAMEENDED: " + this.state.gameEnded);

        if(!this.dealerTurn)
        {
            if(playerPoints > 21)
            {
            this.state.gameEnded = true;
            this.state.dealerWon = true;
            this.state.playerBusted = true;
            }
            else if(playerPoints == 21)
            {
            this.state.gameEnded = true;
            this.state.dealerWon = false;
            this.state.playerBusted = false;
            }
        }
        else
        {
            if(dealerPoints > playerPoints && dealerPoints <= 21)
            {
                this.state.gameEnded = true;
                this.state.dealerWon = true;
                this.state.playerBusted = false;
            }
            else if(dealerPoints > 21)
            {
                this.state.gameEnded = true;
                this.state.dealerWon = false;
                this.state.playerBusted = false;
            }
        }
        
        return this.state;
    }
}