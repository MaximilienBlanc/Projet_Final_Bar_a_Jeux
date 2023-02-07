package test;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import config.AppConfig;
import model.Admin;
import model.Civilite;
import model.Client;
import model.Jeu;
import model.Reservation;
import model.TableBar;
import service.AdminService;
import service.ClientService;
import service.JeuService;
import service.ReservationService;
import service.TableService;

@Transactional
@Rollback(false)
@SpringJUnitConfig(AppConfig.class)
class DonneesInitBdd {

	@Autowired
	ClientService clientSrv;
	
	@Autowired
	AdminService adminSrv;
	
	@Autowired
	JeuService jeuSrv;
	
	@Autowired
	TableService tableBarSrv;
	
	@Autowired
	ReservationService resaSrv;
	

	
	@Test
	void InitBdd() {
		
		//ajout admin
		Admin admin = new Admin("admin@test.fr","admin");
		adminSrv.save(admin);
		
		// ajout des clients
		Client client1 = new Client("client1@test.fr","client1","client1","client1","0600000001",Civilite.homme);
		clientSrv.save(client1);
		Client client2 = new Client("client2@test.fr","client2","client2","client2","0600000002",Civilite.femme);	
		clientSrv.save(client2);
		Client client3 = new Client("client3@test.fr","client3","client3","client3","0600000003",Civilite.nb);
		clientSrv.save(client3);
		Client client4 = new Client("client4@test.fr","client4","client4","client4","0600000004",Civilite.homme);
		clientSrv.save(client4);
		
		//ajout des jeux
		Jeu jeu1 = new Jeu("6 qui prend !",2,10,10,20,"Gigamic","2007",14.9,"\\Projet_Final\\bdd\\image_jeu\\6-qui-prend.png","logique,réflexes",6, "qui prend, la version française de 6 nimmt! le jeu de cartes de Wolfgang Kramer qui porte parfois le nom de 6 qui perd ! Ces drôles de cartes valent de 1 à 7 «têtes de boeufs» chacune. Votre but : en récolter le moins possible. Pas de temps mort, tout le monde joue simultanément, règles simples, jusqu'à 10 joueurs, un mélange de réflexion, de stratégie et de hasard rend ce jeu très addictif.");
		jeuSrv.create(jeu1);	
		Jeu jeu2 = new Jeu("7 Wonders",3,7,10,30,"Repos Production","2010",42.5,"\\Projet_Final\\bdd\\image_jeu\\7-wonders.png","stratégie,tactique",5,"Pour fêter ses 10ans, 7 Wonders s'offre une toute nouvelle édition. Désormais érigé au rang de classique, 7 wonders vous invite à prendre la tête de l’une des sept grandes cités du monde Antique et ainsi laisser votre empreinte dans l’histoire des civilisations. Un jeu de développement de civilisation, de gestion de ressources et de cartes, souvent imité mais jamais égalé. Un des meilleurs jeux de stratégie de construction par carte si ce n'est le meilleur !");
		jeuSrv.create(jeu2);	
		Jeu jeu3 = new Jeu("Abyss",2,4,14,45,"Bombyx","2014",40.5,"\\Projet_Final\\bdd\\image_jeu\\abyss.png","stratégie,tactique",4,"Abyss vous plonge au fond de l'océan dans un jeu stratégique mais accessible. Vous devrez jongler entre exploration de territoires et recrutements de seigneur pour contrôler le monde sous marin. Un jeu splendide aux mécaniques bien huilées, réalisé par un trio de choc : Cathala et Chevallier à l'écriture et Colette à l'illustration. Une perle que l'on ne trouve qu'au fin fond des océans !");
		jeuSrv.create(jeu3);	
		Jeu jeu4 = new Jeu("Azul",2,4,8,30,"Next Move","2017",40.5,"\\Projet_Final\\bdd\\image_jeu\\azul.png","stratégie,tactique",1,"Introduits par les Maures, les azulejos (carreaux de revêtement mural en faîence, originalement décorés de bleu ou polychromes) furent adoptés par les Portuguais au moment où leur roi Manuel 1er, durant une visite au palais de l’Alhambra dans le sud de l’Espagne, fut conquis par l’éblouissante beauté des tuiles décoratives. Manuel 1er ordonna la décoration immédiate, avec des tuiles semblables, des murs de son palais. Azul vous transporte au 16e siècle, truelle en main, à embellir les murs du Palais Royal de Evora?! Un jeu quasi parfait, rapide et addictif avec une mécanique simple à comprendre. Il nécessite de savoir adapter sa stratégie et de faire preuve d'opportunisme pour optimiser son score !");
		jeuSrv.create(jeu4);	
		Jeu jeu5 = new Jeu("Bad Bones",1,6,8,30,"Sit Down","2019",46.9,"\\Projet_Final\\bdd\\image_jeu\\bad-bones.png","stratégie,tactique",5,"Vous meniez la belle vie au sommet de votre tour, contemplant votre royaume paisible et discutant avec vos charmants voisins. Oui mais ça c'était avant ! Bad Bones est un jeu dans lequel vous devez survivre à une invasion de squelettes toujours plus nombreux et dangereux. L'invasion ne peut pas être vaincue, vous devez donc survivre à vos adversaires. Vous avez à votre disposition une gamme d’armes qui permettent de vaincre, de ralentir, voire de dévier les squelettes vers les autres joueurs. Le jeu se termine lorsque la tour ou le village d'un joueur est détruit. Bad bones est un jeu de défense de territoire s'offrant le luxe de proposer à la fois un mode compétitif, un mode coopératif et un mode solo. Accessible dès 8 ans, un must have pour rentrer dans le monde des 'gros' jeux !");
		jeuSrv.create(jeu5);
		Jeu jeu6 = new Jeu("Bang !",4,7,8,20,"daVinci Editrice","2003",17.9,"\\Projet_Final\\bdd\\image_jeu\\bang.png","stratégie,tactique",3,"Avec Bang !, devenez un cow-boy, un sheriff, un bandit... et imposez votre loi dans le far west ! Très bon jeu qui peut être sorti en toute occasion. Les parties durent entre 15 et 30 min. Les différents rôles de chaque personnages avec leurs objectifs donnent une bonne ambiance aux parties. Un Grand Classique à posséder !");
		jeuSrv.create(jeu6);			
		Jeu jeu7 = new Jeu("Brass Lancashire",2,4,14,60,"Funforge","2019",62.9,"\\Projet_Final\\bdd\\image_jeu\\brass-lancashire.png","stratégie,tactique",4,"Brass : Lancashire est un jeu de stratégie économique qui raconte l'histoire d'entrepreneurs concurrents dans le Lancashire pendant la révolution industrielle. Vous devez développer, construire et établir vos industries et votre réseau afin de pouvoir répondre à la demande de fer, de charbon et de coton. Un modèle de jeu de gestion, beaucoup d'interactions, une énorme profondeur et un fort goût de reviens-y !");
		jeuSrv.create(jeu7);
		Jeu jeu8 = new Jeu("Carcassonne",2,5,8,30,"Z-Man Games","2000",31.5,"\\Projet_Final\\bdd\\image_jeu\\carcassonne.png","stratégie,tactique",3,"Carcassonne ce n’est pas que le nom d’une ville du sud de la France, il s’agit également d’un symbole de la lutte des hérétiques contre l’oppression de l’Église au Moyen Âge. Encore aujourd’hui, ses remparts et ses fortifications ne cessent d’impressionner. À l’aide de tuiles sur lesquelles se trouvent villes, monastères, routes et champs, les joueurs agrandissent le plateau tour après tour. Les joueurs placent leurs partisans sur les différentes tuiles constituant les environs de Carcassonne afin d’obtenir le plus de points de victoire possible. Selon l’endroit où ils sont placés, les partisans deviendront chevaliers, moines, voleurs ou paysans. Pour l’emporter, soyez fins stratèges ! Carcassonne est un classique du jeu de société, le jeu est vraiment simple mais cela ne l'empêche pas d'être stratégique !");
		jeuSrv.create(jeu8);
		Jeu jeu9 = new Jeu("Celestia",2,6,8,30,"Blam","2015",23.5,"\\Projet_Final\\bdd\\image_jeu\\celestia.png","course,aventure",3,"Lors de ses voyages, Gulliver chercha en vain le monde fabuleux de Celestia. Sur les traces de ce glorieux ainé, lancez-vous à la conquête de cités célestes toutes aussi mystérieuses que les trésors qu’elles cachent. Au cours de ce périple, triompherez-vous des orages, des pirates Lockhars et des oiseaux-Damok ? Serez-vous le pilote le plus habile ? Votre témérité sera-t-elle récompensée ? À bord d’un aéronef, découvrez les cités de Celestia et récupérez leurs merveilleux trésors. À chaque tour, un nouveau capitaine doit affronter les péripéties du voyage : lui ferez-vous confiance pour atteindre la prochaine cité ? Un astucieux jeu de prise de risque dans un monde onirique. Un très bon jeu de stop ou encore superbement illustré !");
		jeuSrv.create(jeu9);
		Jeu jeu10 = new Jeu("Citadelles - Classique",2,8,10,30,"Edge Entertainment","2000",15.9,"\\Projet_Final\\bdd\\image_jeu\\citadelles-classique.png","stratégie,tactique",3,"Dans Citadelles, votre but est de bâtir une cité prestigieuse avant que vos adversaires ne parviennent à construire la leur. Considéré comme l'un des grands classiques du jeu de société moderne, Citadelles est un jeu de cartes alliant bluff, diplomatie, stratégie et construction !");
		jeuSrv.create(jeu10);	
		Jeu jeu11 = new Jeu("Clank !",2,4,12,45,"Renegade Game Studio","2017",49.5,"\\Projet_Final\\bdd\\image_jeu\\clank.png","stratégie,tactique",5,"Les souterrains sous la Tour du Dragon sont réputés pour être l’endroit le plus dangereux du Royaume. Seuls les roublards les plus intrépides peuvent s’y faufiler pour voler le Dragon et en revenir vivants pour raconter leur histoire. C’est ainsi que vous et vos semblables avez mis en jeu votre réputation de voleurs pour relever le défi. Au cours du chemin, vous allez recruter des alliés et mettre la main sur des trésors. Mais un faux pas et… CLANK ! Le bruit risque d’attirer l’attention du dragon, et plus d’artefacts seront volés, plus cela augmentera sa fureur ! Soyez plus discret que vos compères, si vous espérez vous en sortir vivant… Un très bon jeu de deck building. Rapide à prendre en main et à installer pour un max de fun !");
		jeuSrv.create(jeu11);
		Jeu jeu12 = new Jeu("Codenames",2,8,14,15,"Czech Games Edition","2015",22.5,"\\Projet_Final\\bdd\\image_jeu\\codenames.png","Enquête,enigme",4,"Codenames est un jeu d’association d’idées pour 2 à 8 joueurs (voire plus !) dans lequel, répartis en deux équipes, vous incarnez soit un maître-espion, soit un agent en mission. Pour retrouver sous quel nom de code se cachent vos informateurs, écoutez bien les indices donnés par les deux Maîtres-Espions et prenez garde à ne pas contacter un informateur ennemi, ou pire… le redoutable assassin ! Un jeu d’association d’idées fin et original qui a fait sensation à l’étranger et en France !");
		jeuSrv.create(jeu12);
		Jeu jeu13 = new Jeu("Colt Express",2,6,10,60,"Ludonaute","2014",31.5,"\\Projet_Final\\bdd\\image_jeu\\colt-express.png","course,aventure,stratégie,tactique",1,"Dans Colt Express, les joueurs incarnent des bandits “desperados” qui se lancent à l’attaque d’un train de voyageurs. Pas de pitié, pas d’alliance possible : entre les wagons, sur le toit, les balles fusent , les hors-la-loi sont blessés. Le Marshall patrouille dans le train et contre-carre les plans des bandits. Il est un danger supplémentaire dans cette folle entreprise. Qui obtiendra le titre d’“As de la gâchette” à la fin du jeu ? Qui aura le plus gros butin ? Chacun a sa propre personnalité, mais au bout du compte, tous n’ont qu’un seul but : réunir le plus gros magot pour lui-même en détroussant les passagers avant que le train n’arrive en gare. Un très bon jeu, familial, compétitif et plein de rebondissements !");
		jeuSrv.create(jeu13);
		Jeu jeu14 = new Jeu("Concept",4,12,10,40,"Repos Production","2013",26.9,"\\Projet_Final\\bdd\\image_jeu\\concept.png","quizz,défis",1,"Dans Concept, votre but est de faire deviner des mots au moyen d’associations d’icônes. Une équipe de deux joueurs, voisins de table, choisit un mot à faire deviner aux autres joueurs. Ensemble, en se concertant, ils vont placer judicieusement des pions sur les icônes du plateau. Le joueur qui devine le mot et l’équipe qui à fait deviner gagne des points de victoire (2 et 1 chacun). Après 12 cartes jouées, le joueur qui a le plus de points remporte la partie. Un jeu de communication et d’ambiance avec des icônes simples et compréhensibles par tous ! Simple, adapté à tous, règles adaptables en fonction des niveaux ! Super !");
		jeuSrv.create(jeu14);
		Jeu jeu15 = new Jeu("Dominion",2,4,8,30,"Filosofia","2008",40.5,"\\Projet_Final\\bdd\\image_jeu\\dominion.png","stratégie,tactique",2,"Étendez votre domaine ! Vous êtes le souverain d'un paisible royaume verdoyant. Vous rêvez d'étendre ce royaume et de le rendre plus grand et plus riche. Il vous faut un véritable Dominion ! En unifiant sous votre bannière les nombreux fiefs au bord de l'anarchie qui vous entourent, vous leur apporterez paix et civilisation. Mais d'autres monarques partagent vos ambitions. Vous devrez agir promptement afin d'acquérir le plus de terres possible ! Pour parvenir à vos fins, vous recruterez des laquais, vous construirez des bâtiments et vous entretiendrez le confort de votre château, sans oublier de remplir les coffres de votre trésorerie. Le classique absolu du deckbuilding, beaucoup s'en sont inspirés !");
		jeuSrv.create(jeu15);
		Jeu jeu16 = new Jeu("Draftosaurus",2,5,8,15,"Ankama","2019",19.9,"\\Projet_Final\\bdd\\image_jeu\\draftosaurus.png","stratégie,tactique",4,"Les scientifiques ont enfin réussi à cloner les dinosaures ! Dans le monde entier s’ouvrent de nombreux zoos pour colosses. Organisez vos enclos du mieux possible pour offrir aux curieux les dinosaures les plus en vogue ! Bienvenue dans le monde de Draftosaurus ! Super jeu familial, qui mise sur la prise de risque, l'équilibre entre les joueuses et joueurs et un matériel très mignon !");
		jeuSrv.create(jeu16);
		Jeu jeu17 = new Jeu("Everdell",1,4,14,40,"Matagot","2018",60.9,"\\Projet_Final\\bdd\\image_jeu\\everdell.png","stratégie,tactique",2,"Au cœur de la vaste forêt du monde d’Everdell, une civilisation d'animaux forestiers se développe et prospère. Toutes les créatures luttent chaque année pour construire une nouvelle ville pour passer l’hiver ! Avec des bâtiments à construire, des personnages passionnants à rencontrer, et des événements à gérer, une année chargée vous attend. Un jeu simple à apprendre avec une réelle profondeur !");
		jeuSrv.create(jeu17);
		Jeu jeu18 = new Jeu("Exploding Kittens",2,5,7,15,"Exploding Kittens","2015",17.9,"\\Projet_Final\\bdd\\image_jeu\\exploding-kittens.png","stratégie,tactique",4,"Après un énorme succès sur Kickstarter, le jeu d’ambiance déjanté arrive enfin en français. Vous n’aurez dorénavant plus d’excuse pour vous lancer dans la bataille ! Exploding Kittens revisite la célèbre Roulette Russe dans un jeu de cartes où les chatons côtoient d’un peu trop près grenades, missiles nucléaires et torpilles dans un cocktail détonant ! Un jeu simple, rapide et efficace, notamment grâce aux illustrations qui sont complètement barrées et qui donnent envie d'y rejouer !");
		jeuSrv.create(jeu18);
		Jeu jeu19= new Jeu("Five Tribes",2,4,13,60,"Days of wonder","2014",53.9,"\\Projet_Final\\bdd\\image_jeu\\five-tribes.png","stratégie,tactique",1,"Dans Five Tribes, après des journées de voyage au cœur du pays des mille et une nuits, votre caravane arrive enfin au fabuleux sultanat de Naqala. Les rumeurs étaient vraies : le vieux sultan est mort… les oracles prédisent la venue d'un étranger qui saurait gagner les faveurs des Cinq Tribus pour prendre sa place. Allez-vous accomplir la prophétie ? Invoquez les anciens Djinns, faites appel aux différentes tribus au moment opportun, et le trône sera à vous ! Un très bon jeu, avec une bonne rejouabilité grâce au plateau modulable !");
		jeuSrv.create(jeu19);		
		Jeu jeu20 = new Jeu("Flamme Rouge",2,4,8,30,"Gigamic","2016",41.9,"\\Projet_Final\\bdd\\image_jeu\\flamme-rouge.png","course,aventure",2,"Dans le monde du cyclisme, la flamme rouge est un drapeau qui indique le dernier kilomètre : la dernière ligne droite, le moment où il faut tout donner ! Qui inscrira son nom dans l'histoire de la grande course ? Les règles sont expliquées en 5 minutes et l'immersion est totale.");
		jeuSrv.create(jeu20);
		Jeu jeu21 = new Jeu("Galerapagos",3,12,10,20,"Gigamic","2017",21.9,"\\Projet_Final\\bdd\\image_jeu\\galerapagos.png","stratégie,tactique",5,"Dans Galerapagos, après le naufrage de leur bateau, un groupe de survivants se retrouve sur une île déserte. Le cadre est paradisiaque mais la vie est difficile. L’eau coule au gré des maigres précipitations et le poisson se fait rare. Il n’est pas certain que tout le monde survive à ce régime… Seule solution : construire ensemble un grand radeau. Mais il ne faut pas tarder car les nuages à l’horizon indiquent l’arrivée prochaine d’un dangereux ouragan. Un excellent jeu d'ambiance, dans lequel (presque) tous les coups sont permis !");
		jeuSrv.create(jeu21);		
		Jeu jeu22 = new Jeu("It's a Wonderful World",1,5,14,45,"La boite de jeu","2019",40.5,"\\Projet_Final\\bdd\\image_jeu\\it-s-a-wonderful-world.png","stratégie,tactique",5,"Avec son univers dystopique rétrofuturiste, It's a wonderful world vous plonge au centre d’un conflit mondial où rivalisent puissances militaires et financières. Le monde est désormais divisé en 5 empires s’affrontant pour le pouvoir ultime. Pour l'emporter, vous devrez lors des 4 manches de la partie, toutes aussi décivises les unes que les autres, choisir et produire les bonnes cartes permettant à votre empire de se développer. Un jeu de stratégie ultra addictif, qui vous fera chauffer les neurones. On apprécie les parties rapides (45 min) donnant immédiatement envie de rejouer pour affiner sa stratégie.");
		jeuSrv.create(jeu22);		
		Jeu jeu23 = new Jeu("K3 : Plan your climb",2,4,8,20,"Helvetiq","2021",21.9,"\\Projet_Final\\bdd\\image_jeu\\k3-plan-your-climb.png","logique,réflexes,stratégie,tactique",1,"Dans K3, vous allez chercher à gravir le plus haut ! Pour cela, il vous faudra mettre en place de la planification et de la programmation intelligemment pensées. K3 est un petit jeu en bois qui concentre tactique, stratégie et programmation ! On adore !");
		jeuSrv.create(jeu23);
		Jeu jeu24 = new Jeu("Karuba",2,4,8,40,"HABA","2015",26.9,"\\Projet_Final\\bdd\\image_jeu\\karuba.png","stratégie,tactique",3,"Enfin ! Après un long voyage en bateau, les chasseurs de trésor arrivent enfin sur l’île de Karuba. Ils peuvent se lancer à la recherche des trésors cachés... Qui fera traverser correctement la jungle à son équipe d’expédition, gardera à l’œil les autres joueurs et surtout récoltera l’or et les cristaux tout au long du parcours ? Un excellent jeu familial au matériel impeccable !");
		jeuSrv.create(jeu24);
		Jeu jeu25 = new Jeu("Kingdomino",2,4,8,15,"Blue Orange","2016",19.9,"\\Projet_Final\\bdd\\image_jeu\\kingdomino.png","stratégie,tactique",2,"Dans Kingdomino, vous incarnez un Seigneur en quête de terres pour étendre son Royaume. Champs de blés, lacs, montagnes... il vous faut tout explorer pour repérer les meilleures parcelles. Chaque domaine vous rapportera d'autant plus de prestige qu'il sera vaste et contiendra de riches bâtiments. Mais d'autres seigneurs convoitent les mêmes terres que vous... Un jeu incontournable et accessible à tous !");
		jeuSrv.create(jeu25);
		Jeu jeu26 = new Jeu("Les Aventuriers du Rail",2,5,8,40,"Days of wonder","2018",42.5,"\\Projet_Final\\bdd\\image_jeu\\les-aventuriers-du-rail.png","stratégie,tactique",1,"Les Aventuriers du Rail est un jeu luxueux dans la droite ligne de Crique des Pirates ou de Meurtre à l'Abbaye. Le graphisme dépeint avec bonheur les merveilleuses machines de la grande époque de l'histoire des chemins de fer, de plus comme les autres jeux Days of Wonder, il profite d'un suivi irréprochable. Les règles rapides à assimiler, vous permettront de parcourir l'Amérique du Nord dans de magnifiques trains 'grand siècle'. Dans Les Aventuriers du Rail, les joueurs se font concurrence pour connecter différentes villes en s’appropriant une partie du réseau ferré américain. Un grand classique, à avoir chez soi !");
		jeuSrv.create(jeu26);			
		Jeu jeu27 = new Jeu("Les Petites Bourgades",1,6,14,45,"Lucky Duck","2019",35.9,"\\Projet_Final\\bdd\\image_jeu\\les-petites-bourgades.png","stratégie,tactique",2,"Les Petites Bourgades a été un coup de coeur immédiat dès notre première partie. Un jeu de placement tactique hors norme vous invitant à un mode de réflexion innovant où vous devrez réussir à projeter vos coups à plusieurs tours dans l’espace. Super accessible, terriblement retord, un mélange explosif ! À ne louper sous aucun prétexte.");
		jeuSrv.create(jeu27);
		Jeu jeu28 = new Jeu("Little Town",2,4,10,45,"Iello","2017",23.9,"\\Projet_Final\\bdd\\image_jeu\\little-town.png","stratégie,tactique",2,"Dans Little Town, il existe, bien au-delà des montagnes les plus reculées, une région riche et verdoyante encore inexplorée. Ce lieu regorgeant de richesses est l’endroit idéal pour bâtir la ville de vos rêves. Il vous faudra récolter des ressources pour ensuite ériger un premier bâtiment, puis un autre, et encore un autre… Faites naître ainsi une cité resplendissante ! Quel architecte sera le plus ambitieux et le plus talentueux ? Little Town est une excellente initiation aux jeux de gestions !");
		jeuSrv.create(jeu28);;
		Jeu jeu29 = new Jeu("Magic Maze",1,8,8,15,"Sit Down","2017",25.9,"\\Projet_Final\\bdd\\image_jeu\\magic-maze.png","course,aventure",5,"Dans Magic Maze, vous incarnez un groupe de héros qui vient de se faire voler tout son équipement et tout son argent ! Vous êtes donc contraints de vous rendre au Magic Maze -le centre commercial du coin- et d'y dérober tout l'équipement nécessaire pour vos prochaines aventures. Seulement il vous faudra réussir à échapper aux vigiles qui vont ont bien à l'oeil depuis votre arrivée ! Un jeu coopératif en temps réel, structuré par actions plutôt que par tours de jeu : chaque joueur est le seul à pouvoir faire des actions spécifiques qui lui sont attribuées pour la partie. Il s'agit donc de se coordonner et d'identifier lorsque le groupe a besoin de vous. Mais attention, vous ne serez autorisés à communiquer avec les autres joueurs que durant de courtes périodes...");
		jeuSrv.create(jeu29);
		Jeu jeu30 = new Jeu("Micro Macro Crime City",1,4,8,30,"Spielwiese","2020",23.5,"\\Projet_Final\\bdd\\image_jeu\\micro-macro-crime-city.png","Enquête,enigme",1,"Micro Macro Crime City vous propose une expérience ludique géniale en vous plongeant dans la carte d'une ville fourmillant de détail. À vous de l'explorer et d'y retrouver l'ensemble des détails vous permettant de résoudre l'ensemble des enquêtes proposées pour le jeu. C’est un énorme coup de cœur pour toute personne l’ayant essayé, vous allez le dévorer à coup sûr et nous vous souhaitons un très bon appétit !");
		jeuSrv.create(jeu30);
		Jeu jeu31 = new Jeu("Mysterium",2,7,10,40,"Libellud","2015",40.5,"\\Projet_Final\\bdd\\image_jeu\\mysterium.png","Enquête,enigme",3,"Médiums émérites, astrologues la tête pas trop dans les étoiles, voyants ne perdant pas la boule, vous êtes tous conviés à une séance de spiritisme extraordinaire afin d'élucider un ancien mystère ! Le manoir hanté de Warwick, demeure de Mr MacDowell, vous ouvre ses portes. Mysterium est un jeu d’enquête coopératif dans lequel tout le monde perd ou tout le monde gagne. Les joueurs sont unis dans le but de découvrir les circonstances et le responsable du meurtre. Associations d’idées, discussions, intuition, déductions… Un grand moment de jeu, où le mystère perce par la simple force de vos esprits ! Un jeu d’ambiance immersif à la mécanique simple, évidente et fun, avec un matériel somptueux, au service du jeu et une grande rejouabilité, avec un plaisir à chaque fois différent !");
		jeuSrv.create(jeu31);
		Jeu jeu32 = new Jeu("Nidavellir",2,5,10,45,"Grrre Games","2020",33.5,"\\Projet_Final\\bdd\\image_jeu\\nidavellir.png","stratégie,tactique",3,"Nidavellir, le Royaume des Nains et des Naines, s’assombrit. Mandaté par le Roi, sillonnez chaque taverne du royaume, engagez les nains les plus habiles, recrutez les héros les plus prestigieux et constituez le bataillon le plus puissant pour sauver Nidavellir ! Un énorme coup de coeur pour cette pépite ! Que dire de plus ?");
		jeuSrv.create(jeu32);
		Jeu jeu33 = new Jeu("Pandemic",2,4,8,45,"Z-Man Games","2008",35.9,"\\Projet_Final\\bdd\\image_jeu\\pandemic.png","stratégie,tactique",4,"Dans Pandemic, sauvez la planète avant que les épidémies ne prennent le dessus ! Un très bon jeu de coopération, équilibré et bien pensé niveau gameplay. Un super jeu qui mérite bien ses récompenses.");
		jeuSrv.create(jeu33);	
		Jeu jeu34 = new Jeu("Pappy Winchester",3,5,8,40,"Blue Orange","2019",26.9,"\\Projet_Final\\bdd\\image_jeu\\pappy-winchester.png","stratégie,tactique",1,"Envie d'un Monopoly à la sauce Ranch ? Oubliez les rues de Paris et la caisse de communauté et bienvenue dans le Far West ! Pappy Winchester est un jeu d'enchère dans lequel vous vous affronterez pour posséder le maximum de terrains et de richesse pour l'emporter. En cas de désaccord, il faudra faire parler la poudre. Un coup de coeur Ludum, à partager sans modération entre amis ou en famille.");
		jeuSrv.create(jeu34);
		Jeu jeu35 = new Jeu("Potion Explosion",2,4,8,60,"Ielli","2015",39.9,"\\Projet_Final\\bdd\\image_jeu\\potion-explosion.png","stratégie,tactique",5,"Dans Potion Explosion, l’heure est venue. Votre dernière année à l’Académie de Sorcellerie Horribilorum pour Sorcières et Magiciens Spirituels est presque terminée, et il est temps de passer aux tout derniers examens ! Les règles n’ont pas changé d’un poil : prenez les Ingrédients du Distributeur du Laboratoire pour terminer vos Potions. N’oubliez pas que les explosions que vous ne manquerez pas de provoquer peuvent se révéler utiles ! L’utilisation des Potions concoctées lors de cet examen est permise et vivement conseillée ! Employez-les à bon escient pour peaufiner votre travail, et vous prouverez que vous êtes dignes de devenir des sorcières et magiciens à part entière. Ce jeu est une pépite ludique. Un super matériel pour un jeu intuitif qui plaît à tous !");
		jeuSrv.create(jeu35);
		Jeu jeu36 = new Jeu("Prehistories",2,5,8,30,"Flying Games","2020",24.5,"\\Projet_Final\\bdd\\image_jeu\\prehistories.png","stratégie,tactique",4,"Prehistories fait partie de ces jeux dont vous tombez amoureux dès la première partie ! Un univers des plus charmant, un mécanique accessible et originale, des parties haletantes et serrées. Bref que du bonheur ! Entre son thème immersif, sa mécanique interactive, son aspect tactique lié au placement de tuiles et à la course à l’objectif, Prehistories coche toutes les cases du jeu familial idéal !");
		jeuSrv.create(jeu36);
		Jeu jeu37 = new Jeu("Res Arcana",2,4,12,30,"Sand Castle Games","2019",34.5,"\\Projet_Final\\bdd\\image_jeu\\res-arcana.png","stratégie,tactique",5,"Res Arcana est l'un des jeux les plus salués par la critique cette année. Un jeu carte stratégique où vous devrez réaliser des combos efficaces avant les autres joueurs pour l'emporte et devenir ainsi le roi des Arcanes. De la profondeur stratégique et un grande rejouabilité font de ce jeu l'un des favoris pour les prochains prix à venir en 2020.");
		jeuSrv.create(jeu37);
		Jeu jeu38 = new Jeu("Saboteur",3,10,8,30,"Gigamic","2004",14.9,"\\Projet_Final\\bdd\\image_jeu\\saboteur.png","course,aventure",2,"Vous jouez soit le rôle d'un chercheur d'or qui creuse de profondes galeries, soit le rôle d'un saboteur qui entrave les recherches. Mais parmi les autres joueurs, vous ignorez qui est chercheur et qui est saboteur ! Essayez de le deviner pour savoir qui soutenir... Saboteur allie bluffs, complicités et retournements : une véritable pépite !");
		jeuSrv.create(jeu38);
		Jeu jeu39 = new Jeu("Salade 2 points",2,6,8,20,"Gigamic","2020",14.9,"\\Projet_Final\\bdd\\image_jeu\\salade-2-points.png","stratégie,tactique",3,"Salade 2 points est un jeu de collection simple et amusant pour toute la famille. Avec plus de 100 façons de marquer des points, chaque partie est unique, et les joueurs vont pouvoir multiplier les stratégies pour essayer de gagner ! Le marché évolue tout au long de la partie, choisissez les meilleures combinaisons de légumes et d'objectifs pour composer la meilleure salade de points. Facile à apprendre, rapide à jouer, Salade 2 points est un jeu léger et parfaitement assaisonné !");
		jeuSrv.create(jeu39);
		Jeu jeu40 = new Jeu("Schotten totten 2",2,2,8,30,"Iello","2020",14.9,"\\Projet_Final\\bdd\\image_jeu\\schotten-totten.png","stratégie,tactique",1,"Aurez-vous les yeux plus gros que le ventre dans Schotten Totten ? Lancez-vous dans une lutte où tous les coups sont permis pour gagner le contrôle de la frontière qui vous sépare de votre adversaire. Envoyez les membres de votre tribu défendre les bornes et déployez vos forces en réalisant les meilleures combinaisons de cartes. Pour gagner, soyez le premier à contrôler cinq Bornes dispersées le long de la frontière ou trois Bornes adjacentes. La nouvelle édition d’un classique de Reiner Knizia, reconnu comme l’un des meilleurs jeux à 2 au monde !");
		jeuSrv.create(jeu40);
		Jeu jeu41 = new Jeu("Splendor",2,4,10,30,"Space Cowboys","2014",31.5,"\\Projet_Final\\bdd\\image_jeu\\splendor.png","stratégie,tactique",2,"Dans Splendor, vous incarnez un riche marchand de la Renaissance. Vous utiliserez vos ressources pour acquérir des mines, des moyens de transport et des artisans qui vous permettront de transformer des pierres brutes en magnifiques bijoux. Un jeu tactique, rapide et addictif ! Splendor s’explique en cinq minutes et se joue en une demi-heure, aussi bien à deux qu’à trois ou quatre joueurs !");
		jeuSrv.create(jeu41);
		Jeu jeu42 = new Jeu("Takenoko",2,4,8,50,"Bombyx","2011",35.9,"\\Projet_Final\\bdd\\image_jeu\\takenoko.png","stratégie,tactique",5,"Jadis, l’Empereur de Chine offrit à Empereur du Japon un Grand Panda, symbole de paix.Votre délicate mission : prendre soin de l’animal en lui aménageant une bambouseraie... Mais attention à l’animal sacré et à son goût immodéré pour les tiges croquantes ! Takenoko est As d'or 2012 ! Un jeu avec un plateau modulable pour des parties sans cesse renouvelées. Il offre l’équilibre parfait entre tactique et immersion thématique, magnifié par un matériel et des illustrations de grande qualité !");
		jeuSrv.create(jeu42);
		Jeu jeu43 = new Jeu("Terraforming Mars",1,5,12,90,"Intrafin","2016",57.9,"\\Projet_Final\\bdd\\image_jeu\\terraforming-mars.png","stratégie,tactique",5,"L'ère de la domestication de Mars a commencé. Dans Terraforming Mars, de puissantes corporations travaillent pour rendre la Planète Rouge habitable. La température, l'oxygène et les océans sont les trois axes de développement principaux. Mais pour triompher, il faudra aussi construire des infrastructures pour les générations futures. Jeu incroyable, aux multiples possibilités de stratégie. Un jeu qui comblera de nombreux ludistes expérimentés !");
		jeuSrv.create(jeu43);
		Jeu jeu44 = new Jeu("the crew",2,5,10,20,"Kosmos","2019",16.5,"\\Projet_Final\\bdd\\image_jeu\\the-crew.png","stratégie,tactique",3,"The Crew est un jeu de cartes coopératif qui place les joueurs dans le rôle d'astronautes dans des aventures spatiales à l'issue incertaine. Le jeu est conçu par Thomas Sing, avec l'artwork de Marco Armbruster, et est publié par Kosmos. Il est conçu pour 2-5 joueurs, âgés de 10 ans et plus, et joue en 20 minutes environ. Une variante à 2 joueurs est également incluse. Nominé au Spiel des Jahres, The Crew va rapidement devenir un incontournable pour les fans de jeux de plis tels que la belote ou le tarot !");
		jeuSrv.create(jeu44);
		Jeu jeu45 = new Jeu("The Loop",1,4,12,60,"Catch up Games","2020",39.9,"\\Projet_Final\\bdd\\image_jeu\\the-loop.png","stratégie,tactique",4,"The Loop vous entraîne vous et votre équipe à travers l'espace temps dans une lutte acharnée contre l'infâme Dr. Foo ! Une expérience coopérative exceptionnelle, une édition splendide, une rejouabilité hors pair grace aux 4 modes de jeu et un mode solo efficace. C’est fluide, haletant, magnifiquement illustré ! Le matériel est bien pensé, les mécaniques bien huilées, les règles parfaitement rédigées. C’est bourré d’humour et de références, bref... La réalisation et l’écriture de The Loop illustrent un profond respect pour les joueurs que nous sommes. Tout y est bien pensé ! Nous ne vous détaillerons pas tout car la place est limitée. Mais vous comprenez qu’il s’agit là d’un immense coup de cœur, le plus grand du trimestre, voire de l’année.  Le temps n’attend pas, alors n’attendez plus !");
		jeuSrv.create(jeu45);
		Jeu jeu46 = new Jeu("Time Bomb",4,8,8,20,"New board game party","2016",14.9,"\\Projet_Final\\bdd\\image_jeu\\time-bomb.png","Enquête,enigme",2,"Time Bomb : Big Ben surplombe la charmante ville de Londres tandis qu’elle cache, sous son tic-tac régulier, le son de la bombe posée par Moriarty . C’est alors que Sherlock se précipite vers la grande tour pour tenter de la désamorcer ! Aiderez-vous Sherlock à désamorcer la bombe et sauvez Big Ben ? Ou assisterez-vous plutôt Moriarty dans son plan machiavélique ? Lancez-vous dans une partie pour le découvrir ! Time Bomb est un jeu de bluff et de déduction rapide et fun où vous ressentez la tension monter tout au long de la partie. Jeu simple mais tellement bon et efficace. Certes de quoi ruiner votre entente avec vos amis et révéler des tendances paranoïaques chez certains, mais on ne passe que de bons moments en y jouant !");
		jeuSrv.create(jeu46);
		Jeu jeu47 = new Jeu("Tokaido",2,5,8,30,"Funforge","2012",34.9,"\\Projet_Final\\bdd\\image_jeu\\tokaido.png","stratégie,tactique",2,"Les joueurs sont des voyageurs du Japon d’autrefois. Ils vont arpenter le prestigieux Tokaido, la route de la Mer de l’Est et tenter de faire de ce voyage une expérience des plus enrichissantes. Excellent jeu familial pour des parties posées de 30 minutes. Les dessins sont très jolis et la mécanique est fluide et facile à expliquer !");
		jeuSrv.create(jeu47);
		Jeu jeu48 = new Jeu("Top Ten",4,9,14,30,"Coktail Games","2020",17.9,"\\Projet_Final\\bdd\\image_jeu\\top-ten.png","quizz,défis",4,"Top est LE jeu d'ambiance de la fin d'année 2020 ! Face à une situation donnée, il y a mille façons de réagir. De la pire à la meilleure, de la plus sérieuse à la plus drôle, de la plus valorisante à la plus dégradante. Chacun sera seul juge du meilleur choix à faire ! Est-ce que vos amis partagent votre opinion ? Auriez-vous fait les mêmes choix qu’eux ? Découvrez le dans Top Ten. Top Ten est nommé au Spiel des Jahres 2022 !");
		jeuSrv.create(jeu48);
		Jeu jeu49 = new Jeu("Welcome",1,100,10,25,"Blue Cocker","2019",22.9,"\\Projet_Final\\bdd\\image_jeu\\welcome-to.png","stratégie,tactique",4,"Dans Welcome, les joueurs incarnent des architectes dans les années 1950 aux Etats-Unis, en plein boom démographique. Mais la concurrence sera rude ! Qui respectera au mieux les Plans projetés par la ville en créant dans les trois rues qui lui sont confiées les plus beaux lotissements, avec leurs luxueux parcs et leurs piscines de rêve? Welcome est un jeu où tout le monde joue en même temps avec le même tirage de cartes. Il s’agira alors pour chacun de combiner astucieusement les numéros de maison apparus et les actions qui s’y trouveront associés afin de devenir le plus grand architecte de demain ! Un excellent jeu qui mérite de figurer dans la cour des grands !");
		jeuSrv.create(jeu49);
		Jeu jeu50 = new Jeu("Wingspan",1,5,10,60,"Matagot","2019",57.5,"\\Projet_Final\\bdd\\image_jeu\\wingspan.png","stratégie,tactique",1,"Dans Wingspan, vous êtes des passionnés d’oiseaux : chercheurs, observateurs, ornithologues... Chaque oiseau posé déclenche une combinaison d’actions dans un de vos habitats. Chacun de ces habitats se concentre sur un aspect clé de votre volière. Le vainqueur sera le joueur ayant accumulé le plus de points avec ses oiseaux, cartes Bonus, objectifs de fin de manche, nourriture stockée et cartes recouvertes. Très bon jeu d'engine building avec un thème original qui sort de l'ordinaire. Très beau matériel aussi avec de belles illustrations !");
		jeuSrv.create(jeu50);
		Jeu jeu51 = new Jeu("Yokai",2,4,8,20,"Bankiiz","2018",12.9,"\\Projet_Final\\bdd\\image_jeu\\yokai.png","stratégie,tactique",4,"Un challenge de taille vous attend dans Yokai ! Vous allez devoir coopérer et communiquer mais sans aucun mot ! Le genre à le vent en poupe entre Hanabi, The Mind ou Magic Maze. Yokai y apporte sa touche de fraîcheur et son ambiance asiatique en se basant sur ces mystérieux fantômes japonais. Tous ensemble vous devrez réussir à organiser ses fantômes (placés face cachée) par famille et en silence s'il vous plait !  Alors prêts pour votre premier memory télépathique ?");
		jeuSrv.create(jeu51);
		
		//ajout table bar
		TableBar table1 = new TableBar(4,1);
		tableBarSrv.create(table1);
		TableBar table2= new TableBar(4,2);
		tableBarSrv.create(table2);
		TableBar table3 = new TableBar(6,3);
		tableBarSrv.create(table3);
		TableBar table4 = new TableBar(4,4);
		tableBarSrv.create(table4);
		TableBar table5 = new TableBar(4,5);
		tableBarSrv.create(table5);
		TableBar table6 = new TableBar(6,6);
		tableBarSrv.create(table6);
		TableBar table7 = new TableBar(8,7);
		tableBarSrv.create(table7);
		TableBar table8 = new TableBar(2,8);
		tableBarSrv.create(table8);
		TableBar table9 = new TableBar(2,9);
		tableBarSrv.create(table9);
		TableBar table10 = new TableBar(8,10);
		tableBarSrv.create(table10);
		TableBar table11 = new TableBar(6,11);
		tableBarSrv.create(table11);
		TableBar table12 = new TableBar(4,12);
		tableBarSrv.create(table12);
		
		//ajout des réservations		
		Reservation resa1 = new Reservation(LocalDate.parse("2023-02-22"),LocalTime.parse("10:00:00"),4,table1,client1);
		resaSrv.create(resa1);
		Reservation resa2 = new Reservation(LocalDate.parse("2023-02-22"),LocalTime.parse("10:00:00"),4,table2,client2);
		resaSrv.create(resa2);	
		Reservation resa3 = new Reservation(LocalDate.parse("2023-02-22"),LocalTime.parse("10:00:00"),6,table3,client3);
		resaSrv.create(resa3);		
		Reservation resa4 = new Reservation(LocalDate.parse("2023-02-22"),LocalTime.parse("11:00:00"),4,table1,client1);
		resaSrv.create(resa4);
		Reservation resa5 = new Reservation(LocalDate.parse("2023-02-22"),LocalTime.parse("11:00:00"),4,table2,client4);
		resaSrv.create(resa5);
		Reservation resa6 = new Reservation(LocalDate.parse("2023-02-22"),LocalTime.parse("14:00:00"),6,table3,client1);
		resaSrv.create(resa6);
		Reservation resa7 = new Reservation(LocalDate.parse("2023-02-22"),LocalTime.parse("15:00:00"),6,table3,client4);
		resaSrv.create(resa7);
		Reservation resa8 = new Reservation(LocalDate.parse("2023-02-22"),LocalTime.parse("11:00:00"),8,table10,client2);
		resaSrv.create(resa8);
		Reservation resa9 = new Reservation(LocalDate.parse("2023-02-23"),LocalTime.parse("11:00:00"),4,table12,client1);
		resaSrv.create(resa9);
		
		
	}

}
